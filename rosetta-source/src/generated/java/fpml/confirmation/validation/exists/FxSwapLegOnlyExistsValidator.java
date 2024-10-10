package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxCoreDetailsModel;
import fpml.confirmation.FxSwapLeg;
import fpml.confirmation.PartyTradeIdentifierReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxSwapLegOnlyExistsValidator implements ValidatorWithArg<FxSwapLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxSwapLeg> ValidationResult<FxSwapLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("tradeIdentifierReference", ExistenceChecker.isSet((List<? extends PartyTradeIdentifierReference>) o.getTradeIdentifierReference()))
				.put("fxCoreDetailsModel", ExistenceChecker.isSet((FxCoreDetailsModel) o.getFxCoreDetailsModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxSwapLeg", ValidationType.ONLY_EXISTS, "FxSwapLeg", path, "");
		}
		return failure("FxSwapLeg", ValidationType.ONLY_EXISTS, "FxSwapLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
