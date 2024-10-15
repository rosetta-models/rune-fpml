package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Stub;
import fpml.confirmation.StubCalculationPeriod;
import fpml.confirmation.StubCalculationPeriodSequence;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class StubCalculationPeriodOnlyExistsValidator implements ValidatorWithArg<StubCalculationPeriod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends StubCalculationPeriod> ValidationResult<StubCalculationPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("stubCalculationPeriodSequence", ExistenceChecker.isSet((StubCalculationPeriodSequence) o.getStubCalculationPeriodSequence()))
				.put("finalStub", ExistenceChecker.isSet((Stub) o.getFinalStub()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("StubCalculationPeriod", ValidationType.ONLY_EXISTS, "StubCalculationPeriod", path, "");
		}
		return failure("StubCalculationPeriod", ValidationType.ONLY_EXISTS, "StubCalculationPeriod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
