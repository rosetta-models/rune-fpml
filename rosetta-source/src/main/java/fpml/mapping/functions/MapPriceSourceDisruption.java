package fpml.mapping.functions;

import cdm.observable.asset.PriceSourceDisruption;
import cdm.observable.asset.PriceSourceDisruption.PriceSourceDisruptionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPriceSourceDisruption.MapPriceSourceDisruptionDefault.class)
public abstract class MapPriceSourceDisruption implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFallbackReferencePrice mapFallbackReferencePrice;

	/**
	* @param fpmlDataDocument 
	* @return priceSourceDisruption 
	*/
	public PriceSourceDisruption evaluate(DataDocument fpmlDataDocument) {
		PriceSourceDisruption.PriceSourceDisruptionBuilder priceSourceDisruptionBuilder = doEvaluate(fpmlDataDocument);
		
		final PriceSourceDisruption priceSourceDisruption;
		if (priceSourceDisruptionBuilder == null) {
			priceSourceDisruption = null;
		} else {
			priceSourceDisruption = priceSourceDisruptionBuilder.build();
			objectValidator.validate(PriceSourceDisruption.class, priceSourceDisruption);
		}
		
		return priceSourceDisruption;
	}

	protected abstract PriceSourceDisruption.PriceSourceDisruptionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPriceSourceDisruptionDefault extends MapPriceSourceDisruption {
		@Override
		protected PriceSourceDisruption.PriceSourceDisruptionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PriceSourceDisruption.PriceSourceDisruptionBuilder priceSourceDisruption = PriceSourceDisruption.builder();
			return assignOutput(priceSourceDisruption, fpmlDataDocument);
		}
		
		protected PriceSourceDisruption.PriceSourceDisruptionBuilder assignOutput(PriceSourceDisruption.PriceSourceDisruptionBuilder priceSourceDisruption, DataDocument fpmlDataDocument) {
			priceSourceDisruption = toBuilder(PriceSourceDisruption.builder()
				.setFallbackReferencePrice(mapFallbackReferencePrice.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(priceSourceDisruption)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
