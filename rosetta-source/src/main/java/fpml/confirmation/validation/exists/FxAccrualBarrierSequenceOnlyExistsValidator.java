package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualBarrierSequence;
import fpml.confirmation.InformationSource;
import fpml.confirmation.QuotedCurrencyPair;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualBarrierSequenceOnlyExistsValidator implements ValidatorWithArg<FxAccrualBarrierSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualBarrierSequence> ValidationResult<FxAccrualBarrierSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("informationSource", ExistenceChecker.isSet((List<? extends InformationSource>) o.getInformationSource()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualBarrierSequence", ValidationType.ONLY_EXISTS, "FxAccrualBarrierSequence", path, "");
		}
		return failure("FxAccrualBarrierSequence", ValidationType.ONLY_EXISTS, "FxAccrualBarrierSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
