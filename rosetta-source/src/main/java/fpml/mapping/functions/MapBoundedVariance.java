package fpml.mapping.functions;

import cdm.product.asset.BoundedVariance;
import cdm.product.asset.BoundedVariance.BoundedVarianceBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBoundedVariance.MapBoundedVarianceDefault.class)
public abstract class MapBoundedVariance implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return boundedVariance 
	*/
	public BoundedVariance evaluate(DataDocument fpmlDataDocument) {
		BoundedVariance.BoundedVarianceBuilder boundedVarianceBuilder = doEvaluate(fpmlDataDocument);
		
		final BoundedVariance boundedVariance;
		if (boundedVarianceBuilder == null) {
			boundedVariance = null;
		} else {
			boundedVariance = boundedVarianceBuilder.build();
			objectValidator.validate(BoundedVariance.class, boundedVariance);
		}
		
		return boundedVariance;
	}

	protected abstract BoundedVariance.BoundedVarianceBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBoundedVarianceDefault extends MapBoundedVariance {
		@Override
		protected BoundedVariance.BoundedVarianceBuilder doEvaluate(DataDocument fpmlDataDocument) {
			BoundedVariance.BoundedVarianceBuilder boundedVariance = BoundedVariance.builder();
			return assignOutput(boundedVariance, fpmlDataDocument);
		}
		
		protected BoundedVariance.BoundedVarianceBuilder assignOutput(BoundedVariance.BoundedVarianceBuilder boundedVariance, DataDocument fpmlDataDocument) {
			boundedVariance = toBuilder(BoundedVariance.builder()
				.setRealisedVarianceMethod(null)
				.setDaysInRangeAdjustment(null)
				.setUpperBarrier(null)
				.setLowerBarrier(null)
				.build());
			
			return Optional.ofNullable(boundedVariance)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
