package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbsoluteTolerance;
import fpml.confirmation.PartyReference;
import fpml.confirmation.QuantityUnit;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AbsoluteToleranceOnlyExistsValidator implements ValidatorWithArg<AbsoluteTolerance, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AbsoluteTolerance> ValidationResult<AbsoluteTolerance> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("positive", ExistenceChecker.isSet((BigDecimal) o.getPositive()))
				.put("negative", ExistenceChecker.isSet((BigDecimal) o.getNegative()))
				.put("unit", ExistenceChecker.isSet((QuantityUnit) o.getUnit()))
				.put("optionOwnerPartyReference", ExistenceChecker.isSet((PartyReference) o.getOptionOwnerPartyReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AbsoluteTolerance", ValidationType.ONLY_EXISTS, "AbsoluteTolerance", path, "");
		}
		return failure("AbsoluteTolerance", ValidationType.ONLY_EXISTS, "AbsoluteTolerance", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
