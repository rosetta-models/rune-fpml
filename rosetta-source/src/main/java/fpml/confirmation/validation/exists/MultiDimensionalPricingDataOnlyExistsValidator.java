package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MultiDimensionalPricingData;
import fpml.confirmation.PricingStructurePoint;
import fpml.confirmation.QuotationCharacteristicsModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MultiDimensionalPricingDataOnlyExistsValidator implements ValidatorWithArg<MultiDimensionalPricingData, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MultiDimensionalPricingData> ValidationResult<MultiDimensionalPricingData> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("quotationCharacteristicsModel", ExistenceChecker.isSet((QuotationCharacteristicsModel) o.getQuotationCharacteristicsModel()))
				.put("point", ExistenceChecker.isSet((List<? extends PricingStructurePoint>) o.getPoint()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MultiDimensionalPricingData", ValidationType.ONLY_EXISTS, "MultiDimensionalPricingData", path, "");
		}
		return failure("MultiDimensionalPricingData", ValidationType.ONLY_EXISTS, "MultiDimensionalPricingData", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
