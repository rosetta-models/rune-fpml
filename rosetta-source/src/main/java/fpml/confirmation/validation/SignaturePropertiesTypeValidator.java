package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SignaturePropertiesType;
import fpml.confirmation.SignaturePropertyType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SignaturePropertiesTypeValidator implements Validator<SignaturePropertiesType> {

	private List<ComparisonResult> getComparisonResults(SignaturePropertiesType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("signatureProperty", (List<? extends SignaturePropertyType>) o.getSignatureProperty() == null ? 0 : ((List<? extends SignaturePropertyType>) o.getSignatureProperty()).size(), 1, 0), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SignaturePropertiesType> validate(RosettaPath path, SignaturePropertiesType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SignaturePropertiesType", ValidationType.CARDINALITY, "SignaturePropertiesType", path, "", error);
		}
		return success("SignaturePropertiesType", ValidationType.CARDINALITY, "SignaturePropertiesType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignaturePropertiesType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignaturePropertiesType", ValidationType.CARDINALITY, "SignaturePropertiesType", path, "", res.getError());
				}
				return success("SignaturePropertiesType", ValidationType.CARDINALITY, "SignaturePropertiesType", path, "");
			})
			.collect(toList());
	}

}
