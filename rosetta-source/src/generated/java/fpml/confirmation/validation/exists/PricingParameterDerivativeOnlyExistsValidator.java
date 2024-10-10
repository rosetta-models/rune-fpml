package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetOrTermPointOrPricingStructureReference;
import fpml.confirmation.DerivativeCalculationProcedure;
import fpml.confirmation.PricingParameterDerivative;
import fpml.confirmation.ValuationReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PricingParameterDerivativeOnlyExistsValidator implements ValidatorWithArg<PricingParameterDerivative, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PricingParameterDerivative> ValidationResult<PricingParameterDerivative> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("parameterReference", ExistenceChecker.isSet((AssetOrTermPointOrPricingStructureReference) o.getParameterReference()))
				.put("inputDateReference", ExistenceChecker.isSet((List<? extends ValuationReference>) o.getInputDateReference()))
				.put("calculationProcedure", ExistenceChecker.isSet((DerivativeCalculationProcedure) o.getCalculationProcedure()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PricingParameterDerivative", ValidationType.ONLY_EXISTS, "PricingParameterDerivative", path, "");
		}
		return failure("PricingParameterDerivative", ValidationType.ONLY_EXISTS, "PricingParameterDerivative", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
