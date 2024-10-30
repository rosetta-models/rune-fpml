package fpml.mapping.functions;

import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.CashSettlementTerms.CashSettlementTermsBuilder;
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


@ImplementedBy(MapCashSettlementTermsList.MapCashSettlementTermsListDefault.class)
public abstract class MapCashSettlementTermsList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapMoney mapMoney;
	@Inject protected MapValuationDate mapValuationDate;
	@Inject protected MapValuationMethod mapValuationMethod;

	/**
	* @param fpmlDataDocument 
	* @return cashSettlementTermsList 
	*/
	public List<? extends CashSettlementTerms> evaluate(DataDocument fpmlDataDocument) {
		List<CashSettlementTerms.CashSettlementTermsBuilder> cashSettlementTermsListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends CashSettlementTerms> cashSettlementTermsList;
		if (cashSettlementTermsListBuilder == null) {
			cashSettlementTermsList = null;
		} else {
			cashSettlementTermsList = cashSettlementTermsListBuilder.stream().map(CashSettlementTerms::build).collect(Collectors.toList());
			objectValidator.validate(CashSettlementTerms.class, cashSettlementTermsList);
		}
		
		return cashSettlementTermsList;
	}

	protected abstract List<CashSettlementTerms.CashSettlementTermsBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCashSettlementTermsListDefault extends MapCashSettlementTermsList {
		@Override
		protected List<CashSettlementTerms.CashSettlementTermsBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<CashSettlementTerms.CashSettlementTermsBuilder> cashSettlementTermsList = new ArrayList<>();
			return assignOutput(cashSettlementTermsList, fpmlDataDocument);
		}
		
		protected List<CashSettlementTerms.CashSettlementTermsBuilder> assignOutput(List<CashSettlementTerms.CashSettlementTermsBuilder> cashSettlementTermsList, DataDocument fpmlDataDocument) {
			cashSettlementTermsList.addAll(toBuilder(MapperC.<CashSettlementTerms>of(MapperS.of(CashSettlementTerms.builder()
				.setCashSettlementMethod(null)
				.setValuationMethod(mapValuationMethod.evaluate(fpmlDataDocument))
				.setValuationDate(mapValuationDate.evaluate(fpmlDataDocument))
				.setValuationTime(mapBusinessCenterTime.evaluate(fpmlDataDocument))
				.setCashSettlementAmount(mapMoney.evaluate(fpmlDataDocument))
				.setRecoveryFactor(null)
				.setFixedSettlement(null)
				.setAccruedInterest(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(cashSettlementTermsList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
