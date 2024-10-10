package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ConditionEnum;
import fpml.confirmation.FxAccrualConditionLevelModel;
import fpml.confirmation.FxAccrualLeverage;
import fpml.confirmation.FxAccrualLeverageSequence;
import fpml.confirmation.Schedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualLeverageValidator implements Validator<FxAccrualLeverage> {

	private List<ComparisonResult> getComparisonResults(FxAccrualLeverage o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("condition", (ConditionEnum) o.getCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxAccrualConditionLevelModel", (FxAccrualConditionLevelModel) o.getFxAccrualConditionLevelModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("ratio", (Schedule) o.getRatio() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxAccrualLeverageSequence", (FxAccrualLeverageSequence) o.getFxAccrualLeverageSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualLeverage> validate(RosettaPath path, FxAccrualLeverage o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualLeverage", ValidationType.CARDINALITY, "FxAccrualLeverage", path, "", error);
		}
		return success("FxAccrualLeverage", ValidationType.CARDINALITY, "FxAccrualLeverage", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualLeverage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualLeverage", ValidationType.CARDINALITY, "FxAccrualLeverage", path, "", res.getError());
				}
				return success("FxAccrualLeverage", ValidationType.CARDINALITY, "FxAccrualLeverage", path, "");
			})
			.collect(toList());
	}

}
