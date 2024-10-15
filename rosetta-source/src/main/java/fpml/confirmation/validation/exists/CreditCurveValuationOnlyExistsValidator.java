package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AnyAssetReference;
import fpml.confirmation.CreditCurveValuation;
import fpml.confirmation.DefaultProbabilityCurve;
import fpml.confirmation.PricingInputDatesModel;
import fpml.confirmation.QuotedAssetSet;
import fpml.confirmation.RecoveryRateModel;
import fpml.confirmation.ValuationScenarioReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditCurveValuationOnlyExistsValidator implements ValidatorWithArg<CreditCurveValuation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditCurveValuation> ValidationResult<CreditCurveValuation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("objectReference", ExistenceChecker.isSet((AnyAssetReference) o.getObjectReference()))
				.put("valuationScenarioReference", ExistenceChecker.isSet((ValuationScenarioReference) o.getValuationScenarioReference()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("definitionRef", ExistenceChecker.isSet((String) o.getDefinitionRef()))
				.put("pricingInputDatesModel", ExistenceChecker.isSet((PricingInputDatesModel) o.getPricingInputDatesModel()))
				.put("inputs", ExistenceChecker.isSet((QuotedAssetSet) o.getInputs()))
				.put("defaultProbabilityCurve", ExistenceChecker.isSet((DefaultProbabilityCurve) o.getDefaultProbabilityCurve()))
				.put("recoveryRateModel", ExistenceChecker.isSet((RecoveryRateModel) o.getRecoveryRateModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditCurveValuation", ValidationType.ONLY_EXISTS, "CreditCurveValuation", path, "");
		}
		return failure("CreditCurveValuation", ValidationType.ONLY_EXISTS, "CreditCurveValuation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
