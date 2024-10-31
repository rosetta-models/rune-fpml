package com.regnosys.fpml;

import cdm.base.staticdata.party.*;
import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.legaldocumentation.common.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.regnosys.ingest.IngestionService;
import com.regnosys.rosetta.common.util.Report;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.metafields.FieldWithMetaDate;
import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.confirmation.*;
import fpml.ingest.typesfixed.functions.MapTradeState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.rosetta.util.CollectionUtils.emptyIfNull;

public class FpmlConfirmationToTradeStateIngestionService implements IngestionService {

    private final Module runtimeModule;
    private final LegalAgreementHelper legalAgreementHelper;

    public FpmlConfirmationToTradeStateIngestionService(Module runtimeModule) {
        this.runtimeModule = runtimeModule;
        legalAgreementHelper = new LegalAgreementHelper();
    }

    @Override
    public <T extends RosettaModelObject> Report<T> ingestAndPostProcess(fpml.confirmation.DataDocument fpmlDataDocument) {
        return rosettaTradeStateReport(fpmlDataDocument);
    }

    @SuppressWarnings("unchecked")
    private <T extends RosettaModelObject> Report<T> javaTradeStateReport(DataDocument fpmlDataDocument) {
        return (Report<T>) getTradeState(fpmlDataDocument)
                .map(TradeState.TradeStateBuilder::prune)
                .map(TradeState.TradeStateBuilder::build)
                .map(Report::new)
                .orElse(null);
    }

    @SuppressWarnings("unchecked")
    private <T extends RosettaModelObject> Report<T> rosettaTradeStateReport(DataDocument fpmlDataDocument) {
        Injector injector = Guice.createInjector(runtimeModule);
        MapTradeState tradeState = injector.getInstance(MapTradeState.class);
        return (Report<T>) new Report<>(tradeState.evaluate(fpmlDataDocument));
    }

    public Optional<TradeState.TradeStateBuilder> getTradeState(fpml.confirmation.DataDocument fpmlDataDocument) {
        return Optional.ofNullable(fpmlDataDocument)
                .map(d -> {
                    TradeState.TradeStateBuilder tradeStateBuilder = TradeState.builder();
                    getTrade(d).ifPresent(tradeStateBuilder::setTrade);
                    return tradeStateBuilder;
                });
    }

    public Optional<Trade.TradeBuilder> getTrade(fpml.confirmation.DataDocument fpmlDataDocument) {
        return Optional.ofNullable(fpmlDataDocument)
                .map(d -> {
                    Trade.TradeBuilder tradeBuilder = Trade.builder();
                    Optional<fpml.confirmation.PartiesAndAccountsModel> partiesAndAccountsModel = Optional.ofNullable(d.getPartiesAndAccountsModel());
                    partiesAndAccountsModel.map(fpml.confirmation.PartiesAndAccountsModel::getParty).map(this::getParties).ifPresent(tradeBuilder::setParty);
                    partiesAndAccountsModel.map(fpml.confirmation.PartiesAndAccountsModel::getAccount).map(this::getAccounts).ifPresent(tradeBuilder::setAccount);
                    // only support 1 trade per dataDocument
                    fpml.confirmation.Trade fpmlTrade = onlyElement(d.getTrade());
                    getTradeDate(fpmlTrade).ifPresent(tradeBuilder::setTradeDate);
                    getContractDetails(fpmlTrade).ifPresent(tradeBuilder::setContractDetails);

                    Optional.ofNullable(fpmlTrade)
                            .map(fpml.confirmation.Trade::getTradeHeader)
                            .map(TradeHeader::getPartyTradeInformation)
                            .ifPresent(partyTradeInformation -> tradeBuilder.addPartyRole(getPartyRoles(partyTradeInformation)));


                    return tradeBuilder;
                });
    }

    private List<PartyRole.PartyRoleBuilder> getPartyRoles(List<? extends  fpml.confirmation.PartyTradeInformation> partyTradeInformation) {
        return emptyIfNull(partyTradeInformation).stream()
                .flatMap(pti -> {
                    Optional<PartyAndAccountReferencesModel> partyTradeInformationPartyReference = Optional.ofNullable(pti.getPartyAndAccountReferencesModel());
                    return emptyIfNull(pti.getRelatedParty())
                            .stream().map(relatedParty -> {
                                PartyRole.PartyRoleBuilder partyRoleBuilder = PartyRole.builder();
                                Optional<PartyAndAccountReferencesModel> relatedPartyPartyReference = Optional.ofNullable(relatedParty.getPartyAndAccountReferencesModel());
                                //set partyReference
                                relatedPartyPartyReference.map(PartyAndAccountReferencesModel::getPartyReference).map(PartyReference::getHref)
                                        .ifPresent(href -> partyRoleBuilder.getOrCreatePartyReference().setExternalReference(href));
                                //set role
                                Optional<String> relatedPartyRole = Optional.ofNullable(relatedParty.getRole()).map(fpml.confirmation.PartyRole::getValue);
                                relatedPartyRole.flatMap(this::valueToPartyRoleEnum).ifPresent(partyRoleBuilder::setRole);
                                //set ownershipPartyReference
                                relatedPartyRole.flatMap(value -> partyTradeInformationPartyReference.map(PartyAndAccountReferencesModel::getPartyReference).map(PartyReference::getHref)).ifPresent(href -> partyRoleBuilder.getOrCreateOwnershipPartyReference().setExternalReference(href));
                                return partyRoleBuilder;
                            });
                }).filter(RosettaModelObjectBuilder::hasData).toList();
    }

    private Optional<ContractDetails.ContractDetailsBuilder> getContractDetails(fpml.confirmation.Trade fpmlTrade) {
        return Optional.ofNullable(fpmlTrade)
                .map(t -> {
                    ContractDetails.ContractDetailsBuilder builder = ContractDetails.builder();
                    builder.setDocumentation(getLegalAgreements(t.getDocumentation()));
                    return builder;
                });
    }

    private List<LegalAgreement.LegalAgreementBuilder> getLegalAgreements(fpml.confirmation.Documentation fpmlDocumentation) {
        return Optional.ofNullable(fpmlDocumentation)
                .map(d -> {
                    List<LegalAgreement.LegalAgreementBuilder> legalAgreementBuilders = new ArrayList<>();
                    legalAgreementHelper.getMasterAgreement(d.getMasterAgreement()).ifPresent(legalAgreementBuilders::add);
                    legalAgreementHelper.getMasterConfirmation(d.getMasterConfirmation()).ifPresent(legalAgreementBuilders::add);
                    //getBrokerConfirmation is in the original mapper but i'm ignoring it as it's dead code
                    legalAgreementHelper.getCreditSupportAgreement(d.getCreditSupportAgreement()).ifPresent(legalAgreementBuilders::add);
                    legalAgreementHelper.getConfirmation(d).ifPresent(legalAgreementBuilders::add);
                    legalAgreementBuilders.addAll(legalAgreementHelper.getOtherAgreements(d.getOtherAgreement()));
                    //TODO: work out how we handle waiting for counterparty role to be set so we can set correct PARTY1/PARTY2 on each agreement
                    return legalAgreementBuilders;
                }).orElse(List.of());
    }

    private <E> E onlyElement(List<? extends E> e) {
        return Optional.ofNullable(e)
                .orElse(Collections.emptyList())
                .stream()
                .findFirst()
                .orElse(null);
    }


    private Optional<FieldWithMetaDate.FieldWithMetaDateBuilder> getTradeDate(fpml.confirmation.Trade fpmlTrade) {
        return Optional.ofNullable(fpmlTrade)
                .map(fpml.confirmation.Trade::getTradeHeader)
                .map(fpml.confirmation.TradeHeader::getTradeDate)
                .map(td -> {
                    FieldWithMetaDate.FieldWithMetaDateBuilder fieldWithMetaDate = FieldWithMetaDate.builder();
                    Optional.ofNullable(td.getId()).ifPresent(fieldWithMetaDate.getOrCreateMeta()::setExternalKey);
                    Optional.ofNullable(td.getValue()).ifPresent(fieldWithMetaDate::setValue);
                    return fieldWithMetaDate;
                });
    }

    public List<Party.PartyBuilder> getParties(List<? extends fpml.confirmation.Party> fpmlParties) {
        return emptyIfNull(fpmlParties)
                .stream()
                .map(fpml.confirmation.Party::getPartyModel)
                .map(pm -> {
                    Party.PartyBuilder partyBuilder = Party.builder();
                    getFieldWithMetaString(pm.getPartyName()).ifPresent(partyBuilder::setName);
                    partyBuilder.setPartyId(getPartyIds(pm.getPartyId()));
                    return partyBuilder;
                })
                .toList();
    }

    public Optional<FieldWithMetaString.FieldWithMetaStringBuilder> getFieldWithMetaString(fpml.confirmation.PartyName fpmlPartyName) {
        return Optional.ofNullable(fpmlPartyName)
                .map(pn -> {
                    FieldWithMetaString.FieldWithMetaStringBuilder fieldWithMetaStringBuilder = FieldWithMetaString.builder();
                    Optional.ofNullable(pn.getValue()).ifPresent(fieldWithMetaStringBuilder::setValue);
                    Optional.ofNullable(pn.getPartyNameScheme()).ifPresent(fieldWithMetaStringBuilder.getOrCreateMeta()::setScheme);
                    return fieldWithMetaStringBuilder;
                });
    }

    public List<PartyIdentifier.PartyIdentifierBuilder> getPartyIds(List<? extends fpml.confirmation.PartyId> fpmlPartyIds) {
        return Optional.ofNullable(fpmlPartyIds)
                .orElse(Collections.emptyList())
                .stream()
                .map(pi -> {
                    PartyIdentifier.PartyIdentifierBuilder partyIdentifierBuilder = PartyIdentifier.builder();
                    getFieldWithMetaString(pi).ifPresent(partyIdentifierBuilder::setIdentifier);
                    getIdentifierType(pi.getPartyIdScheme()).ifPresent(partyIdentifierBuilder::setIdentifierType);
                    return partyIdentifierBuilder;
                })
                .toList();
    }

    public Optional<FieldWithMetaString.FieldWithMetaStringBuilder> getFieldWithMetaString(fpml.confirmation.PartyId fpmlPartyId) {
        return Optional.ofNullable(fpmlPartyId)
                .map(pi -> {
                    FieldWithMetaString.FieldWithMetaStringBuilder fieldWithMetaStringBuilder = FieldWithMetaString.builder();
                    Optional.ofNullable(pi.getValue()).ifPresent(fieldWithMetaStringBuilder::setValue);
                    Optional.ofNullable(pi.getPartyIdScheme()).ifPresent(fieldWithMetaStringBuilder.getOrCreateMeta()::setScheme);
                    return fieldWithMetaStringBuilder;
                });
    }

    public Optional<PartyIdentifierTypeEnum> getIdentifierType(String fpmlPartyIdScheme) {
        return Optional.ofNullable(fpmlPartyIdScheme)
                .map(pid -> {
                    if (pid.contains("http://www.fpml.org/coding-scheme/external/iso9362")) {
                        return PartyIdentifierTypeEnum.BIC;
                    } else if (pid.contains("http://www.fpml.org/coding-scheme/external/iso17442")) {
                        return PartyIdentifierTypeEnum.LEI;
                    } else if (pid.contains("http://www.fpml.org/coding-scheme/external/iso10383")) {
                        return PartyIdentifierTypeEnum.MIC;
                    } else {
                        return null;
                    }
                });
    }

    public List<Account.AccountBuilder> getAccounts(List<? extends fpml.confirmation.Account> fpmlAccounts) {
        return emptyIfNull(fpmlAccounts)
                .stream()
                .map(a -> {
                    Account.AccountBuilder accountBuilder = Account.builder();
                    getId(a).ifPresent(accountBuilder.getOrCreateMeta()::setExternalKey);
                    getFieldWithMetaString(a.getAccountName()).ifPresent(accountBuilder::setAccountName);
                    getFieldWithMetaString(onlyElement(a.getAccountId())).ifPresent(accountBuilder::setAccountNumber);
                    getServicingParty(a.getServicingParty()).ifPresent(accountBuilder::setServicingParty);
                    //getAccountBeneficiary(a.getAccountBeneficiary()).ifPresent(accountBuilder::setAccountBeneficiary);
                    return accountBuilder;
                })
                .toList();
    }

    private Optional<String> getId(fpml.confirmation.Account fpmlAccount) {
        return Optional.ofNullable(fpmlAccount).map(a -> a.getId());
    }

    public Optional<FieldWithMetaString.FieldWithMetaStringBuilder> getFieldWithMetaString(fpml.confirmation.AccountName fpmlAccountName) {
        return Optional.ofNullable(fpmlAccountName)
                .map(pn -> {
                    FieldWithMetaString.FieldWithMetaStringBuilder fieldWithMetaStringBuilder = FieldWithMetaString.builder();
                    Optional.ofNullable(pn.getValue()).ifPresent(fieldWithMetaStringBuilder::setValue);
                    Optional.ofNullable(pn.getAccountNameScheme()).ifPresent(fieldWithMetaStringBuilder.getOrCreateMeta()::setScheme);
                    return fieldWithMetaStringBuilder;
                });
    }

    private Optional<FieldWithMetaString> getFieldWithMetaString(fpml.confirmation.AccountId fpmlAccountId) {
        return Optional.ofNullable(fpmlAccountId)
                .map(aid -> {
                    FieldWithMetaString.FieldWithMetaStringBuilder fieldWithMetaStringBuilder = FieldWithMetaString.builder();
                    Optional.ofNullable(aid.getValue()).ifPresent(fieldWithMetaStringBuilder::setValue);
                    Optional.ofNullable(aid.getAccountIdScheme()).ifPresent(fieldWithMetaStringBuilder.getOrCreateMeta()::setScheme);
                    return fieldWithMetaStringBuilder;
                });

    }

    private Optional<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> getServicingParty(fpml.confirmation.PartyReference fpmlServicingParty) {
        return Optional.ofNullable(fpmlServicingParty)
                .map(sp -> {
                    ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyBuilder = ReferenceWithMetaParty.builder();
                    Optional.ofNullable(sp.getHref()).ifPresent(partyBuilder::setExternalReference);
                    return partyBuilder;
                });
    }

    private Optional<PartyRoleEnum> valueToPartyRoleEnum(String value) {
        if (value == null || value.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(switch (value) {
            case "Accountant" -> PartyRoleEnum.ACCOUNTANT;
            case "AllocationAgent" -> PartyRoleEnum.ALLOCATION_AGENT;
            case "ArrangingBroker" -> PartyRoleEnum.ARRANGING_BROKER;
            case "Beneficiary" -> PartyRoleEnum.BENEFICIARY;
            case "BookingParty" -> PartyRoleEnum.BOOKING_PARTY;
            case "Buyer" -> PartyRoleEnum.BUYER;
            case "BuyerDecisionMaker" -> PartyRoleEnum.BUYER_DECISION_MAKER;
            case "ClearingClient" -> PartyRoleEnum.CLEARING_CLIENT;
            case "ClearingExceptionParty" -> PartyRoleEnum.CLEARING_EXCEPTION_PARTY;
            case "ClearingFirm" -> PartyRoleEnum.CLEARING_FIRM;
            case "ClearingOrganization" -> PartyRoleEnum.CLEARING_ORGANIZATION;
            case "Client" -> PartyRoleEnum.CLIENT;
            case "ClientDecisionMaker" -> PartyRoleEnum.CLIENT_DECISION_MAKER;
            case "ConfirmationPlatform" -> PartyRoleEnum.CONFIRMATION_PLATFORM;
            case "ConfirmationService" -> PartyRoleEnum.CONFIRMATION_PLATFORM;
            case "ContractualParty" -> PartyRoleEnum.CONTRACTUAL_PARTY;
            case "CounterPartyAffiliate" -> PartyRoleEnum.COUNTER_PARTY_AFFILIATE;
            case "CounterPartyUltimateParent" -> PartyRoleEnum.COUNTER_PARTY_ULTIMATE_PARENT;
            case "Counterparty" -> PartyRoleEnum.COUNTERPARTY;
            case "CreditSupportProvider" -> PartyRoleEnum.CREDIT_SUPPORT_PROVIDER;
            case "Custodian" -> PartyRoleEnum.CUSTODIAN;
            case "DataSubmitter" -> PartyRoleEnum.DATA_SUBMITTER;
            case "DisputingParty" -> PartyRoleEnum.DISPUTING_PARTY;
            case "DocumentRepository" -> PartyRoleEnum.DOCUMENT_REPOSITORY;
            case "ExecutingBroker" -> PartyRoleEnum.EXECUTING_BROKER;
            case "ExecutingEntity" -> PartyRoleEnum.EXECUTING_ENTITY;
            case "ExecutionAgent" -> PartyRoleEnum.EXECUTION_AGENT;
            case "ExecutionFacility" -> PartyRoleEnum.EXECUTION_FACILITY;
            case "Guarantor" -> PartyRoleEnum.GUARANTOR;
            case "OrderTransmitter" -> PartyRoleEnum.ORDER_TRANSMITTER;
            case "PrimeBroker" -> PartyRoleEnum.PRIME_BROKER;
            case "PriorTradeRepository" -> PartyRoleEnum.PRIOR_TRADE_REPOSITORY;
            case "PTRRCompressionProvider" -> PartyRoleEnum.PTRR_SERVICE_PROVIDER;
            case "PTRRRebalancingProvider" -> PartyRoleEnum.PTRR_SERVICE_PROVIDER;
            case "PublicationVenue" -> PartyRoleEnum.PUBLICATION_VENUE;
            case "ReportingParty" -> PartyRoleEnum.REPORTING_PARTY;
            case "ReportingPartyAffiliate" -> PartyRoleEnum.REPORTING_PARTY_AFFILIATE;
            case "ReportingPartyUltimateParent" -> PartyRoleEnum.REPORTING_PARTY_ULTIMATE_PARENT;
            case "Seller" -> PartyRoleEnum.SELLER;
            case "SellerDecisionMaker" -> PartyRoleEnum.SELLER_DECISION_MAKER;
            case "SettlementAgent" -> PartyRoleEnum.SETTLEMENT_AGENT;
            case "TradeRepository" -> PartyRoleEnum.TRADE_REPOSITORY;
            case "TradeSource" -> PartyRoleEnum.TRADE_SOURCE;
            case "TradingManager" -> PartyRoleEnum.TRADING_MANAGER;
            case "TradingPartner" -> PartyRoleEnum.TRADING_PARTNER;
            default -> null;
        });
    }



    //    private Optional<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> getAccountBeneficiary(fpml.confirmation.PartyReference fpmlAccountBeneficiary) {
//        return Optional.ofNullable(fpmlAccountBeneficiary)
//                .map(sp -> {
//                    ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyBuilder = ReferenceWithMetaParty.builder();
//                    Optional.ofNullable(sp.getHref()).ifPresent(partyBuilder::setExternalReference);
//                    return partyBuilder;
//                });
//    }
}
