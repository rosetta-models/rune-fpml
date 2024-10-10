package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxPivot;
import fpml.confirmation.FxTargetConstantPayoffRegion;
import fpml.confirmation.FxTargetKnockoutForwardSequence;
import fpml.confirmation.FxTargetLinearPayoffRegion;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetKnockoutForwardSequenceOnlyExistsValidator implements ValidatorWithArg<FxTargetKnockoutForwardSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTargetKnockoutForwardSequence> ValidationResult<FxTargetKnockoutForwardSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("pivot", ExistenceChecker.isSet((FxPivot) o.getPivot()))
				.put("constantPayoffRegion", ExistenceChecker.isSet((List<? extends FxTargetConstantPayoffRegion>) o.getConstantPayoffRegion()))
				.put("linearPayoffRegion", ExistenceChecker.isSet((FxTargetLinearPayoffRegion) o.getLinearPayoffRegion()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTargetKnockoutForwardSequence", ValidationType.ONLY_EXISTS, "FxTargetKnockoutForwardSequence", path, "");
		}
		return failure("FxTargetKnockoutForwardSequence", ValidationType.ONLY_EXISTS, "FxTargetKnockoutForwardSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
