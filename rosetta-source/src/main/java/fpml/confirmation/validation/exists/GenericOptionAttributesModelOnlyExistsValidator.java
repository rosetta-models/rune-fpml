package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDate2;
import fpml.confirmation.GenericExerciseStyle;
import fpml.confirmation.GenericOptionAttributesModel;
import fpml.confirmation.GenericOptionStrike;
import fpml.confirmation.GenericProductFeature;
import fpml.confirmation.OptionType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GenericOptionAttributesModelOnlyExistsValidator implements ValidatorWithArg<GenericOptionAttributesModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GenericOptionAttributesModel> ValidationResult<GenericOptionAttributesModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("optionType", ExistenceChecker.isSet((OptionType) o.getOptionType()))
				.put("commencementDate", ExistenceChecker.isSet((AdjustableDate2) o.getCommencementDate()))
				.put("exerciseStyle", ExistenceChecker.isSet((GenericExerciseStyle) o.getExerciseStyle()))
				.put("strike", ExistenceChecker.isSet((List<? extends GenericOptionStrike>) o.getStrike()))
				.put("feature", ExistenceChecker.isSet((List<? extends GenericProductFeature>) o.getFeature()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GenericOptionAttributesModel", ValidationType.ONLY_EXISTS, "GenericOptionAttributesModel", path, "");
		}
		return failure("GenericOptionAttributesModel", ValidationType.ONLY_EXISTS, "GenericOptionAttributesModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
