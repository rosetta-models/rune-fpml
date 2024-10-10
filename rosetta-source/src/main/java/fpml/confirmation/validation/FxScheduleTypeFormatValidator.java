package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxScheduleTypeFormatValidator implements Validator<FxSchedule> {

	private List<ComparisonResult> getComparisonResults(FxSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxSchedule> validate(RosettaPath path, FxSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxSchedule", ValidationType.TYPE_FORMAT, "FxSchedule", path, "", error);
		}
		return success("FxSchedule", ValidationType.TYPE_FORMAT, "FxSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxSchedule", ValidationType.TYPE_FORMAT, "FxSchedule", path, "", res.getError());
				}
				return success("FxSchedule", ValidationType.TYPE_FORMAT, "FxSchedule", path, "");
			})
			.collect(toList());
	}

}
