package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFixedPriceModelChoice;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.SettlementPeriodsFixedPrice;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityFixedPriceModelChoiceOnlyExistsValidator implements ValidatorWithArg<CommodityFixedPriceModelChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityFixedPriceModelChoice> ValidationResult<CommodityFixedPriceModelChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixedPrice", ExistenceChecker.isSet((FixedPrice) o.getFixedPrice()))
				.put("worldscaleRate", ExistenceChecker.isSet((BigDecimal) o.getWorldscaleRate()))
				.put("contractRate", ExistenceChecker.isSet((NonNegativeMoney) o.getContractRate()))
				.put("settlementPeriodsPrice", ExistenceChecker.isSet((List<? extends SettlementPeriodsFixedPrice>) o.getSettlementPeriodsPrice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityFixedPriceModelChoice", ValidationType.ONLY_EXISTS, "CommodityFixedPriceModelChoice", path, "");
		}
		return failure("CommodityFixedPriceModelChoice", ValidationType.ONLY_EXISTS, "CommodityFixedPriceModelChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
