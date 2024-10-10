package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustedPaymentDates;
import fpml.confirmation.FixedAmountCalculation;
import fpml.confirmation.FloatingAmountCalculation;
import fpml.confirmation.Money;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodicPayment;
import fpml.confirmation.RollConventionEnum;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PeriodicPaymentOnlyExistsValidator implements ValidatorWithArg<PeriodicPayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PeriodicPayment> ValidationResult<PeriodicPayment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("paymentFrequency", ExistenceChecker.isSet((Period) o.getPaymentFrequency()))
				.put("firstPeriodStartDate", ExistenceChecker.isSet((Date) o.getFirstPeriodStartDate()))
				.put("firstPaymentDate", ExistenceChecker.isSet((Date) o.getFirstPaymentDate()))
				.put("lastRegularPaymentDate", ExistenceChecker.isSet((Date) o.getLastRegularPaymentDate()))
				.put("rollConvention", ExistenceChecker.isSet((RollConventionEnum) o.getRollConvention()))
				.put("fixedAmount", ExistenceChecker.isSet((Money) o.getFixedAmount()))
				.put("fixedAmountCalculation", ExistenceChecker.isSet((FixedAmountCalculation) o.getFixedAmountCalculation()))
				.put("floatingAmountCalculation", ExistenceChecker.isSet((FloatingAmountCalculation) o.getFloatingAmountCalculation()))
				.put("adjustedPaymentDates", ExistenceChecker.isSet((List<? extends AdjustedPaymentDates>) o.getAdjustedPaymentDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PeriodicPayment", ValidationType.ONLY_EXISTS, "PeriodicPayment", path, "");
		}
		return failure("PeriodicPayment", ValidationType.ONLY_EXISTS, "PeriodicPayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
