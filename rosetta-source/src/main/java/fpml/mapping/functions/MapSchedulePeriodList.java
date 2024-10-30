package fpml.mapping.functions;

import cdm.product.template.SchedulePeriod;
import cdm.product.template.SchedulePeriod.SchedulePeriodBuilder;
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


@ImplementedBy(MapSchedulePeriodList.MapSchedulePeriodListDefault.class)
public abstract class MapSchedulePeriodList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationScheduleDeliveryPeriods mapCalculationScheduleDeliveryPeriods;
	@Inject protected MapDateRange mapDateRange;

	/**
	* @param fpmlDataDocument 
	* @return schedulePeriodList 
	*/
	public List<? extends SchedulePeriod> evaluate(DataDocument fpmlDataDocument) {
		List<SchedulePeriod.SchedulePeriodBuilder> schedulePeriodListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends SchedulePeriod> schedulePeriodList;
		if (schedulePeriodListBuilder == null) {
			schedulePeriodList = null;
		} else {
			schedulePeriodList = schedulePeriodListBuilder.stream().map(SchedulePeriod::build).collect(Collectors.toList());
			objectValidator.validate(SchedulePeriod.class, schedulePeriodList);
		}
		
		return schedulePeriodList;
	}

	protected abstract List<SchedulePeriod.SchedulePeriodBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSchedulePeriodListDefault extends MapSchedulePeriodList {
		@Override
		protected List<SchedulePeriod.SchedulePeriodBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<SchedulePeriod.SchedulePeriodBuilder> schedulePeriodList = new ArrayList<>();
			return assignOutput(schedulePeriodList, fpmlDataDocument);
		}
		
		protected List<SchedulePeriod.SchedulePeriodBuilder> assignOutput(List<SchedulePeriod.SchedulePeriodBuilder> schedulePeriodList, DataDocument fpmlDataDocument) {
			schedulePeriodList.addAll(toBuilder(MapperC.<SchedulePeriod>of(MapperS.of(SchedulePeriod.builder()
				.setCalculationPeriod(mapDateRange.evaluate(fpmlDataDocument))
				.setPaymentDate(null)
				.setFixingPeriod(mapDateRange.evaluate(fpmlDataDocument))
				.setDeliveryPeriod(mapCalculationScheduleDeliveryPeriods.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(schedulePeriodList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
