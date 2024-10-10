package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CanonicalizationMethodType;
import fpml.confirmation.ReferenceType;
import fpml.confirmation.SignatureMethodType;
import fpml.confirmation.SignedInfo;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SignedInfoValidator implements Validator<SignedInfo> {

	private List<ComparisonResult> getComparisonResults(SignedInfo o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("canonicalizationMethod", (CanonicalizationMethodType) o.getCanonicalizationMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("signatureMethod", (SignatureMethodType) o.getSignatureMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("reference", (List<? extends ReferenceType>) o.getReference() == null ? 0 : ((List<? extends ReferenceType>) o.getReference()).size(), 1, 0), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SignedInfo> validate(RosettaPath path, SignedInfo o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SignedInfo", ValidationType.CARDINALITY, "SignedInfo", path, "", error);
		}
		return success("SignedInfo", ValidationType.CARDINALITY, "SignedInfo", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SignedInfo o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SignedInfo", ValidationType.CARDINALITY, "SignedInfo", path, "", res.getError());
				}
				return success("SignedInfo", ValidationType.CARDINALITY, "SignedInfo", path, "");
			})
			.collect(toList());
	}

}
