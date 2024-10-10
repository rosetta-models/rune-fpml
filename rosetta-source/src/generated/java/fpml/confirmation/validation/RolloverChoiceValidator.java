package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Borrowing;
import fpml.confirmation.CommitmentAdjustment;
import fpml.confirmation.InterestCapitalization;
import fpml.confirmation.LoanContractBaseRateSet;
import fpml.confirmation.LoanInterestPayment;
import fpml.confirmation.Repayment;
import fpml.confirmation.RolloverChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RolloverChoiceValidator implements Validator<RolloverChoice> {

	private List<ComparisonResult> getComparisonResults(RolloverChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("baseRateSet", (LoanContractBaseRateSet) o.getBaseRateSet() != null ? 1 : 0, 0, 1), 
				checkCardinality("borrowing", (Borrowing) o.getBorrowing() != null ? 1 : 0, 0, 1), 
				checkCardinality("commitmentAdjustment", (CommitmentAdjustment) o.getCommitmentAdjustment() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestCapitalization", (InterestCapitalization) o.getInterestCapitalization() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestPayment", (LoanInterestPayment) o.getInterestPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("repayment", (Repayment) o.getRepayment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<RolloverChoice> validate(RosettaPath path, RolloverChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RolloverChoice", ValidationType.CARDINALITY, "RolloverChoice", path, "", error);
		}
		return success("RolloverChoice", ValidationType.CARDINALITY, "RolloverChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RolloverChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RolloverChoice", ValidationType.CARDINALITY, "RolloverChoice", path, "", res.getError());
				}
				return success("RolloverChoice", ValidationType.CARDINALITY, "RolloverChoice", path, "");
			})
			.collect(toList());
	}

}
