package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CompoundingFrequency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompoundingFrequencyValidator implements Validator<CompoundingFrequency> {

	private List<ComparisonResult> getComparisonResults(CompoundingFrequency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("compoundingFrequencyScheme", (String) o.getCompoundingFrequencyScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CompoundingFrequency> validate(RosettaPath path, CompoundingFrequency o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CompoundingFrequency", ValidationType.CARDINALITY, "CompoundingFrequency", path, "", error);
		}
		return success("CompoundingFrequency", ValidationType.CARDINALITY, "CompoundingFrequency", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CompoundingFrequency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CompoundingFrequency", ValidationType.CARDINALITY, "CompoundingFrequency", path, "", res.getError());
				}
				return success("CompoundingFrequency", ValidationType.CARDINALITY, "CompoundingFrequency", path, "");
			})
			.collect(toList());
	}

}
