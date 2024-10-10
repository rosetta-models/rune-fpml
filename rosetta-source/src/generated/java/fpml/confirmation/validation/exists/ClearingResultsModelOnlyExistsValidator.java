package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Clearing;
import fpml.confirmation.ClearingResultsModel;
import fpml.confirmation.ClearingResultsModelSequence;
import fpml.confirmation.DeClear;
import fpml.confirmation.TradingEventsModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ClearingResultsModelOnlyExistsValidator implements ValidatorWithArg<ClearingResultsModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ClearingResultsModel> ValidationResult<ClearingResultsModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradingEventsModel", ExistenceChecker.isSet((TradingEventsModel) o.getTradingEventsModel()))
				.put("clearingResultsModelSequence", ExistenceChecker.isSet((ClearingResultsModelSequence) o.getClearingResultsModelSequence()))
				.put("deClear", ExistenceChecker.isSet((DeClear) o.getDeClear()))
				.put("clearing", ExistenceChecker.isSet((Clearing) o.getClearing()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ClearingResultsModel", ValidationType.ONLY_EXISTS, "ClearingResultsModel", path, "");
		}
		return failure("ClearingResultsModel", ValidationType.ONLY_EXISTS, "ClearingResultsModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
