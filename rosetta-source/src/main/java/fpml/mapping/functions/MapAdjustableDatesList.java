package fpml.mapping.functions;

import cdm.base.datetime.AdjustableDates;
import cdm.base.datetime.AdjustableDates.AdjustableDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableDatesList.MapAdjustableDatesListDefault.class)
public abstract class MapAdjustableDatesList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;

	/**
	* @param fpmlDataDocument 
	* @return adjustableDatesList 
	*/
	public List<? extends AdjustableDates> evaluate(DataDocument fpmlDataDocument) {
		List<AdjustableDates.AdjustableDatesBuilder> adjustableDatesListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AdjustableDates> adjustableDatesList;
		if (adjustableDatesListBuilder == null) {
			adjustableDatesList = null;
		} else {
			adjustableDatesList = adjustableDatesListBuilder.stream().map(AdjustableDates::build).collect(Collectors.toList());
			objectValidator.validate(AdjustableDates.class, adjustableDatesList);
		}
		
		return adjustableDatesList;
	}

	protected abstract List<AdjustableDates.AdjustableDatesBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAdjustableDatesListDefault extends MapAdjustableDatesList {
		@Override
		protected List<AdjustableDates.AdjustableDatesBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AdjustableDates.AdjustableDatesBuilder> adjustableDatesList = new ArrayList<>();
			return assignOutput(adjustableDatesList, fpmlDataDocument);
		}
		
		protected List<AdjustableDates.AdjustableDatesBuilder> assignOutput(List<AdjustableDates.AdjustableDatesBuilder> adjustableDatesList, DataDocument fpmlDataDocument) {
			adjustableDatesList.addAll(toBuilder(MapperC.<AdjustableDates>of(MapperS.of(AdjustableDates.builder()
				.setUnadjustedDate(Collections.<Date>emptyList())
				.setDateAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.setAdjustedDateValue(Collections.<Date>emptyList())
				.build())).getMulti()));
			
			return Optional.ofNullable(adjustableDatesList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
