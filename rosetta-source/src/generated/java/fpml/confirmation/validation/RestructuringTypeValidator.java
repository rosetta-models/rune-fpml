package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RestructuringType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RestructuringTypeValidator implements Validator<RestructuringType> {

	private List<ComparisonResult> getComparisonResults(RestructuringType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("restructuringScheme", (String) o.getRestructuringScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<RestructuringType> validate(RosettaPath path, RestructuringType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RestructuringType", ValidationType.CARDINALITY, "RestructuringType", path, "", error);
		}
		return success("RestructuringType", ValidationType.CARDINALITY, "RestructuringType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RestructuringType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RestructuringType", ValidationType.CARDINALITY, "RestructuringType", path, "", res.getError());
				}
				return success("RestructuringType", ValidationType.CARDINALITY, "RestructuringType", path, "");
			})
			.collect(toList());
	}

}
