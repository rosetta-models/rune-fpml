package fpml.mapping.functions;

import cdm.product.asset.AssetDeliveryProfile;
import cdm.product.asset.AssetDeliveryProfile.AssetDeliveryProfileBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapAssetDeliveryProfileList.MapAssetDeliveryProfileListDefault.class)
public abstract class MapAssetDeliveryProfileList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetDeliveryProfileBlockList mapAssetDeliveryProfileBlockList;

	/**
	* @param fpmlDataDocument 
	* @return assetDeliveryProfileList 
	*/
	public List<? extends AssetDeliveryProfile> evaluate(DataDocument fpmlDataDocument) {
		List<AssetDeliveryProfile.AssetDeliveryProfileBuilder> assetDeliveryProfileListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AssetDeliveryProfile> assetDeliveryProfileList;
		if (assetDeliveryProfileListBuilder == null) {
			assetDeliveryProfileList = null;
		} else {
			assetDeliveryProfileList = assetDeliveryProfileListBuilder.stream().map(AssetDeliveryProfile::build).collect(Collectors.toList());
			objectValidator.validate(AssetDeliveryProfile.class, assetDeliveryProfileList);
		}
		
		return assetDeliveryProfileList;
	}

	protected abstract List<AssetDeliveryProfile.AssetDeliveryProfileBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAssetDeliveryProfileListDefault extends MapAssetDeliveryProfileList {
		@Override
		protected List<AssetDeliveryProfile.AssetDeliveryProfileBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AssetDeliveryProfile.AssetDeliveryProfileBuilder> assetDeliveryProfileList = new ArrayList<>();
			return assignOutput(assetDeliveryProfileList, fpmlDataDocument);
		}
		
		protected List<AssetDeliveryProfile.AssetDeliveryProfileBuilder> assignOutput(List<AssetDeliveryProfile.AssetDeliveryProfileBuilder> assetDeliveryProfileList, DataDocument fpmlDataDocument) {
			assetDeliveryProfileList.addAll(toBuilder(MapperC.<AssetDeliveryProfile>of(MapperS.of(AssetDeliveryProfile.builder()
				.setLoadType(null)
				.setBlock(new ArrayList(mapAssetDeliveryProfileBlockList.evaluate(fpmlDataDocument)))
				.setBankHolidaysTreatment(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(assetDeliveryProfileList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
