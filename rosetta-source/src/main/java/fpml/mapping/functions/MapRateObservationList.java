package fpml.mapping.functions;

import cdm.observable.asset.RateObservation;
import cdm.observable.asset.RateObservation.RateObservationBuilder;
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


@ImplementedBy(MapRateObservationList.MapRateObservationListDefault.class)
public abstract class MapRateObservationList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapRateObservation mapRateObservation;

	/**
	* @param fpmlDataDocument 
	* @return rateObservationList 
	*/
	public List<? extends RateObservation> evaluate(DataDocument fpmlDataDocument) {
		List<RateObservation.RateObservationBuilder> rateObservationListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends RateObservation> rateObservationList;
		if (rateObservationListBuilder == null) {
			rateObservationList = null;
		} else {
			rateObservationList = rateObservationListBuilder.stream().map(RateObservation::build).collect(Collectors.toList());
			objectValidator.validate(RateObservation.class, rateObservationList);
		}
		
		return rateObservationList;
	}

	protected abstract List<RateObservation.RateObservationBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRateObservationListDefault extends MapRateObservationList {
		@Override
		protected List<RateObservation.RateObservationBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<RateObservation.RateObservationBuilder> rateObservationList = new ArrayList<>();
			return assignOutput(rateObservationList, fpmlDataDocument);
		}
		
		protected List<RateObservation.RateObservationBuilder> assignOutput(List<RateObservation.RateObservationBuilder> rateObservationList, DataDocument fpmlDataDocument) {
			rateObservationList.addAll(toBuilder(MapperC.<RateObservation>of(MapperS.of(RateObservation.builder()
				.setResetDate(null)
				.setAdjustedFixingDate(null)
				.setObservedRate(null)
				.setTreatedRate(null)
				.setObservationWeight(null)
				.setRateReferenceValue(mapRateObservation.evaluate(fpmlDataDocument))
				.setForecastRate(null)
				.setTreatedForecastRate(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(rateObservationList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
