package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.DeterminationMethodReference;
import fpml.confirmation.NotionalAmount;
import fpml.confirmation.ReturnSwapNotional;
import fpml.confirmation.ReturnSwapNotionalAmountReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnSwapNotionalValidator implements Validator<ReturnSwapNotional> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapNotional o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("relativeNotionalAmount", (ReturnSwapNotionalAmountReference) o.getRelativeNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeDeterminationMethod", (DeterminationMethodReference) o.getRelativeDeterminationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("determinationMethod", (DeterminationMethod) o.getDeterminationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (NotionalAmount) o.getNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReturnSwapNotional> validate(RosettaPath path, ReturnSwapNotional o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnSwapNotional", ValidationType.CARDINALITY, "ReturnSwapNotional", path, "", error);
		}
		return success("ReturnSwapNotional", ValidationType.CARDINALITY, "ReturnSwapNotional", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapNotional o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapNotional", ValidationType.CARDINALITY, "ReturnSwapNotional", path, "", res.getError());
				}
				return success("ReturnSwapNotional", ValidationType.CARDINALITY, "ReturnSwapNotional", path, "");
			})
			.collect(toList());
	}

}
