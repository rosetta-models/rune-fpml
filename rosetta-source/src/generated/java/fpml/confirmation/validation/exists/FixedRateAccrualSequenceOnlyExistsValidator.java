package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedRateAccrualSequence;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FixedRateAccrualSequenceOnlyExistsValidator implements ValidatorWithArg<FixedRateAccrualSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FixedRateAccrualSequence> ValidationResult<FixedRateAccrualSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("penaltySpread", ExistenceChecker.isSet((BigDecimal) o.getPenaltySpread()))
				.put("defaultSpread", ExistenceChecker.isSet((BigDecimal) o.getDefaultSpread()))
				.put("mandatoryCostRate", ExistenceChecker.isSet((BigDecimal) o.getMandatoryCostRate()))
				.put("allInRate", ExistenceChecker.isSet((BigDecimal) o.getAllInRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FixedRateAccrualSequence", ValidationType.ONLY_EXISTS, "FixedRateAccrualSequence", path, "");
		}
		return failure("FixedRateAccrualSequence", ValidationType.ONLY_EXISTS, "FixedRateAccrualSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
