package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ImplementedBy(MapSecondaryAssetClassWithSchemeList.MapSecondaryAssetClassWithSchemeListDefault.class)
public abstract class MapSecondaryAssetClassWithSchemeList implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return assetClassEnumList 
	*/
	public List<AssetClassEnum> evaluate(DataDocument fpmlDataDocument) {
		List<AssetClassEnum> assetClassEnumList = doEvaluate(fpmlDataDocument);
		
		return assetClassEnumList;
	}

	protected abstract List<AssetClassEnum> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSecondaryAssetClassWithSchemeListDefault extends MapSecondaryAssetClassWithSchemeList {
		@Override
		protected List<AssetClassEnum> doEvaluate(DataDocument fpmlDataDocument) {
			List<AssetClassEnum> assetClassEnumList = new ArrayList<>();
			return assignOutput(assetClassEnumList, fpmlDataDocument);
		}
		
		protected List<AssetClassEnum> assignOutput(List<AssetClassEnum> assetClassEnumList, DataDocument fpmlDataDocument) {
			assetClassEnumList.addAll(Collections.<AssetClassEnum>emptyList());
			
			return assetClassEnumList;
		}
	}
}
