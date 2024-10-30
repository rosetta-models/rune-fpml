package fpml.mapping.functions;

import cdm.base.datetime.BusinessCenterEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapBusinessCenterWithScheme.MapBusinessCenterWithSchemeDefault.class)
public abstract class MapBusinessCenterWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return businessCenterEnum 
	*/
	public BusinessCenterEnum evaluate(DataDocument fpmlDataDocument) {
		BusinessCenterEnum businessCenterEnum = doEvaluate(fpmlDataDocument);
		
		return businessCenterEnum;
	}

	protected abstract BusinessCenterEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBusinessCenterWithSchemeDefault extends MapBusinessCenterWithScheme {
		@Override
		protected BusinessCenterEnum doEvaluate(DataDocument fpmlDataDocument) {
			BusinessCenterEnum businessCenterEnum = null;
			return assignOutput(businessCenterEnum, fpmlDataDocument);
		}
		
		protected BusinessCenterEnum assignOutput(BusinessCenterEnum businessCenterEnum, DataDocument fpmlDataDocument) {
			businessCenterEnum = null;
			
			return businessCenterEnum;
		}
	}
}
