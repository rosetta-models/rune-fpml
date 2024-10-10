package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AnyAssetReference;
import fpml.confirmation.MultiDimensionalPricingData;
import fpml.confirmation.ParametricAdjustment;
import fpml.confirmation.PricingInputDatesModel;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.VolatilityMatrix;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class VolatilityMatrixOnlyExistsValidator implements ValidatorWithArg<VolatilityMatrix, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends VolatilityMatrix> ValidationResult<VolatilityMatrix> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("objectReference", ExistenceChecker.isSet((AnyAssetReference) o.getObjectReference()))
				.put("valuationScenarioReference", ExistenceChecker.isSet((ValuationScenarioReference) o.getValuationScenarioReference()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("definitionRef", ExistenceChecker.isSet((String) o.getDefinitionRef()))
				.put("pricingInputDatesModel", ExistenceChecker.isSet((PricingInputDatesModel) o.getPricingInputDatesModel()))
				.put("dataPoints", ExistenceChecker.isSet((MultiDimensionalPricingData) o.getDataPoints()))
				.put("adjustment", ExistenceChecker.isSet((List<? extends ParametricAdjustment>) o.getAdjustment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("VolatilityMatrix", ValidationType.ONLY_EXISTS, "VolatilityMatrix", path, "");
		}
		return failure("VolatilityMatrix", ValidationType.ONLY_EXISTS, "VolatilityMatrix", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
