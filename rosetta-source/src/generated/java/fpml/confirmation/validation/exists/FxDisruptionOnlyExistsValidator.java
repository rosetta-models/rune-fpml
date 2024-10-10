package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Currency;
import fpml.confirmation.FxDisruption;
import fpml.confirmation.FxDisruptionProvisions;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxDisruptionOnlyExistsValidator implements ValidatorWithArg<FxDisruption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxDisruption> ValidationResult<FxDisruption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("baseCurrency", ExistenceChecker.isSet((Currency) o.getBaseCurrency()))
				.put("referenceCurrency", ExistenceChecker.isSet((Currency) o.getReferenceCurrency()))
				.put("provisions", ExistenceChecker.isSet((List<? extends FxDisruptionProvisions>) o.getProvisions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxDisruption", ValidationType.ONLY_EXISTS, "FxDisruption", path, "");
		}
		return failure("FxDisruption", ValidationType.ONLY_EXISTS, "FxDisruption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
