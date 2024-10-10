package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDeliveryPeriods;
import fpml.confirmation.ElectricityDelivery;
import fpml.confirmation.ElectricityPhysicalLeg;
import fpml.confirmation.ElectricityPhysicalQuantity;
import fpml.confirmation.ElectricityProduct;
import fpml.confirmation.LoadTypeEnum;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.SettlementPeriods;
import fpml.confirmation.SettlementPeriodsSchedule;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ElectricityPhysicalLegOnlyExistsValidator implements ValidatorWithArg<ElectricityPhysicalLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ElectricityPhysicalLeg> ValidationResult<ElectricityPhysicalLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("deliveryPeriods", ExistenceChecker.isSet((CommodityDeliveryPeriods) o.getDeliveryPeriods()))
				.put("settlementPeriods", ExistenceChecker.isSet((List<? extends SettlementPeriods>) o.getSettlementPeriods()))
				.put("settlementPeriodsSchedule", ExistenceChecker.isSet((SettlementPeriodsSchedule) o.getSettlementPeriodsSchedule()))
				.put("loadType", ExistenceChecker.isSet((LoadTypeEnum) o.getLoadType()))
				.put("electricity", ExistenceChecker.isSet((ElectricityProduct) o.getElectricity()))
				.put("deliveryConditions", ExistenceChecker.isSet((ElectricityDelivery) o.getDeliveryConditions()))
				.put("deliveryQuantity", ExistenceChecker.isSet((ElectricityPhysicalQuantity) o.getDeliveryQuantity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ElectricityPhysicalLeg", ValidationType.ONLY_EXISTS, "ElectricityPhysicalLeg", path, "");
		}
		return failure("ElectricityPhysicalLeg", ValidationType.ONLY_EXISTS, "ElectricityPhysicalLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
