package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasicQuotation;
import fpml.confirmation.InstrumentTradePricing;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InstrumentTradePricingOnlyExistsValidator implements ValidatorWithArg<InstrumentTradePricing, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InstrumentTradePricing> ValidationResult<InstrumentTradePricing> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("quote", ExistenceChecker.isSet((List<? extends BasicQuotation>) o.getQuote()))
				.put("couponStartDate", ExistenceChecker.isSet((Date) o.getCouponStartDate()))
				.put("exDividendDate", ExistenceChecker.isSet((Date) o.getExDividendDate()))
				.put("tradedFlatOfAccrued", ExistenceChecker.isSet((Boolean) o.getTradedFlatOfAccrued()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InstrumentTradePricing", ValidationType.ONLY_EXISTS, "InstrumentTradePricing", path, "");
		}
		return failure("InstrumentTradePricing", ValidationType.ONLY_EXISTS, "InstrumentTradePricing", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
