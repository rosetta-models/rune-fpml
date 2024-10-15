package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ComputedDerivativeModel;
import fpml.confirmation.DerivativeFormula;
import fpml.confirmation.PricingParameterDerivative;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ComputedDerivativeModelOnlyExistsValidator implements ValidatorWithArg<ComputedDerivativeModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ComputedDerivativeModel> ValidationResult<ComputedDerivativeModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partialDerivative", ExistenceChecker.isSet((List<? extends PricingParameterDerivative>) o.getPartialDerivative()))
				.put("formula", ExistenceChecker.isSet((DerivativeFormula) o.getFormula()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ComputedDerivativeModel", ValidationType.ONLY_EXISTS, "ComputedDerivativeModel", path, "");
		}
		return failure("ComputedDerivativeModel", ValidationType.ONLY_EXISTS, "ComputedDerivativeModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
