package fpml.mapping.functions;

import cdm.product.asset.ReferenceInformation;
import cdm.product.asset.ReferenceInformation.ReferenceInformationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReferenceInformation.MapReferenceInformationDefault.class)
public abstract class MapReferenceInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapPrice mapPrice;
	@Inject protected MapReferenceObligationList mapReferenceObligationList;

	/**
	* @param fpmlDataDocument 
	* @return referenceInformation 
	*/
	public ReferenceInformation evaluate(DataDocument fpmlDataDocument) {
		ReferenceInformation.ReferenceInformationBuilder referenceInformationBuilder = doEvaluate(fpmlDataDocument);
		
		final ReferenceInformation referenceInformation;
		if (referenceInformationBuilder == null) {
			referenceInformation = null;
		} else {
			referenceInformation = referenceInformationBuilder.build();
			objectValidator.validate(ReferenceInformation.class, referenceInformation);
		}
		
		return referenceInformation;
	}

	protected abstract ReferenceInformation.ReferenceInformationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapReferenceInformationDefault extends MapReferenceInformation {
		@Override
		protected ReferenceInformation.ReferenceInformationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ReferenceInformation.ReferenceInformationBuilder referenceInformation = ReferenceInformation.builder();
			return assignOutput(referenceInformation, fpmlDataDocument);
		}
		
		protected ReferenceInformation.ReferenceInformationBuilder assignOutput(ReferenceInformation.ReferenceInformationBuilder referenceInformation, DataDocument fpmlDataDocument) {
			referenceInformation = toBuilder(ReferenceInformation.builder()
				.setReferenceEntity(mapLegalEntity.evaluate(fpmlDataDocument))
				.setReferenceObligation(new ArrayList(mapReferenceObligationList.evaluate(fpmlDataDocument)))
				.setNoReferenceObligation(null)
				.setUnknownReferenceObligation(null)
				.setAllGuarantees(null)
				.setReferencePrice(mapPrice.evaluate(fpmlDataDocument))
				.setReferencePolicy(null)
				.setSecuredList(null)
				.build());
			
			return Optional.ofNullable(referenceInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
