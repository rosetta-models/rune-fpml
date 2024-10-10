package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityPayRelativeToEnum;
import fpml.confirmation.CommodityPayRelativeToEvent;
import fpml.confirmation.CommodityRelativePaymentDates;
import fpml.confirmation.DateOffset;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityRelativePaymentDatesOnlyExistsValidator implements ValidatorWithArg<CommodityRelativePaymentDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityRelativePaymentDates> ValidationResult<CommodityRelativePaymentDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("payRelativeTo", ExistenceChecker.isSet((CommodityPayRelativeToEnum) o.getPayRelativeTo()))
				.put("payRelativeToEvent", ExistenceChecker.isSet((CommodityPayRelativeToEvent) o.getPayRelativeToEvent()))
				.put("commodityCalculationPeriodsPointerModel", ExistenceChecker.isSet((CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel()))
				.put("paymentDaysOffset", ExistenceChecker.isSet((DateOffset) o.getPaymentDaysOffset()))
				.put("businessCentersOrReferenceModel", ExistenceChecker.isSet((BusinessCentersOrReferenceModel) o.getBusinessCentersOrReferenceModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityRelativePaymentDates", ValidationType.ONLY_EXISTS, "CommodityRelativePaymentDates", path, "");
		}
		return failure("CommodityRelativePaymentDates", ValidationType.ONLY_EXISTS, "CommodityRelativePaymentDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
