package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ParametricAdjustment;
import fpml.confirmation.ParametricAdjustmentPoint;
import fpml.confirmation.PriceQuoteUnits;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ParametricAdjustmentOnlyExistsValidator implements ValidatorWithArg<ParametricAdjustment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ParametricAdjustment> ValidationResult<ParametricAdjustment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("inputUnits", ExistenceChecker.isSet((PriceQuoteUnits) o.getInputUnits()))
				.put("datapoint", ExistenceChecker.isSet((List<? extends ParametricAdjustmentPoint>) o.getDatapoint()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ParametricAdjustment", ValidationType.ONLY_EXISTS, "ParametricAdjustment", path, "");
		}
		return failure("ParametricAdjustment", ValidationType.ONLY_EXISTS, "ParametricAdjustment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
