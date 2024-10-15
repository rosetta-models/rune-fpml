package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxKnockoutLevel;
import fpml.confirmation.FxSettlementAdjustmentMethodEnum;
import fpml.confirmation.FxTargetStyleEnum;
import fpml.confirmation.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxKnockoutLevelOnlyExistsValidator implements ValidatorWithArg<FxKnockoutLevel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxKnockoutLevel> ValidationResult<FxKnockoutLevel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amount", ExistenceChecker.isSet((NonNegativeMoney) o.getAmount()))
				.put("intrinsicValue", ExistenceChecker.isSet((BigDecimal) o.getIntrinsicValue()))
				.put("targetStyle", ExistenceChecker.isSet((FxTargetStyleEnum) o.getTargetStyle()))
				.put("settlementAdjustmentStyle", ExistenceChecker.isSet((FxSettlementAdjustmentMethodEnum) o.getSettlementAdjustmentStyle()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxKnockoutLevel", ValidationType.ONLY_EXISTS, "FxKnockoutLevel", path, "");
		}
		return failure("FxKnockoutLevel", ValidationType.ONLY_EXISTS, "FxKnockoutLevel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
