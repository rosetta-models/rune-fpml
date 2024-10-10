package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DataProvider;
import fpml.confirmation.DisruptionFallback;
import fpml.confirmation.ReferenceLevel;
import fpml.confirmation.WeatherIndexData;
import fpml.confirmation.WeatherStation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WeatherIndexDataValidator implements Validator<WeatherIndexData> {

	private List<ComparisonResult> getComparisonResults(WeatherIndexData o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceLevel", (ReferenceLevel) o.getReferenceLevel() != null ? 1 : 0, 1, 1), 
				checkCardinality("dataProvider", (DataProvider) o.getDataProvider() != null ? 1 : 0, 1, 1), 
				checkCardinality("finalEditedData", (Boolean) o.getFinalEditedData() != null ? 1 : 0, 1, 1), 
				checkCardinality("weatherStation", (WeatherStation) o.getWeatherStation() != null ? 1 : 0, 1, 1), 
				checkCardinality("weatherStationFallback", (WeatherStation) o.getWeatherStationFallback() != null ? 1 : 0, 1, 1), 
				checkCardinality("weatherStationSecondFallback", (WeatherStation) o.getWeatherStationSecondFallback() != null ? 1 : 0, 1, 1), 
				checkCardinality("alternativeDataProvider", (Boolean) o.getAlternativeDataProvider() != null ? 1 : 0, 1, 1), 
				checkCardinality("synopticDataFallback", (Boolean) o.getSynopticDataFallback() != null ? 1 : 0, 1, 1), 
				checkCardinality("adjustmentToFallbackWeatherStation", (Boolean) o.getAdjustmentToFallbackWeatherStation() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryDisruptionFallbacks", (DisruptionFallback) o.getPrimaryDisruptionFallbacks() != null ? 1 : 0, 0, 1), 
				checkCardinality("secondaryDisruptionFallbacks", (DisruptionFallback) o.getSecondaryDisruptionFallbacks() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<WeatherIndexData> validate(RosettaPath path, WeatherIndexData o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WeatherIndexData", ValidationType.CARDINALITY, "WeatherIndexData", path, "", error);
		}
		return success("WeatherIndexData", ValidationType.CARDINALITY, "WeatherIndexData", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherIndexData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherIndexData", ValidationType.CARDINALITY, "WeatherIndexData", path, "", res.getError());
				}
				return success("WeatherIndexData", ValidationType.CARDINALITY, "WeatherIndexData", path, "");
			})
			.collect(toList());
	}

}
