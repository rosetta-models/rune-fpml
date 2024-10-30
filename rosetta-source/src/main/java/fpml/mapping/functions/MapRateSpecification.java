package fpml.mapping.functions;

import cdm.product.asset.RateSpecification;
import cdm.product.asset.RateSpecification.RateSpecificationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRateSpecification.MapRateSpecificationDefault.class)
public abstract class MapRateSpecification implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFixedRateSpecification mapFixedRateSpecification;
	@Inject protected MapFloatingRateSpecification mapFloatingRateSpecification;
	@Inject protected MapInflationRateSpecification mapInflationRateSpecification;

	/**
	* @param fpmlDataDocument 
	* @return rateSpecification 
	*/
	public RateSpecification evaluate(DataDocument fpmlDataDocument) {
		RateSpecification.RateSpecificationBuilder rateSpecificationBuilder = doEvaluate(fpmlDataDocument);
		
		final RateSpecification rateSpecification;
		if (rateSpecificationBuilder == null) {
			rateSpecification = null;
		} else {
			rateSpecification = rateSpecificationBuilder.build();
			objectValidator.validate(RateSpecification.class, rateSpecification);
		}
		
		return rateSpecification;
	}

	protected abstract RateSpecification.RateSpecificationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRateSpecificationDefault extends MapRateSpecification {
		@Override
		protected RateSpecification.RateSpecificationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			RateSpecification.RateSpecificationBuilder rateSpecification = RateSpecification.builder();
			return assignOutput(rateSpecification, fpmlDataDocument);
		}
		
		protected RateSpecification.RateSpecificationBuilder assignOutput(RateSpecification.RateSpecificationBuilder rateSpecification, DataDocument fpmlDataDocument) {
			rateSpecification = toBuilder(RateSpecification.builder()
				.setFixedRateSpecification(mapFixedRateSpecification.evaluate(fpmlDataDocument))
				.setFloatingRateSpecification(mapFloatingRateSpecification.evaluate(fpmlDataDocument))
				.setInflationRateSpecification(mapInflationRateSpecification.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(rateSpecification)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
