package fpml.mapping.functions;

import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.Cashflow.CashflowBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCashflowList.MapCashflowListDefault.class)
public abstract class MapCashflowList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashflowType mapCashflowType;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPaymentDiscounting mapPaymentDiscounting;
	@Inject protected MapPrincipalPayments mapPrincipalPayments;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapSettlementTerms mapSettlementTerms;

	/**
	* @param fpmlDataDocument 
	* @return cashflowList 
	*/
	public List<? extends Cashflow> evaluate(DataDocument fpmlDataDocument) {
		List<Cashflow.CashflowBuilder> cashflowListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Cashflow> cashflowList;
		if (cashflowListBuilder == null) {
			cashflowList = null;
		} else {
			cashflowList = cashflowListBuilder.stream().map(Cashflow::build).collect(Collectors.toList());
			objectValidator.validate(Cashflow.class, cashflowList);
		}
		
		return cashflowList;
	}

	protected abstract List<Cashflow.CashflowBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCashflowListDefault extends MapCashflowList {
		@Override
		protected List<Cashflow.CashflowBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Cashflow.CashflowBuilder> cashflowList = new ArrayList<>();
			return assignOutput(cashflowList, fpmlDataDocument);
		}
		
		protected List<Cashflow.CashflowBuilder> assignOutput(List<Cashflow.CashflowBuilder> cashflowList, DataDocument fpmlDataDocument) {
			cashflowList.addAll(toBuilder(MapperC.<Cashflow>of(MapperS.of(Cashflow.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPriceQuantity(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setPrincipalPayment(mapPrincipalPayments.evaluate(fpmlDataDocument))
				.setSettlementTerms(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setCashflowType(mapCashflowType.evaluate(fpmlDataDocument))
				.setPaymentDiscounting(mapPaymentDiscounting.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(cashflowList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
