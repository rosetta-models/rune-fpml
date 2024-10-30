package fpml.mapping.functions;

import cdm.base.staticdata.party.EntityTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapEntityTypeWithScheme.MapEntityTypeWithSchemeDefault.class)
public abstract class MapEntityTypeWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return entityTypeEnum 
	*/
	public EntityTypeEnum evaluate(DataDocument fpmlDataDocument) {
		EntityTypeEnum entityTypeEnum = doEvaluate(fpmlDataDocument);
		
		return entityTypeEnum;
	}

	protected abstract EntityTypeEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapEntityTypeWithSchemeDefault extends MapEntityTypeWithScheme {
		@Override
		protected EntityTypeEnum doEvaluate(DataDocument fpmlDataDocument) {
			EntityTypeEnum entityTypeEnum = null;
			return assignOutput(entityTypeEnum, fpmlDataDocument);
		}
		
		protected EntityTypeEnum assignOutput(EntityTypeEnum entityTypeEnum, DataDocument fpmlDataDocument) {
			entityTypeEnum = null;
			
			return entityTypeEnum;
		}
	}
}
