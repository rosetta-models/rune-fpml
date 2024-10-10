package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FeeLeg;
import fpml.confirmation.FeeLegChoice;
import fpml.confirmation.PeriodicPayment;
import fpml.confirmation.QuotationStyleEnum;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FeeLegOnlyExistsValidator implements ValidatorWithArg<FeeLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FeeLeg> ValidationResult<FeeLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("feeLegChoice", ExistenceChecker.isSet((FeeLegChoice) o.getFeeLegChoice()))
				.put("periodicPayment", ExistenceChecker.isSet((PeriodicPayment) o.getPeriodicPayment()))
				.put("marketFixedRate", ExistenceChecker.isSet((BigDecimal) o.getMarketFixedRate()))
				.put("paymentDelay", ExistenceChecker.isSet((Boolean) o.getPaymentDelay()))
				.put("initialPoints", ExistenceChecker.isSet((BigDecimal) o.getInitialPoints()))
				.put("marketPrice", ExistenceChecker.isSet((BigDecimal) o.getMarketPrice()))
				.put("quotationStyle", ExistenceChecker.isSet((QuotationStyleEnum) o.getQuotationStyle()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FeeLeg", ValidationType.ONLY_EXISTS, "FeeLeg", path, "");
		}
		return failure("FeeLeg", ValidationType.ONLY_EXISTS, "FeeLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
