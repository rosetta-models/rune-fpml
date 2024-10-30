package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.TaxonomyClassification;
import cdm.base.staticdata.asset.common.TaxonomyClassification.TaxonomyClassificationBuilder;
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


@ImplementedBy(MapTaxonomyClassificationList.MapTaxonomyClassificationListDefault.class)
public abstract class MapTaxonomyClassificationList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return taxonomyClassificationList 
	*/
	public List<? extends TaxonomyClassification> evaluate(DataDocument fpmlDataDocument) {
		List<TaxonomyClassification.TaxonomyClassificationBuilder> taxonomyClassificationListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends TaxonomyClassification> taxonomyClassificationList;
		if (taxonomyClassificationListBuilder == null) {
			taxonomyClassificationList = null;
		} else {
			taxonomyClassificationList = taxonomyClassificationListBuilder.stream().map(TaxonomyClassification::build).collect(Collectors.toList());
			objectValidator.validate(TaxonomyClassification.class, taxonomyClassificationList);
		}
		
		return taxonomyClassificationList;
	}

	protected abstract List<TaxonomyClassification.TaxonomyClassificationBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTaxonomyClassificationListDefault extends MapTaxonomyClassificationList {
		@Override
		protected List<TaxonomyClassification.TaxonomyClassificationBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<TaxonomyClassification.TaxonomyClassificationBuilder> taxonomyClassificationList = new ArrayList<>();
			return assignOutput(taxonomyClassificationList, fpmlDataDocument);
		}
		
		protected List<TaxonomyClassification.TaxonomyClassificationBuilder> assignOutput(List<TaxonomyClassification.TaxonomyClassificationBuilder> taxonomyClassificationList, DataDocument fpmlDataDocument) {
			taxonomyClassificationList.addAll(toBuilder(MapperC.<TaxonomyClassification>of(MapperS.of(TaxonomyClassification.builder()
				.setClassName(null)
				.setValue(null)
				.setDescription(null)
				.setOrdinal(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(taxonomyClassificationList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
