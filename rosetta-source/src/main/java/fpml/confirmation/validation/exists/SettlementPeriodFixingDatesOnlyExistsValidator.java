package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementPeriodFixingDates;
import fpml.confirmation.SettlementPeriodFixingDatesSequence;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SettlementPeriodFixingDatesOnlyExistsValidator implements ValidatorWithArg<SettlementPeriodFixingDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SettlementPeriodFixingDates> ValidationResult<SettlementPeriodFixingDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixingDate", ExistenceChecker.isSet((List<Date>) o.getFixingDate()))
				.put("settlementPeriodFixingDatesSequence", ExistenceChecker.isSet((SettlementPeriodFixingDatesSequence) o.getSettlementPeriodFixingDatesSequence()))
				.put("numberOfFixings", ExistenceChecker.isSet((Integer) o.getNumberOfFixings()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SettlementPeriodFixingDates", ValidationType.ONLY_EXISTS, "SettlementPeriodFixingDates", path, "");
		}
		return failure("SettlementPeriodFixingDates", ValidationType.ONLY_EXISTS, "SettlementPeriodFixingDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
