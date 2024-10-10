package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxPivot;
import fpml.confirmation.FxTargetKnockoutForwardSequence;
import fpml.confirmation.FxTargetLinearPayoffRegion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetKnockoutForwardSequenceValidator implements Validator<FxTargetKnockoutForwardSequence> {

	private List<ComparisonResult> getComparisonResults(FxTargetKnockoutForwardSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("pivot", (FxPivot) o.getPivot() != null ? 1 : 0, 1, 1), 
				checkCardinality("linearPayoffRegion", (FxTargetLinearPayoffRegion) o.getLinearPayoffRegion() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxTargetKnockoutForwardSequence> validate(RosettaPath path, FxTargetKnockoutForwardSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetKnockoutForwardSequence", ValidationType.CARDINALITY, "FxTargetKnockoutForwardSequence", path, "", error);
		}
		return success("FxTargetKnockoutForwardSequence", ValidationType.CARDINALITY, "FxTargetKnockoutForwardSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetKnockoutForwardSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetKnockoutForwardSequence", ValidationType.CARDINALITY, "FxTargetKnockoutForwardSequence", path, "", res.getError());
				}
				return success("FxTargetKnockoutForwardSequence", ValidationType.CARDINALITY, "FxTargetKnockoutForwardSequence", path, "");
			})
			.collect(toList());
	}

}
