package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ValuationSetDetail;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ValuationSetDetailOnlyExistsValidator implements ValidatorWithArg<ValuationSetDetail, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ValuationSetDetail> ValidationResult<ValuationSetDetail> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("value", ExistenceChecker.isSet((String) o.getValue()))
				.put("valuationSetDetailScheme", ExistenceChecker.isSet((String) o.getValuationSetDetailScheme()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ValuationSetDetail", ValidationType.ONLY_EXISTS, "ValuationSetDetail", path, "");
		}
		return failure("ValuationSetDetail", ValidationType.ONLY_EXISTS, "ValuationSetDetail", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
