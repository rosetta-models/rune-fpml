package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.Borrowing;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.CommitmentAdjustment;
import fpml.confirmation.InterestCapitalization;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractBaseRateSet;
import fpml.confirmation.LoanInterestPayment;
import fpml.confirmation.Repayment;
import fpml.confirmation.RolloverChoice;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class RolloverChoiceDeepPathUtil {
	public BusinessEventPartiesModel chooseBusinessEventPartiesModel(RolloverChoice rolloverChoice) {
		final MapperS<LoanContractBaseRateSet> baseRateSet = MapperS.of(rolloverChoice).<LoanContractBaseRateSet>map("getBaseRateSet", _rolloverChoice -> _rolloverChoice.getBaseRateSet());
		if (exists(baseRateSet).getOrDefault(false)) {
			return baseRateSet.<BusinessEventPartiesModel>map("getBusinessEventPartiesModel", loanContractBaseRateSet -> loanContractBaseRateSet.getBusinessEventPartiesModel()).get();
		}
		final MapperS<Borrowing> borrowing = MapperS.of(rolloverChoice).<Borrowing>map("getBorrowing", _rolloverChoice -> _rolloverChoice.getBorrowing());
		if (exists(borrowing).getOrDefault(false)) {
			return borrowing.<BusinessEventPartiesModel>map("getBusinessEventPartiesModel", _borrowing -> _borrowing.getBusinessEventPartiesModel()).get();
		}
		final MapperS<CommitmentAdjustment> commitmentAdjustment = MapperS.of(rolloverChoice).<CommitmentAdjustment>map("getCommitmentAdjustment", _rolloverChoice -> _rolloverChoice.getCommitmentAdjustment());
		if (exists(commitmentAdjustment).getOrDefault(false)) {
			return commitmentAdjustment.<BusinessEventPartiesModel>map("getBusinessEventPartiesModel", _commitmentAdjustment -> _commitmentAdjustment.getBusinessEventPartiesModel()).get();
		}
		final MapperS<InterestCapitalization> interestCapitalization = MapperS.of(rolloverChoice).<InterestCapitalization>map("getInterestCapitalization", _rolloverChoice -> _rolloverChoice.getInterestCapitalization());
		if (exists(interestCapitalization).getOrDefault(false)) {
			return interestCapitalization.<BusinessEventPartiesModel>map("getBusinessEventPartiesModel", _interestCapitalization -> _interestCapitalization.getBusinessEventPartiesModel()).get();
		}
		final MapperS<LoanInterestPayment> interestPayment = MapperS.of(rolloverChoice).<LoanInterestPayment>map("getInterestPayment", _rolloverChoice -> _rolloverChoice.getInterestPayment());
		if (exists(interestPayment).getOrDefault(false)) {
			return interestPayment.<BusinessEventPartiesModel>map("getBusinessEventPartiesModel", loanInterestPayment -> loanInterestPayment.getBusinessEventPartiesModel()).get();
		}
		final MapperS<Repayment> repayment = MapperS.of(rolloverChoice).<Repayment>map("getRepayment", _rolloverChoice -> _rolloverChoice.getRepayment());
		if (exists(repayment).getOrDefault(false)) {
			return repayment.<BusinessEventPartiesModel>map("getBusinessEventPartiesModel", _repayment -> _repayment.getBusinessEventPartiesModel()).get();
		}
		return null;
	}
	
	public BusinessEventIdentifier chooseCorrectedEventIdentifier(RolloverChoice rolloverChoice) {
		final MapperS<LoanContractBaseRateSet> baseRateSet = MapperS.of(rolloverChoice).<LoanContractBaseRateSet>map("getBaseRateSet", _rolloverChoice -> _rolloverChoice.getBaseRateSet());
		if (exists(baseRateSet).getOrDefault(false)) {
			return baseRateSet.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", loanContractBaseRateSet -> loanContractBaseRateSet.getCorrectedEventIdentifier()).get();
		}
		final MapperS<Borrowing> borrowing = MapperS.of(rolloverChoice).<Borrowing>map("getBorrowing", _rolloverChoice -> _rolloverChoice.getBorrowing());
		if (exists(borrowing).getOrDefault(false)) {
			return borrowing.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", _borrowing -> _borrowing.getCorrectedEventIdentifier()).get();
		}
		final MapperS<CommitmentAdjustment> commitmentAdjustment = MapperS.of(rolloverChoice).<CommitmentAdjustment>map("getCommitmentAdjustment", _rolloverChoice -> _rolloverChoice.getCommitmentAdjustment());
		if (exists(commitmentAdjustment).getOrDefault(false)) {
			return commitmentAdjustment.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", _commitmentAdjustment -> _commitmentAdjustment.getCorrectedEventIdentifier()).get();
		}
		final MapperS<InterestCapitalization> interestCapitalization = MapperS.of(rolloverChoice).<InterestCapitalization>map("getInterestCapitalization", _rolloverChoice -> _rolloverChoice.getInterestCapitalization());
		if (exists(interestCapitalization).getOrDefault(false)) {
			return interestCapitalization.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", _interestCapitalization -> _interestCapitalization.getCorrectedEventIdentifier()).get();
		}
		final MapperS<LoanInterestPayment> interestPayment = MapperS.of(rolloverChoice).<LoanInterestPayment>map("getInterestPayment", _rolloverChoice -> _rolloverChoice.getInterestPayment());
		if (exists(interestPayment).getOrDefault(false)) {
			return interestPayment.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", loanInterestPayment -> loanInterestPayment.getCorrectedEventIdentifier()).get();
		}
		final MapperS<Repayment> repayment = MapperS.of(rolloverChoice).<Repayment>map("getRepayment", _rolloverChoice -> _rolloverChoice.getRepayment());
		if (exists(repayment).getOrDefault(false)) {
			return repayment.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", _repayment -> _repayment.getCorrectedEventIdentifier()).get();
		}
		return null;
	}
	
	public String chooseComment(RolloverChoice rolloverChoice) {
		final MapperS<LoanContractBaseRateSet> baseRateSet = MapperS.of(rolloverChoice).<LoanContractBaseRateSet>map("getBaseRateSet", _rolloverChoice -> _rolloverChoice.getBaseRateSet());
		if (exists(baseRateSet).getOrDefault(false)) {
			return baseRateSet.<String>map("getComment", loanContractBaseRateSet -> loanContractBaseRateSet.getComment()).get();
		}
		final MapperS<Borrowing> borrowing = MapperS.of(rolloverChoice).<Borrowing>map("getBorrowing", _rolloverChoice -> _rolloverChoice.getBorrowing());
		if (exists(borrowing).getOrDefault(false)) {
			return borrowing.<String>map("getComment", _borrowing -> _borrowing.getComment()).get();
		}
		final MapperS<CommitmentAdjustment> commitmentAdjustment = MapperS.of(rolloverChoice).<CommitmentAdjustment>map("getCommitmentAdjustment", _rolloverChoice -> _rolloverChoice.getCommitmentAdjustment());
		if (exists(commitmentAdjustment).getOrDefault(false)) {
			return commitmentAdjustment.<String>map("getComment", _commitmentAdjustment -> _commitmentAdjustment.getComment()).get();
		}
		final MapperS<InterestCapitalization> interestCapitalization = MapperS.of(rolloverChoice).<InterestCapitalization>map("getInterestCapitalization", _rolloverChoice -> _rolloverChoice.getInterestCapitalization());
		if (exists(interestCapitalization).getOrDefault(false)) {
			return interestCapitalization.<String>map("getComment", _interestCapitalization -> _interestCapitalization.getComment()).get();
		}
		final MapperS<LoanInterestPayment> interestPayment = MapperS.of(rolloverChoice).<LoanInterestPayment>map("getInterestPayment", _rolloverChoice -> _rolloverChoice.getInterestPayment());
		if (exists(interestPayment).getOrDefault(false)) {
			return interestPayment.<String>map("getComment", loanInterestPayment -> loanInterestPayment.getComment()).get();
		}
		final MapperS<Repayment> repayment = MapperS.of(rolloverChoice).<Repayment>map("getRepayment", _rolloverChoice -> _rolloverChoice.getRepayment());
		if (exists(repayment).getOrDefault(false)) {
			return repayment.<String>map("getComment", _repayment -> _repayment.getComment()).get();
		}
		return null;
	}
	
	public BusinessEventIdentifier chooseParentEventIdentifier(RolloverChoice rolloverChoice) {
		final MapperS<LoanContractBaseRateSet> baseRateSet = MapperS.of(rolloverChoice).<LoanContractBaseRateSet>map("getBaseRateSet", _rolloverChoice -> _rolloverChoice.getBaseRateSet());
		if (exists(baseRateSet).getOrDefault(false)) {
			return baseRateSet.<BusinessEventIdentifier>map("getParentEventIdentifier", loanContractBaseRateSet -> loanContractBaseRateSet.getParentEventIdentifier()).get();
		}
		final MapperS<Borrowing> borrowing = MapperS.of(rolloverChoice).<Borrowing>map("getBorrowing", _rolloverChoice -> _rolloverChoice.getBorrowing());
		if (exists(borrowing).getOrDefault(false)) {
			return borrowing.<BusinessEventIdentifier>map("getParentEventIdentifier", _borrowing -> _borrowing.getParentEventIdentifier()).get();
		}
		final MapperS<CommitmentAdjustment> commitmentAdjustment = MapperS.of(rolloverChoice).<CommitmentAdjustment>map("getCommitmentAdjustment", _rolloverChoice -> _rolloverChoice.getCommitmentAdjustment());
		if (exists(commitmentAdjustment).getOrDefault(false)) {
			return commitmentAdjustment.<BusinessEventIdentifier>map("getParentEventIdentifier", _commitmentAdjustment -> _commitmentAdjustment.getParentEventIdentifier()).get();
		}
		final MapperS<InterestCapitalization> interestCapitalization = MapperS.of(rolloverChoice).<InterestCapitalization>map("getInterestCapitalization", _rolloverChoice -> _rolloverChoice.getInterestCapitalization());
		if (exists(interestCapitalization).getOrDefault(false)) {
			return interestCapitalization.<BusinessEventIdentifier>map("getParentEventIdentifier", _interestCapitalization -> _interestCapitalization.getParentEventIdentifier()).get();
		}
		final MapperS<LoanInterestPayment> interestPayment = MapperS.of(rolloverChoice).<LoanInterestPayment>map("getInterestPayment", _rolloverChoice -> _rolloverChoice.getInterestPayment());
		if (exists(interestPayment).getOrDefault(false)) {
			return interestPayment.<BusinessEventIdentifier>map("getParentEventIdentifier", loanInterestPayment -> loanInterestPayment.getParentEventIdentifier()).get();
		}
		final MapperS<Repayment> repayment = MapperS.of(rolloverChoice).<Repayment>map("getRepayment", _rolloverChoice -> _rolloverChoice.getRepayment());
		if (exists(repayment).getOrDefault(false)) {
			return repayment.<BusinessEventIdentifier>map("getParentEventIdentifier", _repayment -> _repayment.getParentEventIdentifier()).get();
		}
		return null;
	}
	
	public List<BusinessEventIdentifier> chooseEventIdentifier(RolloverChoice rolloverChoice) {
		final MapperS<LoanContractBaseRateSet> baseRateSet = MapperS.of(rolloverChoice).<LoanContractBaseRateSet>map("getBaseRateSet", _rolloverChoice -> _rolloverChoice.getBaseRateSet());
		if (exists(baseRateSet).getOrDefault(false)) {
			return baseRateSet.<BusinessEventIdentifier>mapC("getEventIdentifier", loanContractBaseRateSet -> loanContractBaseRateSet.getEventIdentifier()).getMulti();
		}
		final MapperS<Borrowing> borrowing = MapperS.of(rolloverChoice).<Borrowing>map("getBorrowing", _rolloverChoice -> _rolloverChoice.getBorrowing());
		if (exists(borrowing).getOrDefault(false)) {
			return borrowing.<BusinessEventIdentifier>mapC("getEventIdentifier", _borrowing -> _borrowing.getEventIdentifier()).getMulti();
		}
		final MapperS<CommitmentAdjustment> commitmentAdjustment = MapperS.of(rolloverChoice).<CommitmentAdjustment>map("getCommitmentAdjustment", _rolloverChoice -> _rolloverChoice.getCommitmentAdjustment());
		if (exists(commitmentAdjustment).getOrDefault(false)) {
			return commitmentAdjustment.<BusinessEventIdentifier>mapC("getEventIdentifier", _commitmentAdjustment -> _commitmentAdjustment.getEventIdentifier()).getMulti();
		}
		final MapperS<InterestCapitalization> interestCapitalization = MapperS.of(rolloverChoice).<InterestCapitalization>map("getInterestCapitalization", _rolloverChoice -> _rolloverChoice.getInterestCapitalization());
		if (exists(interestCapitalization).getOrDefault(false)) {
			return interestCapitalization.<BusinessEventIdentifier>mapC("getEventIdentifier", _interestCapitalization -> _interestCapitalization.getEventIdentifier()).getMulti();
		}
		final MapperS<LoanInterestPayment> interestPayment = MapperS.of(rolloverChoice).<LoanInterestPayment>map("getInterestPayment", _rolloverChoice -> _rolloverChoice.getInterestPayment());
		if (exists(interestPayment).getOrDefault(false)) {
			return interestPayment.<BusinessEventIdentifier>mapC("getEventIdentifier", loanInterestPayment -> loanInterestPayment.getEventIdentifier()).getMulti();
		}
		final MapperS<Repayment> repayment = MapperS.of(rolloverChoice).<Repayment>map("getRepayment", _rolloverChoice -> _rolloverChoice.getRepayment());
		if (exists(repayment).getOrDefault(false)) {
			return repayment.<BusinessEventIdentifier>mapC("getEventIdentifier", _repayment -> _repayment.getEventIdentifier()).getMulti();
		}
		return Collections.<BusinessEventIdentifier>emptyList();
	}
	
	public LenderAndCashDetailsModel chooseLenderAndCashDetailsModel(RolloverChoice rolloverChoice) {
		final MapperS<LoanContractBaseRateSet> baseRateSet = MapperS.of(rolloverChoice).<LoanContractBaseRateSet>map("getBaseRateSet", _rolloverChoice -> _rolloverChoice.getBaseRateSet());
		if (exists(baseRateSet).getOrDefault(false)) {
			return baseRateSet.<LenderAndCashDetailsModel>map("getLenderAndCashDetailsModel", loanContractBaseRateSet -> loanContractBaseRateSet.getLenderAndCashDetailsModel()).get();
		}
		final MapperS<Borrowing> borrowing = MapperS.of(rolloverChoice).<Borrowing>map("getBorrowing", _rolloverChoice -> _rolloverChoice.getBorrowing());
		if (exists(borrowing).getOrDefault(false)) {
			return borrowing.<LenderAndCashDetailsModel>map("getLenderAndCashDetailsModel", _borrowing -> _borrowing.getLenderAndCashDetailsModel()).get();
		}
		final MapperS<CommitmentAdjustment> commitmentAdjustment = MapperS.of(rolloverChoice).<CommitmentAdjustment>map("getCommitmentAdjustment", _rolloverChoice -> _rolloverChoice.getCommitmentAdjustment());
		if (exists(commitmentAdjustment).getOrDefault(false)) {
			return commitmentAdjustment.<LenderAndCashDetailsModel>map("getLenderAndCashDetailsModel", _commitmentAdjustment -> _commitmentAdjustment.getLenderAndCashDetailsModel()).get();
		}
		final MapperS<InterestCapitalization> interestCapitalization = MapperS.of(rolloverChoice).<InterestCapitalization>map("getInterestCapitalization", _rolloverChoice -> _rolloverChoice.getInterestCapitalization());
		if (exists(interestCapitalization).getOrDefault(false)) {
			return interestCapitalization.<LenderAndCashDetailsModel>map("getLenderAndCashDetailsModel", _interestCapitalization -> _interestCapitalization.getLenderAndCashDetailsModel()).get();
		}
		final MapperS<LoanInterestPayment> interestPayment = MapperS.of(rolloverChoice).<LoanInterestPayment>map("getInterestPayment", _rolloverChoice -> _rolloverChoice.getInterestPayment());
		if (exists(interestPayment).getOrDefault(false)) {
			return interestPayment.<LenderAndCashDetailsModel>map("getLenderAndCashDetailsModel", loanInterestPayment -> loanInterestPayment.getLenderAndCashDetailsModel()).get();
		}
		final MapperS<Repayment> repayment = MapperS.of(rolloverChoice).<Repayment>map("getRepayment", _rolloverChoice -> _rolloverChoice.getRepayment());
		if (exists(repayment).getOrDefault(false)) {
			return repayment.<LenderAndCashDetailsModel>map("getLenderAndCashDetailsModel", _repayment -> _repayment.getLenderAndCashDetailsModel()).get();
		}
		return null;
	}
	
	public Date chooseEffectiveDate(RolloverChoice rolloverChoice) {
		final MapperS<LoanContractBaseRateSet> baseRateSet = MapperS.of(rolloverChoice).<LoanContractBaseRateSet>map("getBaseRateSet", _rolloverChoice -> _rolloverChoice.getBaseRateSet());
		if (exists(baseRateSet).getOrDefault(false)) {
			return baseRateSet.<Date>map("getEffectiveDate", loanContractBaseRateSet -> loanContractBaseRateSet.getEffectiveDate()).get();
		}
		final MapperS<Borrowing> borrowing = MapperS.of(rolloverChoice).<Borrowing>map("getBorrowing", _rolloverChoice -> _rolloverChoice.getBorrowing());
		if (exists(borrowing).getOrDefault(false)) {
			return borrowing.<Date>map("getEffectiveDate", _borrowing -> _borrowing.getEffectiveDate()).get();
		}
		final MapperS<CommitmentAdjustment> commitmentAdjustment = MapperS.of(rolloverChoice).<CommitmentAdjustment>map("getCommitmentAdjustment", _rolloverChoice -> _rolloverChoice.getCommitmentAdjustment());
		if (exists(commitmentAdjustment).getOrDefault(false)) {
			return commitmentAdjustment.<Date>map("getEffectiveDate", _commitmentAdjustment -> _commitmentAdjustment.getEffectiveDate()).get();
		}
		final MapperS<InterestCapitalization> interestCapitalization = MapperS.of(rolloverChoice).<InterestCapitalization>map("getInterestCapitalization", _rolloverChoice -> _rolloverChoice.getInterestCapitalization());
		if (exists(interestCapitalization).getOrDefault(false)) {
			return interestCapitalization.<Date>map("getEffectiveDate", _interestCapitalization -> _interestCapitalization.getEffectiveDate()).get();
		}
		final MapperS<LoanInterestPayment> interestPayment = MapperS.of(rolloverChoice).<LoanInterestPayment>map("getInterestPayment", _rolloverChoice -> _rolloverChoice.getInterestPayment());
		if (exists(interestPayment).getOrDefault(false)) {
			return interestPayment.<Date>map("getEffectiveDate", loanInterestPayment -> loanInterestPayment.getEffectiveDate()).get();
		}
		final MapperS<Repayment> repayment = MapperS.of(rolloverChoice).<Repayment>map("getRepayment", _rolloverChoice -> _rolloverChoice.getRepayment());
		if (exists(repayment).getOrDefault(false)) {
			return repayment.<Date>map("getEffectiveDate", _repayment -> _repayment.getEffectiveDate()).get();
		}
		return null;
	}
	
}
