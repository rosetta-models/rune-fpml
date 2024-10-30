package fpml.mapping.functions;

import cdm.product.template.OptionalEarlyTerminationAdjustedDates;
import cdm.product.template.OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOptionalEarlyTerminationAdjustedDates.MapOptionalEarlyTerminationAdjustedDatesDefault.class)
public abstract class MapOptionalEarlyTerminationAdjustedDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEarlyTerminationEventList mapEarlyTerminationEventList;

	/**
	* @param fpmlDataDocument 
	* @return optionalEarlyTerminationAdjustedDates 
	*/
	public OptionalEarlyTerminationAdjustedDates evaluate(DataDocument fpmlDataDocument) {
		OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder optionalEarlyTerminationAdjustedDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final OptionalEarlyTerminationAdjustedDates optionalEarlyTerminationAdjustedDates;
		if (optionalEarlyTerminationAdjustedDatesBuilder == null) {
			optionalEarlyTerminationAdjustedDates = null;
		} else {
			optionalEarlyTerminationAdjustedDates = optionalEarlyTerminationAdjustedDatesBuilder.build();
			objectValidator.validate(OptionalEarlyTerminationAdjustedDates.class, optionalEarlyTerminationAdjustedDates);
		}
		
		return optionalEarlyTerminationAdjustedDates;
	}

	protected abstract OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapOptionalEarlyTerminationAdjustedDatesDefault extends MapOptionalEarlyTerminationAdjustedDates {
		@Override
		protected OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder optionalEarlyTerminationAdjustedDates = OptionalEarlyTerminationAdjustedDates.builder();
			return assignOutput(optionalEarlyTerminationAdjustedDates, fpmlDataDocument);
		}
		
		protected OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder assignOutput(OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder optionalEarlyTerminationAdjustedDates, DataDocument fpmlDataDocument) {
			optionalEarlyTerminationAdjustedDates = toBuilder(OptionalEarlyTerminationAdjustedDates.builder()
				.setEarlyTerminationEvent(new ArrayList(mapEarlyTerminationEventList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(optionalEarlyTerminationAdjustedDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
