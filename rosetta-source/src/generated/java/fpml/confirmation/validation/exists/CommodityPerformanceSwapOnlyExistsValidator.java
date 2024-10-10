package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityPerformanceSwap;
import fpml.confirmation.CommodityPerformanceSwapEarlyTermination;
import fpml.confirmation.CommodityPerformanceSwapLeg;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.ProductModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityPerformanceSwapOnlyExistsValidator implements ValidatorWithArg<CommodityPerformanceSwap, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityPerformanceSwap> ValidationResult<CommodityPerformanceSwap> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getTerminationDate()))
				.put("settlementCurrency", ExistenceChecker.isSet((IdentifiedCurrency) o.getSettlementCurrency()))
				.put("commodityPerformanceSwapLeg", ExistenceChecker.isSet((List<? extends CommodityPerformanceSwapLeg>) o.getCommodityPerformanceSwapLeg()))
				.put("commodityContentModel", ExistenceChecker.isSet((CommodityContentModel) o.getCommodityContentModel()))
				.put("earlyTermination", ExistenceChecker.isSet((List<? extends CommodityPerformanceSwapEarlyTermination>) o.getEarlyTermination()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityPerformanceSwap", ValidationType.ONLY_EXISTS, "CommodityPerformanceSwap", path, "");
		}
		return failure("CommodityPerformanceSwap", ValidationType.ONLY_EXISTS, "CommodityPerformanceSwap", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
