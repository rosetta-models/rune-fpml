package fpml.mapping.functions;

import cdm.product.asset.DiscountingMethod;
import cdm.product.asset.DiscountingMethod.DiscountingMethodBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDiscountingMethod.MapDiscountingMethodDefault.class)
public abstract class MapDiscountingMethod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDiscountRateDayCountFractionWithScheme mapDiscountRateDayCountFractionWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return discountingMethod 
	*/
	public DiscountingMethod evaluate(DataDocument fpmlDataDocument) {
		DiscountingMethod.DiscountingMethodBuilder discountingMethodBuilder = doEvaluate(fpmlDataDocument);
		
		final DiscountingMethod discountingMethod;
		if (discountingMethodBuilder == null) {
			discountingMethod = null;
		} else {
			discountingMethod = discountingMethodBuilder.build();
			objectValidator.validate(DiscountingMethod.class, discountingMethod);
		}
		
		return discountingMethod;
	}

	protected abstract DiscountingMethod.DiscountingMethodBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDiscountingMethodDefault extends MapDiscountingMethod {
		@Override
		protected DiscountingMethod.DiscountingMethodBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DiscountingMethod.DiscountingMethodBuilder discountingMethod = DiscountingMethod.builder();
			return assignOutput(discountingMethod, fpmlDataDocument);
		}
		
		protected DiscountingMethod.DiscountingMethodBuilder assignOutput(DiscountingMethod.DiscountingMethodBuilder discountingMethod, DataDocument fpmlDataDocument) {
			discountingMethod = toBuilder(DiscountingMethod.builder()
				.setDiscountingType(null)
				.setDiscountRate(null)
				.setDiscountRateDayCountFractionValue(mapDiscountRateDayCountFractionWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(discountingMethod)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
