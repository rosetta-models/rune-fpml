package fpml.mapping.functions;

import cdm.observable.asset.InformationProviderEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapSourceProviderWithScheme.MapSourceProviderWithSchemeDefault.class)
public abstract class MapSourceProviderWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return informationProviderEnum 
	*/
	public InformationProviderEnum evaluate(DataDocument fpmlDataDocument) {
		InformationProviderEnum informationProviderEnum = doEvaluate(fpmlDataDocument);
		
		return informationProviderEnum;
	}

	protected abstract InformationProviderEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSourceProviderWithSchemeDefault extends MapSourceProviderWithScheme {
		@Override
		protected InformationProviderEnum doEvaluate(DataDocument fpmlDataDocument) {
			InformationProviderEnum informationProviderEnum = null;
			return assignOutput(informationProviderEnum, fpmlDataDocument);
		}
		
		protected InformationProviderEnum assignOutput(InformationProviderEnum informationProviderEnum, DataDocument fpmlDataDocument) {
			informationProviderEnum = null;
			
			return informationProviderEnum;
		}
	}
}
