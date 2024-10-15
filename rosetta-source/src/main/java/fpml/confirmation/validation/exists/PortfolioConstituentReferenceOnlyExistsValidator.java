package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PortfolioConstituentReference;
import fpml.confirmation.PortfolioName;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PortfolioConstituentReferenceOnlyExistsValidator implements ValidatorWithArg<PortfolioConstituentReference, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PortfolioConstituentReference> ValidationResult<PortfolioConstituentReference> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("portfolioName", ExistenceChecker.isSet((PortfolioName) o.getPortfolioName()))
				.put("sequenceNumber", ExistenceChecker.isSet((Integer) o.getSequenceNumber()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PortfolioConstituentReference", ValidationType.ONLY_EXISTS, "PortfolioConstituentReference", path, "");
		}
		return failure("PortfolioConstituentReference", ValidationType.ONLY_EXISTS, "PortfolioConstituentReference", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
