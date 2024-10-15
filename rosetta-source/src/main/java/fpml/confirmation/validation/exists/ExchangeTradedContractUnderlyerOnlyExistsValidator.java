package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Asset;
import fpml.confirmation.ExchangeTradedContractUnderlyer;
import fpml.confirmation.FloatingRateIndexModel;
import fpml.confirmation.QuotedCurrencyPair;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ExchangeTradedContractUnderlyerOnlyExistsValidator implements ValidatorWithArg<ExchangeTradedContractUnderlyer, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ExchangeTradedContractUnderlyer> ValidationResult<ExchangeTradedContractUnderlyer> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("floatingRateIndexModel", ExistenceChecker.isSet((FloatingRateIndexModel) o.getFloatingRateIndexModel()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("underlyingAsset", ExistenceChecker.isSet((List<? extends Asset>) o.getUnderlyingAsset()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExchangeTradedContractUnderlyer", ValidationType.ONLY_EXISTS, "ExchangeTradedContractUnderlyer", path, "");
		}
		return failure("ExchangeTradedContractUnderlyer", ValidationType.ONLY_EXISTS, "ExchangeTradedContractUnderlyer", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
