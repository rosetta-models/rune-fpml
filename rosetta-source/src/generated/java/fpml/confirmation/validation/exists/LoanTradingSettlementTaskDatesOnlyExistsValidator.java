package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingSettlementTaskDates;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingSettlementTaskDatesOnlyExistsValidator implements ValidatorWithArg<LoanTradingSettlementTaskDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingSettlementTaskDates> ValidationResult<LoanTradingSettlementTaskDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("raisedDate", ExistenceChecker.isSet((Date) o.getRaisedDate()))
				.put("expectedDate", ExistenceChecker.isSet((Date) o.getExpectedDate()))
				.put("clearedDate", ExistenceChecker.isSet((Date) o.getClearedDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingSettlementTaskDates", ValidationType.ONLY_EXISTS, "LoanTradingSettlementTaskDates", path, "");
		}
		return failure("LoanTradingSettlementTaskDates", ValidationType.ONLY_EXISTS, "LoanTradingSettlementTaskDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
