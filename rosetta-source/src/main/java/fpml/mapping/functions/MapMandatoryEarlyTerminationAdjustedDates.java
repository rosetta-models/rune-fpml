package fpml.mapping.functions;

import cdm.product.template.MandatoryEarlyTerminationAdjustedDates;
import cdm.product.template.MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMandatoryEarlyTerminationAdjustedDates.MapMandatoryEarlyTerminationAdjustedDatesDefault.class)
public abstract class MapMandatoryEarlyTerminationAdjustedDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return mandatoryEarlyTerminationAdjustedDates 
	*/
	public MandatoryEarlyTerminationAdjustedDates evaluate(DataDocument fpmlDataDocument) {
		MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder mandatoryEarlyTerminationAdjustedDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final MandatoryEarlyTerminationAdjustedDates mandatoryEarlyTerminationAdjustedDates;
		if (mandatoryEarlyTerminationAdjustedDatesBuilder == null) {
			mandatoryEarlyTerminationAdjustedDates = null;
		} else {
			mandatoryEarlyTerminationAdjustedDates = mandatoryEarlyTerminationAdjustedDatesBuilder.build();
			objectValidator.validate(MandatoryEarlyTerminationAdjustedDates.class, mandatoryEarlyTerminationAdjustedDates);
		}
		
		return mandatoryEarlyTerminationAdjustedDates;
	}

	protected abstract MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMandatoryEarlyTerminationAdjustedDatesDefault extends MapMandatoryEarlyTerminationAdjustedDates {
		@Override
		protected MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder mandatoryEarlyTerminationAdjustedDates = MandatoryEarlyTerminationAdjustedDates.builder();
			return assignOutput(mandatoryEarlyTerminationAdjustedDates, fpmlDataDocument);
		}
		
		protected MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder assignOutput(MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder mandatoryEarlyTerminationAdjustedDates, DataDocument fpmlDataDocument) {
			mandatoryEarlyTerminationAdjustedDates = toBuilder(MandatoryEarlyTerminationAdjustedDates.builder()
				.setAdjustedEarlyTerminationDate(null)
				.setAdjustedCashSettlementValuationDate(null)
				.setAdjustedCashSettlementPaymentDate(null)
				.build());
			
			return Optional.ofNullable(mandatoryEarlyTerminationAdjustedDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
