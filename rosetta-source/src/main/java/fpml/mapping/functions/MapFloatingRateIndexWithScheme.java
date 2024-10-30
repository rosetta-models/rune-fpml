package fpml.mapping.functions;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapFloatingRateIndexWithScheme.MapFloatingRateIndexWithSchemeDefault.class)
public abstract class MapFloatingRateIndexWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return floatingRateIndexEnum 
	*/
	public FloatingRateIndexEnum evaluate(DataDocument fpmlDataDocument) {
		FloatingRateIndexEnum floatingRateIndexEnum = doEvaluate(fpmlDataDocument);
		
		return floatingRateIndexEnum;
	}

	protected abstract FloatingRateIndexEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFloatingRateIndexWithSchemeDefault extends MapFloatingRateIndexWithScheme {
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
