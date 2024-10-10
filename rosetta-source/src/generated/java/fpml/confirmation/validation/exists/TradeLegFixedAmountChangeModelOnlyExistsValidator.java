package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AmountReference;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.TradeLegFixedAmountChangeModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeLegFixedAmountChangeModelOnlyExistsValidator implements ValidatorWithArg<TradeLegFixedAmountChangeModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeLegFixedAmountChangeModel> ValidationResult<TradeLegFixedAmountChangeModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("knownAmountReference", ExistenceChecker.isSet((AmountReference) o.getKnownAmountReference()))
				.put("changeInKnownAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getChangeInKnownAmount()))
				.put("outstandingKnownAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getOutstandingKnownAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeLegFixedAmountChangeModel", ValidationType.ONLY_EXISTS, "TradeLegFixedAmountChangeModel", path, "");
		}
		return failure("TradeLegFixedAmountChangeModel", ValidationType.ONLY_EXISTS, "TradeLegFixedAmountChangeModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
