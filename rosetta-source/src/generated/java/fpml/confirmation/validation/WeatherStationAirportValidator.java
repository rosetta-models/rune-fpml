package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.WeatherStationAirport;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WeatherStationAirportValidator implements Validator<WeatherStationAirport> {

	private List<ComparisonResult> getComparisonResults(WeatherStationAirport o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("weatherStationAirportScheme", (String) o.getWeatherStationAirportScheme() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<WeatherStationAirport> validate(RosettaPath path, WeatherStationAirport o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WeatherStationAirport", ValidationType.CARDINALITY, "WeatherStationAirport", path, "", error);
		}
		return success("WeatherStationAirport", ValidationType.CARDINALITY, "WeatherStationAirport", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherStationAirport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherStationAirport", ValidationType.CARDINALITY, "WeatherStationAirport", path, "", res.getError());
				}
				return success("WeatherStationAirport", ValidationType.CARDINALITY, "WeatherStationAirport", path, "");
			})
			.collect(toList());
	}

}
