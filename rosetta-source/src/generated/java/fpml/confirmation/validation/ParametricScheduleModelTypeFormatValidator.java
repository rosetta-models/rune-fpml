package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ParametricScheduleModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ParametricScheduleModelTypeFormatValidator implements Validator<ParametricScheduleModel> {

	private List<ComparisonResult> getComparisonResults(ParametricScheduleModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ParametricScheduleModel> validate(RosettaPath path, ParametricScheduleModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ParametricScheduleModel", ValidationType.TYPE_FORMAT, "ParametricScheduleModel", path, "", error);
		}
		return success("ParametricScheduleModel", ValidationType.TYPE_FORMAT, "ParametricScheduleModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParametricScheduleModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ParametricScheduleModel", ValidationType.TYPE_FORMAT, "ParametricScheduleModel", path, "", res.getError());
				}
				return success("ParametricScheduleModel", ValidationType.TYPE_FORMAT, "ParametricScheduleModel", path, "");
			})
			.collect(toList());
	}

}
