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
import fpml.confirmation.InterestCalculationMethodEnum;
import fpml.confirmation.InterestCapitalization;
import fpml.confirmation.InterestCapitalizationSequence;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PeriodModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InterestCapitalizationOnlyExistsValidator implements ValidatorWithArg<InterestCapitalization, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InterestCapitalization> ValidationResult<InterestCapitalization> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("parentEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getParentEventIdentifier()))
				.put("correctedEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getCorrectedEventIdentifier()))
				.put("lenderAndCashDetailsModel", ExistenceChecker.isSet((LenderAndCashDetailsModel) o.getLenderAndCashDetailsModel()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("businessEventPartiesModel", ExistenceChecker.isSet((BusinessEventPartiesModel) o.getBusinessEventPartiesModel()))
				.put("effectiveDate", ExistenceChecker.isSet((Date) o.getEffectiveDate()))
				.put("loanContractReference", ExistenceChecker.isSet((LoanContractReference) o.getLoanContractReference()))
				.put("periodModel", ExistenceChecker.isSet((PeriodModel) o.getPeriodModel()))
				.put("calculationMethod", ExistenceChecker.isSet((InterestCalculationMethodEnum) o.getCalculationMethod()))
				.put("amount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getAmount()))
				.put("interestCapitalizationSequence", ExistenceChecker.isSet((InterestCapitalizationSequence) o.getInterestCapitalizationSequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InterestCapitalization", ValidationType.ONLY_EXISTS, "InterestCapitalization", path, "");
		}
		return failure("InterestCapitalization", ValidationType.ONLY_EXISTS, "InterestCapitalization", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
