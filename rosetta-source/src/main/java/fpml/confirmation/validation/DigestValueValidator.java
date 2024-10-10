package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DigestValue;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DigestValueValidator implements Validator<DigestValue> {

	private List<ComparisonResult> getComparisonResults(DigestValue o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<DigestValue> validate(RosettaPath path, DigestValue o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DigestValue", ValidationType.CARDINALITY, "DigestValue", path, "", error);
		}
		return success("DigestValue", ValidationType.CARDINALITY, "DigestValue", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DigestValue o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DigestValue", ValidationType.CARDINALITY, "DigestValue", path, "", res.getError());
				}
				return success("DigestValue", ValidationType.CARDINALITY, "DigestValue", path, "");
			})
			.collect(toList());
	}

}
