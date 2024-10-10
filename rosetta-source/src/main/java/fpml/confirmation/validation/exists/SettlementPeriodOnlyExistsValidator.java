package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementPeriod;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SettlementPeriodOnlyExistsValidator implements ValidatorWithArg<SettlementPeriod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SettlementPeriod> ValidationResult<SettlementPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expiryDate", ExistenceChecker.isSet((Date) o.getExpiryDate()))
				.put("settlementDate", ExistenceChecker.isSet((Date) o.getSettlementDate()))
				.put("notionalAmount", ExistenceChecker.isSet((BigDecimal) o.getNotionalAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SettlementPeriod", ValidationType.ONLY_EXISTS, "SettlementPeriod", path, "");
		}
		return failure("SettlementPeriod", ValidationType.ONLY_EXISTS, "SettlementPeriod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
