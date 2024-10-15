package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetLeverageSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetLeverageSequenceTypeFormatValidator implements Validator<FxTargetLeverageSequence> {

	private List<ComparisonResult> getComparisonResults(FxTargetLeverageSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxTargetLeverageSequence> validate(RosettaPath path, FxTargetLeverageSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetLeverageSequence", ValidationType.TYPE_FORMAT, "FxTargetLeverageSequence", path, "", error);
		}
		return success("FxTargetLeverageSequence", ValidationType.TYPE_FORMAT, "FxTargetLeverageSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetLeverageSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetLeverageSequence", ValidationType.TYPE_FORMAT, "FxTargetLeverageSequence", path, "", res.getError());
				}
				return success("FxTargetLeverageSequence", ValidationType.TYPE_FORMAT, "FxTargetLeverageSequence", path, "");
			})
			.collect(toList());
	}

}
