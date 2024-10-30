package fpml.mapping.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapSettlementCurrencyWithScheme.MapSettlementCurrencyWithSchemeDefault.class)
public abstract class MapSettlementCurrencyWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return string 
	*/
	public String evaluate(DataDocument fpmlDataDocument) {
		String string = doEvaluate(fpmlDataDocument);
		
		return string;
	}

	protected abstract String doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSettlementCurrencyWithSchemeDefault extends MapSettlementCurrencyWithScheme {
		@Override
		protected String doEvaluate(DataDocument fpmlDataDocument) {
			String string = null;
			return assignOutput(string, fpmlDataDocument);
		}
		
		protected String assignOutput(String string, DataDocument fpmlDataDocument) {
			string = null;
			
			return string;
		}
	}
}
