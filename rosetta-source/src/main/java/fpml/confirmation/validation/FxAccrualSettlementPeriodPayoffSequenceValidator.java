package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualSettlementPeriodPayoffSequence;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualSettlementPeriodPayoffSequenceValidator implements Validator<FxAccrualSettlementPeriodPayoffSequence> {

	private List<ComparisonResult> getComparisonResults(FxAccrualSettlementPeriodPayoffSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("strike", (BigDecimal) o.getStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterCurrencyAmount", (BigDecimal) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualSettlementPeriodPayoffSequence> validate(RosettaPath path, FxAccrualSettlementPeriodPayoffSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualSettlementPeriodPayoffSequence", ValidationType.CARDINALITY, "FxAccrualSettlementPeriodPayoffSequence", path, "", error);
		}
		return success("FxAccrualSettlementPeriodPayoffSequence", ValidationType.CARDINALITY, "FxAccrualSettlementPeriodPayoffSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualSettlementPeriodPayoffSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualSettlementPeriodPayoffSequence", ValidationType.CARDINALITY, "FxAccrualSettlementPeriodPayoffSequence", path, "", res.getError());
				}
				return success("FxAccrualSettlementPeriodPayoffSequence", ValidationType.CARDINALITY, "FxAccrualSettlementPeriodPayoffSequence", path, "");
			})
			.collect(toList());
	}

}
