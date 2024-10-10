package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Formula;
import fpml.confirmation.FormulaComponent;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FormulaComponentOnlyExistsValidator implements ValidatorWithArg<FormulaComponent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FormulaComponent> ValidationResult<FormulaComponent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("componentDescription", ExistenceChecker.isSet((String) o.getComponentDescription()))
				.put("formula", ExistenceChecker.isSet((Formula) o.getFormula()))
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FormulaComponent", ValidationType.ONLY_EXISTS, "FormulaComponent", path, "");
		}
		return failure("FormulaComponent", ValidationType.ONLY_EXISTS, "FormulaComponent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
