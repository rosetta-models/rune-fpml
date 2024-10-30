package fpml.mapping.functions;

import cdm.product.template.AveragingCalculation;
import cdm.product.template.AveragingCalculation.AveragingCalculationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAveragingCalculation.MapAveragingCalculationDefault.class)
public abstract class MapAveragingCalculation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAveragingCalculationMethod mapAveragingCalculationMethod;
	@Inject protected MapRounding mapRounding;

	/**
	* @param fpmlDataDocument 
	* @return averagingCalculation 
	*/
	public AveragingCalculation evaluate(DataDocument fpmlDataDocument) {
		AveragingCalculation.AveragingCalculationBuilder averagingCalculationBuilder = doEvaluate(fpmlDataDocument);
		
		final AveragingCalculation averagingCalculation;
		if (averagingCalculationBuilder == null) {
			averagingCalculation = null;
		} else {
			averagingCalculation = averagingCalculationBuilder.build();
			objectValidator.validate(AveragingCalculation.class, averagingCalculation);
		}
		
		return averagingCalculation;
	}

	protected abstract AveragingCalculation.AveragingCalculationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAveragingCalculationDefault extends MapAveragingCalculation {
		@Override
		protected AveragingCalculation.AveragingCalculationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AveragingCalculation.AveragingCalculationBuilder averagingCalculation = AveragingCalculation.builder();
			return assignOutput(averagingCalculation, fpmlDataDocument);
		}
		
		protected AveragingCalculation.AveragingCalculationBuilder assignOutput(AveragingCalculation.AveragingCalculationBuilder averagingCalculation, DataDocument fpmlDataDocument) {
			averagingCalculation = toBuilder(AveragingCalculation.builder()
				.setAveragingMethod(mapAveragingCalculationMethod.evaluate(fpmlDataDocument))
				.setPrecision(mapRounding.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(averagingCalculation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
