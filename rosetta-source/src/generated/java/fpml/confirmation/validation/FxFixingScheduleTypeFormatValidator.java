package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxFixingSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxFixingScheduleTypeFormatValidator implements Validator<FxFixingSchedule> {

	private List<ComparisonResult> getComparisonResults(FxFixingSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxFixingSchedule> validate(RosettaPath path, FxFixingSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxFixingSchedule", ValidationType.TYPE_FORMAT, "FxFixingSchedule", path, "", error);
		}
		return success("FxFixingSchedule", ValidationType.TYPE_FORMAT, "FxFixingSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFixingSchedule", ValidationType.TYPE_FORMAT, "FxFixingSchedule", path, "", res.getError());
				}
				return success("FxFixingSchedule", ValidationType.TYPE_FORMAT, "FxFixingSchedule", path, "");
			})
			.collect(toList());
	}

}
