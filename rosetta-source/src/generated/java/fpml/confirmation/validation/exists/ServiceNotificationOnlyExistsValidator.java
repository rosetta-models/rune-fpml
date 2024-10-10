package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.NotificationMessageHeader;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.ServiceAdvisory;
import fpml.confirmation.ServiceNotification;
import fpml.confirmation.ServiceProcessingStatus;
import fpml.confirmation.ServiceStatus;
import fpml.confirmation.ValidationModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ServiceNotificationOnlyExistsValidator implements ValidatorWithArg<ServiceNotification, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ServiceNotification> ValidationResult<ServiceNotification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((NotificationMessageHeader) o.getHeader()))
				.put("validationModel", ExistenceChecker.isSet((ValidationModel) o.getValidationModel()))
				.put("correlationAndOptionalSequenceModel", ExistenceChecker.isSet((CorrelationAndOptionalSequenceModel) o.getCorrelationAndOptionalSequenceModel()))
				.put("onBehalfOfModel", ExistenceChecker.isSet((OnBehalfOfModel) o.getOnBehalfOfModel()))
				.put("serviceName", ExistenceChecker.isSet((String) o.getServiceName()))
				.put("status", ExistenceChecker.isSet((ServiceStatus) o.getStatus()))
				.put("processingStatus", ExistenceChecker.isSet((ServiceProcessingStatus) o.getProcessingStatus()))
				.put("advisory", ExistenceChecker.isSet((ServiceAdvisory) o.getAdvisory()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ServiceNotification", ValidationType.ONLY_EXISTS, "ServiceNotification", path, "");
		}
		return failure("ServiceNotification", ValidationType.ONLY_EXISTS, "ServiceNotification", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
