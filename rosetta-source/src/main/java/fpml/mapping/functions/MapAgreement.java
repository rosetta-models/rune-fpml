package fpml.mapping.functions;

import cdm.legaldocumentation.contract.Agreement;
import cdm.legaldocumentation.contract.Agreement.AgreementBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAgreement.MapAgreementDefault.class)
public abstract class MapAgreement implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCollateralTransferAgreementElections mapCollateralTransferAgreementElections;
	@Inject protected MapCreditSupportAgreementElections mapCreditSupportAgreementElections;
	@Inject protected MapMasterAgreementSchedule mapMasterAgreementSchedule;
	@Inject protected MapSecurityAgreementElections mapSecurityAgreementElections;
	@Inject protected MapTransactionAdditionalTerms mapTransactionAdditionalTerms;

	/**
	* @param fpmlDataDocument 
	* @return agreement 
	*/
	public Agreement evaluate(DataDocument fpmlDataDocument) {
		Agreement.AgreementBuilder agreementBuilder = doEvaluate(fpmlDataDocument);
		
		final Agreement agreement;
		if (agreementBuilder == null) {
			agreement = null;
		} else {
			agreement = agreementBuilder.build();
			objectValidator.validate(Agreement.class, agreement);
		}
		
		return agreement;
	}

	protected abstract Agreement.AgreementBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAgreementDefault extends MapAgreement {
		@Override
		protected Agreement.AgreementBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Agreement.AgreementBuilder agreement = Agreement.builder();
			return assignOutput(agreement, fpmlDataDocument);
		}
		
		protected Agreement.AgreementBuilder assignOutput(Agreement.AgreementBuilder agreement, DataDocument fpmlDataDocument) {
			agreement = toBuilder(Agreement.builder()
				.setCreditSupportAgreementElections(mapCreditSupportAgreementElections.evaluate(fpmlDataDocument))
				.setCollateralTransferAgreementElections(mapCollateralTransferAgreementElections.evaluate(fpmlDataDocument))
				.setSecurityAgreementElections(mapSecurityAgreementElections.evaluate(fpmlDataDocument))
				.setMasterAgreementSchedule(mapMasterAgreementSchedule.evaluate(fpmlDataDocument))
				.setTransactionAdditionalTerms(mapTransactionAdditionalTerms.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(agreement)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
