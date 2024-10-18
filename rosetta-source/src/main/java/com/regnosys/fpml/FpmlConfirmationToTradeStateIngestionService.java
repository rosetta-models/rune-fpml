package com.regnosys.fpml;

import cdm.base.staticdata.party.Party;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import com.google.inject.Module;
import com.regnosys.ingest.IngestionService;
import com.regnosys.rosetta.common.util.Report;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.metafields.FieldWithMetaDate;
import com.rosetta.model.metafields.FieldWithMetaString;
import fpml.confirmation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FpmlConfirmationToTradeStateIngestionService implements IngestionService {

    private final Module runtimeModule;

    public FpmlConfirmationToTradeStateIngestionService(Module runtimeModule) {
        this.runtimeModule = runtimeModule;
    }

    @Override
    public <T extends RosettaModelObject> Report<T> ingestAndPostProcess(DataDocument dataDocument) {
        return getTradeState(dataDocument)
                .map(TradeState.TradeStateBuilder::prune)
                .map(TradeState.TradeStateBuilder::build)
                .map(tradeState -> new Report(tradeState))
                .orElse(null);
    }

    public Optional<TradeState.TradeStateBuilder> getTradeState(DataDocument dataDocument) {
        return Optional.ofNullable(dataDocument)
                .map(d -> {
                    TradeState.TradeStateBuilder tradeStateBuilder = TradeState.builder();
                    getTrade(d).ifPresent(tradeStateBuilder::setTrade);
                    return tradeStateBuilder;
                });
    }

    public Optional<Trade.TradeBuilder> getTrade(DataDocument fpmlDataDocument) {
        return Optional.ofNullable(fpmlDataDocument)
                .map(d -> {
                    Trade.TradeBuilder tradeBuilder = Trade.builder();
                    tradeBuilder.setParty(getParty(d.getPartiesAndAccountsModel()));
                    fpml.confirmation.Trade fpmlTrade = Optional.ofNullable(d.getTrade()).orElse(Collections.emptyList()).stream().findFirst().orElse(null); // only support 1 trade per dataDocument
                    getTradeDate(fpmlTrade).ifPresent(tradeBuilder::setTradeDate);
                    return tradeBuilder;
                });
    }

    private Optional<FieldWithMetaDate.FieldWithMetaDateBuilder> getTradeDate(fpml.confirmation.Trade fpmlTrade) {
        return Optional.ofNullable(fpmlTrade)
                .map(fpml.confirmation.Trade::getTradeHeader)
                .map(TradeHeader::getTradeDate)
                .map(td -> {
                    FieldWithMetaDate.FieldWithMetaDateBuilder fieldWithMetaDate = FieldWithMetaDate.builder();
                    Optional.ofNullable(td.getId()).ifPresent(fieldWithMetaDate.getOrCreateMeta()::setExternalKey);
                    Optional.ofNullable(td.getValue()).ifPresent(fieldWithMetaDate::setValue);
                    return fieldWithMetaDate;
                });
    }

    public List<Party.PartyBuilder> getParty(PartiesAndAccountsModel fpmlPartiesAndAccountsModel) {
        return Optional.ofNullable(fpmlPartiesAndAccountsModel)
                .map(PartiesAndAccountsModel::getParty)
                .orElse(Collections.emptyList())
                .stream()
                .map(p -> {
                    Party.PartyBuilder partyBuilder = Party.builder();
                    PartyName fpmlPartyName = Optional.ofNullable(p.getPartyModel()).map(PartyModel::getPartyName).orElse(null);
                    getFieldWithMetaString(fpmlPartyName).ifPresent(partyBuilder::setName);
                    return partyBuilder;
                })
                .toList();
    }

    public Optional<FieldWithMetaString.FieldWithMetaStringBuilder> getFieldWithMetaString(PartyName fpmlPartyName) {
        return Optional.ofNullable(fpmlPartyName)
                .map(pn -> {
                    FieldWithMetaString.FieldWithMetaStringBuilder fieldWithMetaStringBuilder = FieldWithMetaString.builder();
                    Optional.ofNullable(pn.getValue()).ifPresent(fieldWithMetaStringBuilder::setValue);
                    Optional.ofNullable(pn.getPartyNameScheme()).ifPresent(fieldWithMetaStringBuilder.getOrCreateMeta()::setScheme);
                    return fieldWithMetaStringBuilder;
                });
    }
}
