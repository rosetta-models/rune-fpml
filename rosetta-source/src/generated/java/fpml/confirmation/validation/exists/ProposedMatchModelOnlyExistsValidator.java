package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MatchId;
import fpml.confirmation.ProposedMatchModel;
import fpml.confirmation.TradeDifference;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ProposedMatchModelOnlyExistsValidator implements ValidatorWithArg<ProposedMatchModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ProposedMatchModel> ValidationResult<ProposedMatchModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("matchId", ExistenceChecker.isSet((MatchId) o.getMatchId()))
				.put("difference", ExistenceChecker.isSet((List<? extends TradeDifference>) o.getDifference()))
				.put("matchScore", ExistenceChecker.isSet((BigDecimal) o.getMatchScore()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ProposedMatchModel", ValidationType.ONLY_EXISTS, "ProposedMatchModel", path, "");
		}
		return failure("ProposedMatchModel", ValidationType.ONLY_EXISTS, "ProposedMatchModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
