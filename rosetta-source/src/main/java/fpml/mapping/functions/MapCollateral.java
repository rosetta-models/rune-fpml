package fpml.mapping.functions;

import cdm.product.collateral.Collateral;
import cdm.product.collateral.Collateral.CollateralBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCollateral.MapCollateralDefault.class)
public abstract class MapCollateral implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCollateralPortfolioList mapCollateralPortfolioList;
	@Inject protected MapCollateralProvisions mapCollateralProvisions;
	@Inject protected MapIdentifierList mapIdentifierList;
	@Inject protected MapIndependentAmount mapIndependentAmount;

	/**
	* @param fpmlDataDocument 
	* @return collateral 
	*/
	public Collateral evaluate(DataDocument fpmlDataDocument) {
		Collateral.CollateralBuilder collateralBuilder = doEvaluate(fpmlDataDocument);
		
		final Collateral collateral;
		if (collateralBuilder == null) {
			collateral = null;
		} else {
			collateral = collateralBuilder.build();
			objectValidator.validate(Collateral.class, collateral);
		}
		
		return collateral;
	}

	protected abstract Collateral.CollateralBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCollateralDefault extends MapCollateral {
		@Override
		protected Collateral.CollateralBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Collateral.CollateralBuilder collateral = Collateral.builder();
			return assignOutput(collateral, fpmlDataDocument);
		}
		
		protected Collateral.CollateralBuilder assignOutput(Collateral.CollateralBuilder collateral, DataDocument fpmlDataDocument) {
			collateral = toBuilder(Collateral.builder()
				.setIndependentAmount(mapIndependentAmount.evaluate(fpmlDataDocument))
				.setPortfolioIdentifier(new ArrayList(mapIdentifierList.evaluate(fpmlDataDocument)))
				.setCollateralPortfolioValue(new ArrayList(mapCollateralPortfolioList.evaluate(fpmlDataDocument)))
				.setCollateralProvisions(mapCollateralProvisions.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(collateral)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
