package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AnyAssetReference;
import fpml.confirmation.AssetValuation;
import fpml.confirmation.FxRate;
import fpml.confirmation.Quotation;
import fpml.confirmation.ValuationScenarioReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetValuationOnlyExistsValidator implements ValidatorWithArg<AssetValuation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetValuation> ValidationResult<AssetValuation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("objectReference", ExistenceChecker.isSet((AnyAssetReference) o.getObjectReference()))
				.put("valuationScenarioReference", ExistenceChecker.isSet((ValuationScenarioReference) o.getValuationScenarioReference()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("definitionRef", ExistenceChecker.isSet((String) o.getDefinitionRef()))
				.put("quote", ExistenceChecker.isSet((List<? extends Quotation>) o.getQuote()))
				.put("fxRate", ExistenceChecker.isSet((List<? extends FxRate>) o.getFxRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetValuation", ValidationType.ONLY_EXISTS, "AssetValuation", path, "");
		}
		return failure("AssetValuation", ValidationType.ONLY_EXISTS, "AssetValuation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
