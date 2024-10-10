package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationPeriodsScheduleReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CalculationPeriodsScheduleReferenceValidator implements Validator<CalculationPeriodsScheduleReference> {

	private List<ComparisonResult> getComparisonResults(CalculationPeriodsScheduleReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CalculationPeriodsScheduleReference> validate(RosettaPath path, CalculationPeriodsScheduleReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CalculationPeriodsScheduleReference", ValidationType.CARDINALITY, "CalculationPeriodsScheduleReference", path, "", error);
		}
		return success("CalculationPeriodsScheduleReference", ValidationType.CARDINALITY, "CalculationPeriodsScheduleReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationPeriodsScheduleReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationPeriodsScheduleReference", ValidationType.CARDINALITY, "CalculationPeriodsScheduleReference", path, "", res.getError());
				}
				return success("CalculationPeriodsScheduleReference", ValidationType.CARDINALITY, "CalculationPeriodsScheduleReference", path, "");
			})
			.collect(toList());
	}

}
