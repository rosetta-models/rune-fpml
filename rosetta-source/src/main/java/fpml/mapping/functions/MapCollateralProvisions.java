package fpml.mapping.functions;

import cdm.product.collateral.CollateralProvisions;
import cdm.product.collateral.CollateralProvisions.CollateralProvisionsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCollateralProvisions.MapCollateralProvisionsDefault.class)
public abstract class MapCollateralProvisions implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEligibleCollateralCriteriaList mapEligibleCollateralCriteriaList;
	@Inject protected MapSubstitutionProvisions mapSubstitutionProvisions;

	/**
	* @param fpmlDataDocument 
	* @return collateralProvisions 
	*/
	public CollateralProvisions evaluate(DataDocument fpmlDataDocument) {
		CollateralProvisions.CollateralProvisionsBuilder collateralProvisionsBuilder = doEvaluate(fpmlDataDocument);
		
		final CollateralProvisions collateralProvisions;
		if (collateralProvisionsBuilder == null) {
			collateralProvisions = null;
		} else {
			collateralProvisions = collateralProvisionsBuilder.build();
			objectValidator.validate(CollateralProvisions.class, collateralProvisions);
		}
		
		return collateralProvisions;
	}

	protected abstract CollateralProvisions.CollateralProvisionsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCollateralProvisionsDefault extends MapCollateralProvisions {
		@Override
		protected CollateralProvisions.CollateralProvisionsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CollateralProvisions.CollateralProvisionsBuilder collateralProvisions = CollateralProvisions.builder();
			return assignOutput(collateralProvisions, fpmlDataDocument);
		}
		
		protected CollateralProvisions.CollateralProvisionsBuilder assignOutput(CollateralProvisions.CollateralProvisionsBuilder collateralProvisions, DataDocument fpmlDataDocument) {
			collateralProvisions = toBuilder(CollateralProvisions.builder()
				.setCollateralType(null)
				.setEligibleCollateral(new ArrayList(mapEligibleCollateralCriteriaList.evaluate(fpmlDataDocument)))
				.setSubstitutionProvisions(mapSubstitutionProvisions.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(collateralProvisions)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
