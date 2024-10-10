package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetRegionBoundModel;
import fpml.confirmation.FxTargetRegionBoundModelSequence;
import fpml.confirmation.FxTargetRegionUpperBound;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetRegionBoundModelValidator implements Validator<FxTargetRegionBoundModel> {

	private List<ComparisonResult> getComparisonResults(FxTargetRegionBoundModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("upperBound", (FxTargetRegionUpperBound) o.getUpperBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxTargetRegionBoundModelSequence", (FxTargetRegionBoundModelSequence) o.getFxTargetRegionBoundModelSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxTargetRegionBoundModel> validate(RosettaPath path, FxTargetRegionBoundModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetRegionBoundModel", ValidationType.CARDINALITY, "FxTargetRegionBoundModel", path, "", error);
		}
		return success("FxTargetRegionBoundModel", ValidationType.CARDINALITY, "FxTargetRegionBoundModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetRegionBoundModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetRegionBoundModel", ValidationType.CARDINALITY, "FxTargetRegionBoundModel", path, "", res.getError());
				}
				return success("FxTargetRegionBoundModel", ValidationType.CARDINALITY, "FxTargetRegionBoundModel", path, "");
			})
			.collect(toList());
	}

}
