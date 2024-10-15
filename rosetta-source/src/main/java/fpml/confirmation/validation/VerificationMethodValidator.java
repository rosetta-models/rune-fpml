package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VerificationMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VerificationMethodValidator implements Validator<VerificationMethod> {

	private List<ComparisonResult> getComparisonResults(VerificationMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("verificationMethodScheme", (String) o.getVerificationMethodScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<VerificationMethod> validate(RosettaPath path, VerificationMethod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VerificationMethod", ValidationType.CARDINALITY, "VerificationMethod", path, "", error);
		}
		return success("VerificationMethod", ValidationType.CARDINALITY, "VerificationMethod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VerificationMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VerificationMethod", ValidationType.CARDINALITY, "VerificationMethod", path, "", res.getError());
				}
				return success("VerificationMethod", ValidationType.CARDINALITY, "VerificationMethod", path, "");
			})
			.collect(toList());
	}

}
