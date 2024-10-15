package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Currency;
import fpml.confirmation.FxOptionPayout;
import fpml.confirmation.PayoutEnum;
import fpml.confirmation.SettlementInformation;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxOptionPayoutOnlyExistsValidator implements ValidatorWithArg<FxOptionPayout, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxOptionPayout> ValidationResult<FxOptionPayout> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("amount", ExistenceChecker.isSet((BigDecimal) o.getAmount()))
				.put("payoutStyle", ExistenceChecker.isSet((PayoutEnum) o.getPayoutStyle()))
				.put("settlementInformation", ExistenceChecker.isSet((SettlementInformation) o.getSettlementInformation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxOptionPayout", ValidationType.ONLY_EXISTS, "FxOptionPayout", path, "");
		}
		return failure("FxOptionPayout", ValidationType.ONLY_EXISTS, "FxOptionPayout", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
