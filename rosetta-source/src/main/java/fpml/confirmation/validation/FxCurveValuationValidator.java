package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AnyAssetReference;
import fpml.confirmation.FxCurveValuation;
import fpml.confirmation.FxRateSet;
import fpml.confirmation.PricingInputDatesModel;
import fpml.confirmation.PricingStructureReference;
import fpml.confirmation.TermCurve;
import fpml.confirmation.ValuationScenarioReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxCurveValuationValidator implements Validator<FxCurveValuation> {

	private List<ComparisonResult> getComparisonResults(FxCurveValuation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("objectReference", (AnyAssetReference) o.getObjectReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationScenarioReference", (ValuationScenarioReference) o.getValuationScenarioReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("definitionRef", (String) o.getDefinitionRef() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingInputDatesModel", (PricingInputDatesModel) o.getPricingInputDatesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementCurrencyYieldCurve", (PricingStructureReference) o.getSettlementCurrencyYieldCurve() != null ? 1 : 0, 0, 1), 
				checkCardinality("forecastCurrencyYieldCurve", (PricingStructureReference) o.getForecastCurrencyYieldCurve() != null ? 1 : 0, 0, 1), 
				checkCardinality("spotRate", (FxRateSet) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxForwardCurve", (TermCurve) o.getFxForwardCurve() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxForwardPointsCurve", (TermCurve) o.getFxForwardPointsCurve() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxCurveValuation> validate(RosettaPath path, FxCurveValuation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxCurveValuation", ValidationType.CARDINALITY, "FxCurveValuation", path, "", error);
		}
		return success("FxCurveValuation", ValidationType.CARDINALITY, "FxCurveValuation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCurveValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCurveValuation", ValidationType.CARDINALITY, "FxCurveValuation", path, "", res.getError());
				}
				return success("FxCurveValuation", ValidationType.CARDINALITY, "FxCurveValuation", path, "");
			})
			.collect(toList());
	}

}
