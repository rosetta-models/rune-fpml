package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExceptionMessageHeader;
import fpml.confirmation.MessageHeaderModel;
import fpml.confirmation.MessageId;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ExceptionMessageHeaderOnlyExistsValidator implements ValidatorWithArg<ExceptionMessageHeader, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ExceptionMessageHeader> ValidationResult<ExceptionMessageHeader> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("messageId", ExistenceChecker.isSet((MessageId) o.getMessageId()))
				.put("inReplyTo", ExistenceChecker.isSet((MessageId) o.getInReplyTo()))
				.put("messageHeaderModel", ExistenceChecker.isSet((MessageHeaderModel) o.getMessageHeaderModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExceptionMessageHeader", ValidationType.ONLY_EXISTS, "ExceptionMessageHeader", path, "");
		}
		return failure("ExceptionMessageHeader", ValidationType.ONLY_EXISTS, "ExceptionMessageHeader", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
