package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxRegionUpperBoundDirectionEnum;
import fpml.confirmation.FxTargetConditionLevelModel;
import fpml.confirmation.FxTargetRegionUpperBound;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetRegionUpperBoundValidator implements Validator<FxTargetRegionUpperBound> {

	private List<ComparisonResult> getComparisonResults(FxTargetRegionUpperBound o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("condition", (FxRegionUpperBoundDirectionEnum) o.getCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxTargetConditionLevelModel", (FxTargetConditionLevelModel) o.getFxTargetConditionLevelModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxTargetRegionUpperBound> validate(RosettaPath path, FxTargetRegionUpperBound o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetRegionUpperBound", ValidationType.CARDINALITY, "FxTargetRegionUpperBound", path, "", error);
		}
		return success("FxTargetRegionUpperBound", ValidationType.CARDINALITY, "FxTargetRegionUpperBound", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetRegionUpperBound o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetRegionUpperBound", ValidationType.CARDINALITY, "FxTargetRegionUpperBound", path, "", res.getError());
				}
				return success("FxTargetRegionUpperBound", ValidationType.CARDINALITY, "FxTargetRegionUpperBound", path, "");
			})
			.collect(toList());
	}

}
