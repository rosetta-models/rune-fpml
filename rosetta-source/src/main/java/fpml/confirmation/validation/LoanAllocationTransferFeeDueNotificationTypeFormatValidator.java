package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationTransferFeeDueNotification;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationTransferFeeDueNotificationTypeFormatValidator implements Validator<LoanAllocationTransferFeeDueNotification> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationTransferFeeDueNotification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("expectedBuild", o.getExpectedBuild(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("actualBuild", o.getActualBuild(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public ValidationResult<LoanAllocationTransferFeeDueNotification> validate(RosettaPath path, LoanAllocationTransferFeeDueNotification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationTransferFeeDueNotification", ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeDueNotification", path, "", error);
		}
		return success("LoanAllocationTransferFeeDueNotification", ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeDueNotification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationTransferFeeDueNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationTransferFeeDueNotification", ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeDueNotification", path, "", res.getError());
				}
				return success("LoanAllocationTransferFeeDueNotification", ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeDueNotification", path, "");
			})
			.collect(toList());
	}

}
