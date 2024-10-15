package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearanceSystem;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClearanceSystemValidator implements Validator<ClearanceSystem> {

	private List<ComparisonResult> getComparisonResults(ClearanceSystem o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("clearanceSystemScheme", (String) o.getClearanceSystemScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ClearanceSystem> validate(RosettaPath path, ClearanceSystem o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ClearanceSystem", ValidationType.CARDINALITY, "ClearanceSystem", path, "", error);
		}
		return success("ClearanceSystem", ValidationType.CARDINALITY, "ClearanceSystem", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearanceSystem o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearanceSystem", ValidationType.CARDINALITY, "ClearanceSystem", path, "", res.getError());
				}
				return success("ClearanceSystem", ValidationType.CARDINALITY, "ClearanceSystem", path, "");
			})
			.collect(toList());
	}

}
