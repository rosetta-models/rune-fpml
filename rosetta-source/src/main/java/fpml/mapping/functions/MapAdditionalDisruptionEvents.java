package fpml.mapping.functions;

import cdm.legaldocumentation.master.AdditionalDisruptionEvents;
import cdm.legaldocumentation.master.AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdditionalDisruptionEvents.MapAdditionalDisruptionEventsDefault.class)
public abstract class MapAdditionalDisruptionEvents implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapClauseList mapClauseList;

	/**
	* @param fpmlDataDocument 
	* @return additionalDisruptionEvents 
	*/
	public AdditionalDisruptionEvents evaluate(DataDocument fpmlDataDocument) {
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder additionalDisruptionEventsBuilder = doEvaluate(fpmlDataDocument);
		
		final AdditionalDisruptionEvents additionalDisruptionEvents;
		if (additionalDisruptionEventsBuilder == null) {
			additionalDisruptionEvents = null;
		} else {
			additionalDisruptionEvents = additionalDisruptionEventsBuilder.build();
			objectValidator.validate(AdditionalDisruptionEvents.class, additionalDisruptionEvents);
		}
		
		return additionalDisruptionEvents;
	}

	protected abstract AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAdditionalDisruptionEventsDefault extends MapAdditionalDisruptionEvents {
		@Override
		protected AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder additionalDisruptionEvents = AdditionalDisruptionEvents.builder();
			return assignOutput(additionalDisruptionEvents, fpmlDataDocument);
		}
		
		protected AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder assignOutput(AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder additionalDisruptionEvents, DataDocument fpmlDataDocument) {
			additionalDisruptionEvents = toBuilder(AdditionalDisruptionEvents.builder()
				.setChangeInLaw(null)
				.setFailureToDeliver(null)
				.setInsolvencyFiling(null)
				.setHedgingDisruption(null)
				.setIncreasedCostOfHedging(null)
				.setForeignOwnershipEvent(null)
				.setLossOfStockBorrow(null)
				.setMaximumStockLoanRate(null)
				.setIncreasedCostOfStockBorrow(null)
				.setInitialStockLoanRate(null)
				.setDeterminingParty(null)
				.setAdditionalBespokeTerms(new ArrayList(mapClauseList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(additionalDisruptionEvents)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
