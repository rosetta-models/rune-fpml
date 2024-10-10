package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationPeriodDatesReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CalculationPeriodDatesReferenceTypeFormatValidator implements Validator<CalculationPeriodDatesReference> {

	private List<ComparisonResult> getComparisonResults(CalculationPeriodDatesReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CalculationPeriodDatesReference> validate(RosettaPath path, CalculationPeriodDatesReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CalculationPeriodDatesReference", ValidationType.TYPE_FORMAT, "CalculationPeriodDatesReference", path, "", error);
		}
		return success("CalculationPeriodDatesReference", ValidationType.TYPE_FORMAT, "CalculationPeriodDatesReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationPeriodDatesReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationPeriodDatesReference", ValidationType.TYPE_FORMAT, "CalculationPeriodDatesReference", path, "", res.getError());
				}
				return success("CalculationPeriodDatesReference", ValidationType.TYPE_FORMAT, "CalculationPeriodDatesReference", path, "");
			})
			.collect(toList());
	}

}
