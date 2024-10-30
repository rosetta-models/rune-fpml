package fpml.mapping.functions;

import cdm.product.asset.StubFloatingRate;
import cdm.product.asset.StubFloatingRate.StubFloatingRateBuilder;
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


@ImplementedBy(MapStubFloatingRateList.MapStubFloatingRateListDefault.class)
public abstract class MapStubFloatingRateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriod mapPeriod;
	@Inject protected MapSchedule mapSchedule;
	@Inject protected MapSpreadScheduleList mapSpreadScheduleList;
	@Inject protected MapStrikeScheduleList mapStrikeScheduleList;

	/**
	* @param fpmlDataDocument 
	* @return stubFloatingRateList 
	*/
	public List<? extends StubFloatingRate> evaluate(DataDocument fpmlDataDocument) {
		List<StubFloatingRate.StubFloatingRateBuilder> stubFloatingRateListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends StubFloatingRate> stubFloatingRateList;
		if (stubFloatingRateListBuilder == null) {
			stubFloatingRateList = null;
		} else {
			stubFloatingRateList = stubFloatingRateListBuilder.stream().map(StubFloatingRate::build).collect(Collectors.toList());
			objectValidator.validate(StubFloatingRate.class, stubFloatingRateList);
		}
		
		return stubFloatingRateList;
	}

	protected abstract List<StubFloatingRate.StubFloatingRateBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapStubFloatingRateListDefault extends MapStubFloatingRateList {
		@Override
		protected List<StubFloatingRate.StubFloatingRateBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<StubFloatingRate.StubFloatingRateBuilder> stubFloatingRateList = new ArrayList<>();
			return assignOutput(stubFloatingRateList, fpmlDataDocument);
		}
		
		protected List<StubFloatingRate.StubFloatingRateBuilder> assignOutput(List<StubFloatingRate.StubFloatingRateBuilder> stubFloatingRateList, DataDocument fpmlDataDocument) {
			stubFloatingRateList.addAll(toBuilder(MapperC.<StubFloatingRate>of(MapperS.of(StubFloatingRate.builder()
				.setFloatingRateIndex(null)
				.setIndexTenor(mapPeriod.evaluate(fpmlDataDocument))
				.setFloatingRateMultiplierSchedule(mapSchedule.evaluate(fpmlDataDocument))
				.setSpreadSchedule(new ArrayList(mapSpreadScheduleList.evaluate(fpmlDataDocument)))
				.setRateTreatment(null)
				.setCapRateSchedule(new ArrayList(mapStrikeScheduleList.evaluate(fpmlDataDocument)))
				.setFloorRateSchedule(new ArrayList(mapStrikeScheduleList.evaluate(fpmlDataDocument)))
				.build())).getMulti()));
			
			return Optional.ofNullable(stubFloatingRateList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
