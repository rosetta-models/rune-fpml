package fpml.mapping.functions;

import cdm.product.common.schedule.FxLinkedNotionalAmount;
import cdm.product.common.schedule.FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxLinkedNotionalAmount.MapFxLinkedNotionalAmountDefault.class)
public abstract class MapFxLinkedNotionalAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return fxLinkedNotionalAmount 
	*/
	public FxLinkedNotionalAmount evaluate(DataDocument fpmlDataDocument) {
		FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder fxLinkedNotionalAmountBuilder = doEvaluate(fpmlDataDocument);
		
		final FxLinkedNotionalAmount fxLinkedNotionalAmount;
		if (fxLinkedNotionalAmountBuilder == null) {
			fxLinkedNotionalAmount = null;
		} else {
			fxLinkedNotionalAmount = fxLinkedNotionalAmountBuilder.build();
			objectValidator.validate(FxLinkedNotionalAmount.class, fxLinkedNotionalAmount);
		}
		
		return fxLinkedNotionalAmount;
	}

	protected abstract FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFxLinkedNotionalAmountDefault extends MapFxLinkedNotionalAmount {
		@Override
		protected FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder fxLinkedNotionalAmount = FxLinkedNotionalAmount.builder();
			return assignOutput(fxLinkedNotionalAmount, fpmlDataDocument);
		}
		
		protected FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder assignOutput(FxLinkedNotionalAmount.FxLinkedNotionalAmountBuilder fxLinkedNotionalAmount, DataDocument fpmlDataDocument) {
			fxLinkedNotionalAmount = toBuilder(FxLinkedNotionalAmount.builder()
				.setResetDate(null)
				.setAdjustedFxSpotFixingDate(null)
				.setObservedFxSpotRate(null)
				.setNotionalAmount(null)
				.build());
			
			return Optional.ofNullable(fxLinkedNotionalAmount)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
