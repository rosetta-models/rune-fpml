package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.Taxonomy;
import cdm.base.staticdata.asset.common.Taxonomy.TaxonomyBuilder;
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


@ImplementedBy(MapTaxonomyList.MapTaxonomyListDefault.class)
public abstract class MapTaxonomyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapTaxonomyValue mapTaxonomyValue;

	/**
	* @param fpmlDataDocument 
	* @return taxonomyList 
	*/
	public List<? extends Taxonomy> evaluate(DataDocument fpmlDataDocument) {
		List<Taxonomy.TaxonomyBuilder> taxonomyListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Taxonomy> taxonomyList;
		if (taxonomyListBuilder == null) {
			taxonomyList = null;
		} else {
			taxonomyList = taxonomyListBuilder.stream().map(Taxonomy::build).collect(Collectors.toList());
			objectValidator.validate(Taxonomy.class, taxonomyList);
		}
		
		return taxonomyList;
	}

	protected abstract List<Taxonomy.TaxonomyBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTaxonomyListDefault extends MapTaxonomyList {
		@Override
		protected List<Taxonomy.TaxonomyBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Taxonomy.TaxonomyBuilder> taxonomyList = new ArrayList<>();
			return assignOutput(taxonomyList, fpmlDataDocument);
		}
		
		protected List<Taxonomy.TaxonomyBuilder> assignOutput(List<Taxonomy.TaxonomyBuilder> taxonomyList, DataDocument fpmlDataDocument) {
			taxonomyList.addAll(toBuilder(MapperC.<Taxonomy>of(MapperS.of(Taxonomy.builder()
				.setSource(null)
				.setValue(mapTaxonomyValue.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(taxonomyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
