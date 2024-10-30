package fpml.mapping.functions;

import cdm.observable.asset.ValuationPostponement;
import cdm.observable.asset.ValuationPostponement.ValuationPostponementBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapValuationPostponement.MapValuationPostponementDefault.class)
public abstract class MapValuationPostponement implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return valuationPostponement 
	*/
	public ValuationPostponement evaluate(DataDocument fpmlDataDocument) {
		ValuationPostponement.ValuationPostponementBuilder valuationPostponementBuilder = doEvaluate(fpmlDataDocument);
		
		final ValuationPostponement valuationPostponement;
		if (valuationPostponementBuilder == null) {
			valuationPostponement = null;
		} else {
			valuationPostponement = valuationPostponementBuilder.build();
			objectValidator.validate(ValuationPostponement.class, valuationPostponement);
		}
		
		return valuationPostponement;
	}

	protected abstract ValuationPostponement.ValuationPostponementBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapValuationPostponementDefault extends MapValuationPostponement {
		@Override
		protected ValuationPostponement.ValuationPostponementBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ValuationPostponement.ValuationPostponementBuilder valuationPostponement = ValuationPostponement.builder();
			return assignOutput(valuationPostponement, fpmlDataDocument);
		}
		
		protected ValuationPostponement.ValuationPostponementBuilder assignOutput(ValuationPostponement.ValuationPostponementBuilder valuationPostponement, DataDocument fpmlDataDocument) {
			valuationPostponement = toBuilder(ValuationPostponement.builder()
				.setMaximumDaysOfPostponement(null)
				.build());
			
			return Optional.ofNullable(valuationPostponement)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
