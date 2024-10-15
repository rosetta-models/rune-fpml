package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalStandardQuality;
import fpml.confirmation.CommodityCoalCompositionModel;
import fpml.confirmation.CommodityCoalPropertiesModel;
import fpml.confirmation.CommodityCoalReducingAtmosphereModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CoalStandardQualityOnlyExistsValidator implements ValidatorWithArg<CoalStandardQuality, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CoalStandardQuality> ValidationResult<CoalStandardQuality> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commodityCoalCompositionModel", ExistenceChecker.isSet((CommodityCoalCompositionModel) o.getCommodityCoalCompositionModel()))
				.put("commodityCoalPropertiesModel", ExistenceChecker.isSet((CommodityCoalPropertiesModel) o.getCommodityCoalPropertiesModel()))
				.put("commodityCoalReducingAtmosphereModel", ExistenceChecker.isSet((CommodityCoalReducingAtmosphereModel) o.getCommodityCoalReducingAtmosphereModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CoalStandardQuality", ValidationType.ONLY_EXISTS, "CoalStandardQuality", path, "");
		}
		return failure("CoalStandardQuality", ValidationType.ONLY_EXISTS, "CoalStandardQuality", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
