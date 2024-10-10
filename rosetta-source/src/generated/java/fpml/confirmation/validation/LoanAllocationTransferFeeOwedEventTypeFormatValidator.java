package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationTransferFeeOwedEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationTransferFeeOwedEventTypeFormatValidator implements Validator<LoanAllocationTransferFeeOwedEvent> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationTransferFeeOwedEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<LoanAllocationTransferFeeOwedEvent> validate(RosettaPath path, LoanAllocationTransferFeeOwedEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationTransferFeeOwedEvent", ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeOwedEvent", path, "", error);
		}
		return success("LoanAllocationTransferFeeOwedEvent", ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeOwedEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationTransferFeeOwedEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationTransferFeeOwedEvent", ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeOwedEvent", path, "", res.getError());
				}
				return success("LoanAllocationTransferFeeOwedEvent", ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeOwedEvent", path, "");
			})
			.collect(toList());
	}

}
