package com.regnosys.fpml;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.legaldocumentation.common.*;
import cdm.legaldocumentation.master.MasterAgreementTypeEnum;
import cdm.legaldocumentation.master.MasterConfirmationAnnexTypeEnum;
import cdm.legaldocumentation.master.MasterConfirmationTypeEnum;
import cdm.product.collateral.CreditSupportAgreementTypeEnum;
import com.google.inject.Module;
import com.regnosys.ingest.IngestionService;
import com.regnosys.rosetta.common.util.Report;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.confirmation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.rosetta.util.CollectionUtils.emptyIfNull;

public class FpmlConfirmationToTradeStateIngestionService implements IngestionService {

    private final Module runtimeModule;

    public FpmlConfirmationToTradeStateIngestionService(Module runtimeModule) {
        this.runtimeModule = runtimeModule;
    }

    @Override
    public <T extends RosettaModelObject> Report<T> ingestAndPostProcess(fpml.confirmation.DataDocument fpmlDataDocument) {
        return getTradeState(fpmlDataDocument)
                .map(TradeState.TradeStateBuilder::prune)
                .map(TradeState.TradeStateBuilder::build)
                .map(tradeState -> new Report(tradeState))
                .orElse(null);
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
                    return tradeBuilder;
                });
    }

    private Optional<ContractDetails.ContractDetailsBuilder> getContractDetails(fpml.confirmation.Trade fpmlTrade) {
        return Optional.ofNullable(fpmlTrade)
                .map(t -> {
                    ContractDetails.ContractDetailsBuilder builder = ContractDetails.builder();
                    getLegalAgreement(t.getDocumentation()).ifPresent(builder::setDocumentation);
                    return builder;
                });
    }

    private Optional<List<LegalAgreement.LegalAgreementBuilder>> getLegalAgreement(fpml.confirmation.Documentation fpmlDocumentation) {
        return Optional.ofNullable(fpmlDocumentation)
                .map(d -> {
                    List<LegalAgreement.LegalAgreementBuilder> legalAgreementBuilders = new ArrayList<>();
                    getMasterAgreement(d.getMasterAgreement()).ifPresent(legalAgreementBuilders::add);
                    getMasterConfirmation(d.getMasterConfirmation()).ifPresent(legalAgreementBuilders::add);
                    //getBrokerConfirmation is in the original mapper but i'm ignoring it as it's dead code
                    getCreditSupportAgreement(d.getCreditSupportAgreement()).ifPresent(legalAgreementBuilders::add);
                    return legalAgreementBuilders;
                });
    }

    private Optional<LegalAgreement.LegalAgreementBuilder> getCreditSupportAgreement(CreditSupportAgreement creditSupportAgreement) {
        return Optional.ofNullable(creditSupportAgreement)
                .map(c -> {
                    LegalAgreement.LegalAgreementBuilder builder = LegalAgreement.builder();

                    Optional<CreditSupportAgreementType> creditSupportAgreementType = Optional.ofNullable(c.get_type());

                    creditSupportAgreementType
                            .map(CreditSupportAgreementType::getValue)
                            .flatMap(this::valueToCreditSupportAgreementTypeEnum)
                            .ifPresent(creditSupportAgreementTypeEnum -> {
                                builder.getOrCreateLegalAgreementIdentification().getOrCreateAgreementName().setCreditSupportAgreementTypeValue(creditSupportAgreementTypeEnum);
                            });

                    creditSupportAgreementType
                            .map(CreditSupportAgreementType::getCreditSupportAgreementTypeScheme)
                            .ifPresent(scheme -> {
                                builder.getOrCreateLegalAgreementIdentification().getOrCreateAgreementName()
                                .getOrCreateCreditSupportAgreementType().getOrCreateMeta().setScheme(scheme);
                            });

                    Optional.ofNullable(creditSupportAgreement.getDate())
                            .ifPresent(builder::setAgreementDate);
                    return builder;
                });
    }

    private Optional<LegalAgreement.LegalAgreementBuilder> getMasterAgreement(fpml.confirmation.MasterAgreement fpmlMasterAgreement) {
        return Optional.ofNullable(fpmlMasterAgreement)
                .map(m -> {
                    LegalAgreement.LegalAgreementBuilder builder = LegalAgreement.builder();
                    Optional<MasterAgreementType> masterAgreementType = Optional.ofNullable(fpmlMasterAgreement.getMasterAgreementType());

                    masterAgreementType
                            .map(MasterAgreementType::getValue)
                            .flatMap(this::valueToMasterAgreementTypeEnum)
                            .ifPresent(masterAgreementTypeEnum -> {
                                builder.getOrCreateLegalAgreementIdentification()
                                        .getOrCreateAgreementName()
                                        .setMasterAgreementTypeValue(masterAgreementTypeEnum);
                            });

                    masterAgreementType
                            .map(MasterAgreementType::getMasterAgreementTypeScheme)
                            .ifPresent(masterAgreementTypeScheme -> {
                                builder.getOrCreateLegalAgreementIdentification()
                                        .getOrCreateAgreementName()
                                        .getMasterAgreementType()
                                        .getOrCreateMeta()
                                        .setScheme(masterAgreementTypeScheme);
                            });

                   //TODO: map masterAgreementVersion when available in FpML
                   //TODO: map masterAgreementDate when available in FpML

                    return builder;
                });
    }

    private Optional<LegalAgreement.LegalAgreementBuilder> getMasterConfirmation(fpml.confirmation.MasterConfirmation fpmlMasterConfirmation) {
        return Optional.ofNullable(fpmlMasterConfirmation)
                .map(masterConfirmation -> {
                    LegalAgreement.LegalAgreementBuilder builder = LegalAgreement.builder();

                    Optional<MasterConfirmationType> masterConfirmationType = Optional.ofNullable(masterConfirmation.getMasterConfirmationType());

                    masterConfirmationType
                            .map(MasterConfirmationType::getValue)
                            .flatMap(this::valueToMasterConfirmationTypeEnum)
                            .ifPresent(masterConfirmationTypeEnum -> {
                                builder.getOrCreateLegalAgreementIdentification()
                                        .getOrCreateAgreementName()
                                        .setMasterConfirmationTypeValue(masterConfirmationTypeEnum);
                            });

                    masterConfirmationType
                            .map(MasterConfirmationType::getMasterConfirmationTypeScheme)
                            .ifPresent(masterConfirmationTypeScheme -> {
                                builder.getOrCreateLegalAgreementIdentification()
                                        .getOrCreateAgreementName()
                                        .getOrCreateMasterConfirmationType()
                                        .getOrCreateMeta()
                                        .setScheme(masterConfirmationTypeScheme);
                            });

                    Optional<MasterConfirmationAnnexType> masterConfirmationAnnexType = Optional.ofNullable(masterConfirmation.getMasterConfirmationAnnexType());

                    masterConfirmationAnnexType
                            .map(MasterConfirmationAnnexType::getValue)
                            .flatMap(this::valueToMasterConfirmationAnnexTypeEnum)
                            .ifPresent(masterConfirmationAnnexTypeEnum -> {
                                builder.getOrCreateLegalAgreementIdentification().getOrCreateAgreementName().setMasterConfirmationAnnexTypeValue(masterConfirmationAnnexTypeEnum);
                            });

                    masterConfirmationAnnexType
                            .map(MasterConfirmationAnnexType::getMasterConfirmationAnnexTypeScheme)
                            .ifPresent(masterConfirmationAnnexTypeScheme -> {
                                builder.getOrCreateLegalAgreementIdentification()
                                        .getOrCreateAgreementName()
                                        .getOrCreateMasterConfirmationAnnexType().getOrCreateMeta().setScheme(masterConfirmationAnnexTypeScheme);
                            });

                    Optional.ofNullable(masterConfirmation.getMasterConfirmationDate())
                            .ifPresent(builder::setAgreementDate);

                    return builder;
                });
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

    private Optional<MasterAgreementTypeEnum> valueToMasterAgreementTypeEnum(String value) {
        if (value == null || value.isEmpty()) {
            return Optional.empty();
        }
        return  Optional.ofNullable(switch (value) {
            case "AFB" -> MasterAgreementTypeEnum.AFB;
            case "Bespoke" -> MasterAgreementTypeEnum.BESPOKE;
            case "CMA" -> MasterAgreementTypeEnum.CMA;
            case "CMOF" -> MasterAgreementTypeEnum.CMOF;
            case "EEIPower" -> MasterAgreementTypeEnum.EEI_POWER;
            case "EFETElectricity" -> MasterAgreementTypeEnum.EFET_ELECTRICITY;
            case "EFETGas" -> MasterAgreementTypeEnum.EFET_GAS;
            case "EMA" -> MasterAgreementTypeEnum.EMA;
            case "FBF" -> MasterAgreementTypeEnum.FBF;
            case "GMRA" -> MasterAgreementTypeEnum.GMRA;
            case "GMSLA" -> MasterAgreementTypeEnum.GMSLA;
            case "GTMA" -> MasterAgreementTypeEnum.GTMA;
            case "GasEDI" -> MasterAgreementTypeEnum.GAS_EDI;
            case "German" -> MasterAgreementTypeEnum.GERMAN;
            case "ICOM" -> MasterAgreementTypeEnum.ICOM;
            case "IETA-ERPA" -> MasterAgreementTypeEnum.IETA_ERPA;
            case "IETA-ETMA" -> MasterAgreementTypeEnum.IETA_ETMA;
            case "IETA-IETMA" -> MasterAgreementTypeEnum.IETA_IETMA;
            case "IFEMA" -> MasterAgreementTypeEnum.IFEMA;
            case "IFEOMA" -> MasterAgreementTypeEnum.IFEOMA;
            case "ISDA" -> MasterAgreementTypeEnum.ISDA_MASTER;
            case "ISDAFIA-CDEA" -> MasterAgreementTypeEnum.ISDAFIA_CDEA;
            case "ISDAIIFM-TMA" -> MasterAgreementTypeEnum.ISDAIIFM_TMA;
            case "JSCC" -> MasterAgreementTypeEnum.JSCC;
            case "LBMA" -> MasterAgreementTypeEnum.LBMA;
            case "LEAP" -> MasterAgreementTypeEnum.LEAP;
            case "MCPSA" -> MasterAgreementTypeEnum.MCPSA;
            case "NAESBGas" -> MasterAgreementTypeEnum.NAESB_GAS;
            case "NBP" -> MasterAgreementTypeEnum.NBP;
            case "RussianDerivatives" -> MasterAgreementTypeEnum.RUSSIAN_DERIVATIVES;
            case "RussianRepo" -> MasterAgreementTypeEnum.RUSSIAN_REPO;
            case "SCoTA" -> MasterAgreementTypeEnum.S_CO_TA;
            case "Swiss" -> MasterAgreementTypeEnum.SWISS;
            case "TTF" -> MasterAgreementTypeEnum.TTF;
            case "ZBT" -> MasterAgreementTypeEnum.ZBT;
            default -> null;
        });
    }

    private Optional<MasterConfirmationTypeEnum> valueToMasterConfirmationTypeEnum(String value) {
        if (value == null || value.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(switch (value) {
            case "2003CreditIndex" -> MasterConfirmationTypeEnum._2003_CREDIT_INDEX;
            case "2004EquityEuropeanInterdealer" -> MasterConfirmationTypeEnum._2004_EQUITY_EUROPEAN_INTERDEALER;
            case "2005VarianceSwapEuropeanInterdealer" -> MasterConfirmationTypeEnum._2005_VARIANCE_SWAP_EUROPEAN_INTERDEALER;
            case "2006DividendSwapEuropean" -> MasterConfirmationTypeEnum._2006_DIVIDEND_SWAP_EUROPEAN;
            case "2006DividendSwapEuropeanInterdealer" -> MasterConfirmationTypeEnum._2006_DIVIDEND_SWAP_EUROPEAN_INTERDEALER;
            case "2014CreditAsia" -> MasterConfirmationTypeEnum._2014_CREDIT_ASIA;
            case "2014CreditAsiaFinancial" -> MasterConfirmationTypeEnum._2014_CREDIT_ASIA_FINANCIAL;
            case "2014CreditAustraliaNewZealand" -> MasterConfirmationTypeEnum._2014_CREDIT_AUSTRALIA_NEW_ZEALAND;
            case "2014CreditAustraliaNewZealandFinancial" -> MasterConfirmationTypeEnum._2014_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL;
            case "2014CreditEuropean" -> MasterConfirmationTypeEnum._2014_CREDIT_EUROPEAN;
            case "2014CreditEuropeanCoCoFinancial" -> MasterConfirmationTypeEnum._2014_CREDIT_EUROPEAN_CO_CO_FINANCIAL;
            case "2014CreditEuropeanFinancial" -> MasterConfirmationTypeEnum._2014_CREDIT_EUROPEAN_FINANCIAL;
            case "2014CreditJapan" -> MasterConfirmationTypeEnum._2014_CREDIT_JAPAN;
            case "2014CreditJapanFinancial" -> MasterConfirmationTypeEnum._2014_CREDIT_JAPAN_FINANCIAL;
            case "2014CreditNorthAmerican" -> MasterConfirmationTypeEnum._2014_CREDIT_NORTH_AMERICAN;
            case "2014CreditNorthAmericanFinancial" -> MasterConfirmationTypeEnum._2014_CREDIT_NORTH_AMERICAN_FINANCIAL;
            case "2014CreditSingapore" -> MasterConfirmationTypeEnum._2014_CREDIT_SINGAPORE;
            case "2014CreditSingaporeFinancial" -> MasterConfirmationTypeEnum._2014_CREDIT_SINGAPORE_FINANCIAL;
            case "2014CreditSovereignAsia" -> MasterConfirmationTypeEnum._2014_CREDIT_SOVEREIGN_ASIA;
            case "2014CreditSovereignEmergingEuropeanAndMiddleEastern" -> MasterConfirmationTypeEnum._2014_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN;
            case "2014CreditSovereignJapan" -> MasterConfirmationTypeEnum._2014_CREDIT_SOVEREIGN_JAPAN;
            case "2014CreditSovereignLatinAmerican" -> MasterConfirmationTypeEnum._2014_CREDIT_SOVEREIGN_LATIN_AMERICAN;
            case "2014CreditSovereignWesternEuropean" -> MasterConfirmationTypeEnum._2014_CREDIT_SOVEREIGN_WESTERN_EUROPEAN;
            case "2014StandardCreditAsia" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_ASIA;
            case "2014StandardCreditAsiaFinancial" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_ASIA_FINANCIAL;
            case "2014StandardCreditAustraliaNewZealand" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND;
            case "2014StandardCreditAustraliaNewZealandFinancial" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL;
            case "2014StandardCreditEuropean" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_EUROPEAN;
            case "2014StandardCreditEuropeanCoCoFinancial" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_EUROPEAN_CO_CO_FINANCIAL;
            case "2014StandardCreditEuropeanFinancial" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_EUROPEAN_FINANCIAL;
            case "2014StandardCreditJapan" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_JAPAN;
            case "2014StandardCreditJapanFinancial" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_JAPAN_FINANCIAL;
            case "2014StandardCreditNorthAmerican" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_NORTH_AMERICAN;
            case "2014StandardCreditNorthAmericanFinancial" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_NORTH_AMERICAN_FINANCIAL;
            case "2014StandardCreditSingapore" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SINGAPORE;
            case "2014StandardCreditSingaporeFinancial" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SINGAPORE_FINANCIAL;
            case "2014StandardCreditSovereignAsia" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SOVEREIGN_ASIA;
            case "2014StandardCreditSovereignEmergingEuropeanAndMiddleEastern" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN;
            case "2014StandardCreditSovereignJapan" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SOVEREIGN_JAPAN;
            case "2014StandardCreditSovereignLatinAmerican" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN;
            case "2014StandardCreditSovereignWesternEuropean" -> MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN;
            case "DJ.CDX.EM" -> MasterConfirmationTypeEnum.DJ_CDX_EM;
            case "DJ.CDX.EM.DIV" -> MasterConfirmationTypeEnum.DJ_CDX_EM_DIV;
            case "DJ.CDX.NA" -> MasterConfirmationTypeEnum.DJ_CDX_NA;
            case "DJ.iTraxx.Europe" -> MasterConfirmationTypeEnum.DJ_I_TRAXX_EUROPE;
            case "EquityAmericas" -> MasterConfirmationTypeEnum.EQUITY_AMERICAS;
            case "EquityAsia" -> MasterConfirmationTypeEnum.EQUITY_ASIA;
            case "EquityEuropean" -> MasterConfirmationTypeEnum.EQUITY_EUROPEAN;
            case "ISDA1999Credit" -> MasterConfirmationTypeEnum.ISDA_1999_CREDIT;
            case "ISDA2003CreditAsia" -> MasterConfirmationTypeEnum.ISDA_2003_CREDIT_ASIA;
            case "ISDA2003CreditAustraliaNewZealand" -> MasterConfirmationTypeEnum.ISDA_2003_CREDIT_AUSTRALIA_NEW_ZEALAND;
            case "ISDA2003CreditEuropean" -> MasterConfirmationTypeEnum.ISDA_2003_CREDIT_EUROPEAN;
            case "ISDA2003CreditJapan" -> MasterConfirmationTypeEnum.ISDA_2003_CREDIT_JAPAN;
            case "ISDA2003CreditNorthAmerican" -> MasterConfirmationTypeEnum.ISDA_2003_CREDIT_NORTH_AMERICAN;
            case "ISDA2003CreditSingapore" -> MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SINGAPORE;
            case "ISDA2003CreditSovereignAsia" -> MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SOVEREIGN_ASIA;
            case "ISDA2003CreditSovereignCentralAndEasternEurope" -> MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SOVEREIGN_CENTRAL_AND_EASTERN_EUROPE;
            case "ISDA2003CreditSovereignJapan" -> MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SOVEREIGN_JAPAN;
            case "ISDA2003CreditSovereignLatinAmerica" -> MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SOVEREIGN_LATIN_AMERICA;
            case "ISDA2003CreditSovereignMiddleEast" -> MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SOVEREIGN_MIDDLE_EAST;
            case "ISDA2003CreditSovereignWesternEurope" -> MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SOVEREIGN_WESTERN_EUROPE;
            case "ISDA2003StandardCreditAsia" -> MasterConfirmationTypeEnum.ISDA_2003_STANDARD_CREDIT_ASIA;
            case "ISDA2003StandardCreditAustraliaNewZealand" -> MasterConfirmationTypeEnum.ISDA_2003_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND;
            case "ISDA2003StandardCreditEuropean" -> MasterConfirmationTypeEnum.ISDA_2003_STANDARD_CREDIT_EUROPEAN;
            case "ISDA2003StandardCreditJapan" -> MasterConfirmationTypeEnum.ISDA_2003_STANDARD_CREDIT_JAPAN;
            case "ISDA2003StandardCreditNorthAmerican" -> MasterConfirmationTypeEnum.ISDA_2003_STANDARD_CREDIT_NORTH_AMERICAN;
            case "ISDA2003StandardCreditSingapore" -> MasterConfirmationTypeEnum.ISDA_2003_STANDARD_CREDIT_SINGAPORE;
            case "ISDA2004CreditSovereignAsia" -> MasterConfirmationTypeEnum.ISDA_2004_CREDIT_SOVEREIGN_ASIA;
            case "ISDA2004CreditSovereignEmergingEuropeanAndMiddleEastern" -> MasterConfirmationTypeEnum.ISDA_2004_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN;
            case "ISDA2004CreditSovereignJapan" -> MasterConfirmationTypeEnum.ISDA_2004_CREDIT_SOVEREIGN_JAPAN;
            case "ISDA2004CreditSovereignLatinAmerican" -> MasterConfirmationTypeEnum.ISDA_2004_CREDIT_SOVEREIGN_LATIN_AMERICAN;
            case "ISDA2004CreditSovereignWesternEuropean" -> MasterConfirmationTypeEnum.ISDA_2004_CREDIT_SOVEREIGN_WESTERN_EUROPEAN;
            case "ISDA2004EquityAmericasInterdealer" -> MasterConfirmationTypeEnum.ISDA_2004_EQUITY_AMERICAS_INTERDEALER;
            case "ISDA2004EquityAmericasInterdealerRev1" -> MasterConfirmationTypeEnum.ISDA_2004_EQUITY_AMERICAS_INTERDEALER_REV_1;
            case "ISDA2004StandardCreditSovereignAsia" -> MasterConfirmationTypeEnum.ISDA_2004_STANDARD_CREDIT_SOVEREIGN_ASIA;
            case "ISDA2004StandardCreditSovereignEmergingEuropeanAndMiddleEastern" -> MasterConfirmationTypeEnum.ISDA_2004_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN;
            case "ISDA2004StandardCreditSovereignJapan" -> MasterConfirmationTypeEnum.ISDA_2004_STANDARD_CREDIT_SOVEREIGN_JAPAN;
            case "ISDA2004StandardCreditSovereignLatinAmerican" -> MasterConfirmationTypeEnum.ISDA_2004_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN;
            case "ISDA2004StandardCreditSovereignWesternEuropean" -> MasterConfirmationTypeEnum.ISDA_2004_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN;
            case "ISDA2005EquityAsiaExcludingJapanInterdealer" -> MasterConfirmationTypeEnum.ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER;
            case "ISDA2005EquityAsiaExcludingJapanInterdealerRev2" -> MasterConfirmationTypeEnum.ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER_REV_2;
            case "ISDA2005EquityJapaneseInterdealer" -> MasterConfirmationTypeEnum.ISDA_2005_EQUITY_JAPANESE_INTERDEALER;
            case "ISDA2006VarianceSwapJapanese" -> MasterConfirmationTypeEnum.ISDA_2006_VARIANCE_SWAP_JAPANESE;
            case "ISDA2006VarianceSwapJapaneseInterdealer" -> MasterConfirmationTypeEnum.ISDA_2006_VARIANCE_SWAP_JAPANESE_INTERDEALER;
            case "ISDA2007EquityEuropean" -> MasterConfirmationTypeEnum.ISDA_2007_EQUITY_EUROPEAN;
            case "ISDA2007VarianceSwapAmericas" -> MasterConfirmationTypeEnum.ISDA_2007_VARIANCE_SWAP_AMERICAS;
            case "ISDA2007VarianceSwapAsiaExcludingJapan" -> MasterConfirmationTypeEnum.ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN;
            case "ISDA2007VarianceSwapAsiaExcludingJapanRev1" -> MasterConfirmationTypeEnum.ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1;
            case "ISDA2007VarianceSwapAsiaExcludingJapanRev2" -> MasterConfirmationTypeEnum.ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_2;
            case "ISDA2007VarianceSwapEuropean" -> MasterConfirmationTypeEnum.ISDA_2007_VARIANCE_SWAP_EUROPEAN;
            case "ISDA2007VarianceSwapEuropeanRev1" -> MasterConfirmationTypeEnum.ISDA_2007_VARIANCE_SWAP_EUROPEAN_REV_1;
            case "ISDA2008DividendSwapJapan" -> MasterConfirmationTypeEnum.ISDA_2008_DIVIDEND_SWAP_JAPAN;
            case "ISDA2008DividendSwapJapaneseRev1" -> MasterConfirmationTypeEnum.ISDA_2008_DIVIDEND_SWAP_JAPANESE_REV_1;
            case "ISDA2008EquityAmericas" -> MasterConfirmationTypeEnum.ISDA_2008_EQUITY_AMERICAS;
            case "ISDA2008EquityAsiaExcludingJapan" -> MasterConfirmationTypeEnum.ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN;
            case "ISDA2008EquityAsiaExcludingJapanRev1" -> MasterConfirmationTypeEnum.ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN_REV_1;
            case "ISDA2008EquityJapan" -> MasterConfirmationTypeEnum.ISDA_2008_EQUITY_JAPAN;
            case "ISDA2009EquityAmericas" -> MasterConfirmationTypeEnum.ISDA_2009_EQUITY_AMERICAS;
            case "ISDA2009EquityEuropeanInterdealer" -> MasterConfirmationTypeEnum.ISDA_2009_EQUITY_EUROPEAN_INTERDEALER;
            case "ISDA2009EquityPanAsia" -> MasterConfirmationTypeEnum.ISDA_2009_EQUITY_PAN_ASIA;
            case "ISDA2010EquityEMEAInterdealer" -> MasterConfirmationTypeEnum.ISDA_2010_EQUITY_EMEA_INTERDEALER;
            case "ISDA2013VolatilitySwapAmericas" -> MasterConfirmationTypeEnum.ISDA_2013_VOLATILITY_SWAP_AMERICAS;
            case "ISDA2013VolatilitySwapAsiaExcludingJapan" -> MasterConfirmationTypeEnum.ISDA_2013_VOLATILITY_SWAP_ASIA_EXCLUDING_JAPAN;
            case "ISDA2013VolatilitySwapEuropean" -> MasterConfirmationTypeEnum.ISDA_2013_VOLATILITY_SWAP_EUROPEAN;
            case "ISDA2013VolatilitySwapJapanese" -> MasterConfirmationTypeEnum.ISDA_2013_VOLATILITY_SWAP_JAPANESE;
            default -> null;
        });
    }

    private Optional<MasterConfirmationAnnexTypeEnum> valueToMasterConfirmationAnnexTypeEnum(String value) {
        if (value == null || value.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(switch (value) {
            case "ISDA2004IndexVarianceSwapAmericasInterdealer" -> MasterConfirmationAnnexTypeEnum.ISDA_2004_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER;
            case "ISDA2004ShareVarianceSwapAmericasInterdealer" -> MasterConfirmationAnnexTypeEnum.ISDA_2004_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER;
            case "ISDA2007DispersionVarianceSwapEuropean" -> MasterConfirmationAnnexTypeEnum.ISDA_2007_DISPERSION_VARIANCE_SWAP_EUROPEAN;
            case "ISDA2007EquityFinanceSwapEuropean" -> MasterConfirmationAnnexTypeEnum.ISDA_2007_EQUITY_FINANCE_SWAP_EUROPEAN;
            case "ISDA2007IndexVarianceSwapAmericasInterdealer" -> MasterConfirmationAnnexTypeEnum.ISDA_2007_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER;
            case "ISDA2007ShareVarianceSwapAmericasInterdealer" -> MasterConfirmationAnnexTypeEnum.ISDA_2007_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER;
            case "ISDA2007VarianceOptionEuropean" -> MasterConfirmationAnnexTypeEnum.ISDA_2007_VARIANCE_OPTION_EUROPEAN;
            case "ISDA2008EquityFinanceSwapAsiaExcludingJapan" -> MasterConfirmationAnnexTypeEnum.ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN;
            case "ISDA2008EquityFinanceSwapAsiaExcludingJapanRev1" -> MasterConfirmationAnnexTypeEnum.ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1;
            case "ISDA2008EquityOptionAsiaExcludingJapan" -> MasterConfirmationAnnexTypeEnum.ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN;
            case "ISDA2008EquityOptionAsiaExcludingJapanRev1" -> MasterConfirmationAnnexTypeEnum.ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN_REV_1;
            case "ISDA2008EquityOptionJapan" -> MasterConfirmationAnnexTypeEnum.ISDA_2008_EQUITY_OPTION_JAPAN;
            case "ISDA2009ClosedMarketsOptionsAsiaExcludingJapan" -> MasterConfirmationAnnexTypeEnum.ISDA_2009_CLOSED_MARKETS_OPTIONS_ASIA_EXCLUDING_JAPAN;
            case "ISDA2009EquityEuropeanInterdealerSS" -> MasterConfirmationAnnexTypeEnum.ISDA_2009_EQUITY_EUROPEAN_INTERDEALER_SS;
            case "ISDA2009EquityEuropeanIS" -> MasterConfirmationAnnexTypeEnum.ISDA_2009_EQUITY_EUROPEAN_IS;
            case "ISDA2009IndexShareOptionAmericas" -> MasterConfirmationAnnexTypeEnum.ISDA_2009_INDEX_SHARE_OPTION_AMERICAS;
            case "ISDA2009IndexSwapEuropeanInterdealer" -> MasterConfirmationAnnexTypeEnum.ISDA_2009_INDEX_SWAP_EUROPEAN_INTERDEALER;
            case "ISDA2009IndexSwapPanAsiaInterdealer" -> MasterConfirmationAnnexTypeEnum.ISDA_2009_INDEX_SWAP_PAN_ASIA_INTERDEALER;
            case "ISDA2009ShareSwapPanAsia" -> MasterConfirmationAnnexTypeEnum.ISDA_2009_SHARE_SWAP_PAN_ASIA;
            case "ISDA2010FairValueShareSwapEuropeanInterdealer" -> MasterConfirmationAnnexTypeEnum.ISDA_2010_FAIR_VALUE_SHARE_SWAP_EUROPEAN_INTERDEALER;
            case "ISDA2010IndexShareOptionEMEAInterdealer" -> MasterConfirmationAnnexTypeEnum.ISDA_2010_INDEX_SHARE_OPTION_EMEA_INTERDEALER;
            default -> null;
        });
    }

    private Optional<CreditSupportAgreementTypeEnum> valueToCreditSupportAgreementTypeEnum(String value) {
        if (value == null || value.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(switch (value) {
            case "CreditSupportDeed" -> CreditSupportAgreementTypeEnum.CREDIT_SUPPORT_DEED;
            case "CreditSupportAnnex" -> CreditSupportAgreementTypeEnum.CREDIT_SUPPORT_ANNEX;
            case "CollateralTransferAgreement" -> CreditSupportAgreementTypeEnum.COLLATERAL_TRANSFER_AGREEMENT;
            default -> null;
        });
    }

    private Optional<ContractualDefinitionsEnum> valueToContractualDefinitionsEnum(String value) {
        if (value == null || value.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(switch (value) {
            case "ISDA1991InterestRate" -> ContractualDefinitionsEnum.ISDA_1991_INTEREST_RATE;
            case "ISDA1993CommodityDerivatives" -> ContractualDefinitionsEnum.ISDA_1993_COMMODITY_DERIVATIVES;
            case "ISDA1996EquityDerivatives" -> ContractualDefinitionsEnum.ISDA_1996_EQUITY_DERIVATIVES;
            case "ISDA1997Bullion" -> ContractualDefinitionsEnum.ISDA_1997_BULLION;
            case "ISDA1997GovernmentBondOption" -> ContractualDefinitionsEnum.ISDA_1997_GOVERNMENT_BOND_OPTION;
            case "ISDA1998FxAndCurrencyOption" -> ContractualDefinitionsEnum.ISDA_1998_FX_AND_CURRENCY_OPTION;
            case "ISDA1999CreditDerivatives" -> ContractualDefinitionsEnum.ISDA_1999_CREDIT_DERIVATIVES;
            case "ISDA2000" -> ContractualDefinitionsEnum.ISDA2000;
            case "ISDA2002EquityDerivatives" -> ContractualDefinitionsEnum.ISDA_2002_EQUITY_DERIVATIVES;
            case "ISDA2003CreditDerivatives" -> ContractualDefinitionsEnum.ISDA_2003_CREDIT_DERIVATIVES;
            case "ISDA2004Novation" -> ContractualDefinitionsEnum.ISDA_2004_NOVATION;
            case "ISDA2005Commodity" -> ContractualDefinitionsEnum.ISDA_2005_COMMODITY;
            case "ISDA2006" -> ContractualDefinitionsEnum.ISDA2006;
            case "ISDA2006InflationDerivatives" -> ContractualDefinitionsEnum.ISDA_2006_INFLATION_DERIVATIVES;
            case "ISDA2008InflationDerivatives" -> ContractualDefinitionsEnum.ISDA_2008_INFLATION_DERIVATIVES;
            case "ISDA2011EquityDerivatives" -> ContractualDefinitionsEnum.ISDA_2011_EQUITY_DERIVATIVES;
            case "ISDA2014CreditDerivatives" -> ContractualDefinitionsEnum.ISDA_2014_CREDIT_DERIVATIVES;
            case "ISDA2021InterestRateDerivatives" -> ContractualDefinitionsEnum.ISDA_2021_INTEREST_RATE_DERIVATIVES;
            case "ISDA2022VerifiedCarbonCredit" -> ContractualDefinitionsEnum.ISDA_2022_VERIFIED_CARBON_CREDIT;
            case "ISDA2023DigitalAssetDerivatives" -> ContractualDefinitionsEnum.ISDA_2023_DIGITAL_ASSET_DERIVATIVES;
            default -> null;
        });
    }

    private Optional<MatrixTypeEnum> valueToMatrixTypeEnum(String value) {
        if (value == null || value.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(switch (value) {
            case "CreditDerivativesPhysicalSettlementMatrix" -> MatrixTypeEnum.CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX;
            case "EquityDerivativesMatrix" -> MatrixTypeEnum.EQUITY_DERIVATIVES_MATRIX;
            case "SettlementMatrix" -> MatrixTypeEnum.SETTLEMENT_MATRIX;
            default -> null;
        });
    }

    private Optional<MatrixTermEnum> valueToMatrixTermEnum(String value) {
        if (value == null || value.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(switch (value) {
            case "AsiaCorporate" -> MatrixTermEnum.ASIA_CORPORATE;
            case "AsiaFinancialCorporate" -> MatrixTermEnum.ASIA_FINANCIAL_CORPORATE;
            case "AsiaSovereign" -> MatrixTermEnum.ASIA_SOVEREIGN;
            case "AustraliaCorporate" -> MatrixTermEnum.AUSTRALIA_CORPORATE;
            case "AustraliaFinancialCorporate" -> MatrixTermEnum.AUSTRALIA_FINANCIAL_CORPORATE;
            case "AustraliaSovereign" -> MatrixTermEnum.AUSTRALIA_SOVEREIGN;
            case "EmergingEuropeanAndMiddleEasternSovereign" -> MatrixTermEnum.EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN;
            case "EmergingEuropeanCorporate" -> MatrixTermEnum.EMERGING_EUROPEAN_CORPORATE;
            case "EmergingEuropeanCorporateLPN" -> MatrixTermEnum.EMERGING_EUROPEAN_CORPORATE_LPN;
            case "EmergingEuropeanFinancialCorporate" -> MatrixTermEnum.EMERGING_EUROPEAN_FINANCIAL_CORPORATE;
            case "EmergingEuropeanFinancialCorporateLPN" -> MatrixTermEnum.EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN;
            case "EuropeanCoCoFinancialCorporate" -> MatrixTermEnum.EUROPEAN_CO_CO_FINANCIAL_CORPORATE;
            case "EuropeanCorporate" -> MatrixTermEnum.EUROPEAN_CORPORATE;
            case "EuropeanFinancialCorporate" -> MatrixTermEnum.EUROPEAN_FINANCIAL_CORPORATE;
            case "EuropeanSeniorNonPreferredFinancialCorporate" -> MatrixTermEnum.EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE;
            case "IVS1OpenMarkets" -> MatrixTermEnum.IVS_1_OPEN_MARKETS;
            case "JapanCorporate" -> MatrixTermEnum.JAPAN_CORPORATE;
            case "JapanFinancialCorporate" -> MatrixTermEnum.JAPAN_FINANCIAL_CORPORATE;
            case "JapanSovereign" -> MatrixTermEnum.JAPAN_SOVEREIGN;
            case "LatinAmericaCorporate" -> MatrixTermEnum.LATIN_AMERICA_CORPORATE;
            case "LatinAmericaCorporateBond" -> MatrixTermEnum.LATIN_AMERICA_CORPORATE_BOND;
            case "LatinAmericaCorporateBondOrLoan" -> MatrixTermEnum.LATIN_AMERICA_CORPORATE_BOND_OR_LOAN;
            case "LatinAmericaFinancialCorporateBond" -> MatrixTermEnum.LATIN_AMERICA_FINANCIAL_CORPORATE_BOND;
            case "LatinAmericaFinancialCorporateBondOrLoan" -> MatrixTermEnum.LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN;
            case "LatinAmericaSovereign" -> MatrixTermEnum.LATIN_AMERICA_SOVEREIGN;
            case "NewZealandCorporate" -> MatrixTermEnum.NEW_ZEALAND_CORPORATE;
            case "NewZealandFinancialCorporate" -> MatrixTermEnum.NEW_ZEALAND_FINANCIAL_CORPORATE;
            case "NewZealandSovereign" -> MatrixTermEnum.NEW_ZEALAND_SOVEREIGN;
            case "NorthAmericanCorporate" -> MatrixTermEnum.NORTH_AMERICAN_CORPORATE;
            case "NorthAmericanFinancialCorporate" -> MatrixTermEnum.NORTH_AMERICAN_FINANCIAL_CORPORATE;
            case "SingaporeCorporate" -> MatrixTermEnum.SINGAPORE_CORPORATE;
            case "SingaporeFinancialCorporate" -> MatrixTermEnum.SINGAPORE_FINANCIAL_CORPORATE;
            case "SingaporeSovereign" -> MatrixTermEnum.SINGAPORE_SOVEREIGN;
            case "StandardAsiaCorporate" -> MatrixTermEnum.STANDARD_ASIA_CORPORATE;
            case "StandardAsiaFinancialCorporate" -> MatrixTermEnum.STANDARD_ASIA_FINANCIAL_CORPORATE;
            case "StandardAsiaSovereign" -> MatrixTermEnum.STANDARD_ASIA_SOVEREIGN;
            case "StandardAustraliaCorporate" -> MatrixTermEnum.STANDARD_AUSTRALIA_CORPORATE;
            case "StandardAustraliaFinancialCorporate" -> MatrixTermEnum.STANDARD_AUSTRALIA_FINANCIAL_CORPORATE;
            case "StandardAustraliaSovereign" -> MatrixTermEnum.STANDARD_AUSTRALIA_SOVEREIGN;
            case "StandardEmergingEuropeanAndMiddleEasternSovereign" -> MatrixTermEnum.STANDARD_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN;
            case "StandardEmergingEuropeanCorporate" -> MatrixTermEnum.STANDARD_EMERGING_EUROPEAN_CORPORATE;
            case "StandardEmergingEuropeanCorporateLPN" -> MatrixTermEnum.STANDARD_EMERGING_EUROPEAN_CORPORATE_LPN;
            case "StandardEmergingEuropeanFinancialCorporate" -> MatrixTermEnum.STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE;
            case "StandardEmergingEuropeanFinancialCorporateLPN" -> MatrixTermEnum.STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN;
            case "StandardEuropeanCoCoFinancialCorporate" -> MatrixTermEnum.STANDARD_EUROPEAN_CO_CO_FINANCIAL_CORPORATE;
            case "StandardEuropeanCorporate" -> MatrixTermEnum.STANDARD_EUROPEAN_CORPORATE;
            case "StandardEuropeanFinancialCorporate" -> MatrixTermEnum.STANDARD_EUROPEAN_FINANCIAL_CORPORATE;
            case "StandardEuropeanSeniorNonPreferredFinancialCorporate" -> MatrixTermEnum.STANDARD_EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE;
            case "StandardJapanCorporate" -> MatrixTermEnum.STANDARD_JAPAN_CORPORATE;
            case "StandardJapanFinancialCorporate" -> MatrixTermEnum.STANDARD_JAPAN_FINANCIAL_CORPORATE;
            case "StandardJapanSovereign" -> MatrixTermEnum.STANDARD_JAPAN_SOVEREIGN;
            case "StandardLatinAmericaCorporateBond" -> MatrixTermEnum.STANDARD_LATIN_AMERICA_CORPORATE_BOND;
            case "StandardLatinAmericaCorporateBondOrLoan" -> MatrixTermEnum.STANDARD_LATIN_AMERICA_CORPORATE_BOND_OR_LOAN;
            case "StandardLatinAmericaFinancialCorporateBond" -> MatrixTermEnum.STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND;
            case "StandardLatinAmericaFinancialCorporateBondOrLoan" -> MatrixTermEnum.STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN;
            case "StandardLatinAmericaSovereign" -> MatrixTermEnum.STANDARD_LATIN_AMERICA_SOVEREIGN;
            case "StandardNewZealandCorporate" -> MatrixTermEnum.STANDARD_NEW_ZEALAND_CORPORATE;
            case "StandardNewZealandFinancialCorporate" -> MatrixTermEnum.STANDARD_NEW_ZEALAND_FINANCIAL_CORPORATE;
            case "StandardNewZealandSovereign" -> MatrixTermEnum.STANDARD_NEW_ZEALAND_SOVEREIGN;
            case "StandardNorthAmericanCorporate" -> MatrixTermEnum.STANDARD_NORTH_AMERICAN_CORPORATE;
            case "StandardNorthAmericanFinancialCorporate" -> MatrixTermEnum.STANDARD_NORTH_AMERICAN_FINANCIAL_CORPORATE;
            case "StandardSingaporeCorporate" -> MatrixTermEnum.STANDARD_SINGAPORE_CORPORATE;
            case "StandardSingaporeFinancialCorporate" -> MatrixTermEnum.STANDARD_SINGAPORE_FINANCIAL_CORPORATE;
            case "StandardSingaporeSovereign" -> MatrixTermEnum.STANDARD_SINGAPORE_SOVEREIGN;
            case "StandardSubordinatedEuropeanInsuranceCorporate" -> MatrixTermEnum.STANDARD_SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE;
            case "StandardSukukFinancialCorporate" -> MatrixTermEnum.STANDARD_SUKUK_FINANCIAL_CORPORATE;
            case "StandardUSMunicipalFullFaithAndCredit" -> MatrixTermEnum.STANDARD_US_MUNICIPAL_FULL_FAITH_AND_CREDIT;
            case "StandardUSMunicipalGeneralFund" -> MatrixTermEnum.STANDARD_US_MUNICIPAL_GENERAL_FUND;
            case "StandardUSMunicipalRevenue" -> MatrixTermEnum.STANDARD_US_MUNICIPAL_REVENUE;
            case "StandardWesternEuropeanSovereign" -> MatrixTermEnum.STANDARD_WESTERN_EUROPEAN_SOVEREIGN;
            case "SubordinatedEuropeanInsuranceCorporate" -> MatrixTermEnum.SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE;
            case "SukukCorporate" -> MatrixTermEnum.SUKUK_CORPORATE;
            case "SukukFinancialCorporate" -> MatrixTermEnum.SUKUK_FINANCIAL_CORPORATE;
            case "SukukSovereign" -> MatrixTermEnum.SUKUK_SOVEREIGN;
            case "USMunicipalFullFaithAndCredit" -> MatrixTermEnum.US_MUNICIPAL_FULL_FAITH_AND_CREDIT;
            case "USMunicipalGeneralFund" -> MatrixTermEnum.US_MUNICIPAL_GENERAL_FUND;
            case "USMunicipalRevenue" -> MatrixTermEnum.US_MUNICIPAL_REVENUE;
            case "WesternEuropeanSovereign" -> MatrixTermEnum.WESTERN_EUROPEAN_SOVEREIGN;
            default -> null;
        });
    }


    private Optional<ContractualSupplementTypeEnum> valueToContractualSupplementTypeEnum(String value) {
        if (value == null || value.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(switch (value) {
            case "ABX" -> ContractualSupplementTypeEnum.ABX;
            case "ABXTranche" -> ContractualSupplementTypeEnum.ABX_TRANCHE;
            case "CDSonLeveragedLoans" -> ContractualSupplementTypeEnum.CD_SON_LEVERAGED_LOANS;
            case "CDSonMBS" -> ContractualSupplementTypeEnum.CD_SON_MBS;
            case "CDX" -> ContractualSupplementTypeEnum.CDX;
            case "CDXEmergingMarkets" -> ContractualSupplementTypeEnum.CDX_EMERGING_MARKETS;
            case "CDXEmergingMarketsDiversified" -> ContractualSupplementTypeEnum.CDX_EMERGING_MARKETS_DIVERSIFIED;
            case "CDXSwaption" -> ContractualSupplementTypeEnum.CDX_SWAPTION;
            case "CDXTranche" -> ContractualSupplementTypeEnum.CDX_TRANCHE;
            case "CMBX" -> ContractualSupplementTypeEnum.CMBX;
            case "EuropeanCMBS" -> ContractualSupplementTypeEnum.EUROPEAN_CMBS;
            case "EuropeanRMBS" -> ContractualSupplementTypeEnum.EUROPEAN_RMBS;
            case "IOS" -> ContractualSupplementTypeEnum.IOS;
            case "ISDA1999CreditConvertibleExchangeableAccretingObligations" -> ContractualSupplementTypeEnum.ISDA_1999_CREDIT_CONVERTIBLE_EXCHANGEABLE_ACCRETING_OBLIGATIONS;
            case "ISDA1999CreditRestructuring" -> ContractualSupplementTypeEnum.ISDA_1999_CREDIT_RESTRUCTURING;
            case "ISDA1999CreditSuccessorAndCreditEvents" -> ContractualSupplementTypeEnum.ISDA_1999_CREDIT_SUCCESSOR_AND_CREDIT_EVENTS;
            case "ISDA2003AdditionalProvisionsLPN" -> ContractualSupplementTypeEnum.ISDA_2003_ADDITIONAL_PROVISIONS_LPN;
            case "ISDA2003ContingentCreditSpreadTransaction" -> ContractualSupplementTypeEnum.ISDA_2003_CONTINGENT_CREDIT_SPREAD_TRANSACTION;
            case "ISDA2003Credit2005MatrixSupplement" -> ContractualSupplementTypeEnum.ISDA_2003_CREDIT_2005_MATRIX_SUPPLEMENT;
            case "ISDA2003CreditArgentineRepublic" -> ContractualSupplementTypeEnum.ISDA_2003_CREDIT_ARGENTINE_REPUBLIC;
            case "ISDA2003CreditAuctionSupplement" -> ContractualSupplementTypeEnum.ISDA_2003_CREDIT_AUCTION_SUPPLEMENT;
            case "ISDA2003CreditMay2003" -> ContractualSupplementTypeEnum.ISDA_2003_CREDIT_MAY_2003;
            case "ISDA2003CreditMonolineInsurers" -> ContractualSupplementTypeEnum.ISDA_2003_CREDIT_MONOLINE_INSURERS;
            case "ISDA2003CreditMonolineInsurers2005" -> ContractualSupplementTypeEnum.ISDA_2003_CREDIT_MONOLINE_INSURERS_2005;
            case "ISDA2003CreditRepublicOfHungary" -> ContractualSupplementTypeEnum.ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY;
            case "ISDA2003CreditRepublicOfHungary2005" -> ContractualSupplementTypeEnum.ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY_2005;
            case "ISDA2003CreditRussianFederation" -> ContractualSupplementTypeEnum.ISDA_2003_CREDIT_RUSSIAN_FEDERATION;
            case "ISDA2003CreditUSMunicipals" -> ContractualSupplementTypeEnum.ISDA_2003_CREDIT_US_MUNICIPALS;
            case "ISDA2003STMicroelectronicsNV" -> ContractualSupplementTypeEnum.ISDA_2003_ST_MICROELECTRONICS_NV;
            case "ISDA2007FullLookthroughDepositoryReceiptSupplement" -> ContractualSupplementTypeEnum.ISDA_2007_FULL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT;
            case "ISDA2007PartialLookthroughDepositoryReceiptSupplement" -> ContractualSupplementTypeEnum.ISDA_2007_PARTIAL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT;
            case "ISDACreditMonolineInsurers" -> ContractualSupplementTypeEnum.ISDA_CREDIT_MONOLINE_INSURERS;
            case "ISDADeliveryRestrictions" -> ContractualSupplementTypeEnum.ISDA_DELIVERY_RESTRICTIONS;
            case "ISDAFixedRecovery" -> ContractualSupplementTypeEnum.ISDA_FIXED_RECOVERY;
            case "ISDALPNReferenceEntities" -> ContractualSupplementTypeEnum.ISDALPN_REFERENCE_ENTITIES;
            case "ISDAMarch2004EquityCanadianSupplement" -> ContractualSupplementTypeEnum.ISDA_MARCH_2004_EQUITY_CANADIAN_SUPPLEMENT;
            case "ISDARecoveryLock" -> ContractualSupplementTypeEnum.ISDA_RECOVERY_LOCK;
            case "ISDASecuredDeliverableObligationCharacteristic" -> ContractualSupplementTypeEnum.ISDA_SECURED_DELIVERABLE_OBLIGATION_CHARACTERISTIC;
            case "LCDX" -> ContractualSupplementTypeEnum.LCDX;
            case "LCDXTranche" -> ContractualSupplementTypeEnum.LCDX_TRANCHE;
            case "MBX" -> ContractualSupplementTypeEnum.MBX;
            case "MCDX" -> ContractualSupplementTypeEnum.MCDX;
            case "PO" -> ContractualSupplementTypeEnum.PO;
            case "PrimeX" -> ContractualSupplementTypeEnum.PRIME_X;
            case "StandardCDXTranche" -> ContractualSupplementTypeEnum.STANDARD_CDX_TRANCHE;
            case "StandardLCDS" -> ContractualSupplementTypeEnum.STANDARD_LCDS;
            case "StandardLCDSBullet" -> ContractualSupplementTypeEnum.STANDARD_LCDS_BULLET;
            case "StandardLCDXBullet" -> ContractualSupplementTypeEnum.STANDARD_LCDX_BULLET;
            case "StandardLCDXBulletTranche" -> ContractualSupplementTypeEnum.STANDARD_LCDX_BULLET_TRANCHE;
            case "StandardiTraxxEuropeTranche" -> ContractualSupplementTypeEnum.STANDARDI_TRAXX_EUROPE_TRANCHE;
            case "SyndicatedSecuredLoanCDS" -> ContractualSupplementTypeEnum.SYNDICATED_SECURED_LOAN_CDS;
            case "TRX" -> ContractualSupplementTypeEnum.TRX;
            case "TRX.II" -> ContractualSupplementTypeEnum.TRX_II;
            case "iTraxxAsiaExJapan" -> ContractualSupplementTypeEnum.I_TRAXX_ASIA_EX_JAPAN;
            case "iTraxxAsiaExJapanSwaption" -> ContractualSupplementTypeEnum.I_TRAXX_ASIA_EX_JAPAN_SWAPTION;
            case "iTraxxAsiaExJapanTranche" -> ContractualSupplementTypeEnum.I_TRAXX_ASIA_EX_JAPAN_TRANCHE;
            case "iTraxxAustralia" -> ContractualSupplementTypeEnum.I_TRAXX_AUSTRALIA;
            case "iTraxxAustraliaSwaption" -> ContractualSupplementTypeEnum.I_TRAXX_AUSTRALIA_SWAPTION;
            case "iTraxxAustraliaTranche" -> ContractualSupplementTypeEnum.I_TRAXX_AUSTRALIA_TRANCHE;
            case "iTraxxCJ" -> ContractualSupplementTypeEnum.I_TRAXX_CJ;
            case "iTraxxCJTranche" -> ContractualSupplementTypeEnum.I_TRAXX_CJ_TRANCHE;
            case "iTraxxEurope" -> ContractualSupplementTypeEnum.I_TRAXX_EUROPE;
            case "iTraxxEuropeDealer" -> ContractualSupplementTypeEnum.I_TRAXX_EUROPE_DEALER;
            case "iTraxxEuropeNonDealer" -> ContractualSupplementTypeEnum.I_TRAXX_EUROPE_NON_DEALER;
            case "iTraxxEuropeSwaption" -> ContractualSupplementTypeEnum.I_TRAXX_EUROPE_SWAPTION;
            case "iTraxxEuropeTranche" -> ContractualSupplementTypeEnum.I_TRAXX_EUROPE_TRANCHE;
            case "iTraxxJapan" -> ContractualSupplementTypeEnum.I_TRAXX_JAPAN;
            case "iTraxxJapanSwaption" -> ContractualSupplementTypeEnum.I_TRAXX_JAPAN_SWAPTION;
            case "iTraxxJapanTranche" -> ContractualSupplementTypeEnum.I_TRAXX_JAPAN_TRANCHE;
            case "iTraxxLevX" -> ContractualSupplementTypeEnum.I_TRAXX_LEV_X;
            case "iTraxxSDI75Dealer" -> ContractualSupplementTypeEnum.I_TRAXX_SDI_75_DEALER;
            case "iTraxxSDI75NonDealer" -> ContractualSupplementTypeEnum.I_TRAXX_SDI_75_NON_DEALER;
            case "iTraxxSovX" -> ContractualSupplementTypeEnum.I_TRAXX_SOV_X;
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
