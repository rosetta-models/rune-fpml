package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.LoanTradingAccruingFeeAccrual;
import fpml.confirmation.LoanTradingAccruingFeeTypeEnum;
import fpml.confirmation.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingAccruingFeeAccrualValidator implements Validator<LoanTradingAccruingFeeAccrual> {

	private List<ComparisonResult> getComparisonResults(LoanTradingAccruingFeeAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amount", (NonNegativeMoney) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("accrualTypeId", (AccrualTypeId) o.getAccrualTypeId() != null ? 1 : 0, 1, 1), 
				checkCardinality("type", (LoanTradingAccruingFeeTypeEnum) o.getType_() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanTradingAccruingFeeAccrual> validate(RosettaPath path, LoanTradingAccruingFeeAccrual o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingAccruingFeeAccrual", ValidationType.CARDINALITY, "LoanTradingAccruingFeeAccrual", path, "", error);
		}
		return success("LoanTradingAccruingFeeAccrual", ValidationType.CARDINALITY, "LoanTradingAccruingFeeAccrual", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingAccruingFeeAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingAccruingFeeAccrual", ValidationType.CARDINALITY, "LoanTradingAccruingFeeAccrual", path, "", res.getError());
				}
				return success("LoanTradingAccruingFeeAccrual", ValidationType.CARDINALITY, "LoanTradingAccruingFeeAccrual", path, "");
			})
			.collect(toList());
	}

}
