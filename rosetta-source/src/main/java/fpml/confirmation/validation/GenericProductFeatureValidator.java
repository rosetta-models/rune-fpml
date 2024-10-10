package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericProductFeature;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericProductFeatureValidator implements Validator<GenericProductFeature> {

	private List<ComparisonResult> getComparisonResults(GenericProductFeature o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("featureScheme", (String) o.getFeatureScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GenericProductFeature> validate(RosettaPath path, GenericProductFeature o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericProductFeature", ValidationType.CARDINALITY, "GenericProductFeature", path, "", error);
		}
		return success("GenericProductFeature", ValidationType.CARDINALITY, "GenericProductFeature", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericProductFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericProductFeature", ValidationType.CARDINALITY, "GenericProductFeature", path, "", res.getError());
				}
				return success("GenericProductFeature", ValidationType.CARDINALITY, "GenericProductFeature", path, "");
			})
			.collect(toList());
	}

}
