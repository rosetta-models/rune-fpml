package fpml.mapping.functions;

import cdm.product.asset.VarianceCapFloor;
import cdm.product.asset.VarianceCapFloor.VarianceCapFloorBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVarianceCapFloor.MapVarianceCapFloorDefault.class)
public abstract class MapVarianceCapFloor implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBoundedVariance mapBoundedVariance;

	/**
	* @param fpmlDataDocument 
	* @return varianceCapFloor 
	*/
	public VarianceCapFloor evaluate(DataDocument fpmlDataDocument) {
		VarianceCapFloor.VarianceCapFloorBuilder varianceCapFloorBuilder = doEvaluate(fpmlDataDocument);
		
		final VarianceCapFloor varianceCapFloor;
		if (varianceCapFloorBuilder == null) {
			varianceCapFloor = null;
		} else {
			varianceCapFloor = varianceCapFloorBuilder.build();
			objectValidator.validate(VarianceCapFloor.class, varianceCapFloor);
		}
		
		return varianceCapFloor;
	}

	protected abstract VarianceCapFloor.VarianceCapFloorBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapVarianceCapFloorDefault extends MapVarianceCapFloor {
		@Override
		protected VarianceCapFloor.VarianceCapFloorBuilder doEvaluate(DataDocument fpmlDataDocument) {
			VarianceCapFloor.VarianceCapFloorBuilder varianceCapFloor = VarianceCapFloor.builder();
			return assignOutput(varianceCapFloor, fpmlDataDocument);
		}
		
		protected VarianceCapFloor.VarianceCapFloorBuilder assignOutput(VarianceCapFloor.VarianceCapFloorBuilder varianceCapFloor, DataDocument fpmlDataDocument) {
			varianceCapFloor = toBuilder(VarianceCapFloor.builder()
				.setVarianceCap(null)
				.setUnadjustedVarianceCap(null)
				.setBoundedVariance(mapBoundedVariance.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(varianceCapFloor)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
