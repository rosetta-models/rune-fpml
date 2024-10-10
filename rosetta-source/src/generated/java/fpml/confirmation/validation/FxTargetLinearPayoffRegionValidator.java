package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxExchangedCurrencyModel;
import fpml.confirmation.FxStrike;
import fpml.confirmation.FxTargetLeverage;
import fpml.confirmation.FxTargetLinearPayoffRegion;
import fpml.confirmation.FxTargetRegionLowerBound;
import fpml.confirmation.FxTargetRegionUpperBound;
import fpml.confirmation.NonNegativeAmountSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetLinearPayoffRegionValidator implements Validator<FxTargetLinearPayoffRegion> {

	private List<ComparisonResult> getComparisonResults(FxTargetLinearPayoffRegion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxExchangedCurrencyModel", (FxExchangedCurrencyModel) o.getFxExchangedCurrencyModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("strike", (FxStrike) o.getStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterCurrencyAmount", (NonNegativeAmountSchedule) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("lowerBound", (FxTargetRegionLowerBound) o.getLowerBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("upperBound", (FxTargetRegionUpperBound) o.getUpperBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("leverage", (FxTargetLeverage) o.getLeverage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxTargetLinearPayoffRegion> validate(RosettaPath path, FxTargetLinearPayoffRegion o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetLinearPayoffRegion", ValidationType.CARDINALITY, "FxTargetLinearPayoffRegion", path, "", error);
		}
		return success("FxTargetLinearPayoffRegion", ValidationType.CARDINALITY, "FxTargetLinearPayoffRegion", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetLinearPayoffRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetLinearPayoffRegion", ValidationType.CARDINALITY, "FxTargetLinearPayoffRegion", path, "", res.getError());
				}
				return success("FxTargetLinearPayoffRegion", ValidationType.CARDINALITY, "FxTargetLinearPayoffRegion", path, "");
			})
			.collect(toList());
	}

}
