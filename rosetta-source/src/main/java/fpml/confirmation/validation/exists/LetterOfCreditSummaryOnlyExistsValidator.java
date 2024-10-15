package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.LcType;
import fpml.confirmation.LetterOfCreditRolesModel;
import fpml.confirmation.LetterOfCreditSummary;
import fpml.confirmation.MoneyWithParticipantShare;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LetterOfCreditSummaryOnlyExistsValidator implements ValidatorWithArg<LetterOfCreditSummary, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LetterOfCreditSummary> ValidationResult<LetterOfCreditSummary> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet((List<? extends FacilityContractIdentifier>) o.getIdentifier()))
				.put("_type", ExistenceChecker.isSet((LcType) o.get_type()))
				.put("effectiveDate", ExistenceChecker.isSet((Date) o.getEffectiveDate()))
				.put("letterOfCreditRolesModel", ExistenceChecker.isSet((LetterOfCreditRolesModel) o.getLetterOfCreditRolesModel()))
				.put("amount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LetterOfCreditSummary", ValidationType.ONLY_EXISTS, "LetterOfCreditSummary", path, "");
		}
		return failure("LetterOfCreditSummary", ValidationType.ONLY_EXISTS, "LetterOfCreditSummary", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
