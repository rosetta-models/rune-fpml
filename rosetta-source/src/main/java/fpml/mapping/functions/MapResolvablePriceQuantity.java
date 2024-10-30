package fpml.mapping.functions;

import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.ResolvablePriceQuantity.ResolvablePriceQuantityBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapResolvablePriceQuantity.MapResolvablePriceQuantityDefault.class)
public abstract class MapResolvablePriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFutureValueAmount mapFutureValueAmount;
	@Inject protected MapNonNegativeQuantitySchedule mapNonNegativeQuantitySchedule;
	@Inject protected MapPriceScheduleList mapPriceScheduleList;
	@Inject protected MapQuantity mapQuantity;
	@Inject protected MapQuantityMultiplier mapQuantityMultiplier;
	@Inject protected fpml.mapping.functions.MapResolvablePriceQuantity mapResolvablePriceQuantity;

	/**
	* @param fpmlDataDocument 
	* @return resolvablePriceQuantity 
	*/
	public ResolvablePriceQuantity evaluate(DataDocument fpmlDataDocument) {
		ResolvablePriceQuantity.ResolvablePriceQuantityBuilder resolvablePriceQuantityBuilder = doEvaluate(fpmlDataDocument);
		
		final ResolvablePriceQuantity resolvablePriceQuantity;
		if (resolvablePriceQuantityBuilder == null) {
			resolvablePriceQuantity = null;
		} else {
			resolvablePriceQuantity = resolvablePriceQuantityBuilder.build();
			objectValidator.validate(ResolvablePriceQuantity.class, resolvablePriceQuantity);
		}
		
		return resolvablePriceQuantity;
	}

	protected abstract ResolvablePriceQuantity.ResolvablePriceQuantityBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapResolvablePriceQuantityDefault extends MapResolvablePriceQuantity {
		@Override
		protected ResolvablePriceQuantity.ResolvablePriceQuantityBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ResolvablePriceQuantity.ResolvablePriceQuantityBuilder resolvablePriceQuantity = ResolvablePriceQuantity.builder();
			return assignOutput(resolvablePriceQuantity, fpmlDataDocument);
		}
		
		protected ResolvablePriceQuantity.ResolvablePriceQuantityBuilder assignOutput(ResolvablePriceQuantity.ResolvablePriceQuantityBuilder resolvablePriceQuantity, DataDocument fpmlDataDocument) {
			resolvablePriceQuantity = toBuilder(ResolvablePriceQuantity.builder()
				.setResolvedQuantity(mapQuantity.evaluate(fpmlDataDocument))
				.setQuantityScheduleValue(mapNonNegativeQuantitySchedule.evaluate(fpmlDataDocument))
				.setQuantityReferenceValue(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setQuantityMultiplier(mapQuantityMultiplier.evaluate(fpmlDataDocument))
				.setReset(null)
				.setFutureValueNotional(mapFutureValueAmount.evaluate(fpmlDataDocument))
				.setPriceScheduleValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(resolvablePriceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
