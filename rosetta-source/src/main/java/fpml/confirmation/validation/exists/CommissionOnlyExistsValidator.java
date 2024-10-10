package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Commission;
import fpml.confirmation.CommissionDenominationEnum;
import fpml.confirmation.Currency;
import fpml.confirmation.FxRate;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommissionOnlyExistsValidator implements ValidatorWithArg<Commission, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Commission> ValidationResult<Commission> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commissionDenomination", ExistenceChecker.isSet((CommissionDenominationEnum) o.getCommissionDenomination()))
				.put("commissionAmount", ExistenceChecker.isSet((BigDecimal) o.getCommissionAmount()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("commissionPerTrade", ExistenceChecker.isSet((BigDecimal) o.getCommissionPerTrade()))
				.put("fxRate", ExistenceChecker.isSet((List<? extends FxRate>) o.getFxRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Commission", ValidationType.ONLY_EXISTS, "Commission", path, "");
		}
		return failure("Commission", ValidationType.ONLY_EXISTS, "Commission", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
