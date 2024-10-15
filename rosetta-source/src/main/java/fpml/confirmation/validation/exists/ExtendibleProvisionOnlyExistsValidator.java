package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseNotice;
import fpml.confirmation.ExtendibleProvision;
import fpml.confirmation.ExtendibleProvisionAdjustedDates;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ExtendibleProvisionOnlyExistsValidator implements ValidatorWithArg<ExtendibleProvision, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ExtendibleProvision> ValidationResult<ExtendibleProvision> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("exercise", ExistenceChecker.isSet((Exercise) o.getExercise()))
				.put("exerciseNotice", ExistenceChecker.isSet((ExerciseNotice) o.getExerciseNotice()))
				.put("followUpConfirmation", ExistenceChecker.isSet((Boolean) o.getFollowUpConfirmation()))
				.put("extendibleProvisionAdjustedDates", ExistenceChecker.isSet((ExtendibleProvisionAdjustedDates) o.getExtendibleProvisionAdjustedDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExtendibleProvision", ValidationType.ONLY_EXISTS, "ExtendibleProvision", path, "");
		}
		return failure("ExtendibleProvision", ValidationType.ONLY_EXISTS, "ExtendibleProvision", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
