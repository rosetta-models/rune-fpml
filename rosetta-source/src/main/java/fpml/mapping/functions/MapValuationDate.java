package fpml.mapping.functions;

import cdm.product.common.settlement.ValuationDate;
import cdm.product.common.settlement.ValuationDate.ValuationDateBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapValuationDate.MapValuationDateDefault.class)
public abstract class MapValuationDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDates mapAdjustableDates;
	@Inject protected MapFxFixingDate mapFxFixingDate;
	@Inject protected MapMultipleValuationDates mapMultipleValuationDates;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;
	@Inject protected MapSingleValuationDate mapSingleValuationDate;

	/**
	* @param fpmlDataDocument 
	* @return valuationDate 
	*/
	public ValuationDate evaluate(DataDocument fpmlDataDocument) {
		ValuationDate.ValuationDateBuilder valuationDateBuilder = doEvaluate(fpmlDataDocument);
		
		final ValuationDate valuationDate;
		if (valuationDateBuilder == null) {
			valuationDate = null;
		} else {
			valuationDate = valuationDateBuilder.build();
			objectValidator.validate(ValuationDate.class, valuationDate);
		}
		
		return valuationDate;
	}

	protected abstract ValuationDate.ValuationDateBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapValuationDateDefault extends MapValuationDate {
		@Override
		protected ValuationDate.ValuationDateBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ValuationDate.ValuationDateBuilder valuationDate = ValuationDate.builder();
			return assignOutput(valuationDate, fpmlDataDocument);
		}
		
		protected ValuationDate.ValuationDateBuilder assignOutput(ValuationDate.ValuationDateBuilder valuationDate, DataDocument fpmlDataDocument) {
			valuationDate = toBuilder(ValuationDate.builder()
				.setSingleValuationDate(mapSingleValuationDate.evaluate(fpmlDataDocument))
				.setMultipleValuationDates(mapMultipleValuationDates.evaluate(fpmlDataDocument))
				.setValuationDate(mapRelativeDateOffset.evaluate(fpmlDataDocument))
				.setFxFixingDate(mapFxFixingDate.evaluate(fpmlDataDocument))
				.setFxFixingSchedule(mapAdjustableDates.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(valuationDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
