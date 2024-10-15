package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DigestMethodType;
import fpml.confirmation.ReferenceType;
import fpml.confirmation.TransformsType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReferenceTypeValidator implements Validator<ReferenceType> {

	private List<ComparisonResult> getComparisonResults(ReferenceType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("transforms", (TransformsType) o.getTransforms() != null ? 1 : 0, 0, 1), 
				checkCardinality("digestMethod", (DigestMethodType) o.getDigestMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("digestValue", (String) o.getDigestValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("uri", (String) o.getUri() != null ? 1 : 0, 0, 1), 
				checkCardinality("_type", (String) o.get_type() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReferenceType> validate(RosettaPath path, ReferenceType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReferenceType", ValidationType.CARDINALITY, "ReferenceType", path, "", error);
		}
		return success("ReferenceType", ValidationType.CARDINALITY, "ReferenceType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceType", ValidationType.CARDINALITY, "ReferenceType", path, "", res.getError());
				}
				return success("ReferenceType", ValidationType.CARDINALITY, "ReferenceType", path, "");
			})
			.collect(toList());
	}

}
