package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustmentType;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LcAdjustment;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LetterOfCreditReference;
import fpml.confirmation.MoneyWithParticipantShare;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LcAdjustmentOnlyExistsValidator implements ValidatorWithArg<LcAdjustment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LcAdjustment> ValidationResult<LcAdjustment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("parentEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getParentEventIdentifier()))
				.put("correctedEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getCorrectedEventIdentifier()))
				.put("lenderAndCashDetailsModel", ExistenceChecker.isSet((LenderAndCashDetailsModel) o.getLenderAndCashDetailsModel()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("businessEventPartiesModel", ExistenceChecker.isSet((BusinessEventPartiesModel) o.getBusinessEventPartiesModel()))
				.put("effectiveDate", ExistenceChecker.isSet((Date) o.getEffectiveDate()))
				.put("letterOfCreditReference", ExistenceChecker.isSet((LetterOfCreditReference) o.getLetterOfCreditReference()))
				.put("adjustment", ExistenceChecker.isSet((AdjustmentType) o.getAdjustment()))
				.put("amount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getAmount()))
				.put("relatedBorrowing", ExistenceChecker.isSet((Boolean) o.getRelatedBorrowing()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LcAdjustment", ValidationType.ONLY_EXISTS, "LcAdjustment", path, "");
		}
		return failure("LcAdjustment", ValidationType.ONLY_EXISTS, "LcAdjustment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
