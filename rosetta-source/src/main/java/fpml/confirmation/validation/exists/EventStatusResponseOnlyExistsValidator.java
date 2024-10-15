package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.EventStatusItem;
import fpml.confirmation.EventStatusResponse;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.ValidationModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EventStatusResponseOnlyExistsValidator implements ValidatorWithArg<EventStatusResponse, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EventStatusResponse> ValidationResult<EventStatusResponse> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((ResponseMessageHeader) o.getHeader()))
				.put("validationModel", ExistenceChecker.isSet((ValidationModel) o.getValidationModel()))
				.put("correlationAndOptionalSequenceModel", ExistenceChecker.isSet((CorrelationAndOptionalSequenceModel) o.getCorrelationAndOptionalSequenceModel()))
				.put("onBehalfOfModel", ExistenceChecker.isSet((OnBehalfOfModel) o.getOnBehalfOfModel()))
				.put("statusItem", ExistenceChecker.isSet((List<? extends EventStatusItem>) o.getStatusItem()))
				.put("partiesAndAccountsModel", ExistenceChecker.isSet((PartiesAndAccountsModel) o.getPartiesAndAccountsModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EventStatusResponse", ValidationType.ONLY_EXISTS, "EventStatusResponse", path, "");
		}
		return failure("EventStatusResponse", ValidationType.ONLY_EXISTS, "EventStatusResponse", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
