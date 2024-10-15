package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.LoanPartyTradingInstructionOverrideNotification;
import fpml.confirmation.LoanTradeSummary;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingInstructionOverride;
import fpml.confirmation.ValidationModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanPartyTradingInstructionOverrideNotificationOnlyExistsValidator implements ValidatorWithArg<LoanPartyTradingInstructionOverrideNotification, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanPartyTradingInstructionOverrideNotification> ValidationResult<LoanPartyTradingInstructionOverrideNotification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((RequestMessageHeader) o.getHeader()))
				.put("validationModel", ExistenceChecker.isSet((ValidationModel) o.getValidationModel()))
				.put("isCorrection", ExistenceChecker.isSet((Boolean) o.getIsCorrection()))
				.put("correlationAndSequenceModel", ExistenceChecker.isSet((CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel()))
				.put("onBehalfOfModel", ExistenceChecker.isSet((OnBehalfOfModel) o.getOnBehalfOfModel()))
				.put("comments", ExistenceChecker.isSet((String) o.getComments()))
				.put("override", ExistenceChecker.isSet((TradingInstructionOverride) o.getOverride()))
				.put("tradeSummary", ExistenceChecker.isSet((LoanTradeSummary) o.getTradeSummary()))
				.put("facilityDetailsModel", ExistenceChecker.isSet((FacilityDetailsModel) o.getFacilityDetailsModel()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanPartyTradingInstructionOverrideNotification", ValidationType.ONLY_EXISTS, "LoanPartyTradingInstructionOverrideNotification", path, "");
		}
		return failure("LoanPartyTradingInstructionOverrideNotification", ValidationType.ONLY_EXISTS, "LoanPartyTradingInstructionOverrideNotification", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
