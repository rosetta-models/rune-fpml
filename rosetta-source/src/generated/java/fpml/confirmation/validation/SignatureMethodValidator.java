package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SignatureMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SignatureMethodValidator implements Validator<SignatureMethod> {

	private List<ComparisonResult> getComparisonResults(SignatureMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("hmacOutputLength", (Integer) o.getHmacOutputLength() != null ? 1 : 0, 0, 1), 
				checkCardinality("algorithm", (String) o.getAlgorithm() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<SignatureMethod> validate(RosettaPath path, SignatureMethod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SignatureMethod", ValidationType.CARDINALITY, "SignatureMethod", path, "", error);
		}
		return success("SignatureMethod", ValidationType.CARDINALITY, "SignatureMethod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignatureMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignatureMethod", ValidationType.CARDINALITY, "SignatureMethod", path, "", res.getError());
				}
				return success("SignatureMethod", ValidationType.CARDINALITY, "SignatureMethod", path, "");
			})
			.collect(toList());
	}

}
