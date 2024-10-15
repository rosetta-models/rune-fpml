package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetReference;
import fpml.confirmation.ForwardRateCurve;
import fpml.confirmation.TermCurve;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ForwardRateCurveOnlyExistsValidator implements ValidatorWithArg<ForwardRateCurve, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ForwardRateCurve> ValidationResult<ForwardRateCurve> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("assetReference", ExistenceChecker.isSet((AssetReference) o.getAssetReference()))
				.put("rateCurve", ExistenceChecker.isSet((TermCurve) o.getRateCurve()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ForwardRateCurve", ValidationType.ONLY_EXISTS, "ForwardRateCurve", path, "");
		}
		return failure("ForwardRateCurve", ValidationType.ONLY_EXISTS, "ForwardRateCurve", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
