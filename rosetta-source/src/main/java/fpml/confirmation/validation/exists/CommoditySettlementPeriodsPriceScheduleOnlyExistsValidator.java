package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommoditySettlementPeriodsPriceSchedule;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.SettlementPeriodsReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommoditySettlementPeriodsPriceScheduleOnlyExistsValidator implements ValidatorWithArg<CommoditySettlementPeriodsPriceSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommoditySettlementPeriodsPriceSchedule> ValidationResult<CommoditySettlementPeriodsPriceSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("settlementPeriodsPriceStep", ExistenceChecker.isSet((List<? extends FixedPrice>) o.getSettlementPeriodsPriceStep()))
				.put("settlementPeriodsReference", ExistenceChecker.isSet((List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommoditySettlementPeriodsPriceSchedule", ValidationType.ONLY_EXISTS, "CommoditySettlementPeriodsPriceSchedule", path, "");
		}
		return failure("CommoditySettlementPeriodsPriceSchedule", ValidationType.ONLY_EXISTS, "CommoditySettlementPeriodsPriceSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
