package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationSettlementEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationSettlementEventTypeFormatValidator implements Validator<LoanAllocationSettlementEvent> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationSettlementEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<LoanAllocationSettlementEvent> validate(RosettaPath path, LoanAllocationSettlementEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationSettlementEvent", ValidationType.TYPE_FORMAT, "LoanAllocationSettlementEvent", path, "", error);
		}
		return success("LoanAllocationSettlementEvent", ValidationType.TYPE_FORMAT, "LoanAllocationSettlementEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationSettlementEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationSettlementEvent", ValidationType.TYPE_FORMAT, "LoanAllocationSettlementEvent", path, "", res.getError());
				}
				return success("LoanAllocationSettlementEvent", ValidationType.TYPE_FORMAT, "LoanAllocationSettlementEvent", path, "");
			})
			.collect(toList());
	}

}
