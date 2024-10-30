package fpml.mapping.functions;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder;
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


@ImplementedBy(MapAdjustableRelativeOrPeriodicDatesList.MapAdjustableRelativeOrPeriodicDatesListDefault.class)
public abstract class MapAdjustableRelativeOrPeriodicDatesList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDates mapAdjustableDates;
	@Inject protected MapPeriodicDates mapPeriodicDates;
	@Inject protected MapRelativeDates mapRelativeDates;

	/**
	* @param fpmlDataDocument 
	* @return adjustableRelativeOrPeriodicDatesList 
	*/
	public List<? extends AdjustableRelativeOrPeriodicDates> evaluate(DataDocument fpmlDataDocument) {
		List<AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder> adjustableRelativeOrPeriodicDatesListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AdjustableRelativeOrPeriodicDates> adjustableRelativeOrPeriodicDatesList;
		if (adjustableRelativeOrPeriodicDatesListBuilder == null) {
			adjustableRelativeOrPeriodicDatesList = null;
		} else {
			adjustableRelativeOrPeriodicDatesList = adjustableRelativeOrPeriodicDatesListBuilder.stream().map(AdjustableRelativeOrPeriodicDates::build).collect(Collectors.toList());
			objectValidator.validate(AdjustableRelativeOrPeriodicDates.class, adjustableRelativeOrPeriodicDatesList);
		}
		
		return adjustableRelativeOrPeriodicDatesList;
	}

	protected abstract List<AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAdjustableRelativeOrPeriodicDatesListDefault extends MapAdjustableRelativeOrPeriodicDatesList {
		@Override
		protected List<AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder> adjustableRelativeOrPeriodicDatesList = new ArrayList<>();
			return assignOutput(adjustableRelativeOrPeriodicDatesList, fpmlDataDocument);
		}
		
		protected List<AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder> assignOutput(List<AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder> adjustableRelativeOrPeriodicDatesList, DataDocument fpmlDataDocument) {
			adjustableRelativeOrPeriodicDatesList.addAll(toBuilder(MapperC.<AdjustableRelativeOrPeriodicDates>of(MapperS.of(AdjustableRelativeOrPeriodicDates.builder()
				.setAdjustableDates(mapAdjustableDates.evaluate(fpmlDataDocument))
				.setRelativeDates(mapRelativeDates.evaluate(fpmlDataDocument))
				.setPeriodicDates(mapPeriodicDates.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(adjustableRelativeOrPeriodicDatesList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
