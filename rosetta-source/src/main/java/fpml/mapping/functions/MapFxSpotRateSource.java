package fpml.mapping.functions;

import cdm.observable.asset.FxSpotRateSource;
import cdm.observable.asset.FxSpotRateSource.FxSpotRateSourceBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxSpotRateSource.MapFxSpotRateSourceDefault.class)
public abstract class MapFxSpotRateSource implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapInformationSource mapInformationSource;

	/**
	* @param fpmlDataDocument 
	* @return fxSpotRateSource 
	*/
	public FxSpotRateSource evaluate(DataDocument fpmlDataDocument) {
		FxSpotRateSource.FxSpotRateSourceBuilder fxSpotRateSourceBuilder = doEvaluate(fpmlDataDocument);
		
		final FxSpotRateSource fxSpotRateSource;
		if (fxSpotRateSourceBuilder == null) {
			fxSpotRateSource = null;
		} else {
			fxSpotRateSource = fxSpotRateSourceBuilder.build();
			objectValidator.validate(FxSpotRateSource.class, fxSpotRateSource);
		}
		
		return fxSpotRateSource;
	}

	protected abstract FxSpotRateSource.FxSpotRateSourceBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFxSpotRateSourceDefault extends MapFxSpotRateSource {
		@Override
		protected FxSpotRateSource.FxSpotRateSourceBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FxSpotRateSource.FxSpotRateSourceBuilder fxSpotRateSource = FxSpotRateSource.builder();
			return assignOutput(fxSpotRateSource, fpmlDataDocument);
		}
		
		protected FxSpotRateSource.FxSpotRateSourceBuilder assignOutput(FxSpotRateSource.FxSpotRateSourceBuilder fxSpotRateSource, DataDocument fpmlDataDocument) {
			fxSpotRateSource = toBuilder(FxSpotRateSource.builder()
				.setPrimarySource(mapInformationSource.evaluate(fpmlDataDocument))
				.setSecondarySource(mapInformationSource.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(fxSpotRateSource)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
