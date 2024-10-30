package fpml.mapping.functions;

import cdm.observable.asset.ValuationDates;
import cdm.observable.asset.ValuationDates.ValuationDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapValuationDates.MapValuationDatesDefault.class)
public abstract class MapValuationDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPerformanceValuationDates mapPerformanceValuationDates;

	/**
	* @param fpmlDataDocument 
	* @return valuationDates 
	*/
	public ValuationDates evaluate(DataDocument fpmlDataDocument) {
		ValuationDates.ValuationDatesBuilder valuationDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final ValuationDates valuationDates;
		if (valuationDatesBuilder == null) {
			valuationDates = null;
		} else {
			valuationDates = valuationDatesBuilder.build();
			objectValidator.validate(ValuationDates.class, valuationDates);
		}
		
		return valuationDates;
	}

	protected abstract ValuationDates.ValuationDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapValuationDatesDefault extends MapValuationDates {
		@Override
		protected ValuationDates.ValuationDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ValuationDates.ValuationDatesBuilder valuationDates = ValuationDates.builder();
			return assignOutput(valuationDates, fpmlDataDocument);
		}
		
		protected ValuationDates.ValuationDatesBuilder assignOutput(ValuationDates.ValuationDatesBuilder valuationDates, DataDocument fpmlDataDocument) {
			valuationDates = toBuilder(ValuationDates.builder()
				.setInitialValuationDate(mapPerformanceValuationDates.evaluate(fpmlDataDocument))
				.setInterimValuationDate(mapPerformanceValuationDates.evaluate(fpmlDataDocument))
				.setFinalValuationDate(mapPerformanceValuationDates.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(valuationDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
