package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PortfolioReferenceBase;
import fpml.confirmation.PortfolioReferenceBaseModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PortfolioReferenceBaseModelOnlyExistsValidator implements ValidatorWithArg<PortfolioReferenceBaseModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PortfolioReferenceBaseModel> ValidationResult<PortfolioReferenceBaseModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("portfolioReference", ExistenceChecker.isSet((PortfolioReferenceBase) o.getPortfolioReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PortfolioReferenceBaseModel", ValidationType.ONLY_EXISTS, "PortfolioReferenceBaseModel", path, "");
		}
		return failure("PortfolioReferenceBaseModel", ValidationType.ONLY_EXISTS, "PortfolioReferenceBaseModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
