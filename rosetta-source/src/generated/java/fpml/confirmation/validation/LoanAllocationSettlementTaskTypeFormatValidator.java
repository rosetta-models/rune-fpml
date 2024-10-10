package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationSettlementTask;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationSettlementTaskTypeFormatValidator implements Validator<LoanAllocationSettlementTask> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationSettlementTask o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<LoanAllocationSettlementTask> validate(RosettaPath path, LoanAllocationSettlementTask o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationSettlementTask", ValidationType.TYPE_FORMAT, "LoanAllocationSettlementTask", path, "", error);
		}
		return success("LoanAllocationSettlementTask", ValidationType.TYPE_FORMAT, "LoanAllocationSettlementTask", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationSettlementTask o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationSettlementTask", ValidationType.TYPE_FORMAT, "LoanAllocationSettlementTask", path, "", res.getError());
				}
				return success("LoanAllocationSettlementTask", ValidationType.TYPE_FORMAT, "LoanAllocationSettlementTask", path, "");
			})
			.collect(toList());
	}

}
