package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalAttributePercentage;
import fpml.confirmation.CommodityCoalCompositionModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityCoalCompositionModelOnlyExistsValidator implements ValidatorWithArg<CommodityCoalCompositionModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityCoalCompositionModel> ValidationResult<CommodityCoalCompositionModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("moisture", ExistenceChecker.isSet((CoalAttributePercentage) o.getMoisture()))
				.put("ash", ExistenceChecker.isSet((CoalAttributePercentage) o.getAsh()))
				.put("sulfur", ExistenceChecker.isSet((CoalAttributePercentage) o.getSulfur()))
				.put("sO2", ExistenceChecker.isSet((CoalAttributePercentage) o.getSO2()))
				.put("volatile", ExistenceChecker.isSet((CoalAttributePercentage) o.getVolatile()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityCoalCompositionModel", ValidationType.ONLY_EXISTS, "CommodityCoalCompositionModel", path, "");
		}
		return failure("CommodityCoalCompositionModel", ValidationType.ONLY_EXISTS, "CommodityCoalCompositionModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
