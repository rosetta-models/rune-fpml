package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditLimitUtilization;
import fpml.confirmation.Currency;
import fpml.confirmation.LimitApplicable;
import fpml.confirmation.LimitType;
import fpml.confirmation.Velocity;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LimitApplicableOnlyExistsValidator implements ValidatorWithArg<LimitApplicable, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LimitApplicable> ValidationResult<LimitApplicable> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("limitType", ExistenceChecker.isSet((LimitType) o.getLimitType()))
				.put("clipSize", ExistenceChecker.isSet((Integer) o.getClipSize()))
				.put("amountUtilized", ExistenceChecker.isSet((Integer) o.getAmountUtilized()))
				.put("utilization", ExistenceChecker.isSet((CreditLimitUtilization) o.getUtilization()))
				.put("amountRemaining", ExistenceChecker.isSet((Integer) o.getAmountRemaining()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("velocity", ExistenceChecker.isSet((Velocity) o.getVelocity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LimitApplicable", ValidationType.ONLY_EXISTS, "LimitApplicable", path, "");
		}
		return failure("LimitApplicable", ValidationType.ONLY_EXISTS, "LimitApplicable", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
