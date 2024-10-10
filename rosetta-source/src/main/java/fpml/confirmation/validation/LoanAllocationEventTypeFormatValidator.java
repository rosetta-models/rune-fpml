package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationEventTypeFormatValidator implements Validator<LoanAllocationEvent> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<LoanAllocationEvent> validate(RosettaPath path, LoanAllocationEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationEvent", ValidationType.TYPE_FORMAT, "LoanAllocationEvent", path, "", error);
		}
		return success("LoanAllocationEvent", ValidationType.TYPE_FORMAT, "LoanAllocationEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationEvent", ValidationType.TYPE_FORMAT, "LoanAllocationEvent", path, "", res.getError());
				}
				return success("LoanAllocationEvent", ValidationType.TYPE_FORMAT, "LoanAllocationEvent", path, "");
			})
			.collect(toList());
	}

}
