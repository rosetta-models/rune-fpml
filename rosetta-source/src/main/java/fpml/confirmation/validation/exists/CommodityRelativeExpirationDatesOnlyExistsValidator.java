package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.CommodityExpireRelativeToEvent;
import fpml.confirmation.CommodityRelativeExpirationDates;
import fpml.confirmation.DateOffset;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityRelativeExpirationDatesOnlyExistsValidator implements ValidatorWithArg<CommodityRelativeExpirationDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityRelativeExpirationDates> ValidationResult<CommodityRelativeExpirationDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expireRelativeToEvent", ExistenceChecker.isSet((CommodityExpireRelativeToEvent) o.getExpireRelativeToEvent()))
				.put("expirationDateOffset", ExistenceChecker.isSet((DateOffset) o.getExpirationDateOffset()))
				.put("businessCentersOrReferenceModel", ExistenceChecker.isSet((BusinessCentersOrReferenceModel) o.getBusinessCentersOrReferenceModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityRelativeExpirationDates", ValidationType.ONLY_EXISTS, "CommodityRelativeExpirationDates", path, "");
		}
		return failure("CommodityRelativeExpirationDates", ValidationType.ONLY_EXISTS, "CommodityRelativeExpirationDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
