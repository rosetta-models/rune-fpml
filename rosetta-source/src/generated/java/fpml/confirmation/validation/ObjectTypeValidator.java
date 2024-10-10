package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ObjectType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ObjectTypeValidator implements Validator<ObjectType> {

	private List<ComparisonResult> getComparisonResults(ObjectType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("mimeType", (String) o.getMimeType() != null ? 1 : 0, 0, 1), 
				checkCardinality("encoding", (String) o.getEncoding() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ObjectType> validate(RosettaPath path, ObjectType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ObjectType", ValidationType.CARDINALITY, "ObjectType", path, "", error);
		}
		return success("ObjectType", ValidationType.CARDINALITY, "ObjectType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObjectType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObjectType", ValidationType.CARDINALITY, "ObjectType", path, "", res.getError());
				}
				return success("ObjectType", ValidationType.CARDINALITY, "ObjectType", path, "");
			})
			.collect(toList());
	}

}
