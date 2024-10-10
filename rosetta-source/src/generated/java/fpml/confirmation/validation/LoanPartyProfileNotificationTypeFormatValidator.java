package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanPartyProfileNotification;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanPartyProfileNotificationTypeFormatValidator implements Validator<LoanPartyProfileNotification> {

	private List<ComparisonResult> getComparisonResults(LoanPartyProfileNotification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("expectedBuild", o.getExpectedBuild(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("actualBuild", o.getActualBuild(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkString("comments", o.getComments(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<LoanPartyProfileNotification> validate(RosettaPath path, LoanPartyProfileNotification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanPartyProfileNotification", ValidationType.TYPE_FORMAT, "LoanPartyProfileNotification", path, "", error);
		}
		return success("LoanPartyProfileNotification", ValidationType.TYPE_FORMAT, "LoanPartyProfileNotification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanPartyProfileNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanPartyProfileNotification", ValidationType.TYPE_FORMAT, "LoanPartyProfileNotification", path, "", res.getError());
				}
				return success("LoanPartyProfileNotification", ValidationType.TYPE_FORMAT, "LoanPartyProfileNotification", path, "");
			})
			.collect(toList());
	}

}
