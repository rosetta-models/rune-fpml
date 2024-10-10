package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NumberOfOptionsReference;
import fpml.confirmation.TradeLegNumberOfOptionsChangeModel;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeLegNumberOfOptionsChangeModelOnlyExistsValidator implements ValidatorWithArg<TradeLegNumberOfOptionsChangeModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeLegNumberOfOptionsChangeModel> ValidationResult<TradeLegNumberOfOptionsChangeModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("numberOfOptionsReference", ExistenceChecker.isSet((NumberOfOptionsReference) o.getNumberOfOptionsReference()))
				.put("changeInNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getChangeInNumberOfOptions()))
				.put("outstandingNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfOptions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeLegNumberOfOptionsChangeModel", ValidationType.ONLY_EXISTS, "TradeLegNumberOfOptionsChangeModel", path, "");
		}
		return failure("TradeLegNumberOfOptionsChangeModel", ValidationType.ONLY_EXISTS, "TradeLegNumberOfOptionsChangeModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
