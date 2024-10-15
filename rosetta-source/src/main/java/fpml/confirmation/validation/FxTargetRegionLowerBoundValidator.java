package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxRegionLowerBoundDirectionEnum;
import fpml.confirmation.FxTargetConditionLevelModel;
import fpml.confirmation.FxTargetRegionLowerBound;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetRegionLowerBoundValidator implements Validator<FxTargetRegionLowerBound> {

	private List<ComparisonResult> getComparisonResults(FxTargetRegionLowerBound o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("condition", (FxRegionLowerBoundDirectionEnum) o.getCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxTargetConditionLevelModel", (FxTargetConditionLevelModel) o.getFxTargetConditionLevelModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxTargetRegionLowerBound> validate(RosettaPath path, FxTargetRegionLowerBound o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetRegionLowerBound", ValidationType.CARDINALITY, "FxTargetRegionLowerBound", path, "", error);
		}
		return success("FxTargetRegionLowerBound", ValidationType.CARDINALITY, "FxTargetRegionLowerBound", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetRegionLowerBound o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetRegionLowerBound", ValidationType.CARDINALITY, "FxTargetRegionLowerBound", path, "", res.getError());
				}
				return success("FxTargetRegionLowerBound", ValidationType.CARDINALITY, "FxTargetRegionLowerBound", path, "");
			})
			.collect(toList());
	}

}
