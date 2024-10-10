package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BondCollateralModel;
import fpml.confirmation.BondPriceAndYieldModel;
import fpml.confirmation.Money;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BondCollateralModelOnlyExistsValidator implements ValidatorWithArg<BondCollateralModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BondCollateralModel> ValidationResult<BondCollateralModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("nominalAmount", ExistenceChecker.isSet((Money) o.getNominalAmount()))
				.put("bondPriceAndYieldModel", ExistenceChecker.isSet((BondPriceAndYieldModel) o.getBondPriceAndYieldModel()))
				.put("accrualsAmount", ExistenceChecker.isSet((Money) o.getAccrualsAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BondCollateralModel", ValidationType.ONLY_EXISTS, "BondCollateralModel", path, "");
		}
		return failure("BondCollateralModel", ValidationType.ONLY_EXISTS, "BondCollateralModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
