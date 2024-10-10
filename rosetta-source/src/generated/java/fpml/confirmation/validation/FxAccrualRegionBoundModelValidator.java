package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualRegionBoundModel;
import fpml.confirmation.FxAccrualRegionBoundModelSequence;
import fpml.confirmation.FxAccrualRegionUpperBound;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualRegionBoundModelValidator implements Validator<FxAccrualRegionBoundModel> {

	private List<ComparisonResult> getComparisonResults(FxAccrualRegionBoundModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("upperBound", (FxAccrualRegionUpperBound) o.getUpperBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxAccrualRegionBoundModelSequence", (FxAccrualRegionBoundModelSequence) o.getFxAccrualRegionBoundModelSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualRegionBoundModel> validate(RosettaPath path, FxAccrualRegionBoundModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualRegionBoundModel", ValidationType.CARDINALITY, "FxAccrualRegionBoundModel", path, "", error);
		}
		return success("FxAccrualRegionBoundModel", ValidationType.CARDINALITY, "FxAccrualRegionBoundModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegionBoundModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualRegionBoundModel", ValidationType.CARDINALITY, "FxAccrualRegionBoundModel", path, "", res.getError());
				}
				return success("FxAccrualRegionBoundModel", ValidationType.CARDINALITY, "FxAccrualRegionBoundModel", path, "");
			})
			.collect(toList());
	}

}
