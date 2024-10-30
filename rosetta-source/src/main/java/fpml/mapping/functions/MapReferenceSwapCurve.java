package fpml.mapping.functions;

import cdm.observable.asset.ReferenceSwapCurve;
import cdm.observable.asset.ReferenceSwapCurve.ReferenceSwapCurveBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReferenceSwapCurve.MapReferenceSwapCurveDefault.class)
public abstract class MapReferenceSwapCurve implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMakeWholeAmount mapMakeWholeAmount;
	@Inject protected MapSwapCurveValuation mapSwapCurveValuation;

	/**
	* @param fpmlDataDocument 
	* @return referenceSwapCurve 
	*/
	public ReferenceSwapCurve evaluate(DataDocument fpmlDataDocument) {
		ReferenceSwapCurve.ReferenceSwapCurveBuilder referenceSwapCurveBuilder = doEvaluate(fpmlDataDocument);
		
		final ReferenceSwapCurve referenceSwapCurve;
		if (referenceSwapCurveBuilder == null) {
			referenceSwapCurve = null;
		} else {
			referenceSwapCurve = referenceSwapCurveBuilder.build();
			objectValidator.validate(ReferenceSwapCurve.class, referenceSwapCurve);
		}
		
		return referenceSwapCurve;
	}

	protected abstract ReferenceSwapCurve.ReferenceSwapCurveBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapReferenceSwapCurveDefault extends MapReferenceSwapCurve {
		@Override
		protected ReferenceSwapCurve.ReferenceSwapCurveBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ReferenceSwapCurve.ReferenceSwapCurveBuilder referenceSwapCurve = ReferenceSwapCurve.builder();
			return assignOutput(referenceSwapCurve, fpmlDataDocument);
		}
		
		protected ReferenceSwapCurve.ReferenceSwapCurveBuilder assignOutput(ReferenceSwapCurve.ReferenceSwapCurveBuilder referenceSwapCurve, DataDocument fpmlDataDocument) {
			referenceSwapCurve = toBuilder(ReferenceSwapCurve.builder()
				.setSwapUnwindValue(mapSwapCurveValuation.evaluate(fpmlDataDocument))
				.setMakeWholeAmount(mapMakeWholeAmount.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(referenceSwapCurve)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
