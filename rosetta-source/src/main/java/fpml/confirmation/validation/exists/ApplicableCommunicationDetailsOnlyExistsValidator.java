package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ApplicableAssets;
import fpml.confirmation.ApplicableCommunicationDetails;
import fpml.confirmation.ApplicablePurpose;
import fpml.confirmation.ApplicableTransactionType;
import fpml.confirmation.AssociationToAssetIdentifier;
import fpml.confirmation.BusinessUnitReference;
import fpml.confirmation.PersonReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ApplicableCommunicationDetailsOnlyExistsValidator implements ValidatorWithArg<ApplicableCommunicationDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ApplicableCommunicationDetails> ValidationResult<ApplicableCommunicationDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet((AssociationToAssetIdentifier) o.getIdentifier()))
				.put("applicableAssets", ExistenceChecker.isSet((ApplicableAssets) o.getApplicableAssets()))
				.put("applicableTransactions", ExistenceChecker.isSet((List<? extends ApplicableTransactionType>) o.getApplicableTransactions()))
				.put("purpose", ExistenceChecker.isSet((ApplicablePurpose) o.getPurpose()))
				.put("businessUnitReference", ExistenceChecker.isSet((BusinessUnitReference) o.getBusinessUnitReference()))
				.put("personReference", ExistenceChecker.isSet((PersonReference) o.getPersonReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ApplicableCommunicationDetails", ValidationType.ONLY_EXISTS, "ApplicableCommunicationDetails", path, "");
		}
		return failure("ApplicableCommunicationDetails", ValidationType.ONLY_EXISTS, "ApplicableCommunicationDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
