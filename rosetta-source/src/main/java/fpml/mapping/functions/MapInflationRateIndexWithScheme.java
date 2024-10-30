package fpml.mapping.functions;

import cdm.base.staticdata.asset.rates.InflationRateIndexEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapInflationRateIndexWithScheme.MapInflationRateIndexWithSchemeDefault.class)
public abstract class MapInflationRateIndexWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return inflationRateIndexEnum 
	*/
	public InflationRateIndexEnum evaluate(DataDocument fpmlDataDocument) {
		InflationRateIndexEnum inflationRateIndexEnum = doEvaluate(fpmlDataDocument);
		
		return inflationRateIndexEnum;
	}

	protected abstract InflationRateIndexEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapInflationRateIndexWithSchemeDefault extends MapInflationRateIndexWithScheme {
		@Override
		protected InflationRateIndexEnum doEvaluate(DataDocument fpmlDataDocument) {
			InflationRateIndexEnum inflationRateIndexEnum = null;
			return assignOutput(inflationRateIndexEnum, fpmlDataDocument);
		}
		
		protected InflationRateIndexEnum assignOutput(InflationRateIndexEnum inflationRateIndexEnum, DataDocument fpmlDataDocument) {
			inflationRateIndexEnum = null;
			
			return inflationRateIndexEnum;
		}
	}
}
