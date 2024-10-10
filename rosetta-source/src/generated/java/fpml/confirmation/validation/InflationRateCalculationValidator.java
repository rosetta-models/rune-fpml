package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.FloatingRateIndexModel;
import fpml.confirmation.InflationRateCalculation;
import fpml.confirmation.InterpolationMethod;
import fpml.confirmation.MainPublication;
import fpml.confirmation.NegativeInterestRateTreatmentEnum;
import fpml.confirmation.Offset;
import fpml.confirmation.RateSourcePage;
import fpml.confirmation.RateTreatmentEnum;
import fpml.confirmation.Rounding;
import fpml.confirmation.Schedule;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InflationRateCalculationValidator implements Validator<InflationRateCalculation> {

	private List<ComparisonResult> getComparisonResults(InflationRateCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateIndexModel", (FloatingRateIndexModel) o.getFloatingRateIndexModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("floatingRateMultiplierSchedule", (Schedule) o.getFloatingRateMultiplierSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateTreatment", (RateTreatmentEnum) o.getRateTreatment() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialRate", (BigDecimal) o.getInitialRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalRateRounding", (Rounding) o.getFinalRateRounding() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("negativeInterestRateTreatment", (NegativeInterestRateTreatmentEnum) o.getNegativeInterestRateTreatment() != null ? 1 : 0, 0, 1), 
				checkCardinality("inflationLag", (Offset) o.getInflationLag() != null ? 1 : 0, 1, 1), 
				checkCardinality("indexSource", (RateSourcePage) o.getIndexSource() != null ? 1 : 0, 1, 1), 
				checkCardinality("mainPublication", (MainPublication) o.getMainPublication() != null ? 1 : 0, 0, 1), 
				checkCardinality("interpolationMethod", (InterpolationMethod) o.getInterpolationMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("initialIndexLevel", (BigDecimal) o.getInitialIndexLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("fallbackBondApplicable", (Boolean) o.getFallbackBondApplicable() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<InflationRateCalculation> validate(RosettaPath path, InflationRateCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InflationRateCalculation", ValidationType.CARDINALITY, "InflationRateCalculation", path, "", error);
		}
		return success("InflationRateCalculation", ValidationType.CARDINALITY, "InflationRateCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InflationRateCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InflationRateCalculation", ValidationType.CARDINALITY, "InflationRateCalculation", path, "", res.getError());
				}
				return success("InflationRateCalculation", ValidationType.CARDINALITY, "InflationRateCalculation", path, "");
			})
			.collect(toList());
	}

}
