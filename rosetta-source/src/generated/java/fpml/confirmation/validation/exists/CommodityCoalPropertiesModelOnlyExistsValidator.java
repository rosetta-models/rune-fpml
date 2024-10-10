package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalAttributeDecimal;
import fpml.confirmation.CommodityCoalPropertiesModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityCoalPropertiesModelOnlyExistsValidator implements ValidatorWithArg<CommodityCoalPropertiesModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityCoalPropertiesModel> ValidationResult<CommodityCoalPropertiesModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("btUperLB", ExistenceChecker.isSet((CoalAttributeDecimal) o.getBtUperLB()))
				.put("topSize", ExistenceChecker.isSet((CoalAttributeDecimal) o.getTopSize()))
				.put("finesPassingScreen", ExistenceChecker.isSet((CoalAttributeDecimal) o.getFinesPassingScreen()))
				.put("grindability", ExistenceChecker.isSet((CoalAttributeDecimal) o.getGrindability()))
				.put("ashFusionTemperature", ExistenceChecker.isSet((CoalAttributeDecimal) o.getAshFusionTemperature()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityCoalPropertiesModel", ValidationType.ONLY_EXISTS, "CommodityCoalPropertiesModel", path, "");
		}
		return failure("CommodityCoalPropertiesModel", ValidationType.ONLY_EXISTS, "CommodityCoalPropertiesModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
