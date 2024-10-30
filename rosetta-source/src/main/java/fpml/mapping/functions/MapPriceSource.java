package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.PriceSource;
import cdm.base.staticdata.asset.common.PriceSource.PriceSourceBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPriceSource.MapPriceSourceDefault.class)
public abstract class MapPriceSource implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPricePublisherWithScheme mapPricePublisherWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return priceSource 
	*/
	public PriceSource evaluate(DataDocument fpmlDataDocument) {
		PriceSource.PriceSourceBuilder priceSourceBuilder = doEvaluate(fpmlDataDocument);
		
		final PriceSource priceSource;
		if (priceSourceBuilder == null) {
			priceSource = null;
		} else {
			priceSource = priceSourceBuilder.build();
			objectValidator.validate(PriceSource.class, priceSource);
		}
		
		return priceSource;
	}

	protected abstract PriceSource.PriceSourceBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPriceSourceDefault extends MapPriceSource {
		@Override
		protected PriceSource.PriceSourceBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PriceSource.PriceSourceBuilder priceSource = PriceSource.builder();
			return assignOutput(priceSource, fpmlDataDocument);
		}
		
		protected PriceSource.PriceSourceBuilder assignOutput(PriceSource.PriceSourceBuilder priceSource, DataDocument fpmlDataDocument) {
			priceSource = toBuilder(PriceSource.builder()
				.setPricePublisherValue(mapPricePublisherWithScheme.evaluate(fpmlDataDocument))
				.setPriceSourceLocation(null)
				.setPriceSourceHeading(null)
				.setPriceSourceTime(null)
				.build());
			
			return Optional.ofNullable(priceSource)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
