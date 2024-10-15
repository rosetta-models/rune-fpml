package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DifferenceSeverityEnum;
import fpml.confirmation.DifferenceTypeEnum;
import fpml.confirmation.TradeDifference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeDifferenceOnlyExistsValidator implements ValidatorWithArg<TradeDifference, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeDifference> ValidationResult<TradeDifference> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("differenceType", ExistenceChecker.isSet((DifferenceTypeEnum) o.getDifferenceType()))
				.put("differenceSeverity", ExistenceChecker.isSet((DifferenceSeverityEnum) o.getDifferenceSeverity()))
				.put("element", ExistenceChecker.isSet((String) o.getElement()))
				.put("basePath", ExistenceChecker.isSet((String) o.getBasePath()))
				.put("baseValue", ExistenceChecker.isSet((String) o.getBaseValue()))
				.put("otherPath", ExistenceChecker.isSet((String) o.getOtherPath()))
				.put("otherValue", ExistenceChecker.isSet((String) o.getOtherValue()))
				.put("missingElement", ExistenceChecker.isSet((List<String>) o.getMissingElement()))
				.put("extraElement", ExistenceChecker.isSet((List<String>) o.getExtraElement()))
				.put("message", ExistenceChecker.isSet((String) o.getMessage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeDifference", ValidationType.ONLY_EXISTS, "TradeDifference", path, "");
		}
		return failure("TradeDifference", ValidationType.ONLY_EXISTS, "TradeDifference", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
