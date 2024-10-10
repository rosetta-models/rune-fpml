package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.FxExpiryDate;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxExpiryDateOnlyExistsValidator implements ValidatorWithArg<FxExpiryDate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxExpiryDate> ValidationResult<FxExpiryDate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dateAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getDateAdjustments()))
				.put("adjustedDate", ExistenceChecker.isSet((Date) o.getAdjustedDate()))
				.put("expiryTime", ExistenceChecker.isSet((BusinessCenterTime) o.getExpiryTime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxExpiryDate", ValidationType.ONLY_EXISTS, "FxExpiryDate", path, "");
		}
		return failure("FxExpiryDate", ValidationType.ONLY_EXISTS, "FxExpiryDate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
