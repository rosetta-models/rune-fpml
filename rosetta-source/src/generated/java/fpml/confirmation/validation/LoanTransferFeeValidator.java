package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuySellEnum;
import fpml.confirmation.BuyerSellerAmounts;
import fpml.confirmation.LoanTransferFee;
import fpml.confirmation.LoanTransferFeeSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTransferFeeValidator implements Validator<LoanTransferFee> {

	private List<ComparisonResult> getComparisonResults(LoanTransferFee o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("remittedBy", (BuySellEnum) o.getRemittedBy() != null ? 1 : 0, 1, 1), 
				checkCardinality("loanTransferFeeSequence", (LoanTransferFeeSequence) o.getLoanTransferFeeSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("transferFeeAmounts", (BuyerSellerAmounts) o.getTransferFeeAmounts() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanTransferFee> validate(RosettaPath path, LoanTransferFee o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTransferFee", ValidationType.CARDINALITY, "LoanTransferFee", path, "", error);
		}
		return success("LoanTransferFee", ValidationType.CARDINALITY, "LoanTransferFee", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTransferFee o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTransferFee", ValidationType.CARDINALITY, "LoanTransferFee", path, "", res.getError());
				}
				return success("LoanTransferFee", ValidationType.CARDINALITY, "LoanTransferFee", path, "");
			})
			.collect(toList());
	}

}
