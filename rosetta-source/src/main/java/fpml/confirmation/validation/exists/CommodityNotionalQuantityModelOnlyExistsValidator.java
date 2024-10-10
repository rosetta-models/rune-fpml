package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.CommodityNotionalQuantityModelSequence;
import fpml.confirmation.QuantityReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityNotionalQuantityModelOnlyExistsValidator implements ValidatorWithArg<CommodityNotionalQuantityModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityNotionalQuantityModel> ValidationResult<CommodityNotionalQuantityModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commodityNotionalQuantityModelSequence", ExistenceChecker.isSet((CommodityNotionalQuantityModelSequence) o.getCommodityNotionalQuantityModelSequence()))
				.put("quantityReference", ExistenceChecker.isSet((QuantityReference) o.getQuantityReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityNotionalQuantityModel", ValidationType.ONLY_EXISTS, "CommodityNotionalQuantityModel", path, "");
		}
		return failure("CommodityNotionalQuantityModel", ValidationType.ONLY_EXISTS, "CommodityNotionalQuantityModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
