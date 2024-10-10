package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.AbstractFacilityEvent;
import fpml.confirmation.AbstractLcEvent;
import fpml.confirmation.AbstractLoanContractEvent;
import fpml.confirmation.AccruingFeePayment;
import fpml.confirmation.AccruingPikPayment;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanBulkServicingNotificationChoice0;
import fpml.confirmation.NonRecurringFeePayment;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class LoanBulkServicingNotificationChoice0DeepPathUtil {
	public BusinessEventPartiesModel chooseBusinessEventPartiesModel(LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice0) {
		final MapperS<NonRecurringFeePayment> facilityFeePaymentGroup = MapperS.of(loanBulkServicingNotificationChoice0).<NonRecurringFeePayment>map("getFacilityFeePaymentGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityFeePaymentGroup());
		if (exists(facilityFeePaymentGroup).getOrDefault(false)) {
			return facilityFeePaymentGroup.<BusinessEventPartiesModel>map("getBusinessEventPartiesModel", nonRecurringFeePayment -> nonRecurringFeePayment.getBusinessEventPartiesModel()).get();
		}
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<BusinessEventPartiesModel>map("getBusinessEventPartiesModel", abstractFacilityEvent -> abstractFacilityEvent.getBusinessEventPartiesModel()).get();
		}
		final MapperS<AccruingFeePayment> accruingFeePayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingFeePayment>map("getAccruingFeePayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingFeePayment());
		if (exists(accruingFeePayment).getOrDefault(false)) {
			return accruingFeePayment.<BusinessEventPartiesModel>map("getBusinessEventPartiesModel", _accruingFeePayment -> _accruingFeePayment.getBusinessEventPartiesModel()).get();
		}
		final MapperS<AccruingPikPayment> accruingPikPayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingPikPayment>map("getAccruingPikPayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingPikPayment());
		if (exists(accruingPikPayment).getOrDefault(false)) {
			return accruingPikPayment.<BusinessEventPartiesModel>map("getBusinessEventPartiesModel", _accruingPikPayment -> _accruingPikPayment.getBusinessEventPartiesModel()).get();
		}
		final MapperS<AbstractLoanContractEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLoanContractEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<BusinessEventPartiesModel>map("getBusinessEventPartiesModel", abstractLoanContractEvent -> abstractLoanContractEvent.getBusinessEventPartiesModel()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<BusinessEventPartiesModel>map("getBusinessEventPartiesModel", abstractLcEvent -> abstractLcEvent.getBusinessEventPartiesModel()).get();
		}
		return null;
	}
	
	public BusinessEventIdentifier chooseCorrectedEventIdentifier(LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice0) {
		final MapperS<NonRecurringFeePayment> facilityFeePaymentGroup = MapperS.of(loanBulkServicingNotificationChoice0).<NonRecurringFeePayment>map("getFacilityFeePaymentGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityFeePaymentGroup());
		if (exists(facilityFeePaymentGroup).getOrDefault(false)) {
			return facilityFeePaymentGroup.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", nonRecurringFeePayment -> nonRecurringFeePayment.getCorrectedEventIdentifier()).get();
		}
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", abstractFacilityEvent -> abstractFacilityEvent.getCorrectedEventIdentifier()).get();
		}
		final MapperS<AccruingFeePayment> accruingFeePayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingFeePayment>map("getAccruingFeePayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingFeePayment());
		if (exists(accruingFeePayment).getOrDefault(false)) {
			return accruingFeePayment.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", _accruingFeePayment -> _accruingFeePayment.getCorrectedEventIdentifier()).get();
		}
		final MapperS<AccruingPikPayment> accruingPikPayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingPikPayment>map("getAccruingPikPayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingPikPayment());
		if (exists(accruingPikPayment).getOrDefault(false)) {
			return accruingPikPayment.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", _accruingPikPayment -> _accruingPikPayment.getCorrectedEventIdentifier()).get();
		}
		final MapperS<AbstractLoanContractEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLoanContractEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", abstractLoanContractEvent -> abstractLoanContractEvent.getCorrectedEventIdentifier()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", abstractLcEvent -> abstractLcEvent.getCorrectedEventIdentifier()).get();
		}
		return null;
	}
	
	public String chooseComment(LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice0) {
		final MapperS<NonRecurringFeePayment> facilityFeePaymentGroup = MapperS.of(loanBulkServicingNotificationChoice0).<NonRecurringFeePayment>map("getFacilityFeePaymentGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityFeePaymentGroup());
		if (exists(facilityFeePaymentGroup).getOrDefault(false)) {
			return facilityFeePaymentGroup.<String>map("getComment", nonRecurringFeePayment -> nonRecurringFeePayment.getComment()).get();
		}
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<String>map("getComment", abstractFacilityEvent -> abstractFacilityEvent.getComment()).get();
		}
		final MapperS<AccruingFeePayment> accruingFeePayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingFeePayment>map("getAccruingFeePayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingFeePayment());
		if (exists(accruingFeePayment).getOrDefault(false)) {
			return accruingFeePayment.<String>map("getComment", _accruingFeePayment -> _accruingFeePayment.getComment()).get();
		}
		final MapperS<AccruingPikPayment> accruingPikPayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingPikPayment>map("getAccruingPikPayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingPikPayment());
		if (exists(accruingPikPayment).getOrDefault(false)) {
			return accruingPikPayment.<String>map("getComment", _accruingPikPayment -> _accruingPikPayment.getComment()).get();
		}
		final MapperS<AbstractLoanContractEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLoanContractEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<String>map("getComment", abstractLoanContractEvent -> abstractLoanContractEvent.getComment()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<String>map("getComment", abstractLcEvent -> abstractLcEvent.getComment()).get();
		}
		return null;
	}
	
	public BusinessEventIdentifier chooseParentEventIdentifier(LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice0) {
		final MapperS<NonRecurringFeePayment> facilityFeePaymentGroup = MapperS.of(loanBulkServicingNotificationChoice0).<NonRecurringFeePayment>map("getFacilityFeePaymentGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityFeePaymentGroup());
		if (exists(facilityFeePaymentGroup).getOrDefault(false)) {
			return facilityFeePaymentGroup.<BusinessEventIdentifier>map("getParentEventIdentifier", nonRecurringFeePayment -> nonRecurringFeePayment.getParentEventIdentifier()).get();
		}
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<BusinessEventIdentifier>map("getParentEventIdentifier", abstractFacilityEvent -> abstractFacilityEvent.getParentEventIdentifier()).get();
		}
		final MapperS<AccruingFeePayment> accruingFeePayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingFeePayment>map("getAccruingFeePayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingFeePayment());
		if (exists(accruingFeePayment).getOrDefault(false)) {
			return accruingFeePayment.<BusinessEventIdentifier>map("getParentEventIdentifier", _accruingFeePayment -> _accruingFeePayment.getParentEventIdentifier()).get();
		}
		final MapperS<AccruingPikPayment> accruingPikPayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingPikPayment>map("getAccruingPikPayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingPikPayment());
		if (exists(accruingPikPayment).getOrDefault(false)) {
			return accruingPikPayment.<BusinessEventIdentifier>map("getParentEventIdentifier", _accruingPikPayment -> _accruingPikPayment.getParentEventIdentifier()).get();
		}
		final MapperS<AbstractLoanContractEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLoanContractEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<BusinessEventIdentifier>map("getParentEventIdentifier", abstractLoanContractEvent -> abstractLoanContractEvent.getParentEventIdentifier()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<BusinessEventIdentifier>map("getParentEventIdentifier", abstractLcEvent -> abstractLcEvent.getParentEventIdentifier()).get();
		}
		return null;
	}
	
	public List<BusinessEventIdentifier> chooseEventIdentifier(LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice0) {
		final MapperS<NonRecurringFeePayment> facilityFeePaymentGroup = MapperS.of(loanBulkServicingNotificationChoice0).<NonRecurringFeePayment>map("getFacilityFeePaymentGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityFeePaymentGroup());
		if (exists(facilityFeePaymentGroup).getOrDefault(false)) {
			return facilityFeePaymentGroup.<BusinessEventIdentifier>mapC("getEventIdentifier", nonRecurringFeePayment -> nonRecurringFeePayment.getEventIdentifier()).getMulti();
		}
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<BusinessEventIdentifier>mapC("getEventIdentifier", abstractFacilityEvent -> abstractFacilityEvent.getEventIdentifier()).getMulti();
		}
		final MapperS<AccruingFeePayment> accruingFeePayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingFeePayment>map("getAccruingFeePayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingFeePayment());
		if (exists(accruingFeePayment).getOrDefault(false)) {
			return accruingFeePayment.<BusinessEventIdentifier>mapC("getEventIdentifier", _accruingFeePayment -> _accruingFeePayment.getEventIdentifier()).getMulti();
		}
		final MapperS<AccruingPikPayment> accruingPikPayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingPikPayment>map("getAccruingPikPayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingPikPayment());
		if (exists(accruingPikPayment).getOrDefault(false)) {
			return accruingPikPayment.<BusinessEventIdentifier>mapC("getEventIdentifier", _accruingPikPayment -> _accruingPikPayment.getEventIdentifier()).getMulti();
		}
		final MapperS<AbstractLoanContractEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLoanContractEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<BusinessEventIdentifier>mapC("getEventIdentifier", abstractLoanContractEvent -> abstractLoanContractEvent.getEventIdentifier()).getMulti();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<BusinessEventIdentifier>mapC("getEventIdentifier", abstractLcEvent -> abstractLcEvent.getEventIdentifier()).getMulti();
		}
		return Collections.<BusinessEventIdentifier>emptyList();
	}
	
	public LenderAndCashDetailsModel chooseLenderAndCashDetailsModel(LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice0) {
		final MapperS<NonRecurringFeePayment> facilityFeePaymentGroup = MapperS.of(loanBulkServicingNotificationChoice0).<NonRecurringFeePayment>map("getFacilityFeePaymentGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityFeePaymentGroup());
		if (exists(facilityFeePaymentGroup).getOrDefault(false)) {
			return facilityFeePaymentGroup.<LenderAndCashDetailsModel>map("getLenderAndCashDetailsModel", nonRecurringFeePayment -> nonRecurringFeePayment.getLenderAndCashDetailsModel()).get();
		}
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<LenderAndCashDetailsModel>map("getLenderAndCashDetailsModel", abstractFacilityEvent -> abstractFacilityEvent.getLenderAndCashDetailsModel()).get();
		}
		final MapperS<AccruingFeePayment> accruingFeePayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingFeePayment>map("getAccruingFeePayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingFeePayment());
		if (exists(accruingFeePayment).getOrDefault(false)) {
			return accruingFeePayment.<LenderAndCashDetailsModel>map("getLenderAndCashDetailsModel", _accruingFeePayment -> _accruingFeePayment.getLenderAndCashDetailsModel()).get();
		}
		final MapperS<AccruingPikPayment> accruingPikPayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingPikPayment>map("getAccruingPikPayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingPikPayment());
		if (exists(accruingPikPayment).getOrDefault(false)) {
			return accruingPikPayment.<LenderAndCashDetailsModel>map("getLenderAndCashDetailsModel", _accruingPikPayment -> _accruingPikPayment.getLenderAndCashDetailsModel()).get();
		}
		final MapperS<AbstractLoanContractEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLoanContractEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<LenderAndCashDetailsModel>map("getLenderAndCashDetailsModel", abstractLoanContractEvent -> abstractLoanContractEvent.getLenderAndCashDetailsModel()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<LenderAndCashDetailsModel>map("getLenderAndCashDetailsModel", abstractLcEvent -> abstractLcEvent.getLenderAndCashDetailsModel()).get();
		}
		return null;
	}
	
	public Date chooseEffectiveDate(LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice0) {
		final MapperS<NonRecurringFeePayment> facilityFeePaymentGroup = MapperS.of(loanBulkServicingNotificationChoice0).<NonRecurringFeePayment>map("getFacilityFeePaymentGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityFeePaymentGroup());
		if (exists(facilityFeePaymentGroup).getOrDefault(false)) {
			return facilityFeePaymentGroup.<Date>map("getEffectiveDate", nonRecurringFeePayment -> nonRecurringFeePayment.getEffectiveDate()).get();
		}
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<Date>map("getEffectiveDate", abstractFacilityEvent -> abstractFacilityEvent.getEffectiveDate()).get();
		}
		final MapperS<AccruingFeePayment> accruingFeePayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingFeePayment>map("getAccruingFeePayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingFeePayment());
		if (exists(accruingFeePayment).getOrDefault(false)) {
			return accruingFeePayment.<Date>map("getEffectiveDate", _accruingFeePayment -> _accruingFeePayment.getEffectiveDate()).get();
		}
		final MapperS<AccruingPikPayment> accruingPikPayment = MapperS.of(loanBulkServicingNotificationChoice0).<AccruingPikPayment>map("getAccruingPikPayment", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getAccruingPikPayment());
		if (exists(accruingPikPayment).getOrDefault(false)) {
			return accruingPikPayment.<Date>map("getEffectiveDate", _accruingPikPayment -> _accruingPikPayment.getEffectiveDate()).get();
		}
		final MapperS<AbstractLoanContractEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLoanContractEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<Date>map("getEffectiveDate", abstractLoanContractEvent -> abstractLoanContractEvent.getEffectiveDate()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice0).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice0 -> _loanBulkServicingNotificationChoice0.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<Date>map("getEffectiveDate", abstractLcEvent -> abstractLcEvent.getEffectiveDate()).get();
		}
		return null;
	}
	
}
