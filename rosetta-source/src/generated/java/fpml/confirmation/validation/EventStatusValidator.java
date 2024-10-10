package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EventStatus;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EventStatusValidator implements Validator<EventStatus> {

	private List<ComparisonResult> getComparisonResults(EventStatus o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("eventStatusScheme", (String) o.getEventStatusScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EventStatus> validate(RosettaPath path, EventStatus o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EventStatus", ValidationType.CARDINALITY, "EventStatus", path, "", error);
		}
		return success("EventStatus", ValidationType.CARDINALITY, "EventStatus", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventStatus o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventStatus", ValidationType.CARDINALITY, "EventStatus", path, "", res.getError());
				}
				return success("EventStatus", ValidationType.CARDINALITY, "EventStatus", path, "");
			})
			.collect(toList());
	}

}
