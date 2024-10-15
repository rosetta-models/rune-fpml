package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ApplicableAssets;
import fpml.confirmation.ApplicableSettlementInstructionDetails;
import fpml.confirmation.ApplicableTransactionType;
import fpml.confirmation.AssociationToAssetIdentifier;
import fpml.confirmation.SettlementDetails;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ApplicableSettlementInstructionDetailsOnlyExistsValidator implements ValidatorWithArg<ApplicableSettlementInstructionDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ApplicableSettlementInstructionDetails> ValidationResult<ApplicableSettlementInstructionDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet((AssociationToAssetIdentifier) o.getIdentifier()))
				.put("applicableAssets", ExistenceChecker.isSet((ApplicableAssets) o.getApplicableAssets()))
				.put("applicableTransactions", ExistenceChecker.isSet((List<? extends ApplicableTransactionType>) o.getApplicableTransactions()))
				.put("settlementDetails", ExistenceChecker.isSet((List<? extends SettlementDetails>) o.getSettlementDetails()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ApplicableSettlementInstructionDetails", ValidationType.ONLY_EXISTS, "ApplicableSettlementInstructionDetails", path, "");
		}
		return failure("ApplicableSettlementInstructionDetails", ValidationType.ONLY_EXISTS, "ApplicableSettlementInstructionDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
