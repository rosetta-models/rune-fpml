package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustmentType;
import fpml.confirmation.CommitmentChange;
import fpml.confirmation.MoneyWithParticipantShare;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommitmentChangeOnlyExistsValidator implements ValidatorWithArg<CommitmentChange, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommitmentChange> ValidationResult<CommitmentChange> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("date", ExistenceChecker.isSet((Date) o.getDate()))
				.put("adjustment", ExistenceChecker.isSet((AdjustmentType) o.getAdjustment()))
				.put("remaining", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getRemaining()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommitmentChange", ValidationType.ONLY_EXISTS, "CommitmentChange", path, "");
		}
		return failure("CommitmentChange", ValidationType.ONLY_EXISTS, "CommitmentChange", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
