package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.base.staticdata.asset.common.TaxonomyValue.TaxonomyValueBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTaxonomyValue.MapTaxonomyValueDefault.class)
public abstract class MapTaxonomyValue implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNameWithScheme mapNameWithScheme;
	@Inject protected MapTaxonomyClassificationList mapTaxonomyClassificationList;

	/**
	* @param fpmlDataDocument 
	* @return taxonomyValue 
	*/
	public TaxonomyValue evaluate(DataDocument fpmlDataDocument) {
		TaxonomyValue.TaxonomyValueBuilder taxonomyValueBuilder = doEvaluate(fpmlDataDocument);
		
		final TaxonomyValue taxonomyValue;
		if (taxonomyValueBuilder == null) {
			taxonomyValue = null;
		} else {
			taxonomyValue = taxonomyValueBuilder.build();
			objectValidator.validate(TaxonomyValue.class, taxonomyValue);
		}
		
		return taxonomyValue;
	}

	protected abstract TaxonomyValue.TaxonomyValueBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTaxonomyValueDefault extends MapTaxonomyValue {
		@Override
		protected TaxonomyValue.TaxonomyValueBuilder doEvaluate(DataDocument fpmlDataDocument) {
			TaxonomyValue.TaxonomyValueBuilder taxonomyValue = TaxonomyValue.builder();
			return assignOutput(taxonomyValue, fpmlDataDocument);
		}
		
		protected TaxonomyValue.TaxonomyValueBuilder assignOutput(TaxonomyValue.TaxonomyValueBuilder taxonomyValue, DataDocument fpmlDataDocument) {
			taxonomyValue = toBuilder(TaxonomyValue.builder()
				.setNameValue(mapNameWithScheme.evaluate(fpmlDataDocument))
				.setClassification(new ArrayList(mapTaxonomyClassificationList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(taxonomyValue)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
