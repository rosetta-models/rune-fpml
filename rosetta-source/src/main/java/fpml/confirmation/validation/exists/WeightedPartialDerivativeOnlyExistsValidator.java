package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingParameterDerivativeReference;
import fpml.confirmation.WeightedPartialDerivative;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class WeightedPartialDerivativeOnlyExistsValidator implements ValidatorWithArg<WeightedPartialDerivative, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends WeightedPartialDerivative> ValidationResult<WeightedPartialDerivative> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partialDerivativeReference", ExistenceChecker.isSet((PricingParameterDerivativeReference) o.getPartialDerivativeReference()))
				.put("weight", ExistenceChecker.isSet((BigDecimal) o.getWeight()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("WeightedPartialDerivative", ValidationType.ONLY_EXISTS, "WeightedPartialDerivative", path, "");
		}
		return failure("WeightedPartialDerivative", ValidationType.ONLY_EXISTS, "WeightedPartialDerivative", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
