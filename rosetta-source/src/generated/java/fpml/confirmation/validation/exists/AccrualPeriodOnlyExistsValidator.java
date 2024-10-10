package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.AccrualReferenceAmountTypeEnum;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PeriodWithDaysModel;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AccrualPeriodOnlyExistsValidator implements ValidatorWithArg<AccrualPeriod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AccrualPeriod> ValidationResult<AccrualPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("periodWithDaysModel", ExistenceChecker.isSet((PeriodWithDaysModel) o.getPeriodWithDaysModel()))
				.put("referenceAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getReferenceAmount()))
				.put("referenceAmountType", ExistenceChecker.isSet((AccrualReferenceAmountTypeEnum) o.getReferenceAmountType()))
				.put("rate", ExistenceChecker.isSet((BigDecimal) o.getRate()))
				.put("accrualAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getAccrualAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AccrualPeriod", ValidationType.ONLY_EXISTS, "AccrualPeriod", path, "");
		}
		return failure("AccrualPeriod", ValidationType.ONLY_EXISTS, "AccrualPeriod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
