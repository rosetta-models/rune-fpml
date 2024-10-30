package fpml.mapping.functions;

import cdm.legaldocumentation.master.EquityCorporateEvents;
import cdm.legaldocumentation.master.EquityCorporateEvents.EquityCorporateEventsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityCorporateEvents.MapEquityCorporateEventsDefault.class)
public abstract class MapEquityCorporateEvents implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return equityCorporateEvents 
	*/
	public EquityCorporateEvents evaluate(DataDocument fpmlDataDocument) {
		EquityCorporateEvents.EquityCorporateEventsBuilder equityCorporateEventsBuilder = doEvaluate(fpmlDataDocument);
		
		final EquityCorporateEvents equityCorporateEvents;
		if (equityCorporateEventsBuilder == null) {
			equityCorporateEvents = null;
		} else {
			equityCorporateEvents = equityCorporateEventsBuilder.build();
			objectValidator.validate(EquityCorporateEvents.class, equityCorporateEvents);
		}
		
		return equityCorporateEvents;
	}

	protected abstract EquityCorporateEvents.EquityCorporateEventsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapEquityCorporateEventsDefault extends MapEquityCorporateEvents {
		@Override
		protected EquityCorporateEvents.EquityCorporateEventsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			EquityCorporateEvents.EquityCorporateEventsBuilder equityCorporateEvents = EquityCorporateEvents.builder();
			return assignOutput(equityCorporateEvents, fpmlDataDocument);
		}
		
		protected EquityCorporateEvents.EquityCorporateEventsBuilder assignOutput(EquityCorporateEvents.EquityCorporateEventsBuilder equityCorporateEvents, DataDocument fpmlDataDocument) {
			equityCorporateEvents = toBuilder(EquityCorporateEvents.builder()
				.build());
			
			return Optional.ofNullable(equityCorporateEvents)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
