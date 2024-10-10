package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AnyAssetReference;
import fpml.confirmation.Currency;
import fpml.confirmation.VolatilityRepresentation;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class VolatilityRepresentationOnlyExistsValidator implements ValidatorWithArg<VolatilityRepresentation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends VolatilityRepresentation> ValidationResult<VolatilityRepresentation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("asset", ExistenceChecker.isSet((AnyAssetReference) o.getAsset()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("VolatilityRepresentation", ValidationType.ONLY_EXISTS, "VolatilityRepresentation", path, "");
		}
		return failure("VolatilityRepresentation", ValidationType.ONLY_EXISTS, "VolatilityRepresentation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
