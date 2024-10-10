package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPerformanceSwapEarlyTermination;
import fpml.confirmation.CommodityStartingDate;
import fpml.confirmation.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityPerformanceSwapEarlyTerminationOnlyExistsValidator implements ValidatorWithArg<CommodityPerformanceSwapEarlyTermination, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityPerformanceSwapEarlyTermination> ValidationResult<CommodityPerformanceSwapEarlyTermination> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("startingDate", ExistenceChecker.isSet((CommodityStartingDate) o.getStartingDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityPerformanceSwapEarlyTermination", ValidationType.ONLY_EXISTS, "CommodityPerformanceSwapEarlyTermination", path, "");
		}
		return failure("CommodityPerformanceSwapEarlyTermination", ValidationType.ONLY_EXISTS, "CommodityPerformanceSwapEarlyTermination", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
