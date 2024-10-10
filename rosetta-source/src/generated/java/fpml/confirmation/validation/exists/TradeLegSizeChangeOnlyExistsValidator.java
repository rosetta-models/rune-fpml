package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeLegFixedAmountChangeModel;
import fpml.confirmation.TradeLegNotionalChangeModel;
import fpml.confirmation.TradeLegNotionalScheduleChangeModel;
import fpml.confirmation.TradeLegNumberOfOptionsChangeModel;
import fpml.confirmation.TradeLegNumberOfUnitsChangeModel;
import fpml.confirmation.TradeLegSizeChange;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeLegSizeChangeOnlyExistsValidator implements ValidatorWithArg<TradeLegSizeChange, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeLegSizeChange> ValidationResult<TradeLegSizeChange> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeLegNotionalChangeModel", ExistenceChecker.isSet((TradeLegNotionalChangeModel) o.getTradeLegNotionalChangeModel()))
				.put("tradeLegNumberOfOptionsChangeModel", ExistenceChecker.isSet((TradeLegNumberOfOptionsChangeModel) o.getTradeLegNumberOfOptionsChangeModel()))
				.put("tradeLegNumberOfUnitsChangeModel", ExistenceChecker.isSet((TradeLegNumberOfUnitsChangeModel) o.getTradeLegNumberOfUnitsChangeModel()))
				.put("tradeLegNotionalScheduleChangeModel", ExistenceChecker.isSet((TradeLegNotionalScheduleChangeModel) o.getTradeLegNotionalScheduleChangeModel()))
				.put("tradeLegFixedAmountChangeModel", ExistenceChecker.isSet((TradeLegFixedAmountChangeModel) o.getTradeLegFixedAmountChangeModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeLegSizeChange", ValidationType.ONLY_EXISTS, "TradeLegSizeChange", path, "");
		}
		return failure("TradeLegSizeChange", ValidationType.ONLY_EXISTS, "TradeLegSizeChange", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
