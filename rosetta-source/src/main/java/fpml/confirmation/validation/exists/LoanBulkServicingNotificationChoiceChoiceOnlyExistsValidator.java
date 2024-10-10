package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LetterOfCreditDetailsModel;
import fpml.confirmation.LoanBulkServicingNotificationChoiceChoice;
import fpml.confirmation.LoanContractDetailsModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanBulkServicingNotificationChoiceChoiceOnlyExistsValidator implements ValidatorWithArg<LoanBulkServicingNotificationChoiceChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanBulkServicingNotificationChoiceChoice> ValidationResult<LoanBulkServicingNotificationChoiceChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("letterOfCreditDetailsModel", ExistenceChecker.isSet((LetterOfCreditDetailsModel) o.getLetterOfCreditDetailsModel()))
				.put("loanContractDetailsModel", ExistenceChecker.isSet((LoanContractDetailsModel) o.getLoanContractDetailsModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanBulkServicingNotificationChoiceChoice", ValidationType.ONLY_EXISTS, "LoanBulkServicingNotificationChoiceChoice", path, "");
		}
		return failure("LoanBulkServicingNotificationChoiceChoice", ValidationType.ONLY_EXISTS, "LoanBulkServicingNotificationChoiceChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
