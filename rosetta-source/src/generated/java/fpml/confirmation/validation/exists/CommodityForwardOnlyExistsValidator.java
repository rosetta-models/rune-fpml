package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AveragePriceLeg;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityForward;
import fpml.confirmation.CommodityForwardLeg;
import fpml.confirmation.NonPeriodicFixedPriceLeg;
import fpml.confirmation.ProductModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityForwardOnlyExistsValidator implements ValidatorWithArg<CommodityForward, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityForward> ValidationResult<CommodityForward> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("valueDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getValueDate()))
				.put("fixedLeg", ExistenceChecker.isSet((NonPeriodicFixedPriceLeg) o.getFixedLeg()))
				.put("averagePriceLeg", ExistenceChecker.isSet((AveragePriceLeg) o.getAveragePriceLeg()))
				.put("commodityForwardLeg", ExistenceChecker.isSet((CommodityForwardLeg) o.getCommodityForwardLeg()))
				.put("commodityContentModel", ExistenceChecker.isSet((CommodityContentModel) o.getCommodityContentModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityForward", ValidationType.ONLY_EXISTS, "CommodityForward", path, "");
		}
		return failure("CommodityForward", ValidationType.ONLY_EXISTS, "CommodityForward", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
