package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.ContractId;
import fpml.confirmation.ContractIdentifier;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice0;
import fpml.confirmation.PartyReference;
import fpml.confirmation.VersionedContractId;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class FacilityLoanContractDetailsModelChoice0DeepPathUtil {
	public List<ContractId> chooseContractId(FacilityLoanContractDetailsModelChoice0 facilityLoanContractDetailsModelChoice0) {
		final MapperS<ContractIdentifier> loanContractIdentifier = MapperS.of(facilityLoanContractDetailsModelChoice0).<ContractIdentifier>map("getLoanContractIdentifier", _facilityLoanContractDetailsModelChoice0 -> _facilityLoanContractDetailsModelChoice0.getLoanContractIdentifier());
		if (exists(loanContractIdentifier).getOrDefault(false)) {
			return loanContractIdentifier.<ContractId>mapC("getContractId", contractIdentifier -> contractIdentifier.getContractId()).getMulti();
		}
		final MapperS<ContractIdentifier> letterOfCreditIdentifier = MapperS.of(facilityLoanContractDetailsModelChoice0).<ContractIdentifier>map("getLetterOfCreditIdentifier", _facilityLoanContractDetailsModelChoice0 -> _facilityLoanContractDetailsModelChoice0.getLetterOfCreditIdentifier());
		if (exists(letterOfCreditIdentifier).getOrDefault(false)) {
			return letterOfCreditIdentifier.<ContractId>mapC("getContractId", contractIdentifier -> contractIdentifier.getContractId()).getMulti();
		}
		return Collections.<ContractId>emptyList();
	}
	
	public PartyReference choosePartyReference(FacilityLoanContractDetailsModelChoice0 facilityLoanContractDetailsModelChoice0) {
		final MapperS<ContractIdentifier> loanContractIdentifier = MapperS.of(facilityLoanContractDetailsModelChoice0).<ContractIdentifier>map("getLoanContractIdentifier", _facilityLoanContractDetailsModelChoice0 -> _facilityLoanContractDetailsModelChoice0.getLoanContractIdentifier());
		if (exists(loanContractIdentifier).getOrDefault(false)) {
			return loanContractIdentifier.<PartyReference>map("getPartyReference", contractIdentifier -> contractIdentifier.getPartyReference()).get();
		}
		final MapperS<ContractIdentifier> letterOfCreditIdentifier = MapperS.of(facilityLoanContractDetailsModelChoice0).<ContractIdentifier>map("getLetterOfCreditIdentifier", _facilityLoanContractDetailsModelChoice0 -> _facilityLoanContractDetailsModelChoice0.getLetterOfCreditIdentifier());
		if (exists(letterOfCreditIdentifier).getOrDefault(false)) {
			return letterOfCreditIdentifier.<PartyReference>map("getPartyReference", contractIdentifier -> contractIdentifier.getPartyReference()).get();
		}
		return null;
	}
	
	public String chooseId(FacilityLoanContractDetailsModelChoice0 facilityLoanContractDetailsModelChoice0) {
		final MapperS<ContractIdentifier> loanContractIdentifier = MapperS.of(facilityLoanContractDetailsModelChoice0).<ContractIdentifier>map("getLoanContractIdentifier", _facilityLoanContractDetailsModelChoice0 -> _facilityLoanContractDetailsModelChoice0.getLoanContractIdentifier());
		if (exists(loanContractIdentifier).getOrDefault(false)) {
			return loanContractIdentifier.<String>map("getId", contractIdentifier -> contractIdentifier.getId()).get();
		}
		final MapperS<ContractIdentifier> letterOfCreditIdentifier = MapperS.of(facilityLoanContractDetailsModelChoice0).<ContractIdentifier>map("getLetterOfCreditIdentifier", _facilityLoanContractDetailsModelChoice0 -> _facilityLoanContractDetailsModelChoice0.getLetterOfCreditIdentifier());
		if (exists(letterOfCreditIdentifier).getOrDefault(false)) {
			return letterOfCreditIdentifier.<String>map("getId", contractIdentifier -> contractIdentifier.getId()).get();
		}
		return null;
	}
	
	public List<VersionedContractId> chooseVersionedContractId(FacilityLoanContractDetailsModelChoice0 facilityLoanContractDetailsModelChoice0) {
		final MapperS<ContractIdentifier> loanContractIdentifier = MapperS.of(facilityLoanContractDetailsModelChoice0).<ContractIdentifier>map("getLoanContractIdentifier", _facilityLoanContractDetailsModelChoice0 -> _facilityLoanContractDetailsModelChoice0.getLoanContractIdentifier());
		if (exists(loanContractIdentifier).getOrDefault(false)) {
			return loanContractIdentifier.<VersionedContractId>mapC("getVersionedContractId", contractIdentifier -> contractIdentifier.getVersionedContractId()).getMulti();
		}
		final MapperS<ContractIdentifier> letterOfCreditIdentifier = MapperS.of(facilityLoanContractDetailsModelChoice0).<ContractIdentifier>map("getLetterOfCreditIdentifier", _facilityLoanContractDetailsModelChoice0 -> _facilityLoanContractDetailsModelChoice0.getLetterOfCreditIdentifier());
		if (exists(letterOfCreditIdentifier).getOrDefault(false)) {
			return letterOfCreditIdentifier.<VersionedContractId>mapC("getVersionedContractId", contractIdentifier -> contractIdentifier.getVersionedContractId()).getMulti();
		}
		return Collections.<VersionedContractId>emptyList();
	}
	
}
