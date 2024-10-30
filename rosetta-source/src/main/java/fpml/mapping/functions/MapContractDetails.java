package fpml.mapping.functions;

import cdm.event.common.ContractDetails;
import cdm.event.common.ContractDetails.ContractDetailsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapContractDetails.MapContractDetailsDefault.class)
public abstract class MapContractDetails implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapGoverningLawWithScheme mapGoverningLawWithScheme;
	@Inject protected MapLegalAgreementList mapLegalAgreementList;

	/**
	* @param fpmlDataDocument 
	* @return contractDetails 
	*/
	public ContractDetails evaluate(DataDocument fpmlDataDocument) {
		ContractDetails.ContractDetailsBuilder contractDetailsBuilder = doEvaluate(fpmlDataDocument);
		
		final ContractDetails contractDetails;
		if (contractDetailsBuilder == null) {
			contractDetails = null;
		} else {
			contractDetails = contractDetailsBuilder.build();
			objectValidator.validate(ContractDetails.class, contractDetails);
		}
		
		return contractDetails;
	}

	protected abstract ContractDetails.ContractDetailsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapContractDetailsDefault extends MapContractDetails {
		@Override
		protected ContractDetails.ContractDetailsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ContractDetails.ContractDetailsBuilder contractDetails = ContractDetails.builder();
			return assignOutput(contractDetails, fpmlDataDocument);
		}
		
		protected ContractDetails.ContractDetailsBuilder assignOutput(ContractDetails.ContractDetailsBuilder contractDetails, DataDocument fpmlDataDocument) {
			contractDetails = toBuilder(ContractDetails.builder()
				.setDocumentation(new ArrayList(mapLegalAgreementList.evaluate(fpmlDataDocument)))
				.setGoverningLawValue(mapGoverningLawWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(contractDetails)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
