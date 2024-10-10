package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConditionEnum;
import fpml.confirmation.FxAccrualBarrier;
import fpml.confirmation.FxAccrualBarrierSequence;
import fpml.confirmation.FxAccrualKnockoutBarrierRetentionEnum;
import fpml.confirmation.FxBarrierScopeEnum;
import fpml.confirmation.FxBarrierStyleEnum;
import fpml.confirmation.FxBarrierTypeSimpleEnum;
import fpml.confirmation.FxComplexBarrierBaseSequence0;
import fpml.confirmation.FxComplexBarrierBaseSequence1;
import fpml.confirmation.FxRateObservableReference;
import fpml.confirmation.Schedule;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualBarrierOnlyExistsValidator implements ValidatorWithArg<FxAccrualBarrier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualBarrier> ValidationResult<FxAccrualBarrier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("barrierType", ExistenceChecker.isSet((FxBarrierTypeSimpleEnum) o.getBarrierType()))
				.put("style", ExistenceChecker.isSet((FxBarrierStyleEnum) o.getStyle()))
				.put("scope", ExistenceChecker.isSet((FxBarrierScopeEnum) o.getScope()))
				.put("condition", ExistenceChecker.isSet((ConditionEnum) o.getCondition()))
				.put("triggerRate", ExistenceChecker.isSet((Schedule) o.getTriggerRate()))
				.put("fxComplexBarrierBaseSequence0", ExistenceChecker.isSet((FxComplexBarrierBaseSequence0) o.getFxComplexBarrierBaseSequence0()))
				.put("fxComplexBarrierBaseSequence1", ExistenceChecker.isSet((FxComplexBarrierBaseSequence1) o.getFxComplexBarrierBaseSequence1()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("accrualRetention", ExistenceChecker.isSet((FxAccrualKnockoutBarrierRetentionEnum) o.getAccrualRetention()))
				.put("observableReference", ExistenceChecker.isSet((FxRateObservableReference) o.getObservableReference()))
				.put("fxAccrualBarrierSequence", ExistenceChecker.isSet((FxAccrualBarrierSequence) o.getFxAccrualBarrierSequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualBarrier", ValidationType.ONLY_EXISTS, "FxAccrualBarrier", path, "");
		}
		return failure("FxAccrualBarrier", ValidationType.ONLY_EXISTS, "FxAccrualBarrier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
