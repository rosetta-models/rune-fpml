package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFixedPriceModel;
import fpml.confirmation.CommodityFixedPriceModelChoice;
import fpml.confirmation.CommodityFixedPriceSchedule;
import fpml.confirmation.NonNegativeMoney;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityFixedPriceModelOnlyExistsValidator implements ValidatorWithArg<CommodityFixedPriceModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityFixedPriceModel> ValidationResult<CommodityFixedPriceModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixedPriceSchedule", ExistenceChecker.isSet((CommodityFixedPriceSchedule) o.getFixedPriceSchedule()))
				.put("commodityFixedPriceModelChoice", ExistenceChecker.isSet((CommodityFixedPriceModelChoice) o.getCommodityFixedPriceModelChoice()))
				.put("totalPrice", ExistenceChecker.isSet((NonNegativeMoney) o.getTotalPrice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityFixedPriceModel", ValidationType.ONLY_EXISTS, "CommodityFixedPriceModel", path, "");
		}
		return failure("CommodityFixedPriceModel", ValidationType.ONLY_EXISTS, "CommodityFixedPriceModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
