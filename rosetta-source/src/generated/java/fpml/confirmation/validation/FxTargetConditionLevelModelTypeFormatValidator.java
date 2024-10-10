package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetConditionLevelModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetConditionLevelModelTypeFormatValidator implements Validator<FxTargetConditionLevelModel> {

	private List<ComparisonResult> getComparisonResults(FxTargetConditionLevelModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxTargetConditionLevelModel> validate(RosettaPath path, FxTargetConditionLevelModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetConditionLevelModel", ValidationType.TYPE_FORMAT, "FxTargetConditionLevelModel", path, "", error);
		}
		return success("FxTargetConditionLevelModel", ValidationType.TYPE_FORMAT, "FxTargetConditionLevelModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetConditionLevelModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetConditionLevelModel", ValidationType.TYPE_FORMAT, "FxTargetConditionLevelModel", path, "", res.getError());
				}
				return success("FxTargetConditionLevelModel", ValidationType.TYPE_FORMAT, "FxTargetConditionLevelModel", path, "");
			})
			.collect(toList());
	}

}
