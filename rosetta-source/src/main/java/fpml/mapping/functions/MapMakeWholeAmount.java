package fpml.mapping.functions;

import cdm.observable.asset.MakeWholeAmount;
import cdm.observable.asset.MakeWholeAmount.MakeWholeAmountBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMakeWholeAmount.MapMakeWholeAmountDefault.class)
public abstract class MapMakeWholeAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriod mapPeriod;

	/**
	* @param fpmlDataDocument 
	* @return makeWholeAmount 
	*/
	public MakeWholeAmount evaluate(DataDocument fpmlDataDocument) {
		MakeWholeAmount.MakeWholeAmountBuilder makeWholeAmountBuilder = doEvaluate(fpmlDataDocument);
		
		final MakeWholeAmount makeWholeAmount;
		if (makeWholeAmountBuilder == null) {
			makeWholeAmount = null;
		} else {
			makeWholeAmount = makeWholeAmountBuilder.build();
			objectValidator.validate(MakeWholeAmount.class, makeWholeAmount);
		}
		
		return makeWholeAmount;
	}

	protected abstract MakeWholeAmount.MakeWholeAmountBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMakeWholeAmountDefault extends MapMakeWholeAmount {
		@Override
		protected MakeWholeAmount.MakeWholeAmountBuilder doEvaluate(DataDocument fpmlDataDocument) {
			MakeWholeAmount.MakeWholeAmountBuilder makeWholeAmount = MakeWholeAmount.builder();
			return assignOutput(makeWholeAmount, fpmlDataDocument);
		}
		
		protected MakeWholeAmount.MakeWholeAmountBuilder assignOutput(MakeWholeAmount.MakeWholeAmountBuilder makeWholeAmount, DataDocument fpmlDataDocument) {
			makeWholeAmount = toBuilder(MakeWholeAmount.builder()
				.setFloatingRateIndex(null)
				.setIndexTenor(mapPeriod.evaluate(fpmlDataDocument))
				.setSpread(null)
				.setSide(null)
				.setInterpolationMethod(null)
				.setEarlyCallDateValue(null)
				.build());
			
			return Optional.ofNullable(makeWholeAmount)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
