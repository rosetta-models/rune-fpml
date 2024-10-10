package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.KeyInfoTypeChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class KeyInfoTypeChoiceTypeFormatValidator implements Validator<KeyInfoTypeChoice> {

	private List<ComparisonResult> getComparisonResults(KeyInfoTypeChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<KeyInfoTypeChoice> validate(RosettaPath path, KeyInfoTypeChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("KeyInfoTypeChoice", ValidationType.TYPE_FORMAT, "KeyInfoTypeChoice", path, "", error);
		}
		return success("KeyInfoTypeChoice", ValidationType.TYPE_FORMAT, "KeyInfoTypeChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, KeyInfoTypeChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("KeyInfoTypeChoice", ValidationType.TYPE_FORMAT, "KeyInfoTypeChoice", path, "", res.getError());
				}
				return success("KeyInfoTypeChoice", ValidationType.TYPE_FORMAT, "KeyInfoTypeChoice", path, "");
			})
			.collect(toList());
	}

}
