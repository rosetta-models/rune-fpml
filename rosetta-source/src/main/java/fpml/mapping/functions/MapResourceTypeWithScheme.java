package fpml.mapping.functions;

import cdm.legaldocumentation.common.ResourceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapResourceTypeWithScheme.MapResourceTypeWithSchemeDefault.class)
public abstract class MapResourceTypeWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return resourceTypeEnum 
	*/
	public ResourceTypeEnum evaluate(DataDocument fpmlDataDocument) {
		ResourceTypeEnum resourceTypeEnum = doEvaluate(fpmlDataDocument);
		
		return resourceTypeEnum;
	}

	protected abstract ResourceTypeEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapResourceTypeWithSchemeDefault extends MapResourceTypeWithScheme {
		@Override
		protected ResourceTypeEnum doEvaluate(DataDocument fpmlDataDocument) {
			ResourceTypeEnum resourceTypeEnum = null;
			return assignOutput(resourceTypeEnum, fpmlDataDocument);
		}
		
		protected ResourceTypeEnum assignOutput(ResourceTypeEnum resourceTypeEnum, DataDocument fpmlDataDocument) {
			resourceTypeEnum = null;
			
			return resourceTypeEnum;
		}
	}
}
