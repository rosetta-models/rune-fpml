package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.CalculationFromObservationChoiceSequence;
import fpml.confirmation.DeterminationMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CalculationFromObservationChoiceValidator implements Validator<CalculationFromObservationChoice> {

	private List<ComparisonResult> getComparisonResults(CalculationFromObservationChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationFromObservationChoiceSequence", (CalculationFromObservationChoiceSequence) o.getCalculationFromObservationChoiceSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialLevelSource", (DeterminationMethod) o.getInitialLevelSource() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CalculationFromObservationChoice> validate(RosettaPath path, CalculationFromObservationChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CalculationFromObservationChoice", ValidationType.CARDINALITY, "CalculationFromObservationChoice", path, "", error);
		}
		return success("CalculationFromObservationChoice", ValidationType.CARDINALITY, "CalculationFromObservationChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationFromObservationChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationFromObservationChoice", ValidationType.CARDINALITY, "CalculationFromObservationChoice", path, "", res.getError());
				}
				return success("CalculationFromObservationChoice", ValidationType.CARDINALITY, "CalculationFromObservationChoice", path, "");
			})
			.collect(toList());
	}

}
