package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RequestedWithdrawalAction;
import fpml.confirmation.Trade;
import fpml.confirmation.Withdrawal;
import fpml.confirmation.WithdrawalSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WithdrawalValidator implements Validator<Withdrawal> {

	private List<ComparisonResult> getComparisonResults(Withdrawal o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("withdrawalSequence", (WithdrawalSequence) o.getWithdrawalSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("trade", (Trade) o.getTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (Date) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("requestedAction", (RequestedWithdrawalAction) o.getRequestedAction() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Withdrawal> validate(RosettaPath path, Withdrawal o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Withdrawal", ValidationType.CARDINALITY, "Withdrawal", path, "", error);
		}
		return success("Withdrawal", ValidationType.CARDINALITY, "Withdrawal", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Withdrawal o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Withdrawal", ValidationType.CARDINALITY, "Withdrawal", path, "", res.getError());
				}
				return success("Withdrawal", ValidationType.CARDINALITY, "Withdrawal", path, "");
			})
			.collect(toList());
	}

}
