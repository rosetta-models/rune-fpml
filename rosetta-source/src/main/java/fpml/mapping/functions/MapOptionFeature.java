package fpml.mapping.functions;

import cdm.product.template.OptionFeature;
import cdm.product.template.OptionFeature.OptionFeatureBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOptionFeature.MapOptionFeatureDefault.class)
public abstract class MapOptionFeature implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAveragingCalculation mapAveragingCalculation;
	@Inject protected MapBarrier mapBarrier;
	@Inject protected MapFxFeatureList mapFxFeatureList;
	@Inject protected MapKnock mapKnock;
	@Inject protected MapPassThrough mapPassThrough;
	@Inject protected MapStrategyFeature mapStrategyFeature;

	/**
	* @param fpmlDataDocument 
	* @return optionFeature 
	*/
	public OptionFeature evaluate(DataDocument fpmlDataDocument) {
		OptionFeature.OptionFeatureBuilder optionFeatureBuilder = doEvaluate(fpmlDataDocument);
		
		final OptionFeature optionFeature;
		if (optionFeatureBuilder == null) {
			optionFeature = null;
		} else {
			optionFeature = optionFeatureBuilder.build();
			objectValidator.validate(OptionFeature.class, optionFeature);
		}
		
		return optionFeature;
	}

	protected abstract OptionFeature.OptionFeatureBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapOptionFeatureDefault extends MapOptionFeature {
		@Override
		protected OptionFeature.OptionFeatureBuilder doEvaluate(DataDocument fpmlDataDocument) {
			OptionFeature.OptionFeatureBuilder optionFeature = OptionFeature.builder();
			return assignOutput(optionFeature, fpmlDataDocument);
		}
		
		protected OptionFeature.OptionFeatureBuilder assignOutput(OptionFeature.OptionFeatureBuilder optionFeature, DataDocument fpmlDataDocument) {
			optionFeature = toBuilder(OptionFeature.builder()
				.setFxFeature(new ArrayList(mapFxFeatureList.evaluate(fpmlDataDocument)))
				.setStrategyFeature(mapStrategyFeature.evaluate(fpmlDataDocument))
				.setAveragingFeature(mapAveragingCalculation.evaluate(fpmlDataDocument))
				.setBarrier(mapBarrier.evaluate(fpmlDataDocument))
				.setKnock(mapKnock.evaluate(fpmlDataDocument))
				.setPassThrough(mapPassThrough.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(optionFeature)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
