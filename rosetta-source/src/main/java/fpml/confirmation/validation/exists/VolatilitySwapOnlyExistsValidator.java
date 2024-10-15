package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClassifiablePayment;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.ProductModel;
import fpml.confirmation.VolatilityLeg;
import fpml.confirmation.VolatilitySwap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class VolatilitySwapOnlyExistsValidator implements ValidatorWithArg<VolatilitySwap, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends VolatilitySwap> ValidationResult<VolatilitySwap> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends ClassifiablePayment>) o.getAdditionalPayment()))
				.put("extraordinaryEvents", ExistenceChecker.isSet((ExtraordinaryEvents) o.getExtraordinaryEvents()))
				.put("volatilityLeg", ExistenceChecker.isSet((List<? extends VolatilityLeg>) o.getVolatilityLeg()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("VolatilitySwap", ValidationType.ONLY_EXISTS, "VolatilitySwap", path, "");
		}
		return failure("VolatilitySwap", ValidationType.ONLY_EXISTS, "VolatilitySwap", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
