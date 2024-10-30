package fpml.mapping.functions;

import cdm.observable.asset.InterpolationMethodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapInterpolationMethodWithScheme.MapInterpolationMethodWithSchemeDefault.class)
public abstract class MapInterpolationMethodWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return interpolationMethodEnum 
	*/
	public InterpolationMethodEnum evaluate(DataDocument fpmlDataDocument) {
		InterpolationMethodEnum interpolationMethodEnum = doEvaluate(fpmlDataDocument);
		
		return interpolationMethodEnum;
	}

	protected abstract InterpolationMethodEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapInterpolationMethodWithSchemeDefault extends MapInterpolationMethodWithScheme {
		@Override
		protected InterpolationMethodEnum doEvaluate(DataDocument fpmlDataDocument) {
			InterpolationMethodEnum interpolationMethodEnum = null;
			return assignOutput(interpolationMethodEnum, fpmlDataDocument);
		}
		
		protected InterpolationMethodEnum assignOutput(InterpolationMethodEnum interpolationMethodEnum, DataDocument fpmlDataDocument) {
			interpolationMethodEnum = null;
			
			return interpolationMethodEnum;
		}
	}
}
