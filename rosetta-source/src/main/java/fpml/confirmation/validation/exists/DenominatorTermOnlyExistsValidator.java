package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DenominatorTerm;
import fpml.confirmation.WeightedPartialDerivative;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DenominatorTermOnlyExistsValidator implements ValidatorWithArg<DenominatorTerm, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DenominatorTerm> ValidationResult<DenominatorTerm> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("weightedPartial", ExistenceChecker.isSet((WeightedPartialDerivative) o.getWeightedPartial()))
				.put("power", ExistenceChecker.isSet((Integer) o.getPower()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DenominatorTerm", ValidationType.ONLY_EXISTS, "DenominatorTerm", path, "");
		}
		return failure("DenominatorTerm", ValidationType.ONLY_EXISTS, "DenominatorTerm", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
