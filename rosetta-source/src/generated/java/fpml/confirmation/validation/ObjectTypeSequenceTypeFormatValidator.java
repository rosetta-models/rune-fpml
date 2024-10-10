package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ObjectTypeSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ObjectTypeSequenceTypeFormatValidator implements Validator<ObjectTypeSequence> {

	private List<ComparisonResult> getComparisonResults(ObjectTypeSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ObjectTypeSequence> validate(RosettaPath path, ObjectTypeSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ObjectTypeSequence", ValidationType.TYPE_FORMAT, "ObjectTypeSequence", path, "", error);
		}
		return success("ObjectTypeSequence", ValidationType.TYPE_FORMAT, "ObjectTypeSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObjectTypeSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObjectTypeSequence", ValidationType.TYPE_FORMAT, "ObjectTypeSequence", path, "", res.getError());
				}
				return success("ObjectTypeSequence", ValidationType.TYPE_FORMAT, "ObjectTypeSequence", path, "");
			})
			.collect(toList());
	}

}
