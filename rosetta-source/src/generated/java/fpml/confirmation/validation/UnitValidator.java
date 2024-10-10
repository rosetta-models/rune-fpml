package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Unit;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UnitValidator implements Validator<Unit> {

	private List<ComparisonResult> getComparisonResults(Unit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("unitScheme", (String) o.getUnitScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Unit> validate(RosettaPath path, Unit o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Unit", ValidationType.CARDINALITY, "Unit", path, "", error);
		}
		return success("Unit", ValidationType.CARDINALITY, "Unit", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Unit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Unit", ValidationType.CARDINALITY, "Unit", path, "", res.getError());
				}
				return success("Unit", ValidationType.CARDINALITY, "Unit", path, "");
			})
			.collect(toList());
	}

}
