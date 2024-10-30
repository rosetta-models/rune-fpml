package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.ProductTaxonomy.ProductTaxonomyBuilder;
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


@ImplementedBy(MapProductTaxonomyList.MapProductTaxonomyListDefault.class)
public abstract class MapProductTaxonomyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPrimaryAssetClassWithScheme mapPrimaryAssetClassWithScheme;
	@Inject protected MapSecondaryAssetClassWithSchemeList mapSecondaryAssetClassWithSchemeList;
	@Inject protected MapTaxonomyValue mapTaxonomyValue;

	/**
	* @param fpmlDataDocument 
	* @return productTaxonomyList 
	*/
	public List<? extends ProductTaxonomy> evaluate(DataDocument fpmlDataDocument) {
		List<ProductTaxonomy.ProductTaxonomyBuilder> productTaxonomyListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ProductTaxonomy> productTaxonomyList;
		if (productTaxonomyListBuilder == null) {
			productTaxonomyList = null;
		} else {
			productTaxonomyList = productTaxonomyListBuilder.stream().map(ProductTaxonomy::build).collect(Collectors.toList());
			objectValidator.validate(ProductTaxonomy.class, productTaxonomyList);
		}
		
		return productTaxonomyList;
	}

	protected abstract List<ProductTaxonomy.ProductTaxonomyBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapProductTaxonomyListDefault extends MapProductTaxonomyList {
		@Override
		protected List<ProductTaxonomy.ProductTaxonomyBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ProductTaxonomy.ProductTaxonomyBuilder> productTaxonomyList = new ArrayList<>();
			return assignOutput(productTaxonomyList, fpmlDataDocument);
		}
		
		protected List<ProductTaxonomy.ProductTaxonomyBuilder> assignOutput(List<ProductTaxonomy.ProductTaxonomyBuilder> productTaxonomyList, DataDocument fpmlDataDocument) {
			productTaxonomyList.addAll(toBuilder(MapperC.<ProductTaxonomy>of(MapperS.of(ProductTaxonomy.builder()
				.setSource(null)
				.setValue(mapTaxonomyValue.evaluate(fpmlDataDocument))
				.setPrimaryAssetClassValue(mapPrimaryAssetClassWithScheme.evaluate(fpmlDataDocument))
				.setSecondaryAssetClassValue(mapSecondaryAssetClassWithSchemeList.evaluate(fpmlDataDocument))
				.setProductQualifier(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(productTaxonomyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
