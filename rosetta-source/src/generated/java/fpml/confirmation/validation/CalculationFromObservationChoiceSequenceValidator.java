package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationFromObservationChoiceSequence;
import fpml.confirmation.DeterminationMethod;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CalculationFromObservationChoiceSequenceValidator implements Validator<CalculationFromObservationChoiceSequence> {

	private List<ComparisonResult> getComparisonResults(CalculationFromObservationChoiceSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialLevel", (BigDecimal) o.getInitialLevel() != null ? 1 : 0, 1, 1), 
				checkCardinality("initialLevelSource", (DeterminationMethod) o.getInitialLevelSource() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CalculationFromObservationChoiceSequence> validate(RosettaPath path, CalculationFromObservationChoiceSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CalculationFromObservationChoiceSequence", ValidationType.CARDINALITY, "CalculationFromObservationChoiceSequence", path, "", error);
		}
		return success("CalculationFromObservationChoiceSequence", ValidationType.CARDINALITY, "CalculationFromObservationChoiceSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationFromObservationChoiceSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationFromObservationChoiceSequence", ValidationType.CARDINALITY, "CalculationFromObservationChoiceSequence", path, "", res.getError());
				}
				return success("CalculationFromObservationChoiceSequence", ValidationType.CARDINALITY, "CalculationFromObservationChoiceSequence", path, "");
			})
			.collect(toList());
	}

}
