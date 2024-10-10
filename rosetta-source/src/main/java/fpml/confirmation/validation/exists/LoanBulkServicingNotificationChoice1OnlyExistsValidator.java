package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.LoanBulkServicingNotificationChoice1;
import fpml.confirmation.LoanBulkServicingNotificationChoiceChoice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanBulkServicingNotificationChoice1OnlyExistsValidator implements ValidatorWithArg<LoanBulkServicingNotificationChoice1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanBulkServicingNotificationChoice1> ValidationResult<LoanBulkServicingNotificationChoice1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("facilityDetailsModel", ExistenceChecker.isSet((FacilityDetailsModel) o.getFacilityDetailsModel()))
				.put("loanBulkServicingNotificationChoiceChoice", ExistenceChecker.isSet((LoanBulkServicingNotificationChoiceChoice) o.getLoanBulkServicingNotificationChoiceChoice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanBulkServicingNotificationChoice1", ValidationType.ONLY_EXISTS, "LoanBulkServicingNotificationChoice1", path, "");
		}
		return failure("LoanBulkServicingNotificationChoice1", ValidationType.ONLY_EXISTS, "LoanBulkServicingNotificationChoice1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
