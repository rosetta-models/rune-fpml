package fpml.mapping.functions;

import cdm.product.collateral.CollateralTreatment;
import cdm.product.collateral.CollateralTreatment.CollateralTreatmentBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCollateralTreatment.MapCollateralTreatmentDefault.class)
public abstract class MapCollateralTreatment implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCollateralValuationTreatment mapCollateralValuationTreatment;
	@Inject protected MapConcentrationLimitList mapConcentrationLimitList;

	/**
	* @param fpmlDataDocument 
	* @return collateralTreatment 
	*/
	public CollateralTreatment evaluate(DataDocument fpmlDataDocument) {
		CollateralTreatment.CollateralTreatmentBuilder collateralTreatmentBuilder = doEvaluate(fpmlDataDocument);
		
		final CollateralTreatment collateralTreatment;
		if (collateralTreatmentBuilder == null) {
			collateralTreatment = null;
		} else {
			collateralTreatment = collateralTreatmentBuilder.build();
			objectValidator.validate(CollateralTreatment.class, collateralTreatment);
		}
		
		return collateralTreatment;
	}

	protected abstract CollateralTreatment.CollateralTreatmentBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCollateralTreatmentDefault extends MapCollateralTreatment {
		@Override
		protected CollateralTreatment.CollateralTreatmentBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CollateralTreatment.CollateralTreatmentBuilder collateralTreatment = CollateralTreatment.builder();
			return assignOutput(collateralTreatment, fpmlDataDocument);
		}
		
		protected CollateralTreatment.CollateralTreatmentBuilder assignOutput(CollateralTreatment.CollateralTreatmentBuilder collateralTreatment, DataDocument fpmlDataDocument) {
			collateralTreatment = toBuilder(CollateralTreatment.builder()
				.setValuationTreatment(mapCollateralValuationTreatment.evaluate(fpmlDataDocument))
				.setConcentrationLimit(new ArrayList(mapConcentrationLimitList.evaluate(fpmlDataDocument)))
				.setIsIncluded(null)
				.build());
			
			return Optional.ofNullable(collateralTreatment)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
