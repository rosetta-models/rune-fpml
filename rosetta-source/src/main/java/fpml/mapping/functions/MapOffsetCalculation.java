package fpml.mapping.functions;

import cdm.observable.asset.calculatedrate.OffsetCalculation;
import cdm.observable.asset.calculatedrate.OffsetCalculation.OffsetCalculationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOffsetCalculation.MapOffsetCalculationDefault.class)
public abstract class MapOffsetCalculation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return offsetCalculation 
	*/
	public OffsetCalculation evaluate(DataDocument fpmlDataDocument) {
		OffsetCalculation.OffsetCalculationBuilder offsetCalculationBuilder = doEvaluate(fpmlDataDocument);
		
		final OffsetCalculation offsetCalculation;
		if (offsetCalculationBuilder == null) {
			offsetCalculation = null;
		} else {
			offsetCalculation = offsetCalculationBuilder.build();
			objectValidator.validate(OffsetCalculation.class, offsetCalculation);
		}
		
		return offsetCalculation;
	}

	protected abstract OffsetCalculation.OffsetCalculationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapOffsetCalculationDefault extends MapOffsetCalculation {
		@Override
		protected OffsetCalculation.OffsetCalculationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			OffsetCalculation.OffsetCalculationBuilder offsetCalculation = OffsetCalculation.builder();
			return assignOutput(offsetCalculation, fpmlDataDocument);
		}
		
		protected OffsetCalculation.OffsetCalculationBuilder assignOutput(OffsetCalculation.OffsetCalculationBuilder offsetCalculation, DataDocument fpmlDataDocument) {
			offsetCalculation = toBuilder(OffsetCalculation.builder()
				.setOffsetDays(null)
				.build());
			
			return Optional.ofNullable(offsetCalculation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
