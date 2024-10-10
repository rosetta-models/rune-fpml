package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualConditionLevelModel;
import fpml.confirmation.FxAccrualRegionLowerBound;
import fpml.confirmation.FxRegionLowerBoundDirectionEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualRegionLowerBoundValidator implements Validator<FxAccrualRegionLowerBound> {

	private List<ComparisonResult> getComparisonResults(FxAccrualRegionLowerBound o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("condition", (FxRegionLowerBoundDirectionEnum) o.getCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxAccrualConditionLevelModel", (FxAccrualConditionLevelModel) o.getFxAccrualConditionLevelModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualRegionLowerBound> validate(RosettaPath path, FxAccrualRegionLowerBound o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualRegionLowerBound", ValidationType.CARDINALITY, "FxAccrualRegionLowerBound", path, "", error);
		}
		return success("FxAccrualRegionLowerBound", ValidationType.CARDINALITY, "FxAccrualRegionLowerBound", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegionLowerBound o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualRegionLowerBound", ValidationType.CARDINALITY, "FxAccrualRegionLowerBound", path, "", res.getError());
				}
				return success("FxAccrualRegionLowerBound", ValidationType.CARDINALITY, "FxAccrualRegionLowerBound", path, "");
			})
			.collect(toList());
	}

}
