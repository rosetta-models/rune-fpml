package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.CollateralTaxonomy;
import cdm.base.staticdata.asset.common.CollateralTaxonomy.CollateralTaxonomyBuilder;
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


@ImplementedBy(MapCollateralTaxonomyList.MapCollateralTaxonomyListDefault.class)
public abstract class MapCollateralTaxonomyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCollateralTaxonomyValue mapCollateralTaxonomyValue;

	/**
	* @param fpmlDataDocument 
	* @return collateralTaxonomyList 
	*/
	public List<? extends CollateralTaxonomy> evaluate(DataDocument fpmlDataDocument) {
		List<CollateralTaxonomy.CollateralTaxonomyBuilder> collateralTaxonomyListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends CollateralTaxonomy> collateralTaxonomyList;
		if (collateralTaxonomyListBuilder == null) {
			collateralTaxonomyList = null;
		} else {
			collateralTaxonomyList = collateralTaxonomyListBuilder.stream().map(CollateralTaxonomy::build).collect(Collectors.toList());
			objectValidator.validate(CollateralTaxonomy.class, collateralTaxonomyList);
		}
		
		return collateralTaxonomyList;
	}

	protected abstract List<CollateralTaxonomy.CollateralTaxonomyBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCollateralTaxonomyListDefault extends MapCollateralTaxonomyList {
		@Override
		protected List<CollateralTaxonomy.CollateralTaxonomyBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<CollateralTaxonomy.CollateralTaxonomyBuilder> collateralTaxonomyList = new ArrayList<>();
			return assignOutput(collateralTaxonomyList, fpmlDataDocument);
		}
		
		protected List<CollateralTaxonomy.CollateralTaxonomyBuilder> assignOutput(List<CollateralTaxonomy.CollateralTaxonomyBuilder> collateralTaxonomyList, DataDocument fpmlDataDocument) {
			collateralTaxonomyList.addAll(toBuilder(MapperC.<CollateralTaxonomy>of(MapperS.of(CollateralTaxonomy.builder()
				.setTaxonomyValue(mapCollateralTaxonomyValue.evaluate(fpmlDataDocument))
				.setTaxonomySource(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(collateralTaxonomyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
