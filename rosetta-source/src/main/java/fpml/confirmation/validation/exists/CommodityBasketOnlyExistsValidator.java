package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasketIdentifierModel;
import fpml.confirmation.CommodityBasket;
import fpml.confirmation.CommodityBasketModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityBasketOnlyExistsValidator implements ValidatorWithArg<CommodityBasket, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityBasket> ValidationResult<CommodityBasket> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basketIdentifierModel", ExistenceChecker.isSet((BasketIdentifierModel) o.getBasketIdentifierModel()))
				.put("commodityBasketModel", ExistenceChecker.isSet((CommodityBasketModel) o.getCommodityBasketModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityBasket", ValidationType.ONLY_EXISTS, "CommodityBasket", path, "");
		}
		return failure("CommodityBasket", ValidationType.ONLY_EXISTS, "CommodityBasket", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
