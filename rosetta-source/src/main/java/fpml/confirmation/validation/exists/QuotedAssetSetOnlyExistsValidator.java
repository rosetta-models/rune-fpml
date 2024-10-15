package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasicAssetValuation;
import fpml.confirmation.InstrumentSet;
import fpml.confirmation.QuotedAssetSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class QuotedAssetSetOnlyExistsValidator implements ValidatorWithArg<QuotedAssetSet, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends QuotedAssetSet> ValidationResult<QuotedAssetSet> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("instrumentSet", ExistenceChecker.isSet((InstrumentSet) o.getInstrumentSet()))
				.put("assetQuote", ExistenceChecker.isSet((List<? extends BasicAssetValuation>) o.getAssetQuote()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("QuotedAssetSet", ValidationType.ONLY_EXISTS, "QuotedAssetSet", path, "");
		}
		return failure("QuotedAssetSet", ValidationType.ONLY_EXISTS, "QuotedAssetSet", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
