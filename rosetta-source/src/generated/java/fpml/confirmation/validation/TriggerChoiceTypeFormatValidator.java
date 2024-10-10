package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TriggerChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TriggerChoiceTypeFormatValidator implements Validator<TriggerChoice> {

	private List<ComparisonResult> getComparisonResults(TriggerChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TriggerChoice> validate(RosettaPath path, TriggerChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TriggerChoice", ValidationType.TYPE_FORMAT, "TriggerChoice", path, "", error);
		}
		return success("TriggerChoice", ValidationType.TYPE_FORMAT, "TriggerChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TriggerChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TriggerChoice", ValidationType.TYPE_FORMAT, "TriggerChoice", path, "", res.getError());
				}
				return success("TriggerChoice", ValidationType.TYPE_FORMAT, "TriggerChoice", path, "");
			})
			.collect(toList());
	}

}
