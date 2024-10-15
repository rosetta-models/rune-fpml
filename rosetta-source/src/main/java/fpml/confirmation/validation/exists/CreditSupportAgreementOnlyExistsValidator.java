package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditSupportAgreement;
import fpml.confirmation.CreditSupportAgreementIdentifier;
import fpml.confirmation.CreditSupportAgreementType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditSupportAgreementOnlyExistsValidator implements ValidatorWithArg<CreditSupportAgreement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditSupportAgreement> ValidationResult<CreditSupportAgreement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("_type", ExistenceChecker.isSet((CreditSupportAgreementType) o.get_type()))
				.put("date", ExistenceChecker.isSet((Date) o.getDate()))
				.put("identifier", ExistenceChecker.isSet((CreditSupportAgreementIdentifier) o.getIdentifier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditSupportAgreement", ValidationType.ONLY_EXISTS, "CreditSupportAgreement", path, "");
		}
		return failure("CreditSupportAgreement", ValidationType.ONLY_EXISTS, "CreditSupportAgreement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
