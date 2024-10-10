package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetValuation;
import fpml.confirmation.PartyReference;
import fpml.confirmation.QuotationCharacteristics;
import fpml.confirmation.SensitivitySetDefinition;
import fpml.confirmation.ValuationScenario;
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.ValuationSet;
import fpml.confirmation.ValuationSetDetail;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ValuationSetOnlyExistsValidator implements ValidatorWithArg<ValuationSet, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ValuationSet> ValidationResult<ValuationSet> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("valuationScenario", ExistenceChecker.isSet((List<? extends ValuationScenario>) o.getValuationScenario()))
				.put("valuationScenarioReference", ExistenceChecker.isSet((List<? extends ValuationScenarioReference>) o.getValuationScenarioReference()))
				.put("baseParty", ExistenceChecker.isSet((PartyReference) o.getBaseParty()))
				.put("quotationCharacteristics", ExistenceChecker.isSet((List<? extends QuotationCharacteristics>) o.getQuotationCharacteristics()))
				.put("sensitivitySetDefinition", ExistenceChecker.isSet((List<? extends SensitivitySetDefinition>) o.getSensitivitySetDefinition()))
				.put("detail", ExistenceChecker.isSet((ValuationSetDetail) o.getDetail()))
				.put("assetValuation", ExistenceChecker.isSet((List<? extends AssetValuation>) o.getAssetValuation()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ValuationSet", ValidationType.ONLY_EXISTS, "ValuationSet", path, "");
		}
		return failure("ValuationSet", ValidationType.ONLY_EXISTS, "ValuationSet", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
