package com.regnosys.fpml.ingest.types.functions;

import cdm.product.common.schedule.CalculationPeriodDates;
import com.rosetta.model.metafields.MetaFields;
import fpml.ingest.types.functions.EnrichEmptyCalculationPeriodDatesWithExternalKey;

import java.util.Optional;

public class EnrichEmptyCalculationPeriodDatesWithExternalKeyImpl extends EnrichEmptyCalculationPeriodDatesWithExternalKey {
    @Override
    protected CalculationPeriodDates.CalculationPeriodDatesBuilder doEvaluate(String href) {
        return Optional.ofNullable(href)
                .map(h ->CalculationPeriodDates.builder().setMeta(MetaFields.builder().setExternalKey(h).build()))
                .orElse(null);
    }
}
