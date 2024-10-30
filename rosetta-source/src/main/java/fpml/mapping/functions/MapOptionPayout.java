package fpml.mapping.functions;

import cdm.product.template.OptionPayout;
import cdm.product.template.OptionPayout.OptionPayoutBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOptionPayout.MapOptionPayoutDefault.class)
public abstract class MapOptionPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetDeliveryInformation mapAssetDeliveryInformation;
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapCalculationSchedule mapCalculationSchedule;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapObservationTerms mapObservationTerms;
	@Inject protected MapOptionFeature mapOptionFeature;
	@Inject protected MapOptionStrike mapOptionStrike;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPrincipalPayments mapPrincipalPayments;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapSettlementTerms mapSettlementTerms;
	@Inject protected MapUnderlier mapUnderlier;

	/**
	* @param fpmlDataDocument 
	* @return optionPayout 
	*/
	public OptionPayout evaluate(DataDocument fpmlDataDocument) {
		OptionPayout.OptionPayoutBuilder optionPayoutBuilder = doEvaluate(fpmlDataDocument);
		
		final OptionPayout optionPayout;
		if (optionPayoutBuilder == null) {
			optionPayout = null;
		} else {
			optionPayout = optionPayoutBuilder.build();
			objectValidator.validate(OptionPayout.class, optionPayout);
		}
		
		return optionPayout;
	}

	protected abstract OptionPayout.OptionPayoutBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapOptionPayoutDefault extends MapOptionPayout {
		@Override
		protected OptionPayout.OptionPayoutBuilder doEvaluate(DataDocument fpmlDataDocument) {
			OptionPayout.OptionPayoutBuilder optionPayout = OptionPayout.builder();
			return assignOutput(optionPayout, fpmlDataDocument);
		}
		
		protected OptionPayout.OptionPayoutBuilder assignOutput(OptionPayout.OptionPayoutBuilder optionPayout, DataDocument fpmlDataDocument) {
			optionPayout = toBuilder(OptionPayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPriceQuantity(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setPrincipalPayment(mapPrincipalPayments.evaluate(fpmlDataDocument))
				.setSettlementTerms(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setBuyerSeller(mapBuyerSeller.evaluate(fpmlDataDocument))
				.setFeature(mapOptionFeature.evaluate(fpmlDataDocument))
				.setObservationTerms(mapObservationTerms.evaluate(fpmlDataDocument))
				.setSchedule(mapCalculationSchedule.evaluate(fpmlDataDocument))
				.setDelivery(mapAssetDeliveryInformation.evaluate(fpmlDataDocument))
				.setUnderlier(mapUnderlier.evaluate(fpmlDataDocument))
				.setOptionType(null)
				.setExerciseTerms(mapExerciseTerms.evaluate(fpmlDataDocument))
				.setStrike(mapOptionStrike.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(optionPayout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
