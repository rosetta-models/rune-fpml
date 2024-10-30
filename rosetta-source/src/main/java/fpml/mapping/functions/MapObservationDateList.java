package fpml.mapping.functions;

import cdm.product.common.schedule.ObservationDate;
import cdm.product.common.schedule.ObservationDate.ObservationDateBuilder;
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


@ImplementedBy(MapObservationDateList.MapObservationDateListDefault.class)
public abstract class MapObservationDateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return observationDateList 
	*/
	public List<? extends ObservationDate> evaluate(DataDocument fpmlDataDocument) {
		List<ObservationDate.ObservationDateBuilder> observationDateListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ObservationDate> observationDateList;
		if (observationDateListBuilder == null) {
			observationDateList = null;
		} else {
			observationDateList = observationDateListBuilder.stream().map(ObservationDate::build).collect(Collectors.toList());
			objectValidator.validate(ObservationDate.class, observationDateList);
		}
		
		return observationDateList;
	}

	protected abstract List<ObservationDate.ObservationDateBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapObservationDateListDefault extends MapObservationDateList {
		@Override
		protected List<ObservationDate.ObservationDateBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ObservationDate.ObservationDateBuilder> observationDateList = new ArrayList<>();
			return assignOutput(observationDateList, fpmlDataDocument);
		}
		
		protected List<ObservationDate.ObservationDateBuilder> assignOutput(List<ObservationDate.ObservationDateBuilder> observationDateList, DataDocument fpmlDataDocument) {
			observationDateList.addAll(toBuilder(MapperC.<ObservationDate>of(MapperS.of(ObservationDate.builder()
				.setUnadjustedDate(null)
				.setAdjustedDate(null)
				.setWeight(null)
				.setObservationReference(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(observationDateList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
