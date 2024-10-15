package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetReference;
import fpml.confirmation.BondCollateralModel;
import fpml.confirmation.CollateralValuation;
import fpml.confirmation.UnitContractModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CollateralValuationOnlyExistsValidator implements ValidatorWithArg<CollateralValuation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CollateralValuation> ValidationResult<CollateralValuation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("bondCollateralModel", ExistenceChecker.isSet((BondCollateralModel) o.getBondCollateralModel()))
				.put("unitContractModel", ExistenceChecker.isSet((UnitContractModel) o.getUnitContractModel()))
				.put("assetReference", ExistenceChecker.isSet((AssetReference) o.getAssetReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralValuation", ValidationType.ONLY_EXISTS, "CollateralValuation", path, "");
		}
		return failure("CollateralValuation", ValidationType.ONLY_EXISTS, "CollateralValuation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
