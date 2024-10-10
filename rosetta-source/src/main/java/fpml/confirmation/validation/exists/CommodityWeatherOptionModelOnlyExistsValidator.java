package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityExercise;
import fpml.confirmation.CommodityWeatherOptionModel;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.WeatherCalculationPeriodModel;
import fpml.confirmation.WeatherIndex;
import fpml.confirmation.WeatherIndexData;
import fpml.confirmation.WeatherLegCalculation;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityWeatherOptionModelOnlyExistsValidator implements ValidatorWithArg<CommodityWeatherOptionModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityWeatherOptionModel> ValidationResult<CommodityWeatherOptionModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("weatherCalculationPeriodModel", ExistenceChecker.isSet((WeatherCalculationPeriodModel) o.getWeatherCalculationPeriodModel()))
				.put("weatherNotionalAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getWeatherNotionalAmount()))
				.put("exercise", ExistenceChecker.isSet((CommodityExercise) o.getExercise()))
				.put("weatherIndexStrikeLevel", ExistenceChecker.isSet((WeatherIndex) o.getWeatherIndexStrikeLevel()))
				.put("calculation", ExistenceChecker.isSet((WeatherLegCalculation) o.getCalculation()))
				.put("weatherIndexData", ExistenceChecker.isSet((WeatherIndexData) o.getWeatherIndexData()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityWeatherOptionModel", ValidationType.ONLY_EXISTS, "CommodityWeatherOptionModel", path, "");
		}
		return failure("CommodityWeatherOptionModel", ValidationType.ONLY_EXISTS, "CommodityWeatherOptionModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
