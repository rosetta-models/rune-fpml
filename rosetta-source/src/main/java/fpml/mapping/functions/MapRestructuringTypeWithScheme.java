package fpml.mapping.functions;

import cdm.observable.event.RestructuringEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapRestructuringTypeWithScheme.MapRestructuringTypeWithSchemeDefault.class)
public abstract class MapRestructuringTypeWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return restructuringEnum 
	*/
	public RestructuringEnum evaluate(DataDocument fpmlDataDocument) {
		RestructuringEnum restructuringEnum = doEvaluate(fpmlDataDocument);
		
		return restructuringEnum;
	}

	protected abstract RestructuringEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRestructuringTypeWithSchemeDefault extends MapRestructuringTypeWithScheme {
		@Override
		protected RestructuringEnum doEvaluate(DataDocument fpmlDataDocument) {
			RestructuringEnum restructuringEnum = null;
			return assignOutput(restructuringEnum, fpmlDataDocument);
		}
		
		protected RestructuringEnum assignOutput(RestructuringEnum restructuringEnum, DataDocument fpmlDataDocument) {
			restructuringEnum = null;
			
			return restructuringEnum;
		}
	}
}
