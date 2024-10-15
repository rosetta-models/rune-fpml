package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InterestLegCalculationPeriodDatesReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestLegCalculationPeriodDatesReferenceTypeFormatValidator implements Validator<InterestLegCalculationPeriodDatesReference> {

	private List<ComparisonResult> getComparisonResults(InterestLegCalculationPeriodDatesReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InterestLegCalculationPeriodDatesReference> validate(RosettaPath path, InterestLegCalculationPeriodDatesReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestLegCalculationPeriodDatesReference", ValidationType.TYPE_FORMAT, "InterestLegCalculationPeriodDatesReference", path, "", error);
		}
		return success("InterestLegCalculationPeriodDatesReference", ValidationType.TYPE_FORMAT, "InterestLegCalculationPeriodDatesReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestLegCalculationPeriodDatesReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestLegCalculationPeriodDatesReference", ValidationType.TYPE_FORMAT, "InterestLegCalculationPeriodDatesReference", path, "", res.getError());
				}
				return success("InterestLegCalculationPeriodDatesReference", ValidationType.TYPE_FORMAT, "InterestLegCalculationPeriodDatesReference", path, "");
			})
			.collect(toList());
	}

}
