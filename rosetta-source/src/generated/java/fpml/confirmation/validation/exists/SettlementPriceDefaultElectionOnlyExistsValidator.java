package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementPriceDefaultElection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SettlementPriceDefaultElectionOnlyExistsValidator implements ValidatorWithArg<SettlementPriceDefaultElection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SettlementPriceDefaultElection> ValidationResult<SettlementPriceDefaultElection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("value", ExistenceChecker.isSet((String) o.getValue()))
				.put("settlementPriceDefaultElectionScheme", ExistenceChecker.isSet((String) o.getSettlementPriceDefaultElectionScheme()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SettlementPriceDefaultElection", ValidationType.ONLY_EXISTS, "SettlementPriceDefaultElection", path, "");
		}
		return failure("SettlementPriceDefaultElection", ValidationType.ONLY_EXISTS, "SettlementPriceDefaultElection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
