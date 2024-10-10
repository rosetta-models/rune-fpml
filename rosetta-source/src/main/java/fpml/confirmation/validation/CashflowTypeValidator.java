package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CashflowType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CashflowTypeValidator implements Validator<CashflowType> {

	private List<ComparisonResult> getComparisonResults(CashflowType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("cashflowTypeScheme", (String) o.getCashflowTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CashflowType> validate(RosettaPath path, CashflowType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CashflowType", ValidationType.CARDINALITY, "CashflowType", path, "", error);
		}
		return success("CashflowType", ValidationType.CARDINALITY, "CashflowType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashflowType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CashflowType", ValidationType.CARDINALITY, "CashflowType", path, "", res.getError());
				}
				return success("CashflowType", ValidationType.CARDINALITY, "CashflowType", path, "");
			})
			.collect(toList());
	}

}
