package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationTransferFeeDueEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationTransferFeeDueEventTypeFormatValidator implements Validator<LoanAllocationTransferFeeDueEvent> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationTransferFeeDueEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<LoanAllocationTransferFeeDueEvent> validate(RosettaPath path, LoanAllocationTransferFeeDueEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationTransferFeeDueEvent", ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeDueEvent", path, "", error);
		}
		return success("LoanAllocationTransferFeeDueEvent", ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeDueEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationTransferFeeDueEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationTransferFeeDueEvent", ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeDueEvent", path, "", res.getError());
				}
				return success("LoanAllocationTransferFeeDueEvent", ValidationType.TYPE_FORMAT, "LoanAllocationTransferFeeDueEvent", path, "");
			})
			.collect(toList());
	}

}
