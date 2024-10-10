package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IndexId;
import fpml.confirmation.IndexName;
import fpml.confirmation.IndexReferenceInformationSequence0;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class IndexReferenceInformationSequence0OnlyExistsValidator implements ValidatorWithArg<IndexReferenceInformationSequence0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends IndexReferenceInformationSequence0> ValidationResult<IndexReferenceInformationSequence0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("indexName", ExistenceChecker.isSet((IndexName) o.getIndexName()))
				.put("indexId", ExistenceChecker.isSet((List<? extends IndexId>) o.getIndexId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("IndexReferenceInformationSequence0", ValidationType.ONLY_EXISTS, "IndexReferenceInformationSequence0", path, "");
		}
		return failure("IndexReferenceInformationSequence0", ValidationType.ONLY_EXISTS, "IndexReferenceInformationSequence0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
