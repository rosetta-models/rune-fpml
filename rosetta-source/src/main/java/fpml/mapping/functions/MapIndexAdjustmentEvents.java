package fpml.mapping.functions;

import cdm.legaldocumentation.master.IndexAdjustmentEvents;
import cdm.legaldocumentation.master.IndexAdjustmentEvents.IndexAdjustmentEventsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapIndexAdjustmentEvents.MapIndexAdjustmentEventsDefault.class)
public abstract class MapIndexAdjustmentEvents implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return indexAdjustmentEvents 
	*/
	public IndexAdjustmentEvents evaluate(DataDocument fpmlDataDocument) {
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder indexAdjustmentEventsBuilder = doEvaluate(fpmlDataDocument);
		
		final IndexAdjustmentEvents indexAdjustmentEvents;
		if (indexAdjustmentEventsBuilder == null) {
			indexAdjustmentEvents = null;
		} else {
			indexAdjustmentEvents = indexAdjustmentEventsBuilder.build();
			objectValidator.validate(IndexAdjustmentEvents.class, indexAdjustmentEvents);
		}
		
		return indexAdjustmentEvents;
	}

	protected abstract IndexAdjustmentEvents.IndexAdjustmentEventsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapIndexAdjustmentEventsDefault extends MapIndexAdjustmentEvents {
		@Override
		protected IndexAdjustmentEvents.IndexAdjustmentEventsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			IndexAdjustmentEvents.IndexAdjustmentEventsBuilder indexAdjustmentEvents = IndexAdjustmentEvents.builder();
			return assignOutput(indexAdjustmentEvents, fpmlDataDocument);
		}
		
		protected IndexAdjustmentEvents.IndexAdjustmentEventsBuilder assignOutput(IndexAdjustmentEvents.IndexAdjustmentEventsBuilder indexAdjustmentEvents, DataDocument fpmlDataDocument) {
			indexAdjustmentEvents = toBuilder(IndexAdjustmentEvents.builder()
				.build());
			
			return Optional.ofNullable(indexAdjustmentEvents)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
