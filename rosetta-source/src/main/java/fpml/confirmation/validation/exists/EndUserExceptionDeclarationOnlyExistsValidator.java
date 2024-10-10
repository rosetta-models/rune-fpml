package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditDocument;
import fpml.confirmation.EndUserExceptionDeclaration;
import fpml.confirmation.OrganizationCharacteristic;
import fpml.confirmation.SupervisorRegistration;
import fpml.confirmation.TransactionCharacteristic;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EndUserExceptionDeclarationOnlyExistsValidator implements ValidatorWithArg<EndUserExceptionDeclaration, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EndUserExceptionDeclaration> ValidationResult<EndUserExceptionDeclaration> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("creditDocument", ExistenceChecker.isSet((List<? extends CreditDocument>) o.getCreditDocument()))
				.put("organizationCharacteristic", ExistenceChecker.isSet((List<? extends OrganizationCharacteristic>) o.getOrganizationCharacteristic()))
				.put("transactionCharacteristic", ExistenceChecker.isSet((List<? extends TransactionCharacteristic>) o.getTransactionCharacteristic()))
				.put("supervisorRegistration", ExistenceChecker.isSet((List<? extends SupervisorRegistration>) o.getSupervisorRegistration()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EndUserExceptionDeclaration", ValidationType.ONLY_EXISTS, "EndUserExceptionDeclaration", path, "");
		}
		return failure("EndUserExceptionDeclaration", ValidationType.ONLY_EXISTS, "EndUserExceptionDeclaration", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
