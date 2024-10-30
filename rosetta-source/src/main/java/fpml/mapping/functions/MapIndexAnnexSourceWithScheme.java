package fpml.mapping.functions;

import cdm.product.asset.IndexAnnexSourceEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapIndexAnnexSourceWithScheme.MapIndexAnnexSourceWithSchemeDefault.class)
public abstract class MapIndexAnnexSourceWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return indexAnnexSourceEnum 
	*/
	public IndexAnnexSourceEnum evaluate(DataDocument fpmlDataDocument) {
		IndexAnnexSourceEnum indexAnnexSourceEnum = doEvaluate(fpmlDataDocument);
		
		return indexAnnexSourceEnum;
	}

	protected abstract IndexAnnexSourceEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapIndexAnnexSourceWithSchemeDefault extends MapIndexAnnexSourceWithScheme {
		@Override
		protected IndexAnnexSourceEnum doEvaluate(DataDocument fpmlDataDocument) {
			IndexAnnexSourceEnum indexAnnexSourceEnum = null;
			return assignOutput(indexAnnexSourceEnum, fpmlDataDocument);
		}
		
		protected IndexAnnexSourceEnum assignOutput(IndexAnnexSourceEnum indexAnnexSourceEnum, DataDocument fpmlDataDocument) {
			indexAnnexSourceEnum = null;
			
			return indexAnnexSourceEnum;
		}
	}
}
