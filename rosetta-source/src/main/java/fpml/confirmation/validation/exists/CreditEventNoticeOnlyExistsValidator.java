package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AffectedTransactions;
import fpml.confirmation.CreditEvent;
import fpml.confirmation.CreditEventNotice;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.PartyReference;
import fpml.confirmation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditEventNoticeOnlyExistsValidator implements ValidatorWithArg<CreditEventNotice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditEventNotice> ValidationResult<CreditEventNotice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("affectedTransactions", ExistenceChecker.isSet((AffectedTransactions) o.getAffectedTransactions()))
				.put("referenceEntity", ExistenceChecker.isSet((LegalEntity) o.getReferenceEntity()))
				.put("creditEvent", ExistenceChecker.isSet((CreditEvent) o.getCreditEvent()))
				.put("publiclyAvailableInformation", ExistenceChecker.isSet((List<? extends Resource>) o.getPubliclyAvailableInformation()))
				.put("notifyingPartyReference", ExistenceChecker.isSet((PartyReference) o.getNotifyingPartyReference()))
				.put("notifiedPartyReference", ExistenceChecker.isSet((PartyReference) o.getNotifiedPartyReference()))
				.put("creditEventNoticeDate", ExistenceChecker.isSet((Date) o.getCreditEventNoticeDate()))
				.put("creditEventDate", ExistenceChecker.isSet((Date) o.getCreditEventDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditEventNotice", ValidationType.ONLY_EXISTS, "CreditEventNotice", path, "");
		}
		return failure("CreditEventNotice", ValidationType.ONLY_EXISTS, "CreditEventNotice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
