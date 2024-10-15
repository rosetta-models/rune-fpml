package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingInstructions;
import fpml.confirmation.ExerciseSideEnum;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.PhysicalSettlement;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.SimplePayment;
import fpml.confirmation.TouchRateObservationSequence;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TouchRateObservationSequenceOnlyExistsValidator implements ValidatorWithArg<TouchRateObservationSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TouchRateObservationSequence> ValidationResult<TouchRateObservationSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("exerciseSide", ExistenceChecker.isSet((ExerciseSideEnum) o.getExerciseSide()))
				.put("settlementType", ExistenceChecker.isSet((SettlementTypeEnum) o.getSettlementType()))
				.put("cashSettlement", ExistenceChecker.isSet((SimplePayment) o.getCashSettlement()))
				.put("physicalSettlement", ExistenceChecker.isSet((PhysicalSettlement) o.getPhysicalSettlement()))
				.put("payment", ExistenceChecker.isSet((NonNegativePayment) o.getPayment()))
				.put("clearingInstructions", ExistenceChecker.isSet((ClearingInstructions) o.getClearingInstructions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TouchRateObservationSequence", ValidationType.ONLY_EXISTS, "TouchRateObservationSequence", path, "");
		}
		return failure("TouchRateObservationSequence", ValidationType.ONLY_EXISTS, "TouchRateObservationSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
