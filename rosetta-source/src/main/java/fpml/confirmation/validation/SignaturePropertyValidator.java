package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SignatureProperty;
import fpml.confirmation.SignaturePropertyTypeChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SignaturePropertyValidator implements Validator<SignatureProperty> {

	private List<ComparisonResult> getComparisonResults(SignatureProperty o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("signaturePropertyTypeChoice", (List<? extends SignaturePropertyTypeChoice>) o.getSignaturePropertyTypeChoice() == null ? 0 : ((List<? extends SignaturePropertyTypeChoice>) o.getSignaturePropertyTypeChoice()).size(), 1, 0), 
				checkCardinality("target", (String) o.getTarget() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SignatureProperty> validate(RosettaPath path, SignatureProperty o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SignatureProperty", ValidationType.CARDINALITY, "SignatureProperty", path, "", error);
		}
		return success("SignatureProperty", ValidationType.CARDINALITY, "SignatureProperty", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignatureProperty o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignatureProperty", ValidationType.CARDINALITY, "SignatureProperty", path, "", res.getError());
				}
				return success("SignatureProperty", ValidationType.CARDINALITY, "SignatureProperty", path, "");
			})
			.collect(toList());
	}

}
