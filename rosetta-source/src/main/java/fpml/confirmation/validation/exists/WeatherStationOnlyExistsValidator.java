package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCenter;
import fpml.confirmation.WeatherStation;
import fpml.confirmation.WeatherStationAirport;
import fpml.confirmation.WeatherStationWBAN;
import fpml.confirmation.WeatherStationWMO;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class WeatherStationOnlyExistsValidator implements ValidatorWithArg<WeatherStation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends WeatherStation> ValidationResult<WeatherStation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("weatherStationCity", ExistenceChecker.isSet((BusinessCenter) o.getWeatherStationCity()))
				.put("weatherStationAirport", ExistenceChecker.isSet((WeatherStationAirport) o.getWeatherStationAirport()))
				.put("weatherStationWBAN", ExistenceChecker.isSet((WeatherStationWBAN) o.getWeatherStationWBAN()))
				.put("weatherStationWMO", ExistenceChecker.isSet((WeatherStationWMO) o.getWeatherStationWMO()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("WeatherStation", ValidationType.ONLY_EXISTS, "WeatherStation", path, "");
		}
		return failure("WeatherStation", ValidationType.ONLY_EXISTS, "WeatherStation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
