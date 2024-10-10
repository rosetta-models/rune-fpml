package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBasketByNotional;
import fpml.confirmation.CommodityBasketByPercentage;
import fpml.confirmation.CommodityBasketModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityBasketModelOnlyExistsValidator implements ValidatorWithArg<CommodityBasketModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityBasketModel> ValidationResult<CommodityBasketModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalQuantityBasket", ExistenceChecker.isSet((CommodityBasketByNotional) o.getNotionalQuantityBasket()))
				.put("notionalAmountBasket", ExistenceChecker.isSet((CommodityBasketByPercentage) o.getNotionalAmountBasket()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityBasketModel", ValidationType.ONLY_EXISTS, "CommodityBasketModel", path, "");
		}
		return failure("CommodityBasketModel", ValidationType.ONLY_EXISTS, "CommodityBasketModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
