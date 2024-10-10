package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConditionEnum;
import fpml.confirmation.FxPayoffCap;
import fpml.confirmation.FxSettlementAdjustmentMethodEnum;
import fpml.confirmation.Schedule;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxPayoffCapOnlyExistsValidator implements ValidatorWithArg<FxPayoffCap, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxPayoffCap> ValidationResult<FxPayoffCap> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("condition", ExistenceChecker.isSet((ConditionEnum) o.getCondition()))
				.put("rate", ExistenceChecker.isSet((Schedule) o.getRate()))
				.put("settlementAdjustmentStyle", ExistenceChecker.isSet((FxSettlementAdjustmentMethodEnum) o.getSettlementAdjustmentStyle()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxPayoffCap", ValidationType.ONLY_EXISTS, "FxPayoffCap", path, "");
		}
		return failure("FxPayoffCap", ValidationType.ONLY_EXISTS, "FxPayoffCap", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
