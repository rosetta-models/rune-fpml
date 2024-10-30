package fpml.mapping.functions;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapRateSourceWithScheme.MapRateSourceWithSchemeDefault.class)
public abstract class MapRateSourceWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return floatingRateIndexEnum 
	*/
	public FloatingRateIndexEnum evaluate(DataDocument fpmlDataDocument) {
		FloatingRateIndexEnum floatingRateIndexEnum = doEvaluate(fpmlDataDocument);
		
		return floatingRateIndexEnum;
	}

	protected abstract FloatingRateIndexEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRateSourceWithSchemeDefault extends MapRateSourceWithScheme {
		@Override
		protected FloatingRateIndexEnum doEvaluate(DataDocument fpmlDataDocument) {
			FloatingRateIndexEnum floatingRateIndexEnum = null;
			return assignOutput(floatingRateIndexEnum, fpmlDataDocument);
		}
		
		protected FloatingRateIndexEnum assignOutput(FloatingRateIndexEnum floatingRateIndexEnum, DataDocument fpmlDataDocument) {
			floatingRateIndexEnum = null;
			
			return floatingRateIndexEnum;
		}
	}
}
