package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationFromObservation;
import fpml.confirmation.CalculationFromObservationChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CalculationFromObservationValidator implements Validator<CalculationFromObservation> {

	private List<ComparisonResult> getComparisonResults(CalculationFromObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationFromObservationChoice", (CalculationFromObservationChoice) o.getCalculationFromObservationChoice() != null ? 1 : 0, 0, 1), 
				checkCardinality("closingLevel", (Boolean) o.getClosingLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiringLevel", (Boolean) o.getExpiringLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("expectedN", (Integer) o.getExpectedN() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CalculationFromObservation> validate(RosettaPath path, CalculationFromObservation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CalculationFromObservation", ValidationType.CARDINALITY, "CalculationFromObservation", path, "", error);
		}
		return success("CalculationFromObservation", ValidationType.CARDINALITY, "CalculationFromObservation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationFromObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationFromObservation", ValidationType.CARDINALITY, "CalculationFromObservation", path, "", res.getError());
				}
				return success("CalculationFromObservation", ValidationType.CARDINALITY, "CalculationFromObservation", path, "");
			})
			.collect(toList());
	}

}
