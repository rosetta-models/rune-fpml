package fpml.mapping.functions;

import cdm.legaldocumentation.master.MasterAgreementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapMasterAgreementTypeWithScheme.MapMasterAgreementTypeWithSchemeDefault.class)
public abstract class MapMasterAgreementTypeWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return masterAgreementTypeEnum 
	*/
	public MasterAgreementTypeEnum evaluate(DataDocument fpmlDataDocument) {
		MasterAgreementTypeEnum masterAgreementTypeEnum = doEvaluate(fpmlDataDocument);
		
		return masterAgreementTypeEnum;
	}

	protected abstract MasterAgreementTypeEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMasterAgreementTypeWithSchemeDefault extends MapMasterAgreementTypeWithScheme {
		@Override
		protected MasterAgreementTypeEnum doEvaluate(DataDocument fpmlDataDocument) {
			MasterAgreementTypeEnum masterAgreementTypeEnum = null;
			return assignOutput(masterAgreementTypeEnum, fpmlDataDocument);
		}
		
		protected MasterAgreementTypeEnum assignOutput(MasterAgreementTypeEnum masterAgreementTypeEnum, DataDocument fpmlDataDocument) {
			masterAgreementTypeEnum = null;
			
			return masterAgreementTypeEnum;
		}
	}
}
