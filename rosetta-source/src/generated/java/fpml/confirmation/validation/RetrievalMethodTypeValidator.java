package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RetrievalMethodType;
import fpml.confirmation.TransformsType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RetrievalMethodTypeValidator implements Validator<RetrievalMethodType> {

	private List<ComparisonResult> getComparisonResults(RetrievalMethodType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("transforms", (TransformsType) o.getTransforms() != null ? 1 : 0, 0, 1), 
				checkCardinality("uri", (String) o.getUri() != null ? 1 : 0, 0, 1), 
				checkCardinality("type", (String) o.getType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<RetrievalMethodType> validate(RosettaPath path, RetrievalMethodType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RetrievalMethodType", ValidationType.CARDINALITY, "RetrievalMethodType", path, "", error);
		}
		return success("RetrievalMethodType", ValidationType.CARDINALITY, "RetrievalMethodType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RetrievalMethodType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RetrievalMethodType", ValidationType.CARDINALITY, "RetrievalMethodType", path, "", res.getError());
				}
				return success("RetrievalMethodType", ValidationType.CARDINALITY, "RetrievalMethodType", path, "");
			})
			.collect(toList());
	}

}
