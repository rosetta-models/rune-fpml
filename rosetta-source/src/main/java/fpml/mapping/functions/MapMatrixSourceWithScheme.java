package fpml.mapping.functions;

import cdm.product.asset.SettledEntityMatrixSourceEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapMatrixSourceWithScheme.MapMatrixSourceWithSchemeDefault.class)
public abstract class MapMatrixSourceWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return settledEntityMatrixSourceEnum 
	*/
	public SettledEntityMatrixSourceEnum evaluate(DataDocument fpmlDataDocument) {
		SettledEntityMatrixSourceEnum settledEntityMatrixSourceEnum = doEvaluate(fpmlDataDocument);
		
		return settledEntityMatrixSourceEnum;
	}

	protected abstract SettledEntityMatrixSourceEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMatrixSourceWithSchemeDefault extends MapMatrixSourceWithScheme {
		@Override
		protected SettledEntityMatrixSourceEnum doEvaluate(DataDocument fpmlDataDocument) {
			SettledEntityMatrixSourceEnum settledEntityMatrixSourceEnum = null;
			return assignOutput(settledEntityMatrixSourceEnum, fpmlDataDocument);
		}
		
		protected SettledEntityMatrixSourceEnum assignOutput(SettledEntityMatrixSourceEnum settledEntityMatrixSourceEnum, DataDocument fpmlDataDocument) {
			settledEntityMatrixSourceEnum = null;
			
			return settledEntityMatrixSourceEnum;
		}
	}
}
