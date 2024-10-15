package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.CreditEventException;
import fpml.confirmation.ExceptionMessageHeader;
import fpml.confirmation.ExceptionModel;
import fpml.confirmation.ValidationModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditEventExceptionOnlyExistsValidator implements ValidatorWithArg<CreditEventException, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditEventException> ValidationResult<CreditEventException> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((ExceptionMessageHeader) o.getHeader()))
				.put("validationModel", ExistenceChecker.isSet((ValidationModel) o.getValidationModel()))
				.put("correlationAndOptionalSequenceModel", ExistenceChecker.isSet((CorrelationAndOptionalSequenceModel) o.getCorrelationAndOptionalSequenceModel()))
				.put("exceptionModel", ExistenceChecker.isSet((ExceptionModel) o.getExceptionModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditEventException", ValidationType.ONLY_EXISTS, "CreditEventException", path, "");
		}
		return failure("CreditEventException", ValidationType.ONLY_EXISTS, "CreditEventException", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
