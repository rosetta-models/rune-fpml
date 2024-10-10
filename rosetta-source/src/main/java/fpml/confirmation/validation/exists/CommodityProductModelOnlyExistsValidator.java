package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityProductModel;
import fpml.confirmation.CommodityProductModelSequence;
import fpml.confirmation.CommodityReferencePriceFrameworkModel;
import fpml.confirmation.SpecifiedPriceEnum;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityProductModelOnlyExistsValidator implements ValidatorWithArg<CommodityProductModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityProductModel> ValidationResult<CommodityProductModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commodityReferencePriceFrameworkModel", ExistenceChecker.isSet((CommodityReferencePriceFrameworkModel) o.getCommodityReferencePriceFrameworkModel()))
				.put("specifiedPrice", ExistenceChecker.isSet((SpecifiedPriceEnum) o.getSpecifiedPrice()))
				.put("commodityProductModelSequence", ExistenceChecker.isSet((CommodityProductModelSequence) o.getCommodityProductModelSequence()))
				.put("multiplier", ExistenceChecker.isSet((BigDecimal) o.getMultiplier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityProductModel", ValidationType.ONLY_EXISTS, "CommodityProductModel", path, "");
		}
		return failure("CommodityProductModel", ValidationType.ONLY_EXISTS, "CommodityProductModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
