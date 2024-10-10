package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import fpml.confirmation.GasPhysicalQuantity;
import fpml.confirmation.GasPhysicalQuantitySequence;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GasPhysicalQuantityOnlyExistsValidator implements ValidatorWithArg<GasPhysicalQuantity, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GasPhysicalQuantity> ValidationResult<GasPhysicalQuantity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("commodityFixedPhysicalQuantityModel", ExistenceChecker.isSet((CommodityFixedPhysicalQuantityModel) o.getCommodityFixedPhysicalQuantityModel()))
				.put("gasPhysicalQuantitySequence", ExistenceChecker.isSet((GasPhysicalQuantitySequence) o.getGasPhysicalQuantitySequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GasPhysicalQuantity", ValidationType.ONLY_EXISTS, "GasPhysicalQuantity", path, "");
		}
		return failure("GasPhysicalQuantity", ValidationType.ONLY_EXISTS, "GasPhysicalQuantity", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
