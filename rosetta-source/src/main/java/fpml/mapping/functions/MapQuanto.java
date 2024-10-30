package fpml.mapping.functions;

import cdm.product.template.Quanto;
import cdm.product.template.Quanto.QuantoBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapQuanto.MapQuantoDefault.class)
public abstract class MapQuanto implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapFxRateList mapFxRateList;
	@Inject protected MapFxSpotRateSource mapFxSpotRateSource;

	/**
	* @param fpmlDataDocument 
	* @return quanto 
	*/
	public Quanto evaluate(DataDocument fpmlDataDocument) {
		Quanto.QuantoBuilder quantoBuilder = doEvaluate(fpmlDataDocument);
		
		final Quanto quanto;
		if (quantoBuilder == null) {
			quanto = null;
		} else {
			quanto = quantoBuilder.build();
			objectValidator.validate(Quanto.class, quanto);
		}
		
		return quanto;
	}

	protected abstract Quanto.QuantoBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapQuantoDefault extends MapQuanto {
		@Override
		protected Quanto.QuantoBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Quanto.QuantoBuilder quanto = Quanto.builder();
			return assignOutput(quanto, fpmlDataDocument);
		}
		
		protected Quanto.QuantoBuilder assignOutput(Quanto.QuantoBuilder quanto, DataDocument fpmlDataDocument) {
			quanto = toBuilder(Quanto.builder()
				.setFxRate(new ArrayList(mapFxRateList.evaluate(fpmlDataDocument)))
				.setFxSpotRateSource(mapFxSpotRateSource.evaluate(fpmlDataDocument))
				.setFixingTime(mapBusinessCenterTime.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(quanto)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
