package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasketIdentifierModel;
import fpml.confirmation.BasketReferenceInformation;
import fpml.confirmation.BasketReferenceInformationSequence;
import fpml.confirmation.ReferencePool;
import fpml.confirmation.Tranche;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BasketReferenceInformationOnlyExistsValidator implements ValidatorWithArg<BasketReferenceInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BasketReferenceInformation> ValidationResult<BasketReferenceInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basketIdentifierModel", ExistenceChecker.isSet((BasketIdentifierModel) o.getBasketIdentifierModel()))
				.put("referencePool", ExistenceChecker.isSet((ReferencePool) o.getReferencePool()))
				.put("basketReferenceInformationSequence", ExistenceChecker.isSet((BasketReferenceInformationSequence) o.getBasketReferenceInformationSequence()))
				.put("tranche", ExistenceChecker.isSet((Tranche) o.getTranche()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BasketReferenceInformation", ValidationType.ONLY_EXISTS, "BasketReferenceInformation", path, "");
		}
		return failure("BasketReferenceInformation", ValidationType.ONLY_EXISTS, "BasketReferenceInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
