package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualLeverageSequence;
import fpml.confirmation.FxCounterCurrencyAmount;
import fpml.confirmation.NonNegativeAmountSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualLeverageSequenceValidator implements Validator<FxAccrualLeverageSequence> {

	private List<ComparisonResult> getComparisonResults(FxAccrualLeverageSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalAmount", (NonNegativeAmountSchedule) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterCurrencyAmount", (FxCounterCurrencyAmount) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualLeverageSequence> validate(RosettaPath path, FxAccrualLeverageSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualLeverageSequence", ValidationType.CARDINALITY, "FxAccrualLeverageSequence", path, "", error);
		}
		return success("FxAccrualLeverageSequence", ValidationType.CARDINALITY, "FxAccrualLeverageSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualLeverageSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualLeverageSequence", ValidationType.CARDINALITY, "FxAccrualLeverageSequence", path, "", res.getError());
				}
				return success("FxAccrualLeverageSequence", ValidationType.CARDINALITY, "FxAccrualLeverageSequence", path, "");
			})
			.collect(toList());
	}

}
