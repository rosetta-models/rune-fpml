package fpml.mapping.functions;

import cdm.product.common.schedule.FxLinkedNotionalSchedule;
import cdm.product.common.schedule.FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxLinkedNotionalSchedule.MapFxLinkedNotionalScheduleDefault.class)
public abstract class MapFxLinkedNotionalSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapFxSpotRateSource mapFxSpotRateSource;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;
	@Inject protected MapVaryingNotionalCurrencyWithScheme mapVaryingNotionalCurrencyWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return fxLinkedNotionalSchedule 
	*/
	public FxLinkedNotionalSchedule evaluate(DataDocument fpmlDataDocument) {
		FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder fxLinkedNotionalScheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final FxLinkedNotionalSchedule fxLinkedNotionalSchedule;
		if (fxLinkedNotionalScheduleBuilder == null) {
			fxLinkedNotionalSchedule = null;
		} else {
			fxLinkedNotionalSchedule = fxLinkedNotionalScheduleBuilder.build();
			objectValidator.validate(FxLinkedNotionalSchedule.class, fxLinkedNotionalSchedule);
		}
		
		return fxLinkedNotionalSchedule;
	}

	protected abstract FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFxLinkedNotionalScheduleDefault extends MapFxLinkedNotionalSchedule {
		@Override
		protected FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder fxLinkedNotionalSchedule = FxLinkedNotionalSchedule.builder();
			return assignOutput(fxLinkedNotionalSchedule, fpmlDataDocument);
		}
		
		protected FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder assignOutput(FxLinkedNotionalSchedule.FxLinkedNotionalScheduleBuilder fxLinkedNotionalSchedule, DataDocument fpmlDataDocument) {
			fxLinkedNotionalSchedule = toBuilder(FxLinkedNotionalSchedule.builder()
				.setVaryingNotionalCurrencyValue(mapVaryingNotionalCurrencyWithScheme.evaluate(fpmlDataDocument))
				.setVaryingNotionalFixingDates(mapRelativeDateOffset.evaluate(fpmlDataDocument))
				.setFxSpotRateSource(mapFxSpotRateSource.evaluate(fpmlDataDocument))
				.setFixingTime(mapBusinessCenterTime.evaluate(fpmlDataDocument))
				.setVaryingNotionalInterimExchangePaymentDates(mapRelativeDateOffset.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(fxLinkedNotionalSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
