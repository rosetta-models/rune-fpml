package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EventValuationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EventValuationModelTypeFormatValidator implements Validator<EventValuationModel> {

	private List<ComparisonResult> getComparisonResults(EventValuationModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EventValuationModel> validate(RosettaPath path, EventValuationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EventValuationModel", ValidationType.TYPE_FORMAT, "EventValuationModel", path, "", error);
		}
		return success("EventValuationModel", ValidationType.TYPE_FORMAT, "EventValuationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventValuationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventValuationModel", ValidationType.TYPE_FORMAT, "EventValuationModel", path, "", res.getError());
				}
				return success("EventValuationModel", ValidationType.TYPE_FORMAT, "EventValuationModel", path, "");
			})
			.collect(toList());
	}

}
