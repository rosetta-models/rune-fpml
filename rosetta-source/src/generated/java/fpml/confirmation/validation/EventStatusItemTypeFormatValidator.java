package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EventStatusItem;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EventStatusItemTypeFormatValidator implements Validator<EventStatusItem> {

	private List<ComparisonResult> getComparisonResults(EventStatusItem o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EventStatusItem> validate(RosettaPath path, EventStatusItem o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EventStatusItem", ValidationType.TYPE_FORMAT, "EventStatusItem", path, "", error);
		}
		return success("EventStatusItem", ValidationType.TYPE_FORMAT, "EventStatusItem", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventStatusItem o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventStatusItem", ValidationType.TYPE_FORMAT, "EventStatusItem", path, "", res.getError());
				}
				return success("EventStatusItem", ValidationType.TYPE_FORMAT, "EventStatusItem", path, "");
			})
			.collect(toList());
	}

}
