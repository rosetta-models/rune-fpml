package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Asset;
import fpml.confirmation.AssetReference;
import fpml.confirmation.UnderlyingAssetOrReferenceModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class UnderlyingAssetOrReferenceModelOnlyExistsValidator implements ValidatorWithArg<UnderlyingAssetOrReferenceModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends UnderlyingAssetOrReferenceModel> ValidationResult<UnderlyingAssetOrReferenceModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("underlyingAsset", ExistenceChecker.isSet((Asset) o.getUnderlyingAsset()))
				.put("underlyingAssetReference", ExistenceChecker.isSet((AssetReference) o.getUnderlyingAssetReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("UnderlyingAssetOrReferenceModel", ValidationType.ONLY_EXISTS, "UnderlyingAssetOrReferenceModel", path, "");
		}
		return failure("UnderlyingAssetOrReferenceModel", ValidationType.ONLY_EXISTS, "UnderlyingAssetOrReferenceModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
