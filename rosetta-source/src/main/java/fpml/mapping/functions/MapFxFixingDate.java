package fpml.mapping.functions;

import cdm.product.common.settlement.FxFixingDate;
import cdm.product.common.settlement.FxFixingDate.FxFixingDateBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxFixingDate.MapFxFixingDateDefault.class)
public abstract class MapFxFixingDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessCenters mapBusinessCenters;
	@Inject protected MapDateRelativeToCalculationPeriodDates mapDateRelativeToCalculationPeriodDates;
	@Inject protected MapDateRelativeToPaymentDates mapDateRelativeToPaymentDates;
	@Inject protected MapDateRelativeToValuationDates mapDateRelativeToValuationDates;

	/**
	* @param fpmlDataDocument 
	* @return fxFixingDate 
	*/
	public FxFixingDate evaluate(DataDocument fpmlDataDocument) {
		FxFixingDate.FxFixingDateBuilder fxFixingDateBuilder = doEvaluate(fpmlDataDocument);
		
		final FxFixingDate fxFixingDate;
		if (fxFixingDateBuilder == null) {
			fxFixingDate = null;
		} else {
			fxFixingDate = fxFixingDateBuilder.build();
			objectValidator.validate(FxFixingDate.class, fxFixingDate);
		}
		
		return fxFixingDate;
	}

	protected abstract FxFixingDate.FxFixingDateBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFxFixingDateDefault extends MapFxFixingDate {
		@Override
		protected FxFixingDate.FxFixingDateBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FxFixingDate.FxFixingDateBuilder fxFixingDate = FxFixingDate.builder();
			return assignOutput(fxFixingDate, fpmlDataDocument);
		}
		
		protected FxFixingDate.FxFixingDateBuilder assignOutput(FxFixingDate.FxFixingDateBuilder fxFixingDate, DataDocument fpmlDataDocument) {
			fxFixingDate = toBuilder(FxFixingDate.builder()
				.setPeriodMultiplier(null)
				.setPeriod(null)
				.setDayType(null)
				.setBusinessDayConvention(null)
				.setBusinessCenters(mapBusinessCenters.evaluate(fpmlDataDocument))
				.setBusinessCentersReferenceValue(mapBusinessCenters.evaluate(fpmlDataDocument))
				.setDateRelativeToPaymentDates(mapDateRelativeToPaymentDates.evaluate(fpmlDataDocument))
				.setDateRelativeToCalculationPeriodDates(mapDateRelativeToCalculationPeriodDates.evaluate(fpmlDataDocument))
				.setDateRelativeToValuationDates(mapDateRelativeToValuationDates.evaluate(fpmlDataDocument))
				.setFxFixingDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(fxFixingDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
