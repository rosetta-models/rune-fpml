package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.FeeLegChoice;
import fpml.confirmation.FeeLegChoiceSequence0;
import fpml.confirmation.FeeLegChoiceSequence1;
import fpml.confirmation.PeriodicPayment;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class FeeLegChoiceDeepPathUtil {
	public PeriodicPayment choosePeriodicPayment(FeeLegChoice feeLegChoice) {
		final MapperS<FeeLegChoiceSequence0> feeLegChoiceSequence0 = MapperS.of(feeLegChoice).<FeeLegChoiceSequence0>map("getFeeLegChoiceSequence0", _feeLegChoice -> _feeLegChoice.getFeeLegChoiceSequence0());
		if (exists(feeLegChoiceSequence0).getOrDefault(false)) {
			return feeLegChoiceSequence0.<PeriodicPayment>map("getPeriodicPayment", _feeLegChoiceSequence0 -> _feeLegChoiceSequence0.getPeriodicPayment()).get();
		}
		final MapperS<FeeLegChoiceSequence1> feeLegChoiceSequence1 = MapperS.of(feeLegChoice).<FeeLegChoiceSequence1>map("getFeeLegChoiceSequence1", _feeLegChoice -> _feeLegChoice.getFeeLegChoiceSequence1());
		if (exists(feeLegChoiceSequence1).getOrDefault(false)) {
			return feeLegChoiceSequence1.<PeriodicPayment>map("getPeriodicPayment", _feeLegChoiceSequence1 -> _feeLegChoiceSequence1.getPeriodicPayment()).get();
		}
		return null;
	}
	
}
