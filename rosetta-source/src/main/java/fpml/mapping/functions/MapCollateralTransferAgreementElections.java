package fpml.mapping.functions;

import cdm.legaldocumentation.csa.CollateralTransferAgreementElections;
import cdm.legaldocumentation.csa.CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCollateralTransferAgreementElections.MapCollateralTransferAgreementElectionsDefault.class)
public abstract class MapCollateralTransferAgreementElections implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return collateralTransferAgreementElections 
	*/
	public CollateralTransferAgreementElections evaluate(DataDocument fpmlDataDocument) {
		CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder collateralTransferAgreementElectionsBuilder = doEvaluate(fpmlDataDocument);
		
		final CollateralTransferAgreementElections collateralTransferAgreementElections;
		if (collateralTransferAgreementElectionsBuilder == null) {
			collateralTransferAgreementElections = null;
		} else {
			collateralTransferAgreementElections = collateralTransferAgreementElectionsBuilder.build();
			objectValidator.validate(CollateralTransferAgreementElections.class, collateralTransferAgreementElections);
		}
		
		return collateralTransferAgreementElections;
	}

	protected abstract CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCollateralTransferAgreementElectionsDefault extends MapCollateralTransferAgreementElections {
		@Override
		protected CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder collateralTransferAgreementElections = CollateralTransferAgreementElections.builder();
			return assignOutput(collateralTransferAgreementElections, fpmlDataDocument);
		}
		
		protected CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder assignOutput(CollateralTransferAgreementElections.CollateralTransferAgreementElectionsBuilder collateralTransferAgreementElections, DataDocument fpmlDataDocument) {
			collateralTransferAgreementElections = toBuilder(CollateralTransferAgreementElections.builder()
				.build());
			
			return Optional.ofNullable(collateralTransferAgreementElections)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
