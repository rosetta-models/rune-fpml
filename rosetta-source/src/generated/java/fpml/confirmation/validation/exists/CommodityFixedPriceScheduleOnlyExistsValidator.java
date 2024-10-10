package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityFixedPriceSchedule;
import fpml.confirmation.CommoditySettlementPeriodsPriceSchedule;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityFixedPriceScheduleOnlyExistsValidator implements ValidatorWithArg<CommodityFixedPriceSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityFixedPriceSchedule> ValidationResult<CommodityFixedPriceSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixedPriceStep", ExistenceChecker.isSet((List<? extends FixedPrice>) o.getFixedPriceStep()))
				.put("worldscaleRateStep", ExistenceChecker.isSet((List<BigDecimal>) o.getWorldscaleRateStep()))
				.put("contractRateStep", ExistenceChecker.isSet((List<? extends NonNegativeMoney>) o.getContractRateStep()))
				.put("settlementPeriodsPriceSchedule", ExistenceChecker.isSet((List<? extends CommoditySettlementPeriodsPriceSchedule>) o.getSettlementPeriodsPriceSchedule()))
				.put("commodityCalculationPeriodsPointerModel", ExistenceChecker.isSet((CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityFixedPriceSchedule", ValidationType.ONLY_EXISTS, "CommodityFixedPriceSchedule", path, "");
		}
		return failure("CommodityFixedPriceSchedule", ValidationType.ONLY_EXISTS, "CommodityFixedPriceSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
