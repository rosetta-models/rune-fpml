package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualLeverage;
import fpml.confirmation.FxAccrualLinearPayoffRegion;
import fpml.confirmation.FxAccrualLinearPayoffRegionSequence;
import fpml.confirmation.FxAccrualRegionBoundModel;
import fpml.confirmation.FxAverageStrike;
import fpml.confirmation.FxExchangedCurrencyModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualLinearPayoffRegionValidator implements Validator<FxAccrualLinearPayoffRegion> {

	private List<ComparisonResult> getComparisonResults(FxAccrualLinearPayoffRegion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxExchangedCurrencyModel", (FxExchangedCurrencyModel) o.getFxExchangedCurrencyModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxAccrualLinearPayoffRegionSequence", (FxAccrualLinearPayoffRegionSequence) o.getFxAccrualLinearPayoffRegionSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("averageStrike", (FxAverageStrike) o.getAverageStrike() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxAccrualRegionBoundModel", (FxAccrualRegionBoundModel) o.getFxAccrualRegionBoundModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("leverage", (FxAccrualLeverage) o.getLeverage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualLinearPayoffRegion> validate(RosettaPath path, FxAccrualLinearPayoffRegion o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualLinearPayoffRegion", ValidationType.CARDINALITY, "FxAccrualLinearPayoffRegion", path, "", error);
		}
		return success("FxAccrualLinearPayoffRegion", ValidationType.CARDINALITY, "FxAccrualLinearPayoffRegion", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualLinearPayoffRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualLinearPayoffRegion", ValidationType.CARDINALITY, "FxAccrualLinearPayoffRegion", path, "", res.getError());
				}
				return success("FxAccrualLinearPayoffRegion", ValidationType.CARDINALITY, "FxAccrualLinearPayoffRegion", path, "");
			})
			.collect(toList());
	}

}
