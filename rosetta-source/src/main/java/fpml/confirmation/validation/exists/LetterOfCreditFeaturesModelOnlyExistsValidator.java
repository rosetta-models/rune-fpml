package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EvergreenOption;
import fpml.confirmation.LcAutoAdjustEnum;
import fpml.confirmation.LetterOfCreditFeaturesModel;
import fpml.confirmation.MoneyWithParticipantShare;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LetterOfCreditFeaturesModelOnlyExistsValidator implements ValidatorWithArg<LetterOfCreditFeaturesModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LetterOfCreditFeaturesModel> ValidationResult<LetterOfCreditFeaturesModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("evergreenOption", ExistenceChecker.isSet((EvergreenOption) o.getEvergreenOption()))
				.put("lcAutoAdjust", ExistenceChecker.isSet((LcAutoAdjustEnum) o.getLcAutoAdjust()))
				.put("minLcIssuanceFeeAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getMinLcIssuanceFeeAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LetterOfCreditFeaturesModel", ValidationType.ONLY_EXISTS, "LetterOfCreditFeaturesModel", path, "");
		}
		return failure("LetterOfCreditFeaturesModel", ValidationType.ONLY_EXISTS, "LetterOfCreditFeaturesModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
