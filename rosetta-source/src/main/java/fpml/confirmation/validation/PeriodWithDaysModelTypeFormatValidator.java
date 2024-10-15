package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PeriodWithDaysModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PeriodWithDaysModelTypeFormatValidator implements Validator<PeriodWithDaysModel> {

	private List<ComparisonResult> getComparisonResults(PeriodWithDaysModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PeriodWithDaysModel> validate(RosettaPath path, PeriodWithDaysModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PeriodWithDaysModel", ValidationType.TYPE_FORMAT, "PeriodWithDaysModel", path, "", error);
		}
		return success("PeriodWithDaysModel", ValidationType.TYPE_FORMAT, "PeriodWithDaysModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PeriodWithDaysModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PeriodWithDaysModel", ValidationType.TYPE_FORMAT, "PeriodWithDaysModel", path, "", res.getError());
				}
				return success("PeriodWithDaysModel", ValidationType.TYPE_FORMAT, "PeriodWithDaysModel", path, "");
			})
			.collect(toList());
	}

}
