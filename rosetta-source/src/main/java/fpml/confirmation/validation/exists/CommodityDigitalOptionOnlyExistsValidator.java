package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityDigitalExercise;
import fpml.confirmation.CommodityDigitalOption;
import fpml.confirmation.CommodityDigitalOptionFeaturesModel;
import fpml.confirmation.CommodityDigitalOptionSequence;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.NotionalAmount;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityDigitalOptionOnlyExistsValidator implements ValidatorWithArg<CommodityDigitalOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityDigitalOption> ValidationResult<CommodityDigitalOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("optionType", ExistenceChecker.isSet((PutCallEnum) o.getOptionType()))
				.put("commodity", ExistenceChecker.isSet((Commodity) o.getCommodity()))
				.put("commodityDigitalOptionFeaturesModel", ExistenceChecker.isSet((CommodityDigitalOptionFeaturesModel) o.getCommodityDigitalOptionFeaturesModel()))
				.put("notionalAmount", ExistenceChecker.isSet((NotionalAmount) o.getNotionalAmount()))
				.put("commodityDigitalOptionSequence", ExistenceChecker.isSet((CommodityDigitalOptionSequence) o.getCommodityDigitalOptionSequence()))
				.put("exercise", ExistenceChecker.isSet((CommodityDigitalExercise) o.getExercise()))
				.put("premium", ExistenceChecker.isSet((List<? extends CommodityPremium>) o.getPremium()))
				.put("commodityContentModel", ExistenceChecker.isSet((CommodityContentModel) o.getCommodityContentModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityDigitalOption", ValidationType.ONLY_EXISTS, "CommodityDigitalOption", path, "");
		}
		return failure("CommodityDigitalOption", ValidationType.ONLY_EXISTS, "CommodityDigitalOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
