package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationSettlementTaskType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationSettlementTaskTypeValidator implements Validator<LoanAllocationSettlementTaskType> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationSettlementTaskType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("allocationSettlementTaskTypeScheme", (String) o.getAllocationSettlementTaskTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanAllocationSettlementTaskType> validate(RosettaPath path, LoanAllocationSettlementTaskType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationSettlementTaskType", ValidationType.CARDINALITY, "LoanAllocationSettlementTaskType", path, "", error);
		}
		return success("LoanAllocationSettlementTaskType", ValidationType.CARDINALITY, "LoanAllocationSettlementTaskType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationSettlementTaskType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationSettlementTaskType", ValidationType.CARDINALITY, "LoanAllocationSettlementTaskType", path, "", res.getError());
				}
				return success("LoanAllocationSettlementTaskType", ValidationType.CARDINALITY, "LoanAllocationSettlementTaskType", path, "");
			})
			.collect(toList());
	}

}
