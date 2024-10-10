package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EventPayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EventPaymentTypeFormatValidator implements Validator<EventPayment> {

	private List<ComparisonResult> getComparisonResults(EventPayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EventPayment> validate(RosettaPath path, EventPayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EventPayment", ValidationType.TYPE_FORMAT, "EventPayment", path, "", error);
		}
		return success("EventPayment", ValidationType.TYPE_FORMAT, "EventPayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventPayment", ValidationType.TYPE_FORMAT, "EventPayment", path, "", res.getError());
				}
				return success("EventPayment", ValidationType.TYPE_FORMAT, "EventPayment", path, "");
			})
			.collect(toList());
	}

}
