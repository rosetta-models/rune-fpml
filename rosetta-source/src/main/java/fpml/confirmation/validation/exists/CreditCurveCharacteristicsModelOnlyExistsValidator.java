package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditCurveCharacteristicsModel;
import fpml.confirmation.CreditEntityModel;
import fpml.confirmation.CreditEvents;
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.Currency;
import fpml.confirmation.DeliverableObligations;
import fpml.confirmation.Obligations;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditCurveCharacteristicsModelOnlyExistsValidator implements ValidatorWithArg<CreditCurveCharacteristicsModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditCurveCharacteristicsModel> ValidationResult<CreditCurveCharacteristicsModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("creditEntityModel", ExistenceChecker.isSet((CreditEntityModel) o.getCreditEntityModel()))
				.put("creditEvents", ExistenceChecker.isSet((CreditEvents) o.getCreditEvents()))
				.put("seniority", ExistenceChecker.isSet((CreditSeniority) o.getSeniority()))
				.put("secured", ExistenceChecker.isSet((Boolean) o.getSecured()))
				.put("obligationCurrency", ExistenceChecker.isSet((Currency) o.getObligationCurrency()))
				.put("obligations", ExistenceChecker.isSet((Obligations) o.getObligations()))
				.put("deliverableObligations", ExistenceChecker.isSet((DeliverableObligations) o.getDeliverableObligations()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditCurveCharacteristicsModel", ValidationType.ONLY_EXISTS, "CreditCurveCharacteristicsModel", path, "");
		}
		return failure("CreditCurveCharacteristicsModel", ValidationType.ONLY_EXISTS, "CreditCurveCharacteristicsModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
