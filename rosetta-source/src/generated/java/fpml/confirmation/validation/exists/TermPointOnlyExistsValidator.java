package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetReference;
import fpml.confirmation.BidMidAskModel;
import fpml.confirmation.TermPoint;
import fpml.confirmation.TimeDimension;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TermPointOnlyExistsValidator implements ValidatorWithArg<TermPoint, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TermPoint> ValidationResult<TermPoint> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("term", ExistenceChecker.isSet((TimeDimension) o.getTerm()))
				.put("bidMidAskModel", ExistenceChecker.isSet((BidMidAskModel) o.getBidMidAskModel()))
				.put("spreadValue", ExistenceChecker.isSet((BigDecimal) o.getSpreadValue()))
				.put("definition", ExistenceChecker.isSet((AssetReference) o.getDefinition()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TermPoint", ValidationType.ONLY_EXISTS, "TermPoint", path, "");
		}
		return failure("TermPoint", ValidationType.ONLY_EXISTS, "TermPoint", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
