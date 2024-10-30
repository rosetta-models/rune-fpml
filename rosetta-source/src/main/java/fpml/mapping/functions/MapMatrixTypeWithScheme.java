package fpml.mapping.functions;

import cdm.legaldocumentation.common.MatrixTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapMatrixTypeWithScheme.MapMatrixTypeWithSchemeDefault.class)
public abstract class MapMatrixTypeWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return matrixTypeEnum 
	*/
	public MatrixTypeEnum evaluate(DataDocument fpmlDataDocument) {
		MatrixTypeEnum matrixTypeEnum = doEvaluate(fpmlDataDocument);
		
		return matrixTypeEnum;
	}

	protected abstract MatrixTypeEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMatrixTypeWithSchemeDefault extends MapMatrixTypeWithScheme {
		@Override
		protected MatrixTypeEnum doEvaluate(DataDocument fpmlDataDocument) {
			MatrixTypeEnum matrixTypeEnum = null;
			return assignOutput(matrixTypeEnum, fpmlDataDocument);
		}
		
		protected MatrixTypeEnum assignOutput(MatrixTypeEnum matrixTypeEnum, DataDocument fpmlDataDocument) {
			matrixTypeEnum = null;
			
			return matrixTypeEnum;
		}
	}
}
