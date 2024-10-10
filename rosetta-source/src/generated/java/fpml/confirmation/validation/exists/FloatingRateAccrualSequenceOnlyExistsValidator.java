package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FloatingRateAccrualSequence;
import fpml.confirmation.FloatingRateAccrualSequenceSequence;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FloatingRateAccrualSequenceOnlyExistsValidator implements ValidatorWithArg<FloatingRateAccrualSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingRateAccrualSequence> ValidationResult<FloatingRateAccrualSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rateFixingDate", ExistenceChecker.isSet((Date) o.getRateFixingDate()))
				.put("baseRate", ExistenceChecker.isSet((BigDecimal) o.getBaseRate()))
				.put("floatingRateAccrualSequenceSequence", ExistenceChecker.isSet((FloatingRateAccrualSequenceSequence) o.getFloatingRateAccrualSequenceSequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRateAccrualSequence", ValidationType.ONLY_EXISTS, "FloatingRateAccrualSequence", path, "");
		}
		return failure("FloatingRateAccrualSequence", ValidationType.ONLY_EXISTS, "FloatingRateAccrualSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
