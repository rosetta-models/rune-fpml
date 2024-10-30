package fpml.mapping.functions;

import cdm.legaldocumentation.master.ExtraordinaryEvents;
import cdm.legaldocumentation.master.ExtraordinaryEvents.ExtraordinaryEventsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExtraordinaryEvents.MapExtraordinaryEventsDefault.class)
public abstract class MapExtraordinaryEvents implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdditionalDisruptionEvents mapAdditionalDisruptionEvents;
	@Inject protected MapClauseList mapClauseList;
	@Inject protected MapEquityCorporateEvents mapEquityCorporateEvents;
	@Inject protected MapIndexAdjustmentEvents mapIndexAdjustmentEvents;
	@Inject protected MapRepresentations mapRepresentations;

	/**
	* @param fpmlDataDocument 
	* @return extraordinaryEvents 
	*/
	public ExtraordinaryEvents evaluate(DataDocument fpmlDataDocument) {
		ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEventsBuilder = doEvaluate(fpmlDataDocument);
		
		final ExtraordinaryEvents extraordinaryEvents;
		if (extraordinaryEventsBuilder == null) {
			extraordinaryEvents = null;
		} else {
			extraordinaryEvents = extraordinaryEventsBuilder.build();
			objectValidator.validate(ExtraordinaryEvents.class, extraordinaryEvents);
		}
		
		return extraordinaryEvents;
	}

	protected abstract ExtraordinaryEvents.ExtraordinaryEventsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapExtraordinaryEventsDefault extends MapExtraordinaryEvents {
		@Override
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents = ExtraordinaryEvents.builder();
			return assignOutput(extraordinaryEvents, fpmlDataDocument);
		}
		
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder assignOutput(ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents, DataDocument fpmlDataDocument) {
			extraordinaryEvents = toBuilder(ExtraordinaryEvents.builder()
				.setAdditionalBespokeTerms(new ArrayList(mapClauseList.evaluate(fpmlDataDocument)))
				.setMergerEvents(mapEquityCorporateEvents.evaluate(fpmlDataDocument))
				.setTenderOfferEvents(mapEquityCorporateEvents.evaluate(fpmlDataDocument))
				.setCompositionOfCombinedConsideration(null)
				.setIndexAdjustmentEvents(mapIndexAdjustmentEvents.evaluate(fpmlDataDocument))
				.setAdditionalDisruptionEvents(mapAdditionalDisruptionEvents.evaluate(fpmlDataDocument))
				.setFailureToDeliver(null)
				.setRepresentations(mapRepresentations.evaluate(fpmlDataDocument))
				.setNationalizationOrInsolvency(null)
				.setDelisting(null)
				.build());
			
			return Optional.ofNullable(extraordinaryEvents)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
