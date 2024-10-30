package fpml.mapping.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder;
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


@ImplementedBy(MapNonNegativeQuantityScheduleList.MapNonNegativeQuantityScheduleListDefault.class)
public abstract class MapNonNegativeQuantityScheduleList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDatedValueList mapDatedValueList;
	@Inject protected MapFrequency mapFrequency;
	@Inject protected MapMeasure mapMeasure;
	@Inject protected MapUnitType mapUnitType;

	/**
	* @param fpmlDataDocument 
	* @return nonNegativeQuantityScheduleList 
	*/
	public List<? extends NonNegativeQuantitySchedule> evaluate(DataDocument fpmlDataDocument) {
		List<NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder> nonNegativeQuantityScheduleListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends NonNegativeQuantitySchedule> nonNegativeQuantityScheduleList;
		if (nonNegativeQuantityScheduleListBuilder == null) {
			nonNegativeQuantityScheduleList = null;
		} else {
			nonNegativeQuantityScheduleList = nonNegativeQuantityScheduleListBuilder.stream().map(NonNegativeQuantitySchedule::build).collect(Collectors.toList());
			objectValidator.validate(NonNegativeQuantitySchedule.class, nonNegativeQuantityScheduleList);
		}
		
		return nonNegativeQuantityScheduleList;
	}

	protected abstract List<NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapNonNegativeQuantityScheduleListDefault extends MapNonNegativeQuantityScheduleList {
		@Override
		protected List<NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder> nonNegativeQuantityScheduleList = new ArrayList<>();
			return assignOutput(nonNegativeQuantityScheduleList, fpmlDataDocument);
		}
		
		protected List<NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder> assignOutput(List<NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder> nonNegativeQuantityScheduleList, DataDocument fpmlDataDocument) {
			nonNegativeQuantityScheduleList.addAll(toBuilder(MapperC.<NonNegativeQuantitySchedule>of(MapperS.of(NonNegativeQuantitySchedule.builder()
				.setValue(null)
				.setUnit(mapUnitType.evaluate(fpmlDataDocument))
				.setDatedValue(new ArrayList(mapDatedValueList.evaluate(fpmlDataDocument)))
				.setMultiplier(mapMeasure.evaluate(fpmlDataDocument))
				.setFrequency(mapFrequency.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(nonNegativeQuantityScheduleList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
