package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxFixing;
import fpml.confirmation.FxSpotRateSource;
import fpml.confirmation.QuotedCurrencyPair;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxFixingOnlyExistsValidator implements ValidatorWithArg<FxFixing, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxFixing> ValidationResult<FxFixing> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("fixingDate", ExistenceChecker.isSet((Date) o.getFixingDate()))
				.put("fxSpotRateSource", ExistenceChecker.isSet((FxSpotRateSource) o.getFxSpotRateSource()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxFixing", ValidationType.ONLY_EXISTS, "FxFixing", path, "");
		}
		return failure("FxFixing", ValidationType.ONLY_EXISTS, "FxFixing", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
