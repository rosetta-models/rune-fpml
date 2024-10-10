package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CountryCode;
import fpml.confirmation.EquityUnderlyerProvisionsModel;
import fpml.confirmation.IndexAnnexFallbackModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquityUnderlyerProvisionsModelOnlyExistsValidator implements ValidatorWithArg<EquityUnderlyerProvisionsModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquityUnderlyerProvisionsModel> ValidationResult<EquityUnderlyerProvisionsModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("indexAnnexFallbackModel", ExistenceChecker.isSet((IndexAnnexFallbackModel) o.getIndexAnnexFallbackModel()))
				.put("localJurisdiction", ExistenceChecker.isSet((CountryCode) o.getLocalJurisdiction()))
				.put("relevantJurisdiction", ExistenceChecker.isSet((CountryCode) o.getRelevantJurisdiction()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityUnderlyerProvisionsModel", ValidationType.ONLY_EXISTS, "EquityUnderlyerProvisionsModel", path, "");
		}
		return failure("EquityUnderlyerProvisionsModel", ValidationType.ONLY_EXISTS, "EquityUnderlyerProvisionsModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
