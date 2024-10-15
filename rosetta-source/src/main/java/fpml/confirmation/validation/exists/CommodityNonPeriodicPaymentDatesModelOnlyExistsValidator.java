package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDatesOrRelativeDateOffset;
import fpml.confirmation.CommodityNonPeriodicPaymentDatesModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityNonPeriodicPaymentDatesModelOnlyExistsValidator implements ValidatorWithArg<CommodityNonPeriodicPaymentDatesModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityNonPeriodicPaymentDatesModel> ValidationResult<CommodityNonPeriodicPaymentDatesModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("paymentDates", ExistenceChecker.isSet((AdjustableDatesOrRelativeDateOffset) o.getPaymentDates()))
				.put("masterAgreementPaymentDates", ExistenceChecker.isSet((Boolean) o.getMasterAgreementPaymentDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityNonPeriodicPaymentDatesModel", ValidationType.ONLY_EXISTS, "CommodityNonPeriodicPaymentDatesModel", path, "");
		}
		return failure("CommodityNonPeriodicPaymentDatesModel", ValidationType.ONLY_EXISTS, "CommodityNonPeriodicPaymentDatesModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
