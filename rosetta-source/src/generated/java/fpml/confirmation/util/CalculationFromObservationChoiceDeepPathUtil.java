package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.CalculationFromObservationChoiceSequence;
import fpml.confirmation.DeterminationMethod;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class CalculationFromObservationChoiceDeepPathUtil {
	public DeterminationMethod chooseInitialLevelSource(CalculationFromObservationChoice calculationFromObservationChoice) {
		final MapperS<CalculationFromObservationChoiceSequence> calculationFromObservationChoiceSequence = MapperS.of(calculationFromObservationChoice).<CalculationFromObservationChoiceSequence>map("getCalculationFromObservationChoiceSequence", _calculationFromObservationChoice -> _calculationFromObservationChoice.getCalculationFromObservationChoiceSequence());
		if (exists(calculationFromObservationChoiceSequence).getOrDefault(false)) {
			return calculationFromObservationChoiceSequence.<DeterminationMethod>map("getInitialLevelSource", _calculationFromObservationChoiceSequence -> _calculationFromObservationChoiceSequence.getInitialLevelSource()).get();
		}
		final MapperS<DeterminationMethod> initialLevelSource = MapperS.of(calculationFromObservationChoice).<DeterminationMethod>map("getInitialLevelSource", _calculationFromObservationChoice -> _calculationFromObservationChoice.getInitialLevelSource());
		if (exists(initialLevelSource).getOrDefault(false)) {
			return initialLevelSource.get();
		}
		return null;
	}
	
}
