package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.UpfrontFeePayment;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class UpfrontFeePaymentOnlyExistsValidator implements ValidatorWithArg<UpfrontFeePayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends UpfrontFeePayment> ValidationResult<UpfrontFeePayment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("parentEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getParentEventIdentifier()))
				.put("correctedEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getCorrectedEventIdentifier()))
				.put("lenderAndCashDetailsModel", ExistenceChecker.isSet((LenderAndCashDetailsModel) o.getLenderAndCashDetailsModel()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("businessEventPartiesModel", ExistenceChecker.isSet((BusinessEventPartiesModel) o.getBusinessEventPartiesModel()))
				.put("effectiveDate", ExistenceChecker.isSet((Date) o.getEffectiveDate()))
				.put("facilityReference", ExistenceChecker.isSet((FacilityReference) o.getFacilityReference()))
				.put("loanContractReference", ExistenceChecker.isSet((List<? extends LoanContractReference>) o.getLoanContractReference()))
				.put("amount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("UpfrontFeePayment", ValidationType.ONLY_EXISTS, "UpfrontFeePayment", path, "");
		}
		return failure("UpfrontFeePayment", ValidationType.ONLY_EXISTS, "UpfrontFeePayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
