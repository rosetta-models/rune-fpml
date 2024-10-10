package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetConstantPayoffRegion;
import fpml.confirmation.FxTargetKnockoutForwardChoice;
import fpml.confirmation.FxTargetLinearPayoffRegion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetKnockoutForwardChoiceValidator implements Validator<FxTargetKnockoutForwardChoice> {

	private List<ComparisonResult> getComparisonResults(FxTargetKnockoutForwardChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("constantPayoffRegion", (FxTargetConstantPayoffRegion) o.getConstantPayoffRegion() != null ? 1 : 0, 0, 1), 
				checkCardinality("linearPayoffRegion", (FxTargetLinearPayoffRegion) o.getLinearPayoffRegion() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxTargetKnockoutForwardChoice> validate(RosettaPath path, FxTargetKnockoutForwardChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetKnockoutForwardChoice", ValidationType.CARDINALITY, "FxTargetKnockoutForwardChoice", path, "", error);
		}
		return success("FxTargetKnockoutForwardChoice", ValidationType.CARDINALITY, "FxTargetKnockoutForwardChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetKnockoutForwardChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetKnockoutForwardChoice", ValidationType.CARDINALITY, "FxTargetKnockoutForwardChoice", path, "", res.getError());
				}
				return success("FxTargetKnockoutForwardChoice", ValidationType.CARDINALITY, "FxTargetKnockoutForwardChoice", path, "");
			})
			.collect(toList());
	}

}
