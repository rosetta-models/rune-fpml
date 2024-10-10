package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommitmentSchedule;
import fpml.confirmation.FacilityCommitment;
import fpml.confirmation.FacilityCommitmentModel;
import fpml.confirmation.FxTerms;
import fpml.confirmation.MoneyWithParticipantShare;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FacilityCommitmentModelOnlyExistsValidator implements ValidatorWithArg<FacilityCommitmentModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FacilityCommitmentModel> ValidationResult<FacilityCommitmentModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("currentCommitment", ExistenceChecker.isSet((FacilityCommitment) o.getCurrentCommitment()))
				.put("originalCommitment", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getOriginalCommitment()))
				.put("commitmentSchedule", ExistenceChecker.isSet((CommitmentSchedule) o.getCommitmentSchedule()))
				.put("dealFxRate", ExistenceChecker.isSet((FxTerms) o.getDealFxRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FacilityCommitmentModel", ValidationType.ONLY_EXISTS, "FacilityCommitmentModel", path, "");
		}
		return failure("FacilityCommitmentModel", ValidationType.ONLY_EXISTS, "FacilityCommitmentModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
