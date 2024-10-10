package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxWeightedFixingSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxWeightedFixingScheduleTypeFormatValidator implements Validator<FxWeightedFixingSchedule> {

	private List<ComparisonResult> getComparisonResults(FxWeightedFixingSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxWeightedFixingSchedule> validate(RosettaPath path, FxWeightedFixingSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxWeightedFixingSchedule", ValidationType.TYPE_FORMAT, "FxWeightedFixingSchedule", path, "", error);
		}
		return success("FxWeightedFixingSchedule", ValidationType.TYPE_FORMAT, "FxWeightedFixingSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxWeightedFixingSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxWeightedFixingSchedule", ValidationType.TYPE_FORMAT, "FxWeightedFixingSchedule", path, "", res.getError());
				}
				return success("FxWeightedFixingSchedule", ValidationType.TYPE_FORMAT, "FxWeightedFixingSchedule", path, "");
			})
			.collect(toList());
	}

}
