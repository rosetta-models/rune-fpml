package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Allocation;
import fpml.confirmation.AllocationContentModel;
import fpml.confirmation.Money;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.TradeIdentifier;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AllocationOnlyExistsValidator implements ValidatorWithArg<Allocation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Allocation> ValidationResult<Allocation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("allocationTradeId", ExistenceChecker.isSet((List<? extends TradeIdentifier>) o.getAllocationTradeId()))
				.put("partyAndAccountReferencesModel", ExistenceChecker.isSet((PartyAndAccountReferencesModel) o.getPartyAndAccountReferencesModel()))
				.put("allocatedFraction", ExistenceChecker.isSet((BigDecimal) o.getAllocatedFraction()))
				.put("allocatedNotional", ExistenceChecker.isSet((List<? extends Money>) o.getAllocatedNotional()))
				.put("allocationContentModel", ExistenceChecker.isSet((AllocationContentModel) o.getAllocationContentModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Allocation", ValidationType.ONLY_EXISTS, "Allocation", path, "");
		}
		return failure("Allocation", ValidationType.ONLY_EXISTS, "Allocation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
