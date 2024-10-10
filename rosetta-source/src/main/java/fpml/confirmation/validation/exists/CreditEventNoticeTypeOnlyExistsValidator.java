package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCenter;
import fpml.confirmation.CreditEventNoticeType;
import fpml.confirmation.NotifyingParty;
import fpml.confirmation.PubliclyAvailableInformation;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditEventNoticeTypeOnlyExistsValidator implements ValidatorWithArg<CreditEventNoticeType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditEventNoticeType> ValidationResult<CreditEventNoticeType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notifyingParty", ExistenceChecker.isSet((NotifyingParty) o.getNotifyingParty()))
				.put("businessCenter", ExistenceChecker.isSet((BusinessCenter) o.getBusinessCenter()))
				.put("publiclyAvailableInformation", ExistenceChecker.isSet((PubliclyAvailableInformation) o.getPubliclyAvailableInformation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditEventNoticeType", ValidationType.ONLY_EXISTS, "CreditEventNoticeType", path, "");
		}
		return failure("CreditEventNoticeType", ValidationType.ONLY_EXISTS, "CreditEventNoticeType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
