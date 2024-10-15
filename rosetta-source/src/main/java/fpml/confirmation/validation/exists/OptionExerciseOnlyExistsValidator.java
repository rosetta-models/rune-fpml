package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.ClearingInstructions;
import fpml.confirmation.ExerciseSideEnum;
import fpml.confirmation.ExerciseTimingEnum;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.OptionExercise;
import fpml.confirmation.OptionExerciseAmountModel;
import fpml.confirmation.OptionExerciseSequence;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.PhysicalSettlement;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.SimplePayment;
import fpml.confirmation.Trade;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionExerciseOnlyExistsValidator implements ValidatorWithArg<OptionExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionExercise> ValidationResult<OptionExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("optionSeller", ExistenceChecker.isSet((PartyReference) o.getOptionSeller()))
				.put("optionBuyer", ExistenceChecker.isSet((PartyReference) o.getOptionBuyer()))
				.put("originalTrade", ExistenceChecker.isSet((Trade) o.getOriginalTrade()))
				.put("tradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getTradeIdentifier()))
				.put("optionExerciseSequence", ExistenceChecker.isSet((OptionExerciseSequence) o.getOptionExerciseSequence()))
				.put("exerciseTiming", ExistenceChecker.isSet((ExerciseTimingEnum) o.getExerciseTiming()))
				.put("optionExerciseAmountModel", ExistenceChecker.isSet((OptionExerciseAmountModel) o.getOptionExerciseAmountModel()))
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
			return success("OptionExercise", ValidationType.ONLY_EXISTS, "OptionExercise", path, "");
		}
		return failure("OptionExercise", ValidationType.ONLY_EXISTS, "OptionExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
