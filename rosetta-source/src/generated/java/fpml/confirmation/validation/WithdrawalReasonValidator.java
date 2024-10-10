package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.WithdrawalReason;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WithdrawalReasonValidator implements Validator<WithdrawalReason> {

	private List<ComparisonResult> getComparisonResults(WithdrawalReason o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("withdrawalReasonScheme", (String) o.getWithdrawalReasonScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<WithdrawalReason> validate(RosettaPath path, WithdrawalReason o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WithdrawalReason", ValidationType.CARDINALITY, "WithdrawalReason", path, "", error);
		}
		return success("WithdrawalReason", ValidationType.CARDINALITY, "WithdrawalReason", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WithdrawalReason o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WithdrawalReason", ValidationType.CARDINALITY, "WithdrawalReason", path, "", res.getError());
				}
				return success("WithdrawalReason", ValidationType.CARDINALITY, "WithdrawalReason", path, "");
			})
			.collect(toList());
	}

}
