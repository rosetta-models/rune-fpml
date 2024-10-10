package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdditionalData;
import fpml.confirmation.MimeType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AdditionalDataOnlyExistsValidator implements ValidatorWithArg<AdditionalData, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AdditionalData> ValidationResult<AdditionalData> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("mimeType", ExistenceChecker.isSet((MimeType) o.getMimeType()))
				.put("string", ExistenceChecker.isSet((String) o.getString()))
				.put("hexadecimalBinary", ExistenceChecker.isSet((String) o.getHexadecimalBinary()))
				.put("base64Binary", ExistenceChecker.isSet((String) o.getBase64Binary()))
				.put("originalMessage", ExistenceChecker.isSet((String) o.getOriginalMessage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AdditionalData", ValidationType.ONLY_EXISTS, "AdditionalData", path, "");
		}
		return failure("AdditionalData", ValidationType.ONLY_EXISTS, "AdditionalData", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
