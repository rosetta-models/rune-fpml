package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RolloverChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RolloverChoiceTypeFormatValidator implements Validator<RolloverChoice> {

	private List<ComparisonResult> getComparisonResults(RolloverChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<RolloverChoice> validate(RosettaPath path, RolloverChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RolloverChoice", ValidationType.TYPE_FORMAT, "RolloverChoice", path, "", error);
		}
		return success("RolloverChoice", ValidationType.TYPE_FORMAT, "RolloverChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RolloverChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RolloverChoice", ValidationType.TYPE_FORMAT, "RolloverChoice", path, "", res.getError());
				}
				return success("RolloverChoice", ValidationType.TYPE_FORMAT, "RolloverChoice", path, "");
			})
			.collect(toList());
	}

}
