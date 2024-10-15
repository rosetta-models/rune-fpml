package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice1;
import fpml.confirmation.FxTerms;
import fpml.confirmation.LetterOfCredit;
import fpml.confirmation.LoanContract;
import fpml.confirmation.MoneyWithParticipantShare;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class FacilityLoanContractDetailsModelChoice1DeepPathUtil {
	public List<FacilityContractIdentifier> chooseIdentifier(FacilityLoanContractDetailsModelChoice1 facilityLoanContractDetailsModelChoice1) {
		final MapperS<LoanContract> loanContract = MapperS.of(facilityLoanContractDetailsModelChoice1).<LoanContract>map("getLoanContract", _facilityLoanContractDetailsModelChoice1 -> _facilityLoanContractDetailsModelChoice1.getLoanContract());
		if (exists(loanContract).getOrDefault(false)) {
			return loanContract.<FacilityContractIdentifier>mapC("getIdentifier", _loanContract -> _loanContract.getIdentifier()).getMulti();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(facilityLoanContractDetailsModelChoice1).<LetterOfCredit>map("getLetterOfCredit", _facilityLoanContractDetailsModelChoice1 -> _facilityLoanContractDetailsModelChoice1.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<FacilityContractIdentifier>mapC("getIdentifier", _letterOfCredit -> _letterOfCredit.getIdentifier()).getMulti();
		}
		return Collections.<FacilityContractIdentifier>emptyList();
	}
	
	public MoneyWithParticipantShare chooseAmount(FacilityLoanContractDetailsModelChoice1 facilityLoanContractDetailsModelChoice1) {
		final MapperS<LoanContract> loanContract = MapperS.of(facilityLoanContractDetailsModelChoice1).<LoanContract>map("getLoanContract", _facilityLoanContractDetailsModelChoice1 -> _facilityLoanContractDetailsModelChoice1.getLoanContract());
		if (exists(loanContract).getOrDefault(false)) {
			return loanContract.<MoneyWithParticipantShare>map("getAmount", _loanContract -> _loanContract.getAmount()).get();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(facilityLoanContractDetailsModelChoice1).<LetterOfCredit>map("getLetterOfCredit", _facilityLoanContractDetailsModelChoice1 -> _facilityLoanContractDetailsModelChoice1.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<MoneyWithParticipantShare>map("getAmount", _letterOfCredit -> _letterOfCredit.getAmount()).get();
		}
		return null;
	}
	
	public FxTerms chooseFacilityFxRate(FacilityLoanContractDetailsModelChoice1 facilityLoanContractDetailsModelChoice1) {
		final MapperS<LoanContract> loanContract = MapperS.of(facilityLoanContractDetailsModelChoice1).<LoanContract>map("getLoanContract", _facilityLoanContractDetailsModelChoice1 -> _facilityLoanContractDetailsModelChoice1.getLoanContract());
		if (exists(loanContract).getOrDefault(false)) {
			return loanContract.<FxTerms>map("getFacilityFxRate", _loanContract -> _loanContract.getFacilityFxRate()).get();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(facilityLoanContractDetailsModelChoice1).<LetterOfCredit>map("getLetterOfCredit", _facilityLoanContractDetailsModelChoice1 -> _facilityLoanContractDetailsModelChoice1.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<FxTerms>map("getFacilityFxRate", _letterOfCredit -> _letterOfCredit.getFacilityFxRate()).get();
		}
		return null;
	}
	
	public Date chooseEffectiveDate(FacilityLoanContractDetailsModelChoice1 facilityLoanContractDetailsModelChoice1) {
		final MapperS<LoanContract> loanContract = MapperS.of(facilityLoanContractDetailsModelChoice1).<LoanContract>map("getLoanContract", _facilityLoanContractDetailsModelChoice1 -> _facilityLoanContractDetailsModelChoice1.getLoanContract());
		if (exists(loanContract).getOrDefault(false)) {
			return loanContract.<Date>map("getEffectiveDate", _loanContract -> _loanContract.getEffectiveDate()).get();
		}
		final MapperS<LetterOfCredit> letterOfCredit = MapperS.of(facilityLoanContractDetailsModelChoice1).<LetterOfCredit>map("getLetterOfCredit", _facilityLoanContractDetailsModelChoice1 -> _facilityLoanContractDetailsModelChoice1.getLetterOfCredit());
		if (exists(letterOfCredit).getOrDefault(false)) {
			return letterOfCredit.<Date>map("getEffectiveDate", _letterOfCredit -> _letterOfCredit.getEffectiveDate()).get();
		}
		return null;
	}
	
}
