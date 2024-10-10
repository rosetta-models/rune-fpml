package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityMarketDisruption;
import fpml.confirmation.CommodityMarketDisruptionSequence;
import fpml.confirmation.DisruptionFallbacksEnum;
import fpml.confirmation.MarketDisruptionEvent;
import fpml.confirmation.SequencedDisruptionFallback;
import fpml.confirmation.Underlyer;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityMarketDisruptionOnlyExistsValidator implements ValidatorWithArg<CommodityMarketDisruption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityMarketDisruption> ValidationResult<CommodityMarketDisruption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commodityMarketDisruptionSequence", ExistenceChecker.isSet((CommodityMarketDisruptionSequence) o.getCommodityMarketDisruptionSequence()))
				.put("marketDisruptionEvent", ExistenceChecker.isSet((List<? extends MarketDisruptionEvent>) o.getMarketDisruptionEvent()))
				.put("disruptionFallbacks", ExistenceChecker.isSet((DisruptionFallbacksEnum) o.getDisruptionFallbacks()))
				.put("disruptionFallback", ExistenceChecker.isSet((List<? extends SequencedDisruptionFallback>) o.getDisruptionFallback()))
				.put("fallbackReferencePrice", ExistenceChecker.isSet((Underlyer) o.getFallbackReferencePrice()))
				.put("maximumNumberOfDaysOfDisruption", ExistenceChecker.isSet((Integer) o.getMaximumNumberOfDaysOfDisruption()))
				.put("priceMaterialityPercentage", ExistenceChecker.isSet((BigDecimal) o.getPriceMaterialityPercentage()))
				.put("minimumFuturesContracts", ExistenceChecker.isSet((Integer) o.getMinimumFuturesContracts()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityMarketDisruption", ValidationType.ONLY_EXISTS, "CommodityMarketDisruption", path, "");
		}
		return failure("CommodityMarketDisruption", ValidationType.ONLY_EXISTS, "CommodityMarketDisruption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
