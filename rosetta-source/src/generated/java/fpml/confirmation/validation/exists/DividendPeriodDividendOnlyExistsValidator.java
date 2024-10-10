package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetReference;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.DividendPeriodDividend;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DividendPeriodDividendOnlyExistsValidator implements ValidatorWithArg<DividendPeriodDividend, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DividendPeriodDividend> ValidationResult<DividendPeriodDividend> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("unadjustedStartDate", ExistenceChecker.isSet((IdentifiedDate) o.getUnadjustedStartDate()))
				.put("unadjustedEndDate", ExistenceChecker.isSet((IdentifiedDate) o.getUnadjustedEndDate()))
				.put("dateAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getDateAdjustments()))
				.put("underlyerReference", ExistenceChecker.isSet((AssetReference) o.getUnderlyerReference()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("dividend", ExistenceChecker.isSet((NonNegativeMoney) o.getDividend()))
				.put("multiplier", ExistenceChecker.isSet((BigDecimal) o.getMultiplier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DividendPeriodDividend", ValidationType.ONLY_EXISTS, "DividendPeriodDividend", path, "");
		}
		return failure("DividendPeriodDividend", ValidationType.ONLY_EXISTS, "DividendPeriodDividend", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
