package fpml.mapping.functions;

import cdm.legaldocumentation.master.ExtraordinaryEvents;
import cdm.legaldocumentation.master.ExtraordinaryEvents.ExtraordinaryEventsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapExtraordinaryEventsList.MapExtraordinaryEventsListDefault.class)
public abstract class MapExtraordinaryEventsList implements RosettaFunction {
	
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
	* @return extraordinaryEventsList 
	*/
	public List<? extends ExtraordinaryEvents> evaluate(DataDocument fpmlDataDocument) {
		List<ExtraordinaryEvents.ExtraordinaryEventsBuilder> extraordinaryEventsListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ExtraordinaryEvents> extraordinaryEventsList;
		if (extraordinaryEventsListBuilder == null) {
			extraordinaryEventsList = null;
		} else {
			extraordinaryEventsList = extraordinaryEventsListBuilder.stream().map(ExtraordinaryEvents::build).collect(Collectors.toList());
			objectValidator.validate(ExtraordinaryEvents.class, extraordinaryEventsList);
		}
		
		return extraordinaryEventsList;
	}

	protected abstract List<ExtraordinaryEvents.ExtraordinaryEventsBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapExtraordinaryEventsListDefault extends MapExtraordinaryEventsList {
		@Override
		protected List<ExtraordinaryEvents.ExtraordinaryEventsBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ExtraordinaryEvents.ExtraordinaryEventsBuilder> extraordinaryEventsList = new ArrayList<>();
			return assignOutput(extraordinaryEventsList, fpmlDataDocument);
		}
		
		protected List<ExtraordinaryEvents.ExtraordinaryEventsBuilder> assignOutput(List<ExtraordinaryEvents.ExtraordinaryEventsBuilder> extraordinaryEventsList, DataDocument fpmlDataDocument) {
			extraordinaryEventsList.addAll(toBuilder(MapperC.<ExtraordinaryEvents>of(MapperS.of(ExtraordinaryEvents.builder()
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
				.build())).getMulti()));
			
			return Optional.ofNullable(extraordinaryEventsList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
