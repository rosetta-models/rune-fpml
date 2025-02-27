package fpml.confirmation.custom.functions;

import fpml.confirmation.*;
import fpml.confirmation.custom.RateChoice;

public class ToRateChoiceImpl extends ToRateChoice {

    @Override
    protected RateChoice.RateChoiceBuilder doEvaluate(Rate rate) {
        RateChoice.RateChoiceBuilder builder = RateChoice.builder();
        if (rate instanceof InflationRateCalculation) {
            return builder.setInflationRateCalculation(((InflationRateCalculation) rate));
        } else if (rate instanceof LoanFloatingRate) {
            return builder.setLoanFloatingRate(((LoanFloatingRate) rate));
        } else if (rate instanceof FloatingRateCalculation) {
            return builder.setFloatingRateCalculation(((FloatingRateCalculation) rate));
        } else if (rate instanceof StubFloatingRate) {
            return builder.setStubFloatingRate(((StubFloatingRate) rate));
        }
        return builder;
    }
}
