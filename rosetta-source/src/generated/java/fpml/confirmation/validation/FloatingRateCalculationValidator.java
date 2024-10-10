package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.FloatingRateCalculation;
import fpml.confirmation.FloatingRateIndexModel;
import fpml.confirmation.NegativeInterestRateTreatmentEnum;
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

public class FloatingRateCalculationValidator implements Validator<FloatingRateCalculation> {

	private List<ComparisonResult> getComparisonResults(FloatingRateCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateIndexModel", (FloatingRateIndexModel) o.getFloatingRateIndexModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("floatingRateMultiplierSchedule", (Schedule) o.getFloatingRateMultiplierSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateTreatment", (RateTreatmentEnum) o.getRateTreatment() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialRate", (BigDecimal) o.getInitialRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalRateRounding", (Rounding) o.getFinalRateRounding() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("negativeInterestRateTreatment", (NegativeInterestRateTreatmentEnum) o.getNegativeInterestRateTreatment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FloatingRateCalculation> validate(RosettaPath path, FloatingRateCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateCalculation", ValidationType.CARDINALITY, "FloatingRateCalculation", path, "", error);
		}
		return success("FloatingRateCalculation", ValidationType.CARDINALITY, "FloatingRateCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateCalculation", ValidationType.CARDINALITY, "FloatingRateCalculation", path, "", res.getError());
				}
				return success("FloatingRateCalculation", ValidationType.CARDINALITY, "FloatingRateCalculation", path, "");
			})
			.collect(toList());
	}

}
