package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InitialMargin;
import fpml.confirmation.InitialMarginCalculation;
import fpml.confirmation.MarginTypeEnum;
import fpml.confirmation.NonNegativeMoney;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InitialMarginOnlyExistsValidator implements ValidatorWithArg<InitialMargin, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InitialMargin> ValidationResult<InitialMargin> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("marginType", ExistenceChecker.isSet((MarginTypeEnum) o.getMarginType()))
				.put("margin", ExistenceChecker.isSet((List<? extends InitialMarginCalculation>) o.getMargin()))
				.put("marginThreshold", ExistenceChecker.isSet((NonNegativeMoney) o.getMarginThreshold()))
				.put("minimumTransferAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getMinimumTransferAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InitialMargin", ValidationType.ONLY_EXISTS, "InitialMargin", path, "");
		}
		return failure("InitialMargin", ValidationType.ONLY_EXISTS, "InitialMargin", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
