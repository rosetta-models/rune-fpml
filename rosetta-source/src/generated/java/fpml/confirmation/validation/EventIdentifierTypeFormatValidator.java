package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EventIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EventIdentifierTypeFormatValidator implements Validator<EventIdentifier> {

	private List<ComparisonResult> getComparisonResults(EventIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EventIdentifier> validate(RosettaPath path, EventIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EventIdentifier", ValidationType.TYPE_FORMAT, "EventIdentifier", path, "", error);
		}
		return success("EventIdentifier", ValidationType.TYPE_FORMAT, "EventIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventIdentifier", ValidationType.TYPE_FORMAT, "EventIdentifier", path, "", res.getError());
				}
				return success("EventIdentifier", ValidationType.TYPE_FORMAT, "EventIdentifier", path, "");
			})
			.collect(toList());
	}

}
