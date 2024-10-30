package fpml.mapping.functions;

import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreement.LegalAgreementBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapLegalAgreement.MapLegalAgreementDefault.class)
public abstract class MapLegalAgreement implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAgreementTerms mapAgreementTerms;
	@Inject protected MapIdentifierList mapIdentifierList;
	@Inject protected MapLegalAgreementIdentification mapLegalAgreementIdentification;
	@Inject protected MapLegalAgreementList mapLegalAgreementList;
	@Inject protected MapPartyList mapPartyList;
	@Inject protected MapPartyRoleList mapPartyRoleList;
	@Inject protected MapResourceList mapResourceList;
	@Inject protected MapUmbrellaAgreement mapUmbrellaAgreement;

	/**
	* @param fpmlDataDocument 
	* @return legalAgreement 
	*/
	public LegalAgreement evaluate(DataDocument fpmlDataDocument) {
		LegalAgreement.LegalAgreementBuilder legalAgreementBuilder = doEvaluate(fpmlDataDocument);
		
		final LegalAgreement legalAgreement;
		if (legalAgreementBuilder == null) {
			legalAgreement = null;
		} else {
			legalAgreement = legalAgreementBuilder.build();
			objectValidator.validate(LegalAgreement.class, legalAgreement);
		}
		
		return legalAgreement;
	}

	protected abstract LegalAgreement.LegalAgreementBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapLegalAgreementDefault extends MapLegalAgreement {
		@Override
		protected LegalAgreement.LegalAgreementBuilder doEvaluate(DataDocument fpmlDataDocument) {
			LegalAgreement.LegalAgreementBuilder legalAgreement = LegalAgreement.builder();
			return assignOutput(legalAgreement, fpmlDataDocument);
		}
		
		protected LegalAgreement.LegalAgreementBuilder assignOutput(LegalAgreement.LegalAgreementBuilder legalAgreement, DataDocument fpmlDataDocument) {
			legalAgreement = toBuilder(LegalAgreement.builder()
				.setAgreementDate(null)
				.setEffectiveDate(null)
				.setIdentifier(new ArrayList(mapIdentifierList.evaluate(fpmlDataDocument)))
				.setLegalAgreementIdentification(mapLegalAgreementIdentification.evaluate(fpmlDataDocument))
				.setContractualPartyValue(new ArrayList(mapPartyList.evaluate(fpmlDataDocument)))
				.setOtherParty(new ArrayList(mapPartyRoleList.evaluate(fpmlDataDocument)))
				.setAttachment(new ArrayList(mapResourceList.evaluate(fpmlDataDocument)))
				.setAgreementTerms(mapAgreementTerms.evaluate(fpmlDataDocument))
				.setRelatedAgreements(new ArrayList(mapLegalAgreementList.evaluate(fpmlDataDocument)))
				.setUmbrellaAgreement(mapUmbrellaAgreement.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(legalAgreement)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
