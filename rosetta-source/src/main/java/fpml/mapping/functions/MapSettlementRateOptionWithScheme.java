package fpml.mapping.functions;

import cdm.observable.asset.SettlementRateOptionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapSettlementRateOptionWithScheme.MapSettlementRateOptionWithSchemeDefault.class)
public abstract class MapSettlementRateOptionWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return settlementRateOptionEnum 
	*/
	public SettlementRateOptionEnum evaluate(DataDocument fpmlDataDocument) {
		SettlementRateOptionEnum settlementRateOptionEnum = doEvaluate(fpmlDataDocument);
		
		return settlementRateOptionEnum;
	}

	protected abstract SettlementRateOptionEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSettlementRateOptionWithSchemeDefault extends MapSettlementRateOptionWithScheme {
		@Override
		protected SettlementRateOptionEnum doEvaluate(DataDocument fpmlDataDocument) {
			SettlementRateOptionEnum settlementRateOptionEnum = null;
			return assignOutput(settlementRateOptionEnum, fpmlDataDocument);
		}
		
		protected SettlementRateOptionEnum assignOutput(SettlementRateOptionEnum settlementRateOptionEnum, DataDocument fpmlDataDocument) {
			settlementRateOptionEnum = null;
			
			return settlementRateOptionEnum;
		}
	}
}
