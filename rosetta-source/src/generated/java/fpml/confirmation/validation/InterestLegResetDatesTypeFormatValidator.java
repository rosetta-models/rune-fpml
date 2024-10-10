package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InterestLegResetDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestLegResetDatesTypeFormatValidator implements Validator<InterestLegResetDates> {

	private List<ComparisonResult> getComparisonResults(InterestLegResetDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InterestLegResetDates> validate(RosettaPath path, InterestLegResetDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestLegResetDates", ValidationType.TYPE_FORMAT, "InterestLegResetDates", path, "", error);
		}
		return success("InterestLegResetDates", ValidationType.TYPE_FORMAT, "InterestLegResetDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestLegResetDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestLegResetDates", ValidationType.TYPE_FORMAT, "InterestLegResetDates", path, "", res.getError());
				}
				return success("InterestLegResetDates", ValidationType.TYPE_FORMAT, "InterestLegResetDates", path, "");
			})
			.collect(toList());
	}

}
