package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ChangeEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ChangeEventTypeFormatValidator implements Validator<ChangeEvent> {

	private List<ComparisonResult> getComparisonResults(ChangeEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ChangeEvent> validate(RosettaPath path, ChangeEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ChangeEvent", ValidationType.TYPE_FORMAT, "ChangeEvent", path, "", error);
		}
		return success("ChangeEvent", ValidationType.TYPE_FORMAT, "ChangeEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ChangeEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ChangeEvent", ValidationType.TYPE_FORMAT, "ChangeEvent", path, "", res.getError());
				}
				return success("ChangeEvent", ValidationType.TYPE_FORMAT, "ChangeEvent", path, "");
			})
			.collect(toList());
	}

}
