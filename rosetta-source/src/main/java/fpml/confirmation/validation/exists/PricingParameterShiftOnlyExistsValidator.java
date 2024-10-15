package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetOrTermPointOrPricingStructureReference;
import fpml.confirmation.PriceQuoteUnits;
import fpml.confirmation.PricingParameterShift;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PricingParameterShiftOnlyExistsValidator implements ValidatorWithArg<PricingParameterShift, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PricingParameterShift> ValidationResult<PricingParameterShift> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("parameterReference", ExistenceChecker.isSet((AssetOrTermPointOrPricingStructureReference) o.getParameterReference()))
				.put("shift", ExistenceChecker.isSet((BigDecimal) o.getShift()))
				.put("shiftUnits", ExistenceChecker.isSet((PriceQuoteUnits) o.getShiftUnits()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PricingParameterShift", ValidationType.ONLY_EXISTS, "PricingParameterShift", path, "");
		}
		return failure("PricingParameterShift", ValidationType.ONLY_EXISTS, "PricingParameterShift", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
