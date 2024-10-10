package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
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
import fpml.confirmation.SpreadSchedule;
import fpml.confirmation.StrikeSchedule;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InflationRateCalculationOnlyExistsValidator implements ValidatorWithArg<InflationRateCalculation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InflationRateCalculation> ValidationResult<InflationRateCalculation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("floatingRateIndexModel", ExistenceChecker.isSet((FloatingRateIndexModel) o.getFloatingRateIndexModel()))
				.put("floatingRateMultiplierSchedule", ExistenceChecker.isSet((Schedule) o.getFloatingRateMultiplierSchedule()))
				.put("spreadSchedule", ExistenceChecker.isSet((List<? extends SpreadSchedule>) o.getSpreadSchedule()))
				.put("rateTreatment", ExistenceChecker.isSet((RateTreatmentEnum) o.getRateTreatment()))
				.put("capRateSchedule", ExistenceChecker.isSet((List<? extends StrikeSchedule>) o.getCapRateSchedule()))
				.put("floorRateSchedule", ExistenceChecker.isSet((List<? extends StrikeSchedule>) o.getFloorRateSchedule()))
				.put("initialRate", ExistenceChecker.isSet((BigDecimal) o.getInitialRate()))
				.put("finalRateRounding", ExistenceChecker.isSet((Rounding) o.getFinalRateRounding()))
				.put("averagingMethod", ExistenceChecker.isSet((AveragingMethodEnum) o.getAveragingMethod()))
				.put("negativeInterestRateTreatment", ExistenceChecker.isSet((NegativeInterestRateTreatmentEnum) o.getNegativeInterestRateTreatment()))
				.put("inflationLag", ExistenceChecker.isSet((Offset) o.getInflationLag()))
				.put("indexSource", ExistenceChecker.isSet((RateSourcePage) o.getIndexSource()))
				.put("mainPublication", ExistenceChecker.isSet((MainPublication) o.getMainPublication()))
				.put("interpolationMethod", ExistenceChecker.isSet((InterpolationMethod) o.getInterpolationMethod()))
				.put("initialIndexLevel", ExistenceChecker.isSet((BigDecimal) o.getInitialIndexLevel()))
				.put("fallbackBondApplicable", ExistenceChecker.isSet((Boolean) o.getFallbackBondApplicable()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InflationRateCalculation", ValidationType.ONLY_EXISTS, "InflationRateCalculation", path, "");
		}
		return failure("InflationRateCalculation", ValidationType.ONLY_EXISTS, "InflationRateCalculation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
