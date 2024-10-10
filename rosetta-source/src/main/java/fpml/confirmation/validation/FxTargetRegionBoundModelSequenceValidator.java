package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetRegionBoundModelSequence;
import fpml.confirmation.FxTargetRegionLowerBound;
import fpml.confirmation.FxTargetRegionUpperBound;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetRegionBoundModelSequenceValidator implements Validator<FxTargetRegionBoundModelSequence> {

	private List<ComparisonResult> getComparisonResults(FxTargetRegionBoundModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lowerBound", (FxTargetRegionLowerBound) o.getLowerBound() != null ? 1 : 0, 1, 1), 
				checkCardinality("upperBound", (FxTargetRegionUpperBound) o.getUpperBound() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxTargetRegionBoundModelSequence> validate(RosettaPath path, FxTargetRegionBoundModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetRegionBoundModelSequence", ValidationType.CARDINALITY, "FxTargetRegionBoundModelSequence", path, "", error);
		}
		return success("FxTargetRegionBoundModelSequence", ValidationType.CARDINALITY, "FxTargetRegionBoundModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetRegionBoundModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetRegionBoundModelSequence", ValidationType.CARDINALITY, "FxTargetRegionBoundModelSequence", path, "", res.getError());
				}
				return success("FxTargetRegionBoundModelSequence", ValidationType.CARDINALITY, "FxTargetRegionBoundModelSequence", path, "");
			})
			.collect(toList());
	}

}
