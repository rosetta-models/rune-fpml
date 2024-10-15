package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTransferFeePaidByEnum;
import fpml.confirmation.LoanTransferFeeSequence;
import fpml.confirmation.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTransferFeeSequenceValidator implements Validator<LoanTransferFeeSequence> {

	private List<ComparisonResult> getComparisonResults(LoanTransferFeeSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("paidBy", (LoanTransferFeePaidByEnum) o.getPaidBy() != null ? 1 : 0, 1, 1), 
				checkCardinality("totalAmount", (NonNegativeMoney) o.getTotalAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanTransferFeeSequence> validate(RosettaPath path, LoanTransferFeeSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTransferFeeSequence", ValidationType.CARDINALITY, "LoanTransferFeeSequence", path, "", error);
		}
		return success("LoanTransferFeeSequence", ValidationType.CARDINALITY, "LoanTransferFeeSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTransferFeeSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTransferFeeSequence", ValidationType.CARDINALITY, "LoanTransferFeeSequence", path, "", res.getError());
				}
				return success("LoanTransferFeeSequence", ValidationType.CARDINALITY, "LoanTransferFeeSequence", path, "");
			})
			.collect(toList());
	}

}
