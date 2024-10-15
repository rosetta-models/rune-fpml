package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PostTradeEventsBaseModel;
import fpml.confirmation.PostTradeEventsBaseModelSequence;
import fpml.confirmation.TradeAmendmentContent;
import fpml.confirmation.TradeNotionalChange;
import fpml.confirmation.TradeNovationContent;
import fpml.confirmation.Withdrawal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PostTradeEventsBaseModelOnlyExistsValidator implements ValidatorWithArg<PostTradeEventsBaseModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PostTradeEventsBaseModel> ValidationResult<PostTradeEventsBaseModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amendment", ExistenceChecker.isSet((TradeAmendmentContent) o.getAmendment()))
				.put("increase", ExistenceChecker.isSet((TradeNotionalChange) o.getIncrease()))
				.put("postTradeEventsBaseModelSequence", ExistenceChecker.isSet((PostTradeEventsBaseModelSequence) o.getPostTradeEventsBaseModelSequence()))
				.put("novation", ExistenceChecker.isSet((TradeNovationContent) o.getNovation()))
				.put("withdrawal", ExistenceChecker.isSet((Withdrawal) o.getWithdrawal()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PostTradeEventsBaseModel", ValidationType.ONLY_EXISTS, "PostTradeEventsBaseModel", path, "");
		}
		return failure("PostTradeEventsBaseModel", ValidationType.ONLY_EXISTS, "PostTradeEventsBaseModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
