package fpml.mapping.functions;

import cdm.observable.event.FeaturePayment;
import cdm.observable.event.FeaturePayment.FeaturePaymentBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFeaturePayment.MapFeaturePaymentDefault.class)
public abstract class MapFeaturePayment implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapCurrencyWithScheme mapCurrencyWithScheme;
	@Inject protected MapPartyReferencePayerReceiver mapPartyReferencePayerReceiver;

	/**
	* @param fpmlDataDocument 
	* @return featurePayment 
	*/
	public FeaturePayment evaluate(DataDocument fpmlDataDocument) {
		FeaturePayment.FeaturePaymentBuilder featurePaymentBuilder = doEvaluate(fpmlDataDocument);
		
		final FeaturePayment featurePayment;
		if (featurePaymentBuilder == null) {
			featurePayment = null;
		} else {
			featurePayment = featurePaymentBuilder.build();
			objectValidator.validate(FeaturePayment.class, featurePayment);
		}
		
		return featurePayment;
	}

	protected abstract FeaturePayment.FeaturePaymentBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFeaturePaymentDefault extends MapFeaturePayment {
		@Override
		protected FeaturePayment.FeaturePaymentBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FeaturePayment.FeaturePaymentBuilder featurePayment = FeaturePayment.builder();
			return assignOutput(featurePayment, fpmlDataDocument);
		}
		
		protected FeaturePayment.FeaturePaymentBuilder assignOutput(FeaturePayment.FeaturePaymentBuilder featurePayment, DataDocument fpmlDataDocument) {
			featurePayment = toBuilder(FeaturePayment.builder()
				.setPayerReceiver(mapPartyReferencePayerReceiver.evaluate(fpmlDataDocument))
				.setLevelPercentage(null)
				.setAmount(null)
				.setTime(null)
				.setCurrencyValue(mapCurrencyWithScheme.evaluate(fpmlDataDocument))
				.setPaymentDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(featurePayment)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
