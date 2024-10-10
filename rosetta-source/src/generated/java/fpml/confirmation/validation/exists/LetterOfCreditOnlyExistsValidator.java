package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.FxTerms;
import fpml.confirmation.LcAccrual;
import fpml.confirmation.LcPurpose;
import fpml.confirmation.LcType;
import fpml.confirmation.LetterOfCredit;
import fpml.confirmation.LetterOfCreditFeaturesModel;
import fpml.confirmation.LetterOfCreditRolesModel;
import fpml.confirmation.MoneyWithParticipantShare;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LetterOfCreditOnlyExistsValidator implements ValidatorWithArg<LetterOfCredit, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LetterOfCredit> ValidationResult<LetterOfCredit> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet((List<? extends FacilityContractIdentifier>) o.getIdentifier()))
				.put("type", ExistenceChecker.isSet((LcType) o.getType_()))
				.put("effectiveDate", ExistenceChecker.isSet((Date) o.getEffectiveDate()))
				.put("letterOfCreditRolesModel", ExistenceChecker.isSet((LetterOfCreditRolesModel) o.getLetterOfCreditRolesModel()))
				.put("amount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getAmount()))
				.put("expiryDate", ExistenceChecker.isSet((Date) o.getExpiryDate()))
				.put("finalExpiryDate", ExistenceChecker.isSet((Date) o.getFinalExpiryDate()))
				.put("lcAccrual", ExistenceChecker.isSet((LcAccrual) o.getLcAccrual()))
				.put("purpose", ExistenceChecker.isSet((LcPurpose) o.getPurpose()))
				.put("letterOfCreditFeaturesModel", ExistenceChecker.isSet((LetterOfCreditFeaturesModel) o.getLetterOfCreditFeaturesModel()))
				.put("facilityFxRate", ExistenceChecker.isSet((FxTerms) o.getFacilityFxRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LetterOfCredit", ValidationType.ONLY_EXISTS, "LetterOfCredit", path, "");
		}
		return failure("LetterOfCredit", ValidationType.ONLY_EXISTS, "LetterOfCredit", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
