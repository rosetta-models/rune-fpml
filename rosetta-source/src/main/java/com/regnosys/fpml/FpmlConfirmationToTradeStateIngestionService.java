package com.regnosys.fpml;

import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import com.google.inject.Module;
import com.regnosys.ingest.IngestionService;
import com.regnosys.rosetta.common.util.Report;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import fpml.confirmation.DataDocument;

import java.util.Optional;

public class FpmlConfirmationToTradeStateIngestionService implements IngestionService {

    private final Module runtimeModule;

    public FpmlConfirmationToTradeStateIngestionService(Module runtimeModule) {
        this.runtimeModule = runtimeModule;
    }

    @Override
    public <T extends RosettaModelObject> Report<T> ingestAndPostProcess(DataDocument dataDocument) {
        return getTradeState(dataDocument)
                .map(tradeState -> new Report(tradeState))
                .orElse(null);
    }

    public Optional<TradeState> getTradeState(DataDocument dataDocument) {
        return Optional.ofNullable(dataDocument)
                .map(dataDocument1 ->
                        TradeState.builder()
                                .setTrade(Trade.builder()
                                        .setTradeDate(FieldWithMetaDate.builder()
                                                .setValue(Date.of(2024, 10, 10))))
                                .build());
    }
}
