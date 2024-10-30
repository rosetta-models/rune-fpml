package fpml.mapping.functions;

import cdm.product.template.OptionalEarlyTermination;
import cdm.product.template.OptionalEarlyTermination.OptionalEarlyTerminationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOptionalEarlyTermination.MapOptionalEarlyTerminationDefault.class)
public abstract class MapOptionalEarlyTermination implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapCalculationAgent mapCalculationAgent;
	@Inject protected MapExerciseNoticeList mapExerciseNoticeList;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapOptionalEarlyTerminationAdjustedDates mapOptionalEarlyTerminationAdjustedDates;
	@Inject protected MapSettlementTerms mapSettlementTerms;

	/**
	* @param fpmlDataDocument 
	* @return optionalEarlyTermination 
	*/
	public OptionalEarlyTermination evaluate(DataDocument fpmlDataDocument) {
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder optionalEarlyTerminationBuilder = doEvaluate(fpmlDataDocument);
		
		final OptionalEarlyTermination optionalEarlyTermination;
		if (optionalEarlyTerminationBuilder == null) {
			optionalEarlyTermination = null;
		} else {
			optionalEarlyTermination = optionalEarlyTerminationBuilder.build();
			objectValidator.validate(OptionalEarlyTermination.class, optionalEarlyTermination);
		}
		
		return optionalEarlyTermination;
	}

	protected abstract OptionalEarlyTermination.OptionalEarlyTerminationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapOptionalEarlyTerminationDefault extends MapOptionalEarlyTermination {
		@Override
		protected OptionalEarlyTermination.OptionalEarlyTerminationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			OptionalEarlyTermination.OptionalEarlyTerminationBuilder optionalEarlyTermination = OptionalEarlyTermination.builder();
			return assignOutput(optionalEarlyTermination, fpmlDataDocument);
		}
		
		protected OptionalEarlyTermination.OptionalEarlyTerminationBuilder assignOutput(OptionalEarlyTermination.OptionalEarlyTerminationBuilder optionalEarlyTermination, DataDocument fpmlDataDocument) {
			optionalEarlyTermination = toBuilder(OptionalEarlyTermination.builder()
				.setSinglePartyOption(mapBuyerSeller.evaluate(fpmlDataDocument))
				.setMutualEarlyTermination(null)
				.setExerciseNotice(new ArrayList(mapExerciseNoticeList.evaluate(fpmlDataDocument)))
				.setFollowUpConfirmation(null)
				.setCalculationAgent(mapCalculationAgent.evaluate(fpmlDataDocument))
				.setCashSettlement(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setOptionalEarlyTerminationAdjustedDates(mapOptionalEarlyTerminationAdjustedDates.evaluate(fpmlDataDocument))
				.setExerciseTerms(mapExerciseTerms.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(optionalEarlyTermination)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
