package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenter;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Period;
import fpml.confirmation.Rounding;
import fpml.confirmation.WeatherLegCalculation;
import fpml.confirmation.WeatherSettlementLevelEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WeatherLegCalculationValidator implements Validator<WeatherLegCalculation> {

	private List<ComparisonResult> getComparisonResults(WeatherLegCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementLevel", (WeatherSettlementLevelEnum) o.getSettlementLevel() != null ? 1 : 0, 1, 1), 
				checkCardinality("referenceLevelEqualsZero", (Boolean) o.getReferenceLevelEqualsZero() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculationDate", (Period) o.getCalculationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessDays", (BusinessCenter) o.getBusinessDays() != null ? 1 : 0, 1, 1), 
				checkCardinality("dataCorrection", (Boolean) o.getDataCorrection() != null ? 1 : 0, 1, 1), 
				checkCardinality("correctionPeriod", (Period) o.getCorrectionPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumPaymentAmount", (NonNegativeMoney) o.getMaximumPaymentAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumTransactionPaymentAmount", (NonNegativeMoney) o.getMaximumTransactionPaymentAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("rounding", (Rounding) o.getRounding() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<WeatherLegCalculation> validate(RosettaPath path, WeatherLegCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WeatherLegCalculation", ValidationType.CARDINALITY, "WeatherLegCalculation", path, "", error);
		}
		return success("WeatherLegCalculation", ValidationType.CARDINALITY, "WeatherLegCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherLegCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherLegCalculation", ValidationType.CARDINALITY, "WeatherLegCalculation", path, "", res.getError());
				}
				return success("WeatherLegCalculation", ValidationType.CARDINALITY, "WeatherLegCalculation", path, "");
			})
			.collect(toList());
	}

}
