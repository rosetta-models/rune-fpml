package fpml.mapping.functions;

import cdm.product.template.AssetLeg;
import cdm.product.template.AssetLeg.AssetLegBuilder;
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


@ImplementedBy(MapAssetLegList.MapAssetLegListDefault.class)
public abstract class MapAssetLegList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;

	/**
	* @param fpmlDataDocument 
	* @return assetLegList 
	*/
	public List<? extends AssetLeg> evaluate(DataDocument fpmlDataDocument) {
		List<AssetLeg.AssetLegBuilder> assetLegListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AssetLeg> assetLegList;
		if (assetLegListBuilder == null) {
			assetLegList = null;
		} else {
			assetLegList = assetLegListBuilder.stream().map(AssetLeg::build).collect(Collectors.toList());
			objectValidator.validate(AssetLeg.class, assetLegList);
		}
		
		return assetLegList;
	}

	protected abstract List<AssetLeg.AssetLegBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAssetLegListDefault extends MapAssetLegList {
		@Override
		protected List<AssetLeg.AssetLegBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AssetLeg.AssetLegBuilder> assetLegList = new ArrayList<>();
			return assignOutput(assetLegList, fpmlDataDocument);
		}
		
		protected List<AssetLeg.AssetLegBuilder> assignOutput(List<AssetLeg.AssetLegBuilder> assetLegList, DataDocument fpmlDataDocument) {
			assetLegList.addAll(toBuilder(MapperC.<AssetLeg>of(MapperS.of(AssetLeg.builder()
				.setSettlementDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setDeliveryMethod(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(assetLegList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
