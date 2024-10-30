package fpml.mapping.functions;

import cdm.legaldocumentation.master.MasterConfirmationAnnexTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapMasterConfirmationAnnexTypeWithScheme.MapMasterConfirmationAnnexTypeWithSchemeDefault.class)
public abstract class MapMasterConfirmationAnnexTypeWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return masterConfirmationAnnexTypeEnum 
	*/
	public MasterConfirmationAnnexTypeEnum evaluate(DataDocument fpmlDataDocument) {
		MasterConfirmationAnnexTypeEnum masterConfirmationAnnexTypeEnum = doEvaluate(fpmlDataDocument);
		
		return masterConfirmationAnnexTypeEnum;
	}

	protected abstract MasterConfirmationAnnexTypeEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMasterConfirmationAnnexTypeWithSchemeDefault extends MapMasterConfirmationAnnexTypeWithScheme {
		@Override
		protected MasterConfirmationAnnexTypeEnum doEvaluate(DataDocument fpmlDataDocument) {
			MasterConfirmationAnnexTypeEnum masterConfirmationAnnexTypeEnum = null;
			return assignOutput(masterConfirmationAnnexTypeEnum, fpmlDataDocument);
		}
		
		protected MasterConfirmationAnnexTypeEnum assignOutput(MasterConfirmationAnnexTypeEnum masterConfirmationAnnexTypeEnum, DataDocument fpmlDataDocument) {
			masterConfirmationAnnexTypeEnum = null;
			
			return masterConfirmationAnnexTypeEnum;
		}
	}
}
