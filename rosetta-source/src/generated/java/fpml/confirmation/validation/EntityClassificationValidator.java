package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EntityClassification;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EntityClassificationValidator implements Validator<EntityClassification> {

	private List<ComparisonResult> getComparisonResults(EntityClassification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("entityClassificationScheme", (String) o.getEntityClassificationScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EntityClassification> validate(RosettaPath path, EntityClassification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EntityClassification", ValidationType.CARDINALITY, "EntityClassification", path, "", error);
		}
		return success("EntityClassification", ValidationType.CARDINALITY, "EntityClassification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EntityClassification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EntityClassification", ValidationType.CARDINALITY, "EntityClassification", path, "", res.getError());
				}
				return success("EntityClassification", ValidationType.CARDINALITY, "EntityClassification", path, "");
			})
			.collect(toList());
	}

}
