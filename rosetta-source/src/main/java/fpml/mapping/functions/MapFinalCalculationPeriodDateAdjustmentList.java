package fpml.mapping.functions;

import cdm.product.common.schedule.FinalCalculationPeriodDateAdjustment;
import cdm.product.common.schedule.FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder;
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


@ImplementedBy(MapFinalCalculationPeriodDateAdjustmentList.MapFinalCalculationPeriodDateAdjustmentListDefault.class)
public abstract class MapFinalCalculationPeriodDateAdjustmentList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDates mapAdjustableOrRelativeDates;
	@Inject protected MapInterestRatePayout mapInterestRatePayout;

	/**
	* @param fpmlDataDocument 
	* @return finalCalculationPeriodDateAdjustmentList 
	*/
	public List<? extends FinalCalculationPeriodDateAdjustment> evaluate(DataDocument fpmlDataDocument) {
		List<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> finalCalculationPeriodDateAdjustmentListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustmentList;
		if (finalCalculationPeriodDateAdjustmentListBuilder == null) {
			finalCalculationPeriodDateAdjustmentList = null;
		} else {
			finalCalculationPeriodDateAdjustmentList = finalCalculationPeriodDateAdjustmentListBuilder.stream().map(FinalCalculationPeriodDateAdjustment::build).collect(Collectors.toList());
			objectValidator.validate(FinalCalculationPeriodDateAdjustment.class, finalCalculationPeriodDateAdjustmentList);
		}
		
		return finalCalculationPeriodDateAdjustmentList;
	}

	protected abstract List<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFinalCalculationPeriodDateAdjustmentListDefault extends MapFinalCalculationPeriodDateAdjustmentList {
		@Override
		protected List<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> finalCalculationPeriodDateAdjustmentList = new ArrayList<>();
			return assignOutput(finalCalculationPeriodDateAdjustmentList, fpmlDataDocument);
		}
		
		protected List<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> assignOutput(List<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> finalCalculationPeriodDateAdjustmentList, DataDocument fpmlDataDocument) {
			finalCalculationPeriodDateAdjustmentList.addAll(toBuilder(MapperC.<FinalCalculationPeriodDateAdjustment>of(MapperS.of(FinalCalculationPeriodDateAdjustment.builder()
				.setRelevantUnderlyingDateReferenceValue(mapAdjustableOrRelativeDates.evaluate(fpmlDataDocument))
				.setSwapStreamReferenceValue(mapInterestRatePayout.evaluate(fpmlDataDocument))
				.setBusinessDayConvention(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(finalCalculationPeriodDateAdjustmentList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
