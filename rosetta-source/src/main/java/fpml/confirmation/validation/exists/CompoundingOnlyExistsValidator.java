package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2;
import fpml.confirmation.Compounding;
import fpml.confirmation.CompoundingMethodEnum;
import fpml.confirmation.CompoundingRate;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CompoundingOnlyExistsValidator implements ValidatorWithArg<Compounding, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Compounding> ValidationResult<Compounding> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("compoundingMethod", ExistenceChecker.isSet((CompoundingMethodEnum) o.getCompoundingMethod()))
				.put("compoundingRate", ExistenceChecker.isSet((CompoundingRate) o.getCompoundingRate()))
				.put("compoundingSpread", ExistenceChecker.isSet((BigDecimal) o.getCompoundingSpread()))
				.put("compoundingDates", ExistenceChecker.isSet((AdjustableRelativeOrPeriodicDates2) o.getCompoundingDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Compounding", ValidationType.ONLY_EXISTS, "Compounding", path, "");
		}
		return failure("Compounding", ValidationType.ONLY_EXISTS, "Compounding", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
