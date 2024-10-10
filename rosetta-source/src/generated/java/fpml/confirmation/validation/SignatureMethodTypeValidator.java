package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SignatureMethodType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SignatureMethodTypeValidator implements Validator<SignatureMethodType> {

	private List<ComparisonResult> getComparisonResults(SignatureMethodType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("hmacOutputLength", (Integer) o.getHmacOutputLength() != null ? 1 : 0, 0, 1), 
				checkCardinality("algorithm", (String) o.getAlgorithm() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<SignatureMethodType> validate(RosettaPath path, SignatureMethodType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SignatureMethodType", ValidationType.CARDINALITY, "SignatureMethodType", path, "", error);
		}
		return success("SignatureMethodType", ValidationType.CARDINALITY, "SignatureMethodType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignatureMethodType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignatureMethodType", ValidationType.CARDINALITY, "SignatureMethodType", path, "", res.getError());
				}
				return success("SignatureMethodType", ValidationType.CARDINALITY, "SignatureMethodType", path, "");
			})
			.collect(toList());
	}

}
