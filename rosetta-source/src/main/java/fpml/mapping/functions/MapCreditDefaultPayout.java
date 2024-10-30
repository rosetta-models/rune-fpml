package fpml.mapping.functions;

import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.CreditDefaultPayout.CreditDefaultPayoutBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditDefaultPayout.MapCreditDefaultPayoutDefault.class)
public abstract class MapCreditDefaultPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapGeneralTerms mapGeneralTerms;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPrincipalPayments mapPrincipalPayments;
	@Inject protected MapProtectionTermsList mapProtectionTermsList;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapSettlementTerms mapSettlementTerms;
	@Inject protected MapTransactedPrice mapTransactedPrice;

	/**
	* @param fpmlDataDocument 
	* @return creditDefaultPayout 
	*/
	public CreditDefaultPayout evaluate(DataDocument fpmlDataDocument) {
		CreditDefaultPayout.CreditDefaultPayoutBuilder creditDefaultPayoutBuilder = doEvaluate(fpmlDataDocument);
		
		final CreditDefaultPayout creditDefaultPayout;
		if (creditDefaultPayoutBuilder == null) {
			creditDefaultPayout = null;
		} else {
			creditDefaultPayout = creditDefaultPayoutBuilder.build();
			objectValidator.validate(CreditDefaultPayout.class, creditDefaultPayout);
		}
		
		return creditDefaultPayout;
	}

	protected abstract CreditDefaultPayout.CreditDefaultPayoutBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCreditDefaultPayoutDefault extends MapCreditDefaultPayout {
		@Override
		protected CreditDefaultPayout.CreditDefaultPayoutBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CreditDefaultPayout.CreditDefaultPayoutBuilder creditDefaultPayout = CreditDefaultPayout.builder();
			return assignOutput(creditDefaultPayout, fpmlDataDocument);
		}
		
		protected CreditDefaultPayout.CreditDefaultPayoutBuilder assignOutput(CreditDefaultPayout.CreditDefaultPayoutBuilder creditDefaultPayout, DataDocument fpmlDataDocument) {
			creditDefaultPayout = toBuilder(CreditDefaultPayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPriceQuantity(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setPrincipalPayment(mapPrincipalPayments.evaluate(fpmlDataDocument))
				.setSettlementTerms(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setGeneralTerms(mapGeneralTerms.evaluate(fpmlDataDocument))
				.setProtectionTerms(new ArrayList(mapProtectionTermsList.evaluate(fpmlDataDocument)))
				.setTransactedPrice(mapTransactedPrice.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(creditDefaultPayout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
