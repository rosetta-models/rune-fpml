package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Asset.AssetBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAsset.MapAssetDefault.class)
public abstract class MapAsset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCash mapCash;
	@Inject protected MapCommodity mapCommodity;
	@Inject protected MapDigitalAsset mapDigitalAsset;
	@Inject protected MapInstrument mapInstrument;

	/**
	* @param fpmlDataDocument 
	* @return asset 
	*/
	public Asset evaluate(DataDocument fpmlDataDocument) {
		Asset.AssetBuilder assetBuilder = doEvaluate(fpmlDataDocument);
		
		final Asset asset;
		if (assetBuilder == null) {
			asset = null;
		} else {
			asset = assetBuilder.build();
			objectValidator.validate(Asset.class, asset);
		}
		
		return asset;
	}

	protected abstract Asset.AssetBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAssetDefault extends MapAsset {
		@Override
		protected Asset.AssetBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Asset.AssetBuilder asset = Asset.builder();
			return assignOutput(asset, fpmlDataDocument);
		}
		
		protected Asset.AssetBuilder assignOutput(Asset.AssetBuilder asset, DataDocument fpmlDataDocument) {
			asset = toBuilder(Asset.builder()
				.setCash(mapCash.evaluate(fpmlDataDocument))
				.setCommodityValue(mapCommodity.evaluate(fpmlDataDocument))
				.setDigitalAsset(mapDigitalAsset.evaluate(fpmlDataDocument))
				.setInstrument(mapInstrument.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(asset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
