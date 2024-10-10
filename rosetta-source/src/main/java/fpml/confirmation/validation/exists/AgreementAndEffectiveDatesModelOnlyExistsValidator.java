package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AgreementAndEffectiveDatesModel;
import fpml.confirmation.ExecutionDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AgreementAndEffectiveDatesModelOnlyExistsValidator implements ValidatorWithArg<AgreementAndEffectiveDatesModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AgreementAndEffectiveDatesModel> ValidationResult<AgreementAndEffectiveDatesModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("agreementDate", ExistenceChecker.isSet((Date) o.getAgreementDate()))
				.put("executionDateTime", ExistenceChecker.isSet((ExecutionDateTime) o.getExecutionDateTime()))
				.put("effectiveDate", ExistenceChecker.isSet((Date) o.getEffectiveDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AgreementAndEffectiveDatesModel", ValidationType.ONLY_EXISTS, "AgreementAndEffectiveDatesModel", path, "");
		}
		return failure("AgreementAndEffectiveDatesModel", ValidationType.ONLY_EXISTS, "AgreementAndEffectiveDatesModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
