package fpml.mapping.functions;

import cdm.product.collateral.CollateralValuationTreatment;
import cdm.product.collateral.CollateralValuationTreatment.CollateralValuationTreatmentBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCollateralValuationTreatment.MapCollateralValuationTreatmentDefault.class)
public abstract class MapCollateralValuationTreatment implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return collateralValuationTreatment 
	*/
	public CollateralValuationTreatment evaluate(DataDocument fpmlDataDocument) {
		CollateralValuationTreatment.CollateralValuationTreatmentBuilder collateralValuationTreatmentBuilder = doEvaluate(fpmlDataDocument);
		
		final CollateralValuationTreatment collateralValuationTreatment;
		if (collateralValuationTreatmentBuilder == null) {
			collateralValuationTreatment = null;
		} else {
			collateralValuationTreatment = collateralValuationTreatmentBuilder.build();
			objectValidator.validate(CollateralValuationTreatment.class, collateralValuationTreatment);
		}
		
		return collateralValuationTreatment;
	}

	protected abstract CollateralValuationTreatment.CollateralValuationTreatmentBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCollateralValuationTreatmentDefault extends MapCollateralValuationTreatment {
		@Override
		protected CollateralValuationTreatment.CollateralValuationTreatmentBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CollateralValuationTreatment.CollateralValuationTreatmentBuilder collateralValuationTreatment = CollateralValuationTreatment.builder();
			return assignOutput(collateralValuationTreatment, fpmlDataDocument);
		}
		
		protected CollateralValuationTreatment.CollateralValuationTreatmentBuilder assignOutput(CollateralValuationTreatment.CollateralValuationTreatmentBuilder collateralValuationTreatment, DataDocument fpmlDataDocument) {
			collateralValuationTreatment = toBuilder(CollateralValuationTreatment.builder()
				.setHaircutPercentage(null)
				.setMarginPercentage(null)
				.setFxHaircutPercentage(null)
				.setAdditionalHaircutPercentage(null)
				.build());
			
			return Optional.ofNullable(collateralValuationTreatment)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
