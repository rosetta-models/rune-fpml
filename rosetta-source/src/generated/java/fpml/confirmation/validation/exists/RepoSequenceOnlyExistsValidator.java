package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOffset;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CallingPartyEnum;
import fpml.confirmation.PartyNoticePeriod;
import fpml.confirmation.RepoSequence;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RepoSequenceOnlyExistsValidator implements ValidatorWithArg<RepoSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RepoSequence> ValidationResult<RepoSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("callingParty", ExistenceChecker.isSet((CallingPartyEnum) o.getCallingParty()))
				.put("callDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getCallDate()))
				.put("noticePeriod", ExistenceChecker.isSet((AdjustableOffset) o.getNoticePeriod()))
				.put("partyNoticePeriod", ExistenceChecker.isSet((List<? extends PartyNoticePeriod>) o.getPartyNoticePeriod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RepoSequence", ValidationType.ONLY_EXISTS, "RepoSequence", path, "");
		}
		return failure("RepoSequence", ValidationType.ONLY_EXISTS, "RepoSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
