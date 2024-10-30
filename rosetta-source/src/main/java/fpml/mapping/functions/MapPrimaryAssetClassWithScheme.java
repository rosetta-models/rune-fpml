package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapPrimaryAssetClassWithScheme.MapPrimaryAssetClassWithSchemeDefault.class)
public abstract class MapPrimaryAssetClassWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return assetClassEnum 
	*/
	public AssetClassEnum evaluate(DataDocument fpmlDataDocument) {
		AssetClassEnum assetClassEnum = doEvaluate(fpmlDataDocument);
		
		return assetClassEnum;
	}

	protected abstract AssetClassEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPrimaryAssetClassWithSchemeDefault extends MapPrimaryAssetClassWithScheme {
		@Override
		protected AssetClassEnum doEvaluate(DataDocument fpmlDataDocument) {
			AssetClassEnum assetClassEnum = null;
			return assignOutput(assetClassEnum, fpmlDataDocument);
		}
		
		protected AssetClassEnum assignOutput(AssetClassEnum assetClassEnum, DataDocument fpmlDataDocument) {
			assetClassEnum = null;
			
			return assetClassEnum;
		}
	}
}
