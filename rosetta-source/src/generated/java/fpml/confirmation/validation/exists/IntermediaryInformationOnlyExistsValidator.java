package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IntermediaryInformation;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RoutingIdentificationModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class IntermediaryInformationOnlyExistsValidator implements ValidatorWithArg<IntermediaryInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends IntermediaryInformation> ValidationResult<IntermediaryInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("routingIdentificationModel", ExistenceChecker.isSet((RoutingIdentificationModel) o.getRoutingIdentificationModel()))
				.put("intermediarySequenceNumber", ExistenceChecker.isSet((Integer) o.getIntermediarySequenceNumber()))
				.put("intermediaryPartyReference", ExistenceChecker.isSet((PartyReference) o.getIntermediaryPartyReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("IntermediaryInformation", ValidationType.ONLY_EXISTS, "IntermediaryInformation", path, "");
		}
		return failure("IntermediaryInformation", ValidationType.ONLY_EXISTS, "IntermediaryInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
