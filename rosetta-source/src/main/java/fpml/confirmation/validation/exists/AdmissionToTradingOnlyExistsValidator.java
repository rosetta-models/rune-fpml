package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdmissionToTrading;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AdmissionToTradingOnlyExistsValidator implements ValidatorWithArg<AdmissionToTrading, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AdmissionToTrading> ValidationResult<AdmissionToTrading> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("requested", ExistenceChecker.isSet((Boolean) o.getRequested()))
				.put("requestDate", ExistenceChecker.isSet((ZonedDateTime) o.getRequestDate()))
				.put("approvalDate", ExistenceChecker.isSet((ZonedDateTime) o.getApprovalDate()))
				.put("admissionDate", ExistenceChecker.isSet((ZonedDateTime) o.getAdmissionDate()))
				.put("terminationDate", ExistenceChecker.isSet((ZonedDateTime) o.getTerminationDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AdmissionToTrading", ValidationType.ONLY_EXISTS, "AdmissionToTrading", path, "");
		}
		return failure("AdmissionToTrading", ValidationType.ONLY_EXISTS, "AdmissionToTrading", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
