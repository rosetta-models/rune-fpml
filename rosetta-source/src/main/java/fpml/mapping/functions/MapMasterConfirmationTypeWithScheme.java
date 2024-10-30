package fpml.mapping.functions;

import cdm.legaldocumentation.master.MasterConfirmationTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapMasterConfirmationTypeWithScheme.MapMasterConfirmationTypeWithSchemeDefault.class)
public abstract class MapMasterConfirmationTypeWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return masterConfirmationTypeEnum 
	*/
	public MasterConfirmationTypeEnum evaluate(DataDocument fpmlDataDocument) {
		MasterConfirmationTypeEnum masterConfirmationTypeEnum = doEvaluate(fpmlDataDocument);
		
		return masterConfirmationTypeEnum;
	}

	protected abstract MasterConfirmationTypeEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMasterConfirmationTypeWithSchemeDefault extends MapMasterConfirmationTypeWithScheme {
		@Override
		protected MasterConfirmationTypeEnum doEvaluate(DataDocument fpmlDataDocument) {
			MasterConfirmationTypeEnum masterConfirmationTypeEnum = null;
			return assignOutput(masterConfirmationTypeEnum, fpmlDataDocument);
		}
		
		protected MasterConfirmationTypeEnum assignOutput(MasterConfirmationTypeEnum masterConfirmationTypeEnum, DataDocument fpmlDataDocument) {
			masterConfirmationTypeEnum = null;
			
			return masterConfirmationTypeEnum;
		}
	}
}
