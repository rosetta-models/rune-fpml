package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualLeverageSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualLeverageSequenceTypeFormatValidator implements Validator<FxAccrualLeverageSequence> {

	private List<ComparisonResult> getComparisonResults(FxAccrualLeverageSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualLeverageSequence> validate(RosettaPath path, FxAccrualLeverageSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualLeverageSequence", ValidationType.TYPE_FORMAT, "FxAccrualLeverageSequence", path, "", error);
		}
		return success("FxAccrualLeverageSequence", ValidationType.TYPE_FORMAT, "FxAccrualLeverageSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualLeverageSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualLeverageSequence", ValidationType.TYPE_FORMAT, "FxAccrualLeverageSequence", path, "", res.getError());
				}
				return success("FxAccrualLeverageSequence", ValidationType.TYPE_FORMAT, "FxAccrualLeverageSequence", path, "");
			})
			.collect(toList());
	}

}
