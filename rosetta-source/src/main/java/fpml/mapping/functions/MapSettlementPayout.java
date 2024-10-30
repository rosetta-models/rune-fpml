package fpml.mapping.functions;

import cdm.product.template.SettlementPayout;
import cdm.product.template.SettlementPayout.SettlementPayoutBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSettlementPayout.MapSettlementPayoutDefault.class)
public abstract class MapSettlementPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetDeliveryInformation mapAssetDeliveryInformation;
	@Inject protected MapCalculationSchedule mapCalculationSchedule;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPrincipalPayments mapPrincipalPayments;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapSettlementTerms mapSettlementTerms;
	@Inject protected MapUnderlier mapUnderlier;

	/**
	* @param fpmlDataDocument 
	* @return settlementPayout 
	*/
	public SettlementPayout evaluate(DataDocument fpmlDataDocument) {
		SettlementPayout.SettlementPayoutBuilder settlementPayoutBuilder = doEvaluate(fpmlDataDocument);
		
		final SettlementPayout settlementPayout;
		if (settlementPayoutBuilder == null) {
			settlementPayout = null;
		} else {
			settlementPayout = settlementPayoutBuilder.build();
			objectValidator.validate(SettlementPayout.class, settlementPayout);
		}
		
		return settlementPayout;
	}

	protected abstract SettlementPayout.SettlementPayoutBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSettlementPayoutDefault extends MapSettlementPayout {
		@Override
		protected SettlementPayout.SettlementPayoutBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SettlementPayout.SettlementPayoutBuilder settlementPayout = SettlementPayout.builder();
			return assignOutput(settlementPayout, fpmlDataDocument);
		}
		
		protected SettlementPayout.SettlementPayoutBuilder assignOutput(SettlementPayout.SettlementPayoutBuilder settlementPayout, DataDocument fpmlDataDocument) {
			settlementPayout = toBuilder(SettlementPayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPriceQuantity(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setPrincipalPayment(mapPrincipalPayments.evaluate(fpmlDataDocument))
				.setSettlementTerms(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setUnderlier(mapUnderlier.evaluate(fpmlDataDocument))
				.setDeliveryTerm(null)
				.setDelivery(mapAssetDeliveryInformation.evaluate(fpmlDataDocument))
				.setSchedule(mapCalculationSchedule.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(settlementPayout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
