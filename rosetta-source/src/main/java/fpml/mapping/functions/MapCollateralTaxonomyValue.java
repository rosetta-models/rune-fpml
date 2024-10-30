package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.CollateralTaxonomyValue;
import cdm.base.staticdata.asset.common.CollateralTaxonomyValue.CollateralTaxonomyValueBuilder;
import cdm.base.staticdata.asset.common.EU_EMIR_EligibleCollateralEnum;
import cdm.base.staticdata.asset.common.UK_EMIR_EligibleCollateralEnum;
import cdm.base.staticdata.asset.common.US_CFTC_PR_EligibleCollateralEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCollateralTaxonomyValue.MapCollateralTaxonomyValueDefault.class)
public abstract class MapCollateralTaxonomyValue implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNonEnumeratedTaxonomyValueWithSchemeList mapNonEnumeratedTaxonomyValueWithSchemeList;

	/**
	* @param fpmlDataDocument 
	* @return collateralTaxonomyValue 
	*/
	public CollateralTaxonomyValue evaluate(DataDocument fpmlDataDocument) {
		CollateralTaxonomyValue.CollateralTaxonomyValueBuilder collateralTaxonomyValueBuilder = doEvaluate(fpmlDataDocument);
		
		final CollateralTaxonomyValue collateralTaxonomyValue;
		if (collateralTaxonomyValueBuilder == null) {
			collateralTaxonomyValue = null;
		} else {
			collateralTaxonomyValue = collateralTaxonomyValueBuilder.build();
			objectValidator.validate(CollateralTaxonomyValue.class, collateralTaxonomyValue);
		}
		
		return collateralTaxonomyValue;
	}

	protected abstract CollateralTaxonomyValue.CollateralTaxonomyValueBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCollateralTaxonomyValueDefault extends MapCollateralTaxonomyValue {
		@Override
		protected CollateralTaxonomyValue.CollateralTaxonomyValueBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CollateralTaxonomyValue.CollateralTaxonomyValueBuilder collateralTaxonomyValue = CollateralTaxonomyValue.builder();
			return assignOutput(collateralTaxonomyValue, fpmlDataDocument);
		}
		
		protected CollateralTaxonomyValue.CollateralTaxonomyValueBuilder assignOutput(CollateralTaxonomyValue.CollateralTaxonomyValueBuilder collateralTaxonomyValue, DataDocument fpmlDataDocument) {
			collateralTaxonomyValue = toBuilder(CollateralTaxonomyValue.builder()
				.setEu_EMIR_EligibleCollateral(Collections.<EU_EMIR_EligibleCollateralEnum>emptyList())
				.setUk_EMIR_EligibleCollateral(Collections.<UK_EMIR_EligibleCollateralEnum>emptyList())
				.setUs_CFTC_PR_EligibleCollateral(Collections.<US_CFTC_PR_EligibleCollateralEnum>emptyList())
				.setNonEnumeratedTaxonomyValueValue(mapNonEnumeratedTaxonomyValueWithSchemeList.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(collateralTaxonomyValue)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
