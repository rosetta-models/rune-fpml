package fpml.mapping.functions;

import cdm.product.asset.FloatingAmountProvisions;
import cdm.product.asset.FloatingAmountProvisions.FloatingAmountProvisionsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFloatingAmountProvisions.MapFloatingAmountProvisionsDefault.class)
public abstract class MapFloatingAmountProvisions implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return floatingAmountProvisions 
	*/
	public FloatingAmountProvisions evaluate(DataDocument fpmlDataDocument) {
		FloatingAmountProvisions.FloatingAmountProvisionsBuilder floatingAmountProvisionsBuilder = doEvaluate(fpmlDataDocument);
		
		final FloatingAmountProvisions floatingAmountProvisions;
		if (floatingAmountProvisionsBuilder == null) {
			floatingAmountProvisions = null;
		} else {
			floatingAmountProvisions = floatingAmountProvisionsBuilder.build();
			objectValidator.validate(FloatingAmountProvisions.class, floatingAmountProvisions);
		}
		
		return floatingAmountProvisions;
	}

	protected abstract FloatingAmountProvisions.FloatingAmountProvisionsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFloatingAmountProvisionsDefault extends MapFloatingAmountProvisions {
		@Override
		protected FloatingAmountProvisions.FloatingAmountProvisionsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FloatingAmountProvisions.FloatingAmountProvisionsBuilder floatingAmountProvisions = FloatingAmountProvisions.builder();
			return assignOutput(floatingAmountProvisions, fpmlDataDocument);
		}
		
		protected FloatingAmountProvisions.FloatingAmountProvisionsBuilder assignOutput(FloatingAmountProvisions.FloatingAmountProvisionsBuilder floatingAmountProvisions, DataDocument fpmlDataDocument) {
			floatingAmountProvisions = toBuilder(FloatingAmountProvisions.builder()
				.setWacCapInterestProvision(null)
				.setStepUpProvision(null)
				.build());
			
			return Optional.ofNullable(floatingAmountProvisions)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
