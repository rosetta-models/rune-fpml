package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalAttributePercentage;
import fpml.confirmation.CoalAttributePercentageSequence0;
import fpml.confirmation.CoalAttributePercentageSequence1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CoalAttributePercentageOnlyExistsValidator implements ValidatorWithArg<CoalAttributePercentage, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CoalAttributePercentage> ValidationResult<CoalAttributePercentage> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("coalAttributePercentageSequence0", ExistenceChecker.isSet((CoalAttributePercentageSequence0) o.getCoalAttributePercentageSequence0()))
				.put("coalAttributePercentageSequence1", ExistenceChecker.isSet((CoalAttributePercentageSequence1) o.getCoalAttributePercentageSequence1()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CoalAttributePercentage", ValidationType.ONLY_EXISTS, "CoalAttributePercentage", path, "");
		}
		return failure("CoalAttributePercentage", ValidationType.ONLY_EXISTS, "CoalAttributePercentage", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
