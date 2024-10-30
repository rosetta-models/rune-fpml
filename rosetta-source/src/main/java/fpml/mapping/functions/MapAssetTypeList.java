package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.AssetType;
import cdm.base.staticdata.asset.common.AssetType.AssetTypeBuilder;
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


@ImplementedBy(MapAssetTypeList.MapAssetTypeListDefault.class)
public abstract class MapAssetTypeList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDebtType mapDebtType;

	/**
	* @param fpmlDataDocument 
	* @return assetTypeList 
	*/
	public List<? extends AssetType> evaluate(DataDocument fpmlDataDocument) {
		List<AssetType.AssetTypeBuilder> assetTypeListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AssetType> assetTypeList;
		if (assetTypeListBuilder == null) {
			assetTypeList = null;
		} else {
			assetTypeList = assetTypeListBuilder.stream().map(AssetType::build).collect(Collectors.toList());
			objectValidator.validate(AssetType.class, assetTypeList);
		}
		
		return assetTypeList;
	}

	protected abstract List<AssetType.AssetTypeBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAssetTypeListDefault extends MapAssetTypeList {
		@Override
		protected List<AssetType.AssetTypeBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AssetType.AssetTypeBuilder> assetTypeList = new ArrayList<>();
			return assignOutput(assetTypeList, fpmlDataDocument);
		}
		
		protected List<AssetType.AssetTypeBuilder> assignOutput(List<AssetType.AssetTypeBuilder> assetTypeList, DataDocument fpmlDataDocument) {
			assetTypeList.addAll(toBuilder(MapperC.<AssetType>of(MapperS.of(AssetType.builder()
				.setAssetType(null)
				.setSecurityType(null)
				.setDebtType(mapDebtType.evaluate(fpmlDataDocument))
				.setEquityType(null)
				.setFundType(null)
				.setOtherAssetType(Collections.<String>emptyList())
				.build())).getMulti()));
			
			return Optional.ofNullable(assetTypeList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
