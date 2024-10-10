package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.FacilityType;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.Lien;
import fpml.confirmation.Loan;
import fpml.confirmation.LoanChoice;
import fpml.confirmation.ProductReference;
import fpml.confirmation.UnderlyingAssetTranche;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanOnlyExistsValidator implements ValidatorWithArg<Loan, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Loan> ValidationResult<Loan> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("currency", ExistenceChecker.isSet((IdentifiedCurrency) o.getCurrency()))
				.put("exchangeId", ExistenceChecker.isSet((ExchangeId) o.getExchangeId()))
				.put("clearanceSystem", ExistenceChecker.isSet((ClearanceSystem) o.getClearanceSystem()))
				.put("definition", ExistenceChecker.isSet((ProductReference) o.getDefinition()))
				.put("loanChoice", ExistenceChecker.isSet((List<? extends LoanChoice>) o.getLoanChoice()))
				.put("lien", ExistenceChecker.isSet((Lien) o.getLien()))
				.put("facilityType", ExistenceChecker.isSet((FacilityType) o.getFacilityType()))
				.put("maturity", ExistenceChecker.isSet((Date) o.getMaturity()))
				.put("creditAgreementDate", ExistenceChecker.isSet((Date) o.getCreditAgreementDate()))
				.put("tranche", ExistenceChecker.isSet((UnderlyingAssetTranche) o.getTranche()))
				.put("seniority", ExistenceChecker.isSet((CreditSeniority) o.getSeniority()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Loan", ValidationType.ONLY_EXISTS, "Loan", path, "");
		}
		return failure("Loan", ValidationType.ONLY_EXISTS, "Loan", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
