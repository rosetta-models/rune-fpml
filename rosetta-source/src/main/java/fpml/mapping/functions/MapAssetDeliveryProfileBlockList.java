package fpml.mapping.functions;

import cdm.base.datetime.DayOfWeekEnum;
import cdm.product.asset.AssetDeliveryProfileBlock;
import cdm.product.asset.AssetDeliveryProfileBlock.AssetDeliveryProfileBlockBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapAssetDeliveryProfileBlockList.MapAssetDeliveryProfileBlockListDefault.class)
public abstract class MapAssetDeliveryProfileBlockList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPrice mapPrice;
	@Inject protected MapQuantity mapQuantity;

	/**
	* @param fpmlDataDocument 
	* @return assetDeliveryProfileBlockList 
	*/
	public List<? extends AssetDeliveryProfileBlock> evaluate(DataDocument fpmlDataDocument) {
		List<AssetDeliveryProfileBlock.AssetDeliveryProfileBlockBuilder> assetDeliveryProfileBlockListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AssetDeliveryProfileBlock> assetDeliveryProfileBlockList;
		if (assetDeliveryProfileBlockListBuilder == null) {
			assetDeliveryProfileBlockList = null;
		} else {
			assetDeliveryProfileBlockList = assetDeliveryProfileBlockListBuilder.stream().map(AssetDeliveryProfileBlock::build).collect(Collectors.toList());
			objectValidator.validate(AssetDeliveryProfileBlock.class, assetDeliveryProfileBlockList);
		}
		
		return assetDeliveryProfileBlockList;
	}

	protected abstract List<AssetDeliveryProfileBlock.AssetDeliveryProfileBlockBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAssetDeliveryProfileBlockListDefault extends MapAssetDeliveryProfileBlockList {
		@Override
		protected List<AssetDeliveryProfileBlock.AssetDeliveryProfileBlockBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AssetDeliveryProfileBlock.AssetDeliveryProfileBlockBuilder> assetDeliveryProfileBlockList = new ArrayList<>();
			return assignOutput(assetDeliveryProfileBlockList, fpmlDataDocument);
		}
		
		protected List<AssetDeliveryProfileBlock.AssetDeliveryProfileBlockBuilder> assignOutput(List<AssetDeliveryProfileBlock.AssetDeliveryProfileBlockBuilder> assetDeliveryProfileBlockList, DataDocument fpmlDataDocument) {
			assetDeliveryProfileBlockList.addAll(toBuilder(MapperC.<AssetDeliveryProfileBlock>of(MapperS.of(AssetDeliveryProfileBlock.builder()
				.setStartTime(null)
				.setEndTime(null)
				.setDayOfWeek(Collections.<DayOfWeekEnum>emptyList())
				.setDeliveryCapacity(mapQuantity.evaluate(fpmlDataDocument))
				.setPriceTimeIntervalQuantity(mapPrice.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(assetDeliveryProfileBlockList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
