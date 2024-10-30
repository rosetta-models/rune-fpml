package fpml.mapping.functions;

import cdm.product.common.settlement.FixedPrice;
import cdm.product.common.settlement.FixedPrice.FixedPriceBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFixedPrice.MapFixedPriceDefault.class)
public abstract class MapFixedPrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPriceSchedule mapPriceSchedule;

	/**
	* @param fpmlDataDocument 
	* @return fixedPrice 
	*/
	public FixedPrice evaluate(DataDocument fpmlDataDocument) {
		FixedPrice.FixedPriceBuilder fixedPriceBuilder = doEvaluate(fpmlDataDocument);
		
		final FixedPrice fixedPrice;
		if (fixedPriceBuilder == null) {
			fixedPrice = null;
		} else {
			fixedPrice = fixedPriceBuilder.build();
			objectValidator.validate(FixedPrice.class, fixedPrice);
		}
		
		return fixedPrice;
	}

	protected abstract FixedPrice.FixedPriceBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFixedPriceDefault extends MapFixedPrice {
		@Override
		protected FixedPrice.FixedPriceBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FixedPrice.FixedPriceBuilder fixedPrice = FixedPrice.builder();
			return assignOutput(fixedPrice, fpmlDataDocument);
		}
		
		protected FixedPrice.FixedPriceBuilder assignOutput(FixedPrice.FixedPriceBuilder fixedPrice, DataDocument fpmlDataDocument) {
			fixedPrice = toBuilder(FixedPrice.builder()
				.setPriceValue(mapPriceSchedule.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(fixedPrice)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
