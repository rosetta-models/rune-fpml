package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetConstantPayoffRegion;
import fpml.confirmation.FxTargetKnockoutForwardChoice;
import fpml.confirmation.FxTargetLinearPayoffRegion;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetKnockoutForwardChoiceOnlyExistsValidator implements ValidatorWithArg<FxTargetKnockoutForwardChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTargetKnockoutForwardChoice> ValidationResult<FxTargetKnockoutForwardChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("constantPayoffRegion", ExistenceChecker.isSet((FxTargetConstantPayoffRegion) o.getConstantPayoffRegion()))
				.put("linearPayoffRegion", ExistenceChecker.isSet((FxTargetLinearPayoffRegion) o.getLinearPayoffRegion()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTargetKnockoutForwardChoice", ValidationType.ONLY_EXISTS, "FxTargetKnockoutForwardChoice", path, "");
		}
		return failure("FxTargetKnockoutForwardChoice", ValidationType.ONLY_EXISTS, "FxTargetKnockoutForwardChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
