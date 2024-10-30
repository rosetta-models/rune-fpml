package fpml.mapping.functions;

import cdm.legaldocumentation.common.GoverningLawEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapGoverningLawWithScheme.MapGoverningLawWithSchemeDefault.class)
public abstract class MapGoverningLawWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return governingLawEnum 
	*/
	public GoverningLawEnum evaluate(DataDocument fpmlDataDocument) {
		GoverningLawEnum governingLawEnum = doEvaluate(fpmlDataDocument);
		
		return governingLawEnum;
	}

	protected abstract GoverningLawEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapGoverningLawWithSchemeDefault extends MapGoverningLawWithScheme {
		@Override
		protected GoverningLawEnum doEvaluate(DataDocument fpmlDataDocument) {
			GoverningLawEnum governingLawEnum = null;
			return assignOutput(governingLawEnum, fpmlDataDocument);
		}
		
		protected GoverningLawEnum assignOutput(GoverningLawEnum governingLawEnum, DataDocument fpmlDataDocument) {
			governingLawEnum = null;
			
			return governingLawEnum;
		}
	}
}
