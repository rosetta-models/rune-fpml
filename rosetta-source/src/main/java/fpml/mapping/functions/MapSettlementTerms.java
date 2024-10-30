package fpml.mapping.functions;

import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTerms.SettlementTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSettlementTerms.MapSettlementTermsDefault.class)
public abstract class MapSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashSettlementTermsList mapCashSettlementTermsList;
	@Inject protected MapPhysicalSettlementTerms mapPhysicalSettlementTerms;
	@Inject protected MapSettlementCurrencyWithScheme mapSettlementCurrencyWithScheme;
	@Inject protected MapSettlementDate mapSettlementDate;
	@Inject protected MapSettlementProvision mapSettlementProvision;

	/**
	* @param fpmlDataDocument 
	* @return settlementTerms 
	*/
	public SettlementTerms evaluate(DataDocument fpmlDataDocument) {
		SettlementTerms.SettlementTermsBuilder settlementTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final SettlementTerms settlementTerms;
		if (settlementTermsBuilder == null) {
			settlementTerms = null;
		} else {
			settlementTerms = settlementTermsBuilder.build();
			objectValidator.validate(SettlementTerms.class, settlementTerms);
		}
		
		return settlementTerms;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSettlementTermsDefault extends MapSettlementTerms {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SettlementTerms.SettlementTermsBuilder settlementTerms = SettlementTerms.builder();
			return assignOutput(settlementTerms, fpmlDataDocument);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder settlementTerms, DataDocument fpmlDataDocument) {
			settlementTerms = toBuilder(SettlementTerms.builder()
				.setSettlementType(null)
				.setTransferSettlementType(null)
				.setSettlementCurrencyValue(mapSettlementCurrencyWithScheme.evaluate(fpmlDataDocument))
				.setSettlementDate(mapSettlementDate.evaluate(fpmlDataDocument))
				.setSettlementCentre(null)
				.setSettlementProvision(mapSettlementProvision.evaluate(fpmlDataDocument))
				.setStandardSettlementStyle(null)
				.setCashSettlementTerms(new ArrayList(mapCashSettlementTermsList.evaluate(fpmlDataDocument)))
				.setPhysicalSettlementTerms(mapPhysicalSettlementTerms.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(settlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
