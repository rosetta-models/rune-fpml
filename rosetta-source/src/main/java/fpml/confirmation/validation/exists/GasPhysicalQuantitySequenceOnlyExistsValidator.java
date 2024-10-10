package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.GasPhysicalQuantitySequence;
import fpml.confirmation.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GasPhysicalQuantitySequenceOnlyExistsValidator implements ValidatorWithArg<GasPhysicalQuantitySequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GasPhysicalQuantitySequence> ValidationResult<GasPhysicalQuantitySequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("minPhysicalQuantity", ExistenceChecker.isSet((List<? extends CommodityNotionalQuantity>) o.getMinPhysicalQuantity()))
				.put("maxPhysicalQuantity", ExistenceChecker.isSet((List<? extends CommodityNotionalQuantity>) o.getMaxPhysicalQuantity()))
				.put("electingParty", ExistenceChecker.isSet((PartyReference) o.getElectingParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GasPhysicalQuantitySequence", ValidationType.ONLY_EXISTS, "GasPhysicalQuantitySequence", path, "");
		}
		return failure("GasPhysicalQuantitySequence", ValidationType.ONLY_EXISTS, "GasPhysicalQuantitySequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
