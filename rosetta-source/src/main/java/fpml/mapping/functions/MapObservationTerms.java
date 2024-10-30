package fpml.mapping.functions;

import cdm.product.common.schedule.ObservationTerms;
import cdm.product.common.schedule.ObservationTerms.ObservationTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapObservationTerms.MapObservationTermsDefault.class)
public abstract class MapObservationTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapCalculationPeriodDates mapCalculationPeriodDates;
	@Inject protected MapFxSpotRateSource mapFxSpotRateSource;
	@Inject protected MapObservationDates mapObservationDates;
	@Inject protected MapRounding mapRounding;

	/**
	* @param fpmlDataDocument 
	* @return observationTerms 
	*/
	public ObservationTerms evaluate(DataDocument fpmlDataDocument) {
		ObservationTerms.ObservationTermsBuilder observationTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final ObservationTerms observationTerms;
		if (observationTermsBuilder == null) {
			observationTerms = null;
		} else {
			observationTerms = observationTermsBuilder.build();
			objectValidator.validate(ObservationTerms.class, observationTerms);
		}
		
		return observationTerms;
	}

	protected abstract ObservationTerms.ObservationTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapObservationTermsDefault extends MapObservationTerms {
		@Override
		protected ObservationTerms.ObservationTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ObservationTerms.ObservationTermsBuilder observationTerms = ObservationTerms.builder();
			return assignOutput(observationTerms, fpmlDataDocument);
		}
		
		protected ObservationTerms.ObservationTermsBuilder assignOutput(ObservationTerms.ObservationTermsBuilder observationTerms, DataDocument fpmlDataDocument) {
			observationTerms = toBuilder(ObservationTerms.builder()
				.setObservationTime(mapBusinessCenterTime.evaluate(fpmlDataDocument))
				.setObservationTimeType(null)
				.setInformationSource(mapFxSpotRateSource.evaluate(fpmlDataDocument))
				.setPrecision(mapRounding.evaluate(fpmlDataDocument))
				.setCalculationPeriodDates(mapCalculationPeriodDates.evaluate(fpmlDataDocument))
				.setObservationDates(mapObservationDates.evaluate(fpmlDataDocument))
				.setNumberOfObservationDates(null)
				.build());
			
			return Optional.ofNullable(observationTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
