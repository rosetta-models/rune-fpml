package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EntityId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EntityIdValidator implements Validator<EntityId> {

	private List<ComparisonResult> getComparisonResults(EntityId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("entityIdScheme", (String) o.getEntityIdScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EntityId> validate(RosettaPath path, EntityId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EntityId", ValidationType.CARDINALITY, "EntityId", path, "", error);
		}
		return success("EntityId", ValidationType.CARDINALITY, "EntityId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EntityId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EntityId", ValidationType.CARDINALITY, "EntityId", path, "", res.getError());
				}
				return success("EntityId", ValidationType.CARDINALITY, "EntityId", path, "");
			})
			.collect(toList());
	}

}
