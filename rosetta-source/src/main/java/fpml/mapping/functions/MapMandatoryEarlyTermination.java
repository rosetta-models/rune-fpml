package fpml.mapping.functions;

import cdm.product.template.MandatoryEarlyTermination;
import cdm.product.template.MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMandatoryEarlyTermination.MapMandatoryEarlyTerminationDefault.class)
public abstract class MapMandatoryEarlyTermination implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapCalculationAgent mapCalculationAgent;
	@Inject protected MapMandatoryEarlyTerminationAdjustedDates mapMandatoryEarlyTerminationAdjustedDates;
	@Inject protected MapSettlementTerms mapSettlementTerms;

	/**
	* @param fpmlDataDocument 
	* @return mandatoryEarlyTermination 
	*/
	public MandatoryEarlyTermination evaluate(DataDocument fpmlDataDocument) {
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder mandatoryEarlyTerminationBuilder = doEvaluate(fpmlDataDocument);
		
		final MandatoryEarlyTermination mandatoryEarlyTermination;
		if (mandatoryEarlyTerminationBuilder == null) {
			mandatoryEarlyTermination = null;
		} else {
			mandatoryEarlyTermination = mandatoryEarlyTerminationBuilder.build();
			objectValidator.validate(MandatoryEarlyTermination.class, mandatoryEarlyTermination);
		}
		
		return mandatoryEarlyTermination;
	}

	protected abstract MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMandatoryEarlyTerminationDefault extends MapMandatoryEarlyTermination {
		@Override
		protected MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder mandatoryEarlyTermination = MandatoryEarlyTermination.builder();
			return assignOutput(mandatoryEarlyTermination, fpmlDataDocument);
		}
		
		protected MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder assignOutput(MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder mandatoryEarlyTermination, DataDocument fpmlDataDocument) {
			mandatoryEarlyTermination = toBuilder(MandatoryEarlyTermination.builder()
				.setMandatoryEarlyTerminationDate(mapAdjustableDate.evaluate(fpmlDataDocument))
				.setCalculationAgent(mapCalculationAgent.evaluate(fpmlDataDocument))
				.setCashSettlement(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setMandatoryEarlyTerminationAdjustedDates(mapMandatoryEarlyTerminationAdjustedDates.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(mandatoryEarlyTermination)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
