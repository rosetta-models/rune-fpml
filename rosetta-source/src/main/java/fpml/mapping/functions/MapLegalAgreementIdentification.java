package fpml.mapping.functions;

import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.legaldocumentation.common.LegalAgreementIdentification.LegalAgreementIdentificationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapLegalAgreementIdentification.MapLegalAgreementIdentificationDefault.class)
public abstract class MapLegalAgreementIdentification implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAgreementName mapAgreementName;

	/**
	* @param fpmlDataDocument 
	* @return legalAgreementIdentification 
	*/
	public LegalAgreementIdentification evaluate(DataDocument fpmlDataDocument) {
		LegalAgreementIdentification.LegalAgreementIdentificationBuilder legalAgreementIdentificationBuilder = doEvaluate(fpmlDataDocument);
		
		final LegalAgreementIdentification legalAgreementIdentification;
		if (legalAgreementIdentificationBuilder == null) {
			legalAgreementIdentification = null;
		} else {
			legalAgreementIdentification = legalAgreementIdentificationBuilder.build();
			objectValidator.validate(LegalAgreementIdentification.class, legalAgreementIdentification);
		}
		
		return legalAgreementIdentification;
	}

	protected abstract LegalAgreementIdentification.LegalAgreementIdentificationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapLegalAgreementIdentificationDefault extends MapLegalAgreementIdentification {
		@Override
		protected LegalAgreementIdentification.LegalAgreementIdentificationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			LegalAgreementIdentification.LegalAgreementIdentificationBuilder legalAgreementIdentification = LegalAgreementIdentification.builder();
			return assignOutput(legalAgreementIdentification, fpmlDataDocument);
		}
		
		protected LegalAgreementIdentification.LegalAgreementIdentificationBuilder assignOutput(LegalAgreementIdentification.LegalAgreementIdentificationBuilder legalAgreementIdentification, DataDocument fpmlDataDocument) {
			legalAgreementIdentification = toBuilder(LegalAgreementIdentification.builder()
				.setGoverningLaw(null)
				.setAgreementName(mapAgreementName.evaluate(fpmlDataDocument))
				.setPublisher(null)
				.setVintage(null)
				.build());
			
			return Optional.ofNullable(legalAgreementIdentification)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
