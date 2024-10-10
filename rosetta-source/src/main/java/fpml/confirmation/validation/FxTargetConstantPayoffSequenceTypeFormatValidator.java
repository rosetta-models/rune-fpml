package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetConstantPayoffSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetConstantPayoffSequenceTypeFormatValidator implements Validator<FxTargetConstantPayoffSequence> {

	private List<ComparisonResult> getComparisonResults(FxTargetConstantPayoffSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxTargetConstantPayoffSequence> validate(RosettaPath path, FxTargetConstantPayoffSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetConstantPayoffSequence", ValidationType.TYPE_FORMAT, "FxTargetConstantPayoffSequence", path, "", error);
		}
		return success("FxTargetConstantPayoffSequence", ValidationType.TYPE_FORMAT, "FxTargetConstantPayoffSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetConstantPayoffSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetConstantPayoffSequence", ValidationType.TYPE_FORMAT, "FxTargetConstantPayoffSequence", path, "", res.getError());
				}
				return success("FxTargetConstantPayoffSequence", ValidationType.TYPE_FORMAT, "FxTargetConstantPayoffSequence", path, "");
			})
			.collect(toList());
	}

}
