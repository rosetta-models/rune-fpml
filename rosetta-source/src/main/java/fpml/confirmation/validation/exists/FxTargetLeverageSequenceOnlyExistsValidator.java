package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxCounterCurrencyAmount;
import fpml.confirmation.FxTargetLeverageSequence;
import fpml.confirmation.NonNegativeAmountSchedule;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetLeverageSequenceOnlyExistsValidator implements ValidatorWithArg<FxTargetLeverageSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTargetLeverageSequence> ValidationResult<FxTargetLeverageSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalAmount", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getNotionalAmount()))
				.put("counterCurrencyAmount", ExistenceChecker.isSet((List<? extends FxCounterCurrencyAmount>) o.getCounterCurrencyAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTargetLeverageSequence", ValidationType.ONLY_EXISTS, "FxTargetLeverageSequence", path, "");
		}
		return failure("FxTargetLeverageSequence", ValidationType.ONLY_EXISTS, "FxTargetLeverageSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
