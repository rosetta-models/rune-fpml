package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTouchSequenceSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTouchSequenceSequenceTypeFormatValidator implements Validator<FxTouchSequenceSequence> {

	private List<ComparisonResult> getComparisonResults(FxTouchSequenceSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxTouchSequenceSequence> validate(RosettaPath path, FxTouchSequenceSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTouchSequenceSequence", ValidationType.TYPE_FORMAT, "FxTouchSequenceSequence", path, "", error);
		}
		return success("FxTouchSequenceSequence", ValidationType.TYPE_FORMAT, "FxTouchSequenceSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTouchSequenceSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTouchSequenceSequence", ValidationType.TYPE_FORMAT, "FxTouchSequenceSequence", path, "", res.getError());
				}
				return success("FxTouchSequenceSequence", ValidationType.TYPE_FORMAT, "FxTouchSequenceSequence", path, "");
			})
			.collect(toList());
	}

}
