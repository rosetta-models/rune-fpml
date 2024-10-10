package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationNoSettlePeriodType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationNoSettlePeriodTypeValidator implements Validator<LoanAllocationNoSettlePeriodType> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationNoSettlePeriodType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("noSettlePeriodTypeScheme", (String) o.getNoSettlePeriodTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanAllocationNoSettlePeriodType> validate(RosettaPath path, LoanAllocationNoSettlePeriodType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationNoSettlePeriodType", ValidationType.CARDINALITY, "LoanAllocationNoSettlePeriodType", path, "", error);
		}
		return success("LoanAllocationNoSettlePeriodType", ValidationType.CARDINALITY, "LoanAllocationNoSettlePeriodType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNoSettlePeriodType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationNoSettlePeriodType", ValidationType.CARDINALITY, "LoanAllocationNoSettlePeriodType", path, "", res.getError());
				}
				return success("LoanAllocationNoSettlePeriodType", ValidationType.CARDINALITY, "LoanAllocationNoSettlePeriodType", path, "");
			})
			.collect(toList());
	}

}
