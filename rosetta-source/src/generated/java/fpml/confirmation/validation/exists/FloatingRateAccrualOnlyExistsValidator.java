package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateAccrual;
import fpml.confirmation.FloatingRateAccrualSequence;
import fpml.confirmation.FloatingRateIndexLoanModel;
import fpml.confirmation.PaymentProjection;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodWithDaysModel;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FloatingRateAccrualOnlyExistsValidator implements ValidatorWithArg<FloatingRateAccrual, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingRateAccrual> ValidationResult<FloatingRateAccrual> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("accrualOptionId", ExistenceChecker.isSet((AccrualTypeId) o.getAccrualOptionId()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("paymentFrequency", ExistenceChecker.isSet((Period) o.getPaymentFrequency()))
				.put("floatingRateIndexLoanModel", ExistenceChecker.isSet((FloatingRateIndexLoanModel) o.getFloatingRateIndexLoanModel()))
				.put("spread", ExistenceChecker.isSet((BigDecimal) o.getSpread()))
				.put("pikSpread", ExistenceChecker.isSet((BigDecimal) o.getPikSpread()))
				.put("periodWithDaysModel", ExistenceChecker.isSet((PeriodWithDaysModel) o.getPeriodWithDaysModel()))
				.put("floatingRateAccrualSequence", ExistenceChecker.isSet((FloatingRateAccrualSequence) o.getFloatingRateAccrualSequence()))
				.put("paymentProjection", ExistenceChecker.isSet((PaymentProjection) o.getPaymentProjection()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRateAccrual", ValidationType.ONLY_EXISTS, "FloatingRateAccrual", path, "");
		}
		return failure("FloatingRateAccrual", ValidationType.ONLY_EXISTS, "FloatingRateAccrual", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
