package fpml.mapping.functions;

import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.CashSettlementTerms.CashSettlementTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCashSettlementTerms.MapCashSettlementTermsDefault.class)
public abstract class MapCashSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapMoney mapMoney;
	@Inject protected MapValuationDate mapValuationDate;
	@Inject protected MapValuationMethod mapValuationMethod;

	/**
	* @param fpmlDataDocument 
	* @return cashSettlementTerms 
	*/
	public CashSettlementTerms evaluate(DataDocument fpmlDataDocument) {
		CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final CashSettlementTerms cashSettlementTerms;
		if (cashSettlementTermsBuilder == null) {
			cashSettlementTerms = null;
		} else {
			cashSettlementTerms = cashSettlementTermsBuilder.build();
			objectValidator.validate(CashSettlementTerms.class, cashSettlementTerms);
		}
		
		return cashSettlementTerms;
	}

	protected abstract CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCashSettlementTermsDefault extends MapCashSettlementTerms {
		@Override
		protected CashSettlementTerms.CashSettlementTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms = CashSettlementTerms.builder();
			return assignOutput(cashSettlementTerms, fpmlDataDocument);
		}
		
		protected CashSettlementTerms.CashSettlementTermsBuilder assignOutput(CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms, DataDocument fpmlDataDocument) {
			cashSettlementTerms = toBuilder(CashSettlementTerms.builder()
				.setCashSettlementMethod(null)
				.setValuationMethod(mapValuationMethod.evaluate(fpmlDataDocument))
				.setValuationDate(mapValuationDate.evaluate(fpmlDataDocument))
				.setValuationTime(mapBusinessCenterTime.evaluate(fpmlDataDocument))
				.setCashSettlementAmount(mapMoney.evaluate(fpmlDataDocument))
				.setRecoveryFactor(null)
				.setFixedSettlement(null)
				.setAccruedInterest(null)
				.build());
			
			return Optional.ofNullable(cashSettlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
