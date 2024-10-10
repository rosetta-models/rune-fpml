package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.AccruingFeeOption;
import fpml.confirmation.AccruingFeeType;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodOptionalEndModel;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AccruingFeeOptionOnlyExistsValidator implements ValidatorWithArg<AccruingFeeOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AccruingFeeOption> ValidationResult<AccruingFeeOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("accrualOptionId", ExistenceChecker.isSet((AccrualTypeId) o.getAccrualOptionId()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("paymentFrequency", ExistenceChecker.isSet((Period) o.getPaymentFrequency()))
				.put("rate", ExistenceChecker.isSet((BigDecimal) o.getRate()))
				.put("type", ExistenceChecker.isSet((AccruingFeeType) o.getType_()))
				.put("periodOptionalEndModel", ExistenceChecker.isSet((PeriodOptionalEndModel) o.getPeriodOptionalEndModel()))
				.put("calculationDefinition", ExistenceChecker.isSet((String) o.getCalculationDefinition()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AccruingFeeOption", ValidationType.ONLY_EXISTS, "AccruingFeeOption", path, "");
		}
		return failure("AccruingFeeOption", ValidationType.ONLY_EXISTS, "AccruingFeeOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
