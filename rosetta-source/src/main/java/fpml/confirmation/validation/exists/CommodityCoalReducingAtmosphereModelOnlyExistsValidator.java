package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalAttributeDecimal;
import fpml.confirmation.CommodityCoalReducingAtmosphereModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityCoalReducingAtmosphereModelOnlyExistsValidator implements ValidatorWithArg<CommodityCoalReducingAtmosphereModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityCoalReducingAtmosphereModel> ValidationResult<CommodityCoalReducingAtmosphereModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("initialDeformation", ExistenceChecker.isSet((CoalAttributeDecimal) o.getInitialDeformation()))
				.put("softeningHeightWidth", ExistenceChecker.isSet((CoalAttributeDecimal) o.getSofteningHeightWidth()))
				.put("softeningHeightHalfWidth", ExistenceChecker.isSet((CoalAttributeDecimal) o.getSofteningHeightHalfWidth()))
				.put("fluid", ExistenceChecker.isSet((CoalAttributeDecimal) o.getFluid()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityCoalReducingAtmosphereModel", ValidationType.ONLY_EXISTS, "CommodityCoalReducingAtmosphereModel", path, "");
		}
		return failure("CommodityCoalReducingAtmosphereModel", ValidationType.ONLY_EXISTS, "CommodityCoalReducingAtmosphereModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
