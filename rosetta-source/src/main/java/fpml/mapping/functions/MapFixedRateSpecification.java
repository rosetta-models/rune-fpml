package fpml.mapping.functions;

import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.FixedRateSpecification.FixedRateSpecificationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFixedRateSpecification.MapFixedRateSpecificationDefault.class)
public abstract class MapFixedRateSpecification implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapRateSchedule mapRateSchedule;

	/**
	* @param fpmlDataDocument 
	* @return fixedRateSpecification 
	*/
	public FixedRateSpecification evaluate(DataDocument fpmlDataDocument) {
		FixedRateSpecification.FixedRateSpecificationBuilder fixedRateSpecificationBuilder = doEvaluate(fpmlDataDocument);
		
		final FixedRateSpecification fixedRateSpecification;
		if (fixedRateSpecificationBuilder == null) {
			fixedRateSpecification = null;
		} else {
			fixedRateSpecification = fixedRateSpecificationBuilder.build();
			objectValidator.validate(FixedRateSpecification.class, fixedRateSpecification);
		}
		
		return fixedRateSpecification;
	}

	protected abstract FixedRateSpecification.FixedRateSpecificationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFixedRateSpecificationDefault extends MapFixedRateSpecification {
		@Override
		protected FixedRateSpecification.FixedRateSpecificationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FixedRateSpecification.FixedRateSpecificationBuilder fixedRateSpecification = FixedRateSpecification.builder();
			return assignOutput(fixedRateSpecification, fpmlDataDocument);
		}
		
		protected FixedRateSpecification.FixedRateSpecificationBuilder assignOutput(FixedRateSpecification.FixedRateSpecificationBuilder fixedRateSpecification, DataDocument fpmlDataDocument) {
			fixedRateSpecification = toBuilder(FixedRateSpecification.builder()
				.setRateSchedule(mapRateSchedule.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(fixedRateSpecification)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
