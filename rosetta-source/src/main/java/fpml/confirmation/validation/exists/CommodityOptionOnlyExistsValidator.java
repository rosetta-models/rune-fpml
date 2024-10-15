package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityFinancialOptionModel;
import fpml.confirmation.CommodityOption;
import fpml.confirmation.CommodityPhysicalOptionModel;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.CommodityWeatherOptionModel;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityOptionOnlyExistsValidator implements ValidatorWithArg<CommodityOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityOption> ValidationResult<CommodityOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("optionType", ExistenceChecker.isSet((PutCallEnum) o.getOptionType()))
				.put("commodityFinancialOptionModel", ExistenceChecker.isSet((CommodityFinancialOptionModel) o.getCommodityFinancialOptionModel()))
				.put("commodityPhysicalOptionModel", ExistenceChecker.isSet((CommodityPhysicalOptionModel) o.getCommodityPhysicalOptionModel()))
				.put("commodityWeatherOptionModel", ExistenceChecker.isSet((CommodityWeatherOptionModel) o.getCommodityWeatherOptionModel()))
				.put("premium", ExistenceChecker.isSet((List<? extends CommodityPremium>) o.getPremium()))
				.put("commodityContentModel", ExistenceChecker.isSet((CommodityContentModel) o.getCommodityContentModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityOption", ValidationType.ONLY_EXISTS, "CommodityOption", path, "");
		}
		return failure("CommodityOption", ValidationType.ONLY_EXISTS, "CommodityOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
