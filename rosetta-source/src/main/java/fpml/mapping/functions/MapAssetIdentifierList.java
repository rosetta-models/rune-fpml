package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.AssetIdentifier.AssetIdentifierBuilder;
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


@ImplementedBy(MapAssetIdentifierList.MapAssetIdentifierListDefault.class)
public abstract class MapAssetIdentifierList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapIdentifierWithScheme mapIdentifierWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return assetIdentifierList 
	*/
	public List<? extends AssetIdentifier> evaluate(DataDocument fpmlDataDocument) {
		List<AssetIdentifier.AssetIdentifierBuilder> assetIdentifierListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AssetIdentifier> assetIdentifierList;
		if (assetIdentifierListBuilder == null) {
			assetIdentifierList = null;
		} else {
			assetIdentifierList = assetIdentifierListBuilder.stream().map(AssetIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(AssetIdentifier.class, assetIdentifierList);
		}
		
		return assetIdentifierList;
	}

	protected abstract List<AssetIdentifier.AssetIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAssetIdentifierListDefault extends MapAssetIdentifierList {
		@Override
		protected List<AssetIdentifier.AssetIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AssetIdentifier.AssetIdentifierBuilder> assetIdentifierList = new ArrayList<>();
			return assignOutput(assetIdentifierList, fpmlDataDocument);
		}
		
		protected List<AssetIdentifier.AssetIdentifierBuilder> assignOutput(List<AssetIdentifier.AssetIdentifierBuilder> assetIdentifierList, DataDocument fpmlDataDocument) {
			assetIdentifierList.addAll(toBuilder(MapperC.<AssetIdentifier>of(MapperS.of(AssetIdentifier.builder()
				.setIdentifierValue(mapIdentifierWithScheme.evaluate(fpmlDataDocument))
				.setIdentifierType(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(assetIdentifierList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
