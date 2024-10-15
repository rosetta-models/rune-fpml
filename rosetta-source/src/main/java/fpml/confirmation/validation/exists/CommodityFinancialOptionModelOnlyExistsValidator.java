package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityExercise;
import fpml.confirmation.CommodityFinancialOptionModel;
import fpml.confirmation.CommodityFloatingStrikePriceModel;
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.CommodityOptionFeaturesModel;
import fpml.confirmation.CommodityStrikePriceModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityFinancialOptionModelOnlyExistsValidator implements ValidatorWithArg<CommodityFinancialOptionModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityFinancialOptionModel> ValidationResult<CommodityFinancialOptionModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commodity", ExistenceChecker.isSet((Commodity) o.getCommodity()))
				.put("commodityOptionFeaturesModel", ExistenceChecker.isSet((CommodityOptionFeaturesModel) o.getCommodityOptionFeaturesModel()))
				.put("commodityNotionalQuantityModel", ExistenceChecker.isSet((CommodityNotionalQuantityModel) o.getCommodityNotionalQuantityModel()))
				.put("exercise", ExistenceChecker.isSet((CommodityExercise) o.getExercise()))
				.put("commodityStrikePriceModel", ExistenceChecker.isSet((CommodityStrikePriceModel) o.getCommodityStrikePriceModel()))
				.put("commodityFloatingStrikePriceModel", ExistenceChecker.isSet((CommodityFloatingStrikePriceModel) o.getCommodityFloatingStrikePriceModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityFinancialOptionModel", ValidationType.ONLY_EXISTS, "CommodityFinancialOptionModel", path, "");
		}
		return failure("CommodityFinancialOptionModel", ValidationType.ONLY_EXISTS, "CommodityFinancialOptionModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
