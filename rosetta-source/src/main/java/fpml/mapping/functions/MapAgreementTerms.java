package fpml.mapping.functions;

import cdm.legaldocumentation.common.AgreementTerms;
import cdm.legaldocumentation.common.AgreementTerms.AgreementTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAgreementTerms.MapAgreementTermsDefault.class)
public abstract class MapAgreementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAgreement mapAgreement;
	@Inject protected MapCounterpartyList mapCounterpartyList;

	/**
	* @param fpmlDataDocument 
	* @return agreementTerms 
	*/
	public AgreementTerms evaluate(DataDocument fpmlDataDocument) {
		AgreementTerms.AgreementTermsBuilder agreementTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final AgreementTerms agreementTerms;
		if (agreementTermsBuilder == null) {
			agreementTerms = null;
		} else {
			agreementTerms = agreementTermsBuilder.build();
			objectValidator.validate(AgreementTerms.class, agreementTerms);
		}
		
		return agreementTerms;
	}

	protected abstract AgreementTerms.AgreementTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAgreementTermsDefault extends MapAgreementTerms {
		@Override
		protected AgreementTerms.AgreementTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AgreementTerms.AgreementTermsBuilder agreementTerms = AgreementTerms.builder();
			return assignOutput(agreementTerms, fpmlDataDocument);
		}
		
		protected AgreementTerms.AgreementTermsBuilder assignOutput(AgreementTerms.AgreementTermsBuilder agreementTerms, DataDocument fpmlDataDocument) {
			agreementTerms = toBuilder(AgreementTerms.builder()
				.setAgreement(mapAgreement.evaluate(fpmlDataDocument))
				.setClauseLibrary(null)
				.setCounterparty(new ArrayList(mapCounterpartyList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(agreementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
