package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractEventTypeFormatValidator implements Validator<AbstractEvent> {

	private List<ComparisonResult> getComparisonResults(AbstractEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AbstractEvent> validate(RosettaPath path, AbstractEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractEvent", ValidationType.TYPE_FORMAT, "AbstractEvent", path, "", error);
		}
		return success("AbstractEvent", ValidationType.TYPE_FORMAT, "AbstractEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractEvent", ValidationType.TYPE_FORMAT, "AbstractEvent", path, "", res.getError());
				}
				return success("AbstractEvent", ValidationType.TYPE_FORMAT, "AbstractEvent", path, "");
			})
			.collect(toList());
	}

}
