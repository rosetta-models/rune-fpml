package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventPayment;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.LoanBulkServicingNotification;
import fpml.confirmation.LoanBulkServicingNotificationChoice0;
import fpml.confirmation.LoanBulkServicingNotificationChoice1;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanBulkServicingNotificationOnlyExistsValidator implements ValidatorWithArg<LoanBulkServicingNotification, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanBulkServicingNotification> ValidationResult<LoanBulkServicingNotification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((RequestMessageHeader) o.getHeader()))
				.put("validationModel", ExistenceChecker.isSet((ValidationModel) o.getValidationModel()))
				.put("isCorrection", ExistenceChecker.isSet((Boolean) o.getIsCorrection()))
				.put("correlationAndSequenceModel", ExistenceChecker.isSet((CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel()))
				.put("onBehalfOfModel", ExistenceChecker.isSet((OnBehalfOfModel) o.getOnBehalfOfModel()))
				.put("noticeDate", ExistenceChecker.isSet((Date) o.getNoticeDate()))
				.put("isGlobalOnly", ExistenceChecker.isSet((Boolean) o.getIsGlobalOnly()))
				.put("eventPayment", ExistenceChecker.isSet((List<? extends EventPayment>) o.getEventPayment()))
				.put("facilityOutstandingsPosition", ExistenceChecker.isSet((List<? extends FacilityOutstandingsPosition>) o.getFacilityOutstandingsPosition()))
				.put("loanBulkServicingNotificationChoice0", ExistenceChecker.isSet((List<? extends LoanBulkServicingNotificationChoice0>) o.getLoanBulkServicingNotificationChoice0()))
				.put("loanBulkServicingNotificationChoice1", ExistenceChecker.isSet((List<? extends LoanBulkServicingNotificationChoice1>) o.getLoanBulkServicingNotificationChoice1()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanBulkServicingNotification", ValidationType.ONLY_EXISTS, "LoanBulkServicingNotification", path, "");
		}
		return failure("LoanBulkServicingNotification", ValidationType.ONLY_EXISTS, "LoanBulkServicingNotification", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
