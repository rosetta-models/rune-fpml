package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxBarrierFeature;
import fpml.confirmation.FxOptionFeatures;
import fpml.confirmation.FxOptionFeaturesSequence;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxOptionFeaturesOnlyExistsValidator implements ValidatorWithArg<FxOptionFeatures, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxOptionFeatures> ValidationResult<FxOptionFeatures> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fxOptionFeaturesSequence", ExistenceChecker.isSet((FxOptionFeaturesSequence) o.getFxOptionFeaturesSequence()))
				.put("barrier", ExistenceChecker.isSet((List<? extends FxBarrierFeature>) o.getBarrier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxOptionFeatures", ValidationType.ONLY_EXISTS, "FxOptionFeatures", path, "");
		}
		return failure("FxOptionFeatures", ValidationType.ONLY_EXISTS, "FxOptionFeatures", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
