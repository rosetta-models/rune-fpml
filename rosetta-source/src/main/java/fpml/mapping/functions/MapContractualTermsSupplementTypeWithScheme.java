package fpml.mapping.functions;

import cdm.legaldocumentation.common.ContractualSupplementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapContractualTermsSupplementTypeWithScheme.MapContractualTermsSupplementTypeWithSchemeDefault.class)
public abstract class MapContractualTermsSupplementTypeWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return contractualSupplementTypeEnum 
	*/
	public ContractualSupplementTypeEnum evaluate(DataDocument fpmlDataDocument) {
		ContractualSupplementTypeEnum contractualSupplementTypeEnum = doEvaluate(fpmlDataDocument);
		
		return contractualSupplementTypeEnum;
	}

	protected abstract ContractualSupplementTypeEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapContractualTermsSupplementTypeWithSchemeDefault extends MapContractualTermsSupplementTypeWithScheme {
		@Override
		protected ContractualSupplementTypeEnum doEvaluate(DataDocument fpmlDataDocument) {
			ContractualSupplementTypeEnum contractualSupplementTypeEnum = null;
			return assignOutput(contractualSupplementTypeEnum, fpmlDataDocument);
		}
		
		protected ContractualSupplementTypeEnum assignOutput(ContractualSupplementTypeEnum contractualSupplementTypeEnum, DataDocument fpmlDataDocument) {
			contractualSupplementTypeEnum = null;
			
			return contractualSupplementTypeEnum;
		}
	}
}
