package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetReference;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.DividendPeriod;
import fpml.confirmation.IdentifiedDate;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DividendPeriodOnlyExistsValidator implements ValidatorWithArg<DividendPeriod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DividendPeriod> ValidationResult<DividendPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("unadjustedStartDate", ExistenceChecker.isSet((IdentifiedDate) o.getUnadjustedStartDate()))
				.put("unadjustedEndDate", ExistenceChecker.isSet((IdentifiedDate) o.getUnadjustedEndDate()))
				.put("dateAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getDateAdjustments()))
				.put("underlyerReference", ExistenceChecker.isSet((AssetReference) o.getUnderlyerReference()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DividendPeriod", ValidationType.ONLY_EXISTS, "DividendPeriod", path, "");
		}
		return failure("DividendPeriod", ValidationType.ONLY_EXISTS, "DividendPeriod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
