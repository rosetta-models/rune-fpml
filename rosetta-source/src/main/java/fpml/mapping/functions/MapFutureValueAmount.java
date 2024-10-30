package fpml.mapping.functions;

import cdm.product.asset.FutureValueAmount;
import cdm.product.asset.FutureValueAmount.FutureValueAmountBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFutureValueAmount.MapFutureValueAmountDefault.class)
public abstract class MapFutureValueAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrencyWithScheme mapCurrencyWithScheme;
	@Inject protected MapNonNegativeQuantitySchedule mapNonNegativeQuantitySchedule;

	/**
	* @param fpmlDataDocument 
	* @return futureValueAmount 
	*/
	public FutureValueAmount evaluate(DataDocument fpmlDataDocument) {
		FutureValueAmount.FutureValueAmountBuilder futureValueAmountBuilder = doEvaluate(fpmlDataDocument);
		
		final FutureValueAmount futureValueAmount;
		if (futureValueAmountBuilder == null) {
			futureValueAmount = null;
		} else {
			futureValueAmount = futureValueAmountBuilder.build();
			objectValidator.validate(FutureValueAmount.class, futureValueAmount);
		}
		
		return futureValueAmount;
	}

	protected abstract FutureValueAmount.FutureValueAmountBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFutureValueAmountDefault extends MapFutureValueAmount {
		@Override
		protected FutureValueAmount.FutureValueAmountBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FutureValueAmount.FutureValueAmountBuilder futureValueAmount = FutureValueAmount.builder();
			return assignOutput(futureValueAmount, fpmlDataDocument);
		}
		
		protected FutureValueAmount.FutureValueAmountBuilder assignOutput(FutureValueAmount.FutureValueAmountBuilder futureValueAmount, DataDocument fpmlDataDocument) {
			futureValueAmount = toBuilder(FutureValueAmount.builder()
				.setQuantityValue(mapNonNegativeQuantitySchedule.evaluate(fpmlDataDocument))
				.setCurrencyValue(mapCurrencyWithScheme.evaluate(fpmlDataDocument))
				.setCalculationPeriodNumberOfDays(null)
				.setValueDate(null)
				.build());
			
			return Optional.ofNullable(futureValueAmount)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
