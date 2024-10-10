package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingNonRecurringFee;
import fpml.confirmation.LoanTradingNonRecurringFeeTypeEnum;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonRecurringMiscFeeType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingNonRecurringFeeValidator implements Validator<LoanTradingNonRecurringFee> {

	private List<ComparisonResult> getComparisonResults(LoanTradingNonRecurringFee o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amount", (NonNegativeMoney) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("feeType", (LoanTradingNonRecurringFeeTypeEnum) o.getFeeType() != null ? 1 : 0, 0, 1), 
				checkCardinality("miscFeeType", (NonRecurringMiscFeeType) o.getMiscFeeType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanTradingNonRecurringFee> validate(RosettaPath path, LoanTradingNonRecurringFee o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingNonRecurringFee", ValidationType.CARDINALITY, "LoanTradingNonRecurringFee", path, "", error);
		}
		return success("LoanTradingNonRecurringFee", ValidationType.CARDINALITY, "LoanTradingNonRecurringFee", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingNonRecurringFee o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingNonRecurringFee", ValidationType.CARDINALITY, "LoanTradingNonRecurringFee", path, "", res.getError());
				}
				return success("LoanTradingNonRecurringFee", ValidationType.CARDINALITY, "LoanTradingNonRecurringFee", path, "");
			})
			.collect(toList());
	}

}
