package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualConditionLevelModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualConditionLevelModelTypeFormatValidator implements Validator<FxAccrualConditionLevelModel> {

	private List<ComparisonResult> getComparisonResults(FxAccrualConditionLevelModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualConditionLevelModel> validate(RosettaPath path, FxAccrualConditionLevelModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualConditionLevelModel", ValidationType.TYPE_FORMAT, "FxAccrualConditionLevelModel", path, "", error);
		}
		return success("FxAccrualConditionLevelModel", ValidationType.TYPE_FORMAT, "FxAccrualConditionLevelModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualConditionLevelModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualConditionLevelModel", ValidationType.TYPE_FORMAT, "FxAccrualConditionLevelModel", path, "", res.getError());
				}
				return success("FxAccrualConditionLevelModel", ValidationType.TYPE_FORMAT, "FxAccrualConditionLevelModel", path, "");
			})
			.collect(toList());
	}

}
