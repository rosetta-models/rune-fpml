package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.OptionExercise;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.RequestExecutionRetracted;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingEventsModel;
import fpml.confirmation.ValidationModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RequestExecutionRetractedOnlyExistsValidator implements ValidatorWithArg<RequestExecutionRetracted, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RequestExecutionRetracted> ValidationResult<RequestExecutionRetracted> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((RequestMessageHeader) o.getHeader()))
				.put("validationModel", ExistenceChecker.isSet((ValidationModel) o.getValidationModel()))
				.put("correlationAndSequenceModel", ExistenceChecker.isSet((CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel()))
				.put("onBehalfOfModel", ExistenceChecker.isSet((OnBehalfOfModel) o.getOnBehalfOfModel()))
				.put("tradingEventsModel", ExistenceChecker.isSet((TradingEventsModel) o.getTradingEventsModel()))
				.put("optionExercise", ExistenceChecker.isSet((OptionExercise) o.getOptionExercise()))
				.put("partiesAndAccountsModel", ExistenceChecker.isSet((PartiesAndAccountsModel) o.getPartiesAndAccountsModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RequestExecutionRetracted", ValidationType.ONLY_EXISTS, "RequestExecutionRetracted", path, "");
		}
		return failure("RequestExecutionRetracted", ValidationType.ONLY_EXISTS, "RequestExecutionRetracted", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
