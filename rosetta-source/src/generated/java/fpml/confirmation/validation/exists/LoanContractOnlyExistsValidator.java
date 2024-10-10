package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.FixedRateAccrual;
import fpml.confirmation.FloatingRateAccrual;
import fpml.confirmation.FxTerms;
import fpml.confirmation.LoanContract;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanContractOnlyExistsValidator implements ValidatorWithArg<LoanContract, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanContract> ValidationResult<LoanContract> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet((List<? extends FacilityContractIdentifier>) o.getIdentifier()))
				.put("effectiveDate", ExistenceChecker.isSet((Date) o.getEffectiveDate()))
				.put("borrowerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBorrowerPartyReference()))
				.put("guarantorPartyReference", ExistenceChecker.isSet((PartyReference) o.getGuarantorPartyReference()))
				.put("amount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getAmount()))
				.put("repricingDate", ExistenceChecker.isSet((Date) o.getRepricingDate()))
				.put("maturityDate", ExistenceChecker.isSet((Date) o.getMaturityDate()))
				.put("fixedRateAccrual", ExistenceChecker.isSet((FixedRateAccrual) o.getFixedRateAccrual()))
				.put("floatingRateAccrual", ExistenceChecker.isSet((FloatingRateAccrual) o.getFloatingRateAccrual()))
				.put("facilityFxRate", ExistenceChecker.isSet((FxTerms) o.getFacilityFxRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanContract", ValidationType.ONLY_EXISTS, "LoanContract", path, "");
		}
		return failure("LoanContract", ValidationType.ONLY_EXISTS, "LoanContract", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
