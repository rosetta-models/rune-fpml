package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.OverrideIdentifier;
import fpml.confirmation.SettlementDetails;
import fpml.confirmation.TradingInstructionOverride;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradingInstructionOverrideOnlyExistsValidator implements ValidatorWithArg<TradingInstructionOverride, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradingInstructionOverride> ValidationResult<TradingInstructionOverride> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("overrideIdentifier", ExistenceChecker.isSet((OverrideIdentifier) o.getOverrideIdentifier()))
				.put("allocationIdentifier", ExistenceChecker.isSet((LoanAllocationIdentifier) o.getAllocationIdentifier()))
				.put("loanTradeReference", ExistenceChecker.isSet((LoanTradeReference) o.getLoanTradeReference()))
				.put("settlementDetails", ExistenceChecker.isSet((List<? extends SettlementDetails>) o.getSettlementDetails()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradingInstructionOverride", ValidationType.ONLY_EXISTS, "TradingInstructionOverride", path, "");
		}
		return failure("TradingInstructionOverride", ValidationType.ONLY_EXISTS, "TradingInstructionOverride", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
