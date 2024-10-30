package fpml.mapping.functions;

import cdm.legaldocumentation.common.AgreementName;
import cdm.legaldocumentation.common.AgreementName.AgreementNameBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAgreementName.MapAgreementNameDefault.class)
public abstract class MapAgreementName implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapContractualDefinitionsTypeWithSchemeList mapContractualDefinitionsTypeWithSchemeList;
	@Inject protected MapContractualMatrixList mapContractualMatrixList;
	@Inject protected MapContractualTermsSupplementList mapContractualTermsSupplementList;
	@Inject protected MapCreditSupportAgreementTypeWithScheme mapCreditSupportAgreementTypeWithScheme;
	@Inject protected MapMasterAgreementTypeWithScheme mapMasterAgreementTypeWithScheme;
	@Inject protected MapMasterConfirmationAnnexTypeWithScheme mapMasterConfirmationAnnexTypeWithScheme;
	@Inject protected MapMasterConfirmationTypeWithScheme mapMasterConfirmationTypeWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return agreementName 
	*/
	public AgreementName evaluate(DataDocument fpmlDataDocument) {
		AgreementName.AgreementNameBuilder agreementNameBuilder = doEvaluate(fpmlDataDocument);
		
		final AgreementName agreementName;
		if (agreementNameBuilder == null) {
			agreementName = null;
		} else {
			agreementName = agreementNameBuilder.build();
			objectValidator.validate(AgreementName.class, agreementName);
		}
		
		return agreementName;
	}

	protected abstract AgreementName.AgreementNameBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAgreementNameDefault extends MapAgreementName {
		@Override
		protected AgreementName.AgreementNameBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AgreementName.AgreementNameBuilder agreementName = AgreementName.builder();
			return assignOutput(agreementName, fpmlDataDocument);
		}
		
		protected AgreementName.AgreementNameBuilder assignOutput(AgreementName.AgreementNameBuilder agreementName, DataDocument fpmlDataDocument) {
			agreementName = toBuilder(AgreementName.builder()
				.setAgreementType(null)
				.setCreditSupportAgreementTypeValue(mapCreditSupportAgreementTypeWithScheme.evaluate(fpmlDataDocument))
				.setCreditSupportAgreementMarginType(null)
				.setContractualDefinitionsTypeValue(mapContractualDefinitionsTypeWithSchemeList.evaluate(fpmlDataDocument))
				.setContractualTermsSupplement(new ArrayList(mapContractualTermsSupplementList.evaluate(fpmlDataDocument)))
				.setContractualMatrix(new ArrayList(mapContractualMatrixList.evaluate(fpmlDataDocument)))
				.setMasterAgreementTypeValue(mapMasterAgreementTypeWithScheme.evaluate(fpmlDataDocument))
				.setMasterConfirmationTypeValue(mapMasterConfirmationTypeWithScheme.evaluate(fpmlDataDocument))
				.setMasterConfirmationAnnexTypeValue(mapMasterConfirmationAnnexTypeWithScheme.evaluate(fpmlDataDocument))
				.setOtherAgreement(null)
				.build());
			
			return Optional.ofNullable(agreementName)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
