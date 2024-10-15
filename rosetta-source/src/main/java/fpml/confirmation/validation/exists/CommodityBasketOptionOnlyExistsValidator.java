package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CommodityBasketModel;
import fpml.confirmation.CommodityBasketOption;
import fpml.confirmation.CommodityBasketOptionFeaturesModel;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityExerciseBasket;
import fpml.confirmation.CommodityFloatingStrikePriceModel;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.CommodityStrikePriceModel;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import fpml.confirmation.StrikePriceBasketReference;
import fpml.confirmation.StrikePriceUnderlyingReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityBasketOptionOnlyExistsValidator implements ValidatorWithArg<CommodityBasketOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityBasketOption> ValidationResult<CommodityBasketOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("optionType", ExistenceChecker.isSet((PutCallEnum) o.getOptionType()))
				.put("commodityBasketOptionFeaturesModel", ExistenceChecker.isSet((CommodityBasketOptionFeaturesModel) o.getCommodityBasketOptionFeaturesModel()))
				.put("commodityBasketModel", ExistenceChecker.isSet((CommodityBasketModel) o.getCommodityBasketModel()))
				.put("strikePriceUnderlyingReference", ExistenceChecker.isSet((StrikePriceUnderlyingReference) o.getStrikePriceUnderlyingReference()))
				.put("strikePriceBasketReference", ExistenceChecker.isSet((StrikePriceBasketReference) o.getStrikePriceBasketReference()))
				.put("commodityStrikePriceModel", ExistenceChecker.isSet((CommodityStrikePriceModel) o.getCommodityStrikePriceModel()))
				.put("commodityFloatingStrikePriceModel", ExistenceChecker.isSet((CommodityFloatingStrikePriceModel) o.getCommodityFloatingStrikePriceModel()))
				.put("exercise", ExistenceChecker.isSet((CommodityExerciseBasket) o.getExercise()))
				.put("premium", ExistenceChecker.isSet((List<? extends CommodityPremium>) o.getPremium()))
				.put("commodityContentModel", ExistenceChecker.isSet((CommodityContentModel) o.getCommodityContentModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityBasketOption", ValidationType.ONLY_EXISTS, "CommodityBasketOption", path, "");
		}
		return failure("CommodityBasketOption", ValidationType.ONLY_EXISTS, "CommodityBasketOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
