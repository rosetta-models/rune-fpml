package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Formula;
import fpml.confirmation.FormulaComponent;
import fpml.confirmation.Math;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FormulaOnlyExistsValidator implements ValidatorWithArg<Formula, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Formula> ValidationResult<Formula> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("formulaDescription", ExistenceChecker.isSet((String) o.getFormulaDescription()))
				.put("math", ExistenceChecker.isSet((Math) o.getMath()))
				.put("formulaComponent", ExistenceChecker.isSet((List<? extends FormulaComponent>) o.getFormulaComponent()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Formula", ValidationType.ONLY_EXISTS, "Formula", path, "");
		}
		return failure("Formula", ValidationType.ONLY_EXISTS, "Formula", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
