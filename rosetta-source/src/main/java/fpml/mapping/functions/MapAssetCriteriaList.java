package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.CurrencyCodeEnum;
import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.product.collateral.AssetCriteria;
import cdm.product.collateral.AssetCriteria.AssetCriteriaBuilder;
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


@ImplementedBy(MapAssetCriteriaList.MapAssetCriteriaListDefault.class)
public abstract class MapAssetCriteriaList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAgencyRatingCriteriaList mapAgencyRatingCriteriaList;
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapAssetTypeList mapAssetTypeList;
	@Inject protected MapCollateralTaxonomyList mapCollateralTaxonomyList;
	@Inject protected MapListingType mapListingType;
	@Inject protected MapPeriodRange mapPeriodRange;

	/**
	* @param fpmlDataDocument 
	* @return assetCriteriaList 
	*/
	public List<? extends AssetCriteria> evaluate(DataDocument fpmlDataDocument) {
		List<AssetCriteria.AssetCriteriaBuilder> assetCriteriaListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AssetCriteria> assetCriteriaList;
		if (assetCriteriaListBuilder == null) {
			assetCriteriaList = null;
		} else {
			assetCriteriaList = assetCriteriaListBuilder.stream().map(AssetCriteria::build).collect(Collectors.toList());
			objectValidator.validate(AssetCriteria.class, assetCriteriaList);
		}
		
		return assetCriteriaList;
	}

	protected abstract List<AssetCriteria.AssetCriteriaBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAssetCriteriaListDefault extends MapAssetCriteriaList {
		@Override
		protected List<AssetCriteria.AssetCriteriaBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AssetCriteria.AssetCriteriaBuilder> assetCriteriaList = new ArrayList<>();
			return assignOutput(assetCriteriaList, fpmlDataDocument);
		}
		
		protected List<AssetCriteria.AssetCriteriaBuilder> assignOutput(List<AssetCriteria.AssetCriteriaBuilder> assetCriteriaList, DataDocument fpmlDataDocument) {
			assetCriteriaList.addAll(toBuilder(MapperC.<AssetCriteria>of(MapperS.of(AssetCriteria.builder()
				.setCollateralAssetType(new ArrayList(mapAssetTypeList.evaluate(fpmlDataDocument)))
				.setAssetCountryOfOrigin(Collections.<ISOCountryCodeEnum>emptyList())
				.setDenominatedCurrency(Collections.<CurrencyCodeEnum>emptyList())
				.setAgencyRating(new ArrayList(mapAgencyRatingCriteriaList.evaluate(fpmlDataDocument)))
				.setMaturityType(null)
				.setMaturityRange(mapPeriodRange.evaluate(fpmlDataDocument))
				.setAssetIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setCollateralTaxonomy(new ArrayList(mapCollateralTaxonomyList.evaluate(fpmlDataDocument)))
				.setDomesticCurrencyIssued(null)
				.setListing(mapListingType.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(assetCriteriaList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
