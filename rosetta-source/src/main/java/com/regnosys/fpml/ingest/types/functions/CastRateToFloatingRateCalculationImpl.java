package com.regnosys.fpml.ingest.types.functions;

import fpml.confirmation.FloatingRateCalculation;
import fpml.confirmation.Rate;
import fpml.ingest.types.functions.CastRateToFloatingRateCalculation;

import java.util.Optional;

public class CastRateToFloatingRateCalculationImpl extends CastRateToFloatingRateCalculation {
    @Override
    protected FloatingRateCalculation.FloatingRateCalculationBuilder doEvaluate(Rate fpmlRate) {
        return (FloatingRateCalculation.FloatingRateCalculationBuilder) Optional.ofNullable(fpmlRate)
                .map(Rate::toBuilder)
                .filter(x -> x instanceof FloatingRateCalculation.FloatingRateCalculationBuilder)
                .orElse(null);
    }
}
