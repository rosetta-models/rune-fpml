package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ImplementationSpecification;
import fpml.confirmation.MessageAddress;
import fpml.confirmation.MessageHeaderModel;
import fpml.confirmation.PartyMessageInformation;
import fpml.confirmation.SignatureType;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MessageHeaderModelOnlyExistsValidator implements ValidatorWithArg<MessageHeaderModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MessageHeaderModel> ValidationResult<MessageHeaderModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("sentBy", ExistenceChecker.isSet((MessageAddress) o.getSentBy()))
				.put("sendTo", ExistenceChecker.isSet((List<? extends MessageAddress>) o.getSendTo()))
				.put("copyTo", ExistenceChecker.isSet((List<? extends MessageAddress>) o.getCopyTo()))
				.put("creationTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getCreationTimestamp()))
				.put("expiryTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getExpiryTimestamp()))
				.put("implementationSpecification", ExistenceChecker.isSet((ImplementationSpecification) o.getImplementationSpecification()))
				.put("partyMessageInformation", ExistenceChecker.isSet((List<? extends PartyMessageInformation>) o.getPartyMessageInformation()))
				.put("signature", ExistenceChecker.isSet((List<? extends SignatureType>) o.getSignature()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MessageHeaderModel", ValidationType.ONLY_EXISTS, "MessageHeaderModel", path, "");
		}
		return failure("MessageHeaderModel", ValidationType.ONLY_EXISTS, "MessageHeaderModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
