package fpml.mapping.functions;

import cdm.product.asset.VolatilityCapFloor;
import cdm.product.asset.VolatilityCapFloor.VolatilityCapFloorBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVolatilityCapFloor.MapVolatilityCapFloorDefault.class)
public abstract class MapVolatilityCapFloor implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return volatilityCapFloor 
	*/
	public VolatilityCapFloor evaluate(DataDocument fpmlDataDocument) {
		VolatilityCapFloor.VolatilityCapFloorBuilder volatilityCapFloorBuilder = doEvaluate(fpmlDataDocument);
		
		final VolatilityCapFloor volatilityCapFloor;
		if (volatilityCapFloorBuilder == null) {
			volatilityCapFloor = null;
		} else {
			volatilityCapFloor = volatilityCapFloorBuilder.build();
			objectValidator.validate(VolatilityCapFloor.class, volatilityCapFloor);
		}
		
		return volatilityCapFloor;
	}

	protected abstract VolatilityCapFloor.VolatilityCapFloorBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapVolatilityCapFloorDefault extends MapVolatilityCapFloor {
		@Override
		protected VolatilityCapFloor.VolatilityCapFloorBuilder doEvaluate(DataDocument fpmlDataDocument) {
			VolatilityCapFloor.VolatilityCapFloorBuilder volatilityCapFloor = VolatilityCapFloor.builder();
			return assignOutput(volatilityCapFloor, fpmlDataDocument);
		}
		
		protected VolatilityCapFloor.VolatilityCapFloorBuilder assignOutput(VolatilityCapFloor.VolatilityCapFloorBuilder volatilityCapFloor, DataDocument fpmlDataDocument) {
			volatilityCapFloor = toBuilder(VolatilityCapFloor.builder()
				.setApplicable(null)
				.setTotalVolatilityCap(null)
				.setVolatilityCapFactor(null)
				.build());
			
			return Optional.ofNullable(volatilityCapFloor)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
