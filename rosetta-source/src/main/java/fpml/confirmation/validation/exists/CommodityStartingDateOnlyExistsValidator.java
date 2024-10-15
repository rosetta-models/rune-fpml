package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.CommodityStartingDate;
import fpml.confirmation.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityStartingDateOnlyExistsValidator implements ValidatorWithArg<CommodityStartingDate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityStartingDate> ValidationResult<CommodityStartingDate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dateRelativeTo", ExistenceChecker.isSet((PartyReference) o.getDateRelativeTo()))
				.put("adjustableDate", ExistenceChecker.isSet((AdjustableDate) o.getAdjustableDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityStartingDate", ValidationType.ONLY_EXISTS, "CommodityStartingDate", path, "");
		}
		return failure("CommodityStartingDate", ValidationType.ONLY_EXISTS, "CommodityStartingDate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
