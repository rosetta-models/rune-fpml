package fpml.mapping.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapRelevantJurisdictionWithScheme.MapRelevantJurisdictionWithSchemeDefault.class)
public abstract class MapRelevantJurisdictionWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return string 
	*/
	public String evaluate(DataDocument fpmlDataDocument) {
		String string = doEvaluate(fpmlDataDocument);
		
		return string;
	}

	protected abstract String doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRelevantJurisdictionWithSchemeDefault extends MapRelevantJurisdictionWithScheme {
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
