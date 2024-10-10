package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ResourceId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ResourceIdValidator implements Validator<ResourceId> {

	private List<ComparisonResult> getComparisonResults(ResourceId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("resourceIdScheme", (String) o.getResourceIdScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ResourceId> validate(RosettaPath path, ResourceId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ResourceId", ValidationType.CARDINALITY, "ResourceId", path, "", error);
		}
		return success("ResourceId", ValidationType.CARDINALITY, "ResourceId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResourceId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ResourceId", ValidationType.CARDINALITY, "ResourceId", path, "", res.getError());
				}
				return success("ResourceId", ValidationType.CARDINALITY, "ResourceId", path, "");
			})
			.collect(toList());
	}

}
