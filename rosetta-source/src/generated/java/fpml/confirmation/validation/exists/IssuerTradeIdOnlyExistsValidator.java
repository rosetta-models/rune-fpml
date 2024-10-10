package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IssuerTradeId;
import fpml.confirmation.IssuerTradeIdModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class IssuerTradeIdOnlyExistsValidator implements ValidatorWithArg<IssuerTradeId, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends IssuerTradeId> ValidationResult<IssuerTradeId> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("issuerTradeIdModel", ExistenceChecker.isSet((IssuerTradeIdModel) o.getIssuerTradeIdModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("IssuerTradeId", ValidationType.ONLY_EXISTS, "IssuerTradeId", path, "");
		}
		return failure("IssuerTradeId", ValidationType.ONLY_EXISTS, "IssuerTradeId", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
