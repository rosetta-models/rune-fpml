package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RSAKeyValueType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RSAKeyValueTypeValidator implements Validator<RSAKeyValueType> {

	private List<ComparisonResult> getComparisonResults(RSAKeyValueType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("modulus", (String) o.getModulus() != null ? 1 : 0, 1, 1), 
				checkCardinality("exponent", (String) o.getExponent() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<RSAKeyValueType> validate(RosettaPath path, RSAKeyValueType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RSAKeyValueType", ValidationType.CARDINALITY, "RSAKeyValueType", path, "", error);
		}
		return success("RSAKeyValueType", ValidationType.CARDINALITY, "RSAKeyValueType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RSAKeyValueType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RSAKeyValueType", ValidationType.CARDINALITY, "RSAKeyValueType", path, "", res.getError());
				}
				return success("RSAKeyValueType", ValidationType.CARDINALITY, "RSAKeyValueType", path, "");
			})
			.collect(toList());
	}

}
