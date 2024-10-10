package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityExercise;
import fpml.confirmation.CommodityWeatherOptionModel;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.WeatherCalculationPeriodModel;
import fpml.confirmation.WeatherIndex;
import fpml.confirmation.WeatherIndexData;
import fpml.confirmation.WeatherLegCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityWeatherOptionModelValidator implements Validator<CommodityWeatherOptionModel> {

	private List<ComparisonResult> getComparisonResults(CommodityWeatherOptionModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("weatherCalculationPeriodModel", (WeatherCalculationPeriodModel) o.getWeatherCalculationPeriodModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("weatherNotionalAmount", (NonNegativeMoney) o.getWeatherNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("exercise", (CommodityExercise) o.getExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("weatherIndexStrikeLevel", (WeatherIndex) o.getWeatherIndexStrikeLevel() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculation", (WeatherLegCalculation) o.getCalculation() != null ? 1 : 0, 1, 1), 
				checkCardinality("weatherIndexData", (WeatherIndexData) o.getWeatherIndexData() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityWeatherOptionModel> validate(RosettaPath path, CommodityWeatherOptionModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityWeatherOptionModel", ValidationType.CARDINALITY, "CommodityWeatherOptionModel", path, "", error);
		}
		return success("CommodityWeatherOptionModel", ValidationType.CARDINALITY, "CommodityWeatherOptionModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityWeatherOptionModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityWeatherOptionModel", ValidationType.CARDINALITY, "CommodityWeatherOptionModel", path, "", res.getError());
				}
				return success("CommodityWeatherOptionModel", ValidationType.CARDINALITY, "CommodityWeatherOptionModel", path, "");
			})
			.collect(toList());
	}

}
