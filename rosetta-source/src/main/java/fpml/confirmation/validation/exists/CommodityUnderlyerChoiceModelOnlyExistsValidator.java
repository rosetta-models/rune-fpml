package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityBasket;
import fpml.confirmation.CommodityUnderlyerChoiceModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityUnderlyerChoiceModelOnlyExistsValidator implements ValidatorWithArg<CommodityUnderlyerChoiceModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityUnderlyerChoiceModel> ValidationResult<CommodityUnderlyerChoiceModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commodity", ExistenceChecker.isSet((Commodity) o.getCommodity()))
				.put("commodityBasket", ExistenceChecker.isSet((CommodityBasket) o.getCommodityBasket()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityUnderlyerChoiceModel", ValidationType.ONLY_EXISTS, "CommodityUnderlyerChoiceModel", path, "");
		}
		return failure("CommodityUnderlyerChoiceModel", ValidationType.ONLY_EXISTS, "CommodityUnderlyerChoiceModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
