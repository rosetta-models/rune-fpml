package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.Currency;
import fpml.confirmation.DualCurrencyFeature;
import fpml.confirmation.DualCurrencyStrikePrice;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DualCurrencyFeatureOnlyExistsValidator implements ValidatorWithArg<DualCurrencyFeature, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DualCurrencyFeature> ValidationResult<DualCurrencyFeature> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("fixingDate", ExistenceChecker.isSet((Date) o.getFixingDate()))
				.put("fixingTime", ExistenceChecker.isSet((BusinessCenterTime) o.getFixingTime()))
				.put("strike", ExistenceChecker.isSet((DualCurrencyStrikePrice) o.getStrike()))
				.put("spotRate", ExistenceChecker.isSet((BigDecimal) o.getSpotRate()))
				.put("interestAtRisk", ExistenceChecker.isSet((Boolean) o.getInterestAtRisk()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DualCurrencyFeature", ValidationType.ONLY_EXISTS, "DualCurrencyFeature", path, "");
		}
		return failure("DualCurrencyFeature", ValidationType.ONLY_EXISTS, "DualCurrencyFeature", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
