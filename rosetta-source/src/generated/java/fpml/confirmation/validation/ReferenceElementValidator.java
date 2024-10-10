package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DigestMethodType;
import fpml.confirmation.ReferenceElement;
import fpml.confirmation.TransformsType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReferenceElementValidator implements Validator<ReferenceElement> {

	private List<ComparisonResult> getComparisonResults(ReferenceElement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("transforms", (TransformsType) o.getTransforms() != null ? 1 : 0, 0, 1), 
				checkCardinality("digestMethod", (DigestMethodType) o.getDigestMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("digestValue", (String) o.getDigestValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("uri", (String) o.getUri() != null ? 1 : 0, 0, 1), 
				checkCardinality("type", (String) o.getType_() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReferenceElement> validate(RosettaPath path, ReferenceElement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReferenceElement", ValidationType.CARDINALITY, "ReferenceElement", path, "", error);
		}
		return success("ReferenceElement", ValidationType.CARDINALITY, "ReferenceElement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceElement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceElement", ValidationType.CARDINALITY, "ReferenceElement", path, "", res.getError());
				}
				return success("ReferenceElement", ValidationType.CARDINALITY, "ReferenceElement", path, "");
			})
			.collect(toList());
	}

}
