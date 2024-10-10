package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityPhysicalExercise;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.CommoditySwaption;
import fpml.confirmation.CommoditySwaptionUnderlying;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommoditySwaptionOnlyExistsValidator implements ValidatorWithArg<CommoditySwaption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommoditySwaption> ValidationResult<CommoditySwaption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("optionType", ExistenceChecker.isSet((PutCallEnum) o.getOptionType()))
				.put("commoditySwap", ExistenceChecker.isSet((CommoditySwaptionUnderlying) o.getCommoditySwap()))
				.put("physicalExercise", ExistenceChecker.isSet((CommodityPhysicalExercise) o.getPhysicalExercise()))
				.put("premium", ExistenceChecker.isSet((CommodityPremium) o.getPremium()))
				.put("commodityContentModel", ExistenceChecker.isSet((CommodityContentModel) o.getCommodityContentModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommoditySwaption", ValidationType.ONLY_EXISTS, "CommoditySwaption", path, "");
		}
		return failure("CommoditySwaption", ValidationType.ONLY_EXISTS, "CommoditySwaption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
