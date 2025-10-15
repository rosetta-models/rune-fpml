package fpml.custom.functions;

import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.ird.InflationRateCalculation;
import fpml.consolidated.loan.LoanFloatingRate;
import fpml.consolidated.shared.Rate;
import fpml.consolidated.shared.StubFloatingRate;
import fpml.custom.RateChoice;

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
