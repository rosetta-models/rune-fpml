package fpml.mapping.functions;

import cdm.legaldocumentation.common.MatrixTermEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapMatrixTermWithScheme.MapMatrixTermWithSchemeDefault.class)
public abstract class MapMatrixTermWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return matrixTermEnum 
	*/
	public MatrixTermEnum evaluate(DataDocument fpmlDataDocument) {
		MatrixTermEnum matrixTermEnum = doEvaluate(fpmlDataDocument);
		
		return matrixTermEnum;
	}

	protected abstract MatrixTermEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMatrixTermWithSchemeDefault extends MapMatrixTermWithScheme {
		@Override
		protected MatrixTermEnum doEvaluate(DataDocument fpmlDataDocument) {
			MatrixTermEnum matrixTermEnum = null;
			return assignOutput(matrixTermEnum, fpmlDataDocument);
		}
		
		protected MatrixTermEnum assignOutput(MatrixTermEnum matrixTermEnum, DataDocument fpmlDataDocument) {
			matrixTermEnum = null;
			
			return matrixTermEnum;
		}
	}
}
