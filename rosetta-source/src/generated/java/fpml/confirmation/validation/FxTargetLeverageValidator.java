package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ConditionEnum;
import fpml.confirmation.FxTargetConditionLevelModel;
import fpml.confirmation.FxTargetLeverage;
import fpml.confirmation.FxTargetLeverageSequence;
import fpml.confirmation.Schedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetLeverageValidator implements Validator<FxTargetLeverage> {

	private List<ComparisonResult> getComparisonResults(FxTargetLeverage o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("condition", (ConditionEnum) o.getCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxTargetConditionLevelModel", (FxTargetConditionLevelModel) o.getFxTargetConditionLevelModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("ratio", (Schedule) o.getRatio() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxTargetLeverageSequence", (FxTargetLeverageSequence) o.getFxTargetLeverageSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxTargetLeverage> validate(RosettaPath path, FxTargetLeverage o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetLeverage", ValidationType.CARDINALITY, "FxTargetLeverage", path, "", error);
		}
		return success("FxTargetLeverage", ValidationType.CARDINALITY, "FxTargetLeverage", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetLeverage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetLeverage", ValidationType.CARDINALITY, "FxTargetLeverage", path, "", res.getError());
				}
				return success("FxTargetLeverage", ValidationType.CARDINALITY, "FxTargetLeverage", path, "");
			})
			.collect(toList());
	}

}
