package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxCrossRateObservable;
import fpml.confirmation.FxInformationSource;
import fpml.confirmation.QuotedCurrencyPair;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxCrossRateObservableOnlyExistsValidator implements ValidatorWithArg<FxCrossRateObservable, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxCrossRateObservable> ValidationResult<FxCrossRateObservable> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("informationSource", ExistenceChecker.isSet((FxInformationSource) o.getInformationSource()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxCrossRateObservable", ValidationType.ONLY_EXISTS, "FxCrossRateObservable", path, "");
		}
		return failure("FxCrossRateObservable", ValidationType.ONLY_EXISTS, "FxCrossRateObservable", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
