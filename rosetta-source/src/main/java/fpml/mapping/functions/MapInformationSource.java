package fpml.mapping.functions;

import cdm.observable.asset.InformationSource;
import cdm.observable.asset.InformationSource.InformationSourceBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInformationSource.MapInformationSourceDefault.class)
public abstract class MapInformationSource implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapSourcePageWithScheme mapSourcePageWithScheme;
	@Inject protected MapSourceProviderWithScheme mapSourceProviderWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return informationSource 
	*/
	public InformationSource evaluate(DataDocument fpmlDataDocument) {
		InformationSource.InformationSourceBuilder informationSourceBuilder = doEvaluate(fpmlDataDocument);
		
		final InformationSource informationSource;
		if (informationSourceBuilder == null) {
			informationSource = null;
		} else {
			informationSource = informationSourceBuilder.build();
			objectValidator.validate(InformationSource.class, informationSource);
		}
		
		return informationSource;
	}

	protected abstract InformationSource.InformationSourceBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapInformationSourceDefault extends MapInformationSource {
		@Override
		protected InformationSource.InformationSourceBuilder doEvaluate(DataDocument fpmlDataDocument) {
			InformationSource.InformationSourceBuilder informationSource = InformationSource.builder();
			return assignOutput(informationSource, fpmlDataDocument);
		}
		
		protected InformationSource.InformationSourceBuilder assignOutput(InformationSource.InformationSourceBuilder informationSource, DataDocument fpmlDataDocument) {
			informationSource = toBuilder(InformationSource.builder()
				.setSourceProviderValue(mapSourceProviderWithScheme.evaluate(fpmlDataDocument))
				.setSourcePageValue(mapSourcePageWithScheme.evaluate(fpmlDataDocument))
				.setSourcePageHeading(null)
				.build());
			
			return Optional.ofNullable(informationSource)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
