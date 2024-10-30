package fpml.mapping.functions;

import cdm.product.asset.ReferenceObligation;
import cdm.product.asset.ReferenceObligation.ReferenceObligationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReferenceObligation.MapReferenceObligationDefault.class)
public abstract class MapReferenceObligation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLoan mapLoan;
	@Inject protected MapSecurity mapSecurity;

	/**
	* @param fpmlDataDocument 
	* @return referenceObligation 
	*/
	public ReferenceObligation evaluate(DataDocument fpmlDataDocument) {
		ReferenceObligation.ReferenceObligationBuilder referenceObligationBuilder = doEvaluate(fpmlDataDocument);
		
		final ReferenceObligation referenceObligation;
		if (referenceObligationBuilder == null) {
			referenceObligation = null;
		} else {
			referenceObligation = referenceObligationBuilder.build();
			objectValidator.validate(ReferenceObligation.class, referenceObligation);
		}
		
		return referenceObligation;
	}

	protected abstract ReferenceObligation.ReferenceObligationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapReferenceObligationDefault extends MapReferenceObligation {
		@Override
		protected ReferenceObligation.ReferenceObligationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ReferenceObligation.ReferenceObligationBuilder referenceObligation = ReferenceObligation.builder();
			return assignOutput(referenceObligation, fpmlDataDocument);
		}
		
		protected ReferenceObligation.ReferenceObligationBuilder assignOutput(ReferenceObligation.ReferenceObligationBuilder referenceObligation, DataDocument fpmlDataDocument) {
			referenceObligation = toBuilder(ReferenceObligation.builder()
				.setSecurity(mapSecurity.evaluate(fpmlDataDocument))
				.setLoan(mapLoan.evaluate(fpmlDataDocument))
				.setPrimaryObligor(mapLegalEntity.evaluate(fpmlDataDocument))
				.setPrimaryObligorReferenceValue(mapLegalEntity.evaluate(fpmlDataDocument))
				.setGuarantor(mapLegalEntity.evaluate(fpmlDataDocument))
				.setGuarantorReference(null)
				.setStandardReferenceObligation(null)
				.build());
			
			return Optional.ofNullable(referenceObligation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
