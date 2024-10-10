package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationPayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationPaymentTypeFormatValidator implements Validator<LoanAllocationPayment> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationPayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanAllocationPayment> validate(RosettaPath path, LoanAllocationPayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationPayment", ValidationType.TYPE_FORMAT, "LoanAllocationPayment", path, "", error);
		}
		return success("LoanAllocationPayment", ValidationType.TYPE_FORMAT, "LoanAllocationPayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationPayment", ValidationType.TYPE_FORMAT, "LoanAllocationPayment", path, "", res.getError());
				}
				return success("LoanAllocationPayment", ValidationType.TYPE_FORMAT, "LoanAllocationPayment", path, "");
			})
			.collect(toList());
	}

}
