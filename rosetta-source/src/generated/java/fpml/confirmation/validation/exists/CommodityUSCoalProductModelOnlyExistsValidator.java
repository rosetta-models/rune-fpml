package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalQualityAdjustments;
import fpml.confirmation.CommodityUSCoalProductModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityUSCoalProductModelOnlyExistsValidator implements ValidatorWithArg<CommodityUSCoalProductModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityUSCoalProductModel> ValidationResult<CommodityUSCoalProductModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("btuQualityAdjustment", ExistenceChecker.isSet((CoalQualityAdjustments) o.getBtuQualityAdjustment()))
				.put("so2QualityAdjustment", ExistenceChecker.isSet((CoalQualityAdjustments) o.getSo2QualityAdjustment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityUSCoalProductModel", ValidationType.ONLY_EXISTS, "CommodityUSCoalProductModel", path, "");
		}
		return failure("CommodityUSCoalProductModel", ValidationType.ONLY_EXISTS, "CommodityUSCoalProductModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
