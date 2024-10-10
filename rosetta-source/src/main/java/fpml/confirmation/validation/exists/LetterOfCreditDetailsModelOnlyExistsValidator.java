package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.LetterOfCredit;
import fpml.confirmation.LetterOfCreditDetailsModel;
import fpml.confirmation.LetterOfCreditSummary;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LetterOfCreditDetailsModelOnlyExistsValidator implements ValidatorWithArg<LetterOfCreditDetailsModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LetterOfCreditDetailsModel> ValidationResult<LetterOfCreditDetailsModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("letterOfCreditIdentifier", ExistenceChecker.isSet((FacilityContractIdentifier) o.getLetterOfCreditIdentifier()))
				.put("letterOfCreditSummary", ExistenceChecker.isSet((LetterOfCreditSummary) o.getLetterOfCreditSummary()))
				.put("letterOfCredit", ExistenceChecker.isSet((LetterOfCredit) o.getLetterOfCredit()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LetterOfCreditDetailsModel", ValidationType.ONLY_EXISTS, "LetterOfCreditDetailsModel", path, "");
		}
		return failure("LetterOfCreditDetailsModel", ValidationType.ONLY_EXISTS, "LetterOfCreditDetailsModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
