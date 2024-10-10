package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditLimitUtilization;
import fpml.confirmation.CreditLimitUtilizationPosition;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditLimitUtilizationValidator implements Validator<CreditLimitUtilization> {

	private List<ComparisonResult> getComparisonResults(CreditLimitUtilization o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("executed", (CreditLimitUtilizationPosition) o.getExecuted() != null ? 1 : 0, 1, 1), 
				checkCardinality("pending", (CreditLimitUtilizationPosition) o.getPending() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CreditLimitUtilization> validate(RosettaPath path, CreditLimitUtilization o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditLimitUtilization", ValidationType.CARDINALITY, "CreditLimitUtilization", path, "", error);
		}
		return success("CreditLimitUtilization", ValidationType.CARDINALITY, "CreditLimitUtilization", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditLimitUtilization o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditLimitUtilization", ValidationType.CARDINALITY, "CreditLimitUtilization", path, "", res.getError());
				}
				return success("CreditLimitUtilization", ValidationType.CARDINALITY, "CreditLimitUtilization", path, "");
			})
			.collect(toList());
	}

}
