package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccountReference;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PayerModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PayerModelOnlyExistsValidator implements ValidatorWithArg<PayerModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PayerModel> ValidationResult<PayerModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PayerModel", ValidationType.ONLY_EXISTS, "PayerModel", path, "");
		}
		return failure("PayerModel", ValidationType.ONLY_EXISTS, "PayerModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
