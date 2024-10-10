package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.DateOffset;
import fpml.confirmation.EEPParameters;
import fpml.confirmation.EnvironmentalAbandonmentOfSchemeEnum;
import fpml.confirmation.EnvironmentalPhysicalLeg;
import fpml.confirmation.EnvironmentalProduct;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.UnitQuantity;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EnvironmentalPhysicalLegOnlyExistsValidator implements ValidatorWithArg<EnvironmentalPhysicalLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EnvironmentalPhysicalLeg> ValidationResult<EnvironmentalPhysicalLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("numberOfAllowances", ExistenceChecker.isSet((UnitQuantity) o.getNumberOfAllowances()))
				.put("environmental", ExistenceChecker.isSet((EnvironmentalProduct) o.getEnvironmental()))
				.put("abandonmentOfScheme", ExistenceChecker.isSet((EnvironmentalAbandonmentOfSchemeEnum) o.getAbandonmentOfScheme()))
				.put("deliveryDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getDeliveryDate()))
				.put("paymentDate", ExistenceChecker.isSet((DateOffset) o.getPaymentDate()))
				.put("businessCentersOrReferenceModel", ExistenceChecker.isSet((BusinessCentersOrReferenceModel) o.getBusinessCentersOrReferenceModel()))
				.put("failureToDeliverApplicable", ExistenceChecker.isSet((Boolean) o.getFailureToDeliverApplicable()))
				.put("eEPParameters", ExistenceChecker.isSet((EEPParameters) o.getEEPParameters()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EnvironmentalPhysicalLeg", ValidationType.ONLY_EXISTS, "EnvironmentalPhysicalLeg", path, "");
		}
		return failure("EnvironmentalPhysicalLeg", ValidationType.ONLY_EXISTS, "EnvironmentalPhysicalLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
