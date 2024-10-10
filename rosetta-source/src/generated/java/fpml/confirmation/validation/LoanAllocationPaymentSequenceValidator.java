package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationPaymentSequence;
import fpml.confirmation.LoanAllocationReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationPaymentSequenceValidator implements Validator<LoanAllocationPaymentSequence> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationPaymentSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("allocationReference", (LoanAllocationReference) o.getAllocationReference() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LoanAllocationPaymentSequence> validate(RosettaPath path, LoanAllocationPaymentSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationPaymentSequence", ValidationType.CARDINALITY, "LoanAllocationPaymentSequence", path, "", error);
		}
		return success("LoanAllocationPaymentSequence", ValidationType.CARDINALITY, "LoanAllocationPaymentSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationPaymentSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationPaymentSequence", ValidationType.CARDINALITY, "LoanAllocationPaymentSequence", path, "", res.getError());
				}
				return success("LoanAllocationPaymentSequence", ValidationType.CARDINALITY, "LoanAllocationPaymentSequence", path, "");
			})
			.collect(toList());
	}

}
