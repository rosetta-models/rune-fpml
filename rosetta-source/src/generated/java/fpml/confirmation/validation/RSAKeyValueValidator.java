package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RSAKeyValue;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RSAKeyValueValidator implements Validator<RSAKeyValue> {

	private List<ComparisonResult> getComparisonResults(RSAKeyValue o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("modulus", (String) o.getModulus() != null ? 1 : 0, 1, 1), 
				checkCardinality("exponent", (String) o.getExponent() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<RSAKeyValue> validate(RosettaPath path, RSAKeyValue o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RSAKeyValue", ValidationType.CARDINALITY, "RSAKeyValue", path, "", error);
		}
		return success("RSAKeyValue", ValidationType.CARDINALITY, "RSAKeyValue", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RSAKeyValue o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RSAKeyValue", ValidationType.CARDINALITY, "RSAKeyValue", path, "", res.getError());
				}
				return success("RSAKeyValue", ValidationType.CARDINALITY, "RSAKeyValue", path, "");
			})
			.collect(toList());
	}

}
