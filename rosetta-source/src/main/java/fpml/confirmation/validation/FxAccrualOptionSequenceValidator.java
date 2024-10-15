package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualOptionSequence;
import fpml.confirmation.FxOptionStrikePrice;
import fpml.confirmation.NonNegativeAmountSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualOptionSequenceValidator implements Validator<FxAccrualOptionSequence> {

	private List<ComparisonResult> getComparisonResults(FxAccrualOptionSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("strike", (FxOptionStrikePrice) o.getStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterCurrencyAmount", (NonNegativeAmountSchedule) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualOptionSequence> validate(RosettaPath path, FxAccrualOptionSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualOptionSequence", ValidationType.CARDINALITY, "FxAccrualOptionSequence", path, "", error);
		}
		return success("FxAccrualOptionSequence", ValidationType.CARDINALITY, "FxAccrualOptionSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualOptionSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualOptionSequence", ValidationType.CARDINALITY, "FxAccrualOptionSequence", path, "", res.getError());
				}
				return success("FxAccrualOptionSequence", ValidationType.CARDINALITY, "FxAccrualOptionSequence", path, "");
			})
			.collect(toList());
	}

}
