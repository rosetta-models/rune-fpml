package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CurrencyAndDeterminationMethodModel;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.IdentifiedCurrencyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CurrencyAndDeterminationMethodModelOnlyExistsValidator implements ValidatorWithArg<CurrencyAndDeterminationMethodModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CurrencyAndDeterminationMethodModel> ValidationResult<CurrencyAndDeterminationMethodModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("currency", ExistenceChecker.isSet((IdentifiedCurrency) o.getCurrency()))
				.put("determinationMethod", ExistenceChecker.isSet((DeterminationMethod) o.getDeterminationMethod()))
				.put("currencyReference", ExistenceChecker.isSet((IdentifiedCurrencyReference) o.getCurrencyReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CurrencyAndDeterminationMethodModel", ValidationType.ONLY_EXISTS, "CurrencyAndDeterminationMethodModel", path, "");
		}
		return failure("CurrencyAndDeterminationMethodModel", ValidationType.ONLY_EXISTS, "CurrencyAndDeterminationMethodModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
