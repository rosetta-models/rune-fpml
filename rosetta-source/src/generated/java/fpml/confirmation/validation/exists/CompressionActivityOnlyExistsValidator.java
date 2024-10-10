package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CompressionActivity;
import fpml.confirmation.CompressionActivitySequence0;
import fpml.confirmation.CompressionActivitySequence1;
import fpml.confirmation.CompressionType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CompressionActivityOnlyExistsValidator implements ValidatorWithArg<CompressionActivity, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CompressionActivity> ValidationResult<CompressionActivity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("compressionType", ExistenceChecker.isSet((CompressionType) o.getCompressionType()))
				.put("compressionActivitySequence0", ExistenceChecker.isSet((CompressionActivitySequence0) o.getCompressionActivitySequence0()))
				.put("compressionActivitySequence1", ExistenceChecker.isSet((CompressionActivitySequence1) o.getCompressionActivitySequence1()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CompressionActivity", ValidationType.ONLY_EXISTS, "CompressionActivity", path, "");
		}
		return failure("CompressionActivity", ValidationType.ONLY_EXISTS, "CompressionActivity", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
