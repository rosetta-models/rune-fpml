package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TransformTypeChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TransformTypeChoiceTypeFormatValidator implements Validator<TransformTypeChoice> {

	private List<ComparisonResult> getComparisonResults(TransformTypeChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TransformTypeChoice> validate(RosettaPath path, TransformTypeChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TransformTypeChoice", ValidationType.TYPE_FORMAT, "TransformTypeChoice", path, "", error);
		}
		return success("TransformTypeChoice", ValidationType.TYPE_FORMAT, "TransformTypeChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransformTypeChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransformTypeChoice", ValidationType.TYPE_FORMAT, "TransformTypeChoice", path, "", res.getError());
				}
				return success("TransformTypeChoice", ValidationType.TYPE_FORMAT, "TransformTypeChoice", path, "");
			})
			.collect(toList());
	}

}
