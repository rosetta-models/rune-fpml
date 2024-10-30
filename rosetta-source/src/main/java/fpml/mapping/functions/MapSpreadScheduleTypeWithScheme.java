package fpml.mapping.functions;

import cdm.product.asset.SpreadScheduleTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapSpreadScheduleTypeWithScheme.MapSpreadScheduleTypeWithSchemeDefault.class)
public abstract class MapSpreadScheduleTypeWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return spreadScheduleTypeEnum 
	*/
	public SpreadScheduleTypeEnum evaluate(DataDocument fpmlDataDocument) {
		SpreadScheduleTypeEnum spreadScheduleTypeEnum = doEvaluate(fpmlDataDocument);
		
		return spreadScheduleTypeEnum;
	}

	protected abstract SpreadScheduleTypeEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSpreadScheduleTypeWithSchemeDefault extends MapSpreadScheduleTypeWithScheme {
		@Override
		protected SpreadScheduleTypeEnum doEvaluate(DataDocument fpmlDataDocument) {
			SpreadScheduleTypeEnum spreadScheduleTypeEnum = null;
			return assignOutput(spreadScheduleTypeEnum, fpmlDataDocument);
		}
		
		protected SpreadScheduleTypeEnum assignOutput(SpreadScheduleTypeEnum spreadScheduleTypeEnum, DataDocument fpmlDataDocument) {
			spreadScheduleTypeEnum = null;
			
			return spreadScheduleTypeEnum;
		}
	}
}
