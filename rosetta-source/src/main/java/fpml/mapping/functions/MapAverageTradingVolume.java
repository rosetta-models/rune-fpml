package fpml.mapping.functions;

import cdm.product.collateral.AverageTradingVolume;
import cdm.product.collateral.AverageTradingVolume.AverageTradingVolumeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAverageTradingVolume.MapAverageTradingVolumeDefault.class)
public abstract class MapAverageTradingVolume implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriod mapPeriod;

	/**
	* @param fpmlDataDocument 
	* @return averageTradingVolume 
	*/
	public AverageTradingVolume evaluate(DataDocument fpmlDataDocument) {
		AverageTradingVolume.AverageTradingVolumeBuilder averageTradingVolumeBuilder = doEvaluate(fpmlDataDocument);
		
		final AverageTradingVolume averageTradingVolume;
		if (averageTradingVolumeBuilder == null) {
			averageTradingVolume = null;
		} else {
			averageTradingVolume = averageTradingVolumeBuilder.build();
			objectValidator.validate(AverageTradingVolume.class, averageTradingVolume);
		}
		
		return averageTradingVolume;
	}

	protected abstract AverageTradingVolume.AverageTradingVolumeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAverageTradingVolumeDefault extends MapAverageTradingVolume {
		@Override
		protected AverageTradingVolume.AverageTradingVolumeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AverageTradingVolume.AverageTradingVolumeBuilder averageTradingVolume = AverageTradingVolume.builder();
			return assignOutput(averageTradingVolume, fpmlDataDocument);
		}
		
		protected AverageTradingVolume.AverageTradingVolumeBuilder assignOutput(AverageTradingVolume.AverageTradingVolumeBuilder averageTradingVolume, DataDocument fpmlDataDocument) {
			averageTradingVolume = toBuilder(AverageTradingVolume.builder()
				.setPeriod(mapPeriod.evaluate(fpmlDataDocument))
				.setMethodology(null)
				.build());
			
			return Optional.ofNullable(averageTradingVolume)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
