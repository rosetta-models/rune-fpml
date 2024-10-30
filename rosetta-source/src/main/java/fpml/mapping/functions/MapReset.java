package fpml.mapping.functions;

import cdm.event.common.Reset;
import cdm.event.common.Reset.ResetBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReset.MapResetDefault.class)
public abstract class MapReset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAveragingCalculation mapAveragingCalculation;
	@Inject protected MapObservationList mapObservationList;
	@Inject protected MapPrice mapPrice;

	/**
	* @param fpmlDataDocument 
	* @return reset 
	*/
	public Reset evaluate(DataDocument fpmlDataDocument) {
		Reset.ResetBuilder resetBuilder = doEvaluate(fpmlDataDocument);
		
		final Reset reset;
		if (resetBuilder == null) {
			reset = null;
		} else {
			reset = resetBuilder.build();
			objectValidator.validate(Reset.class, reset);
		}
		
		return reset;
	}

	protected abstract Reset.ResetBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapResetDefault extends MapReset {
		@Override
		protected Reset.ResetBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Reset.ResetBuilder reset = Reset.builder();
			return assignOutput(reset, fpmlDataDocument);
		}
		
		protected Reset.ResetBuilder assignOutput(Reset.ResetBuilder reset, DataDocument fpmlDataDocument) {
			reset = toBuilder(Reset.builder()
				.setResetValue(mapPrice.evaluate(fpmlDataDocument))
				.setResetDate(null)
				.setRateRecordDate(null)
				.setObservationsValue(new ArrayList(mapObservationList.evaluate(fpmlDataDocument)))
				.setAveragingMethodology(mapAveragingCalculation.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(reset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
