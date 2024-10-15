package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.Currency;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FixedRateOption;
import fpml.confirmation.PartyReference;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.RateLimits;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FixedRateOptionOnlyExistsValidator implements ValidatorWithArg<FixedRateOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FixedRateOption> ValidationResult<FixedRateOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("accrualOptionId", ExistenceChecker.isSet((AccrualTypeId) o.getAccrualOptionId()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("paymentFrequency", ExistenceChecker.isSet((Period) o.getPaymentFrequency()))
				.put("rate", ExistenceChecker.isSet((BigDecimal) o.getRate()))
				.put("pikSpread", ExistenceChecker.isSet((BigDecimal) o.getPikSpread()))
				.put("periodModel", ExistenceChecker.isSet((PeriodModel) o.getPeriodModel()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("allInRateLimits", ExistenceChecker.isSet((RateLimits) o.getAllInRateLimits()))
				.put("borrowerPartyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getBorrowerPartyReference()))
				.put("drawdownNoticeDays", ExistenceChecker.isSet((Integer) o.getDrawdownNoticeDays()))
				.put("fxRateSetNoticeDays", ExistenceChecker.isSet((Integer) o.getFxRateSetNoticeDays()))
				.put("rateSetNoticeDays", ExistenceChecker.isSet((Integer) o.getRateSetNoticeDays()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FixedRateOption", ValidationType.ONLY_EXISTS, "FixedRateOption", path, "");
		}
		return failure("FixedRateOption", ValidationType.ONLY_EXISTS, "FixedRateOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
