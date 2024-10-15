package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Currency;
import fpml.confirmation.OptionDenominationModel;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionDenominationModelOnlyExistsValidator implements ValidatorWithArg<OptionDenominationModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionDenominationModel> ValidationResult<OptionDenominationModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("optionEntitlement", ExistenceChecker.isSet((BigDecimal) o.getOptionEntitlement()))
				.put("entitlementCurrency", ExistenceChecker.isSet((Currency) o.getEntitlementCurrency()))
				.put("numberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getNumberOfOptions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionDenominationModel", ValidationType.ONLY_EXISTS, "OptionDenominationModel", path, "");
		}
		return failure("OptionDenominationModel", ValidationType.ONLY_EXISTS, "OptionDenominationModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
