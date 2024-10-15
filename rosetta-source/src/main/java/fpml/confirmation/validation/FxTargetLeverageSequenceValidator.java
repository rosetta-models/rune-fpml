package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetLeverageSequence;
import fpml.confirmation.NonNegativeAmountSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetLeverageSequenceValidator implements Validator<FxTargetLeverageSequence> {

	private List<ComparisonResult> getComparisonResults(FxTargetLeverageSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalAmount", (NonNegativeAmountSchedule) o.getNotionalAmount() != null ? 1 : 0, 1, 1)
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
			return failure("FxTargetLeverageSequence", ValidationType.CARDINALITY, "FxTargetLeverageSequence", path, "", error);
		}
		return success("FxTargetLeverageSequence", ValidationType.CARDINALITY, "FxTargetLeverageSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetLeverageSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetLeverageSequence", ValidationType.CARDINALITY, "FxTargetLeverageSequence", path, "", res.getError());
				}
				return success("FxTargetLeverageSequence", ValidationType.CARDINALITY, "FxTargetLeverageSequence", path, "");
			})
			.collect(toList());
	}

}
