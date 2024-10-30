package fpml.mapping.functions;

import cdm.legaldocumentation.master.FxAdditionalTerms;
import cdm.legaldocumentation.master.FxAdditionalTerms.FxAdditionalTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxAdditionalTerms.MapFxAdditionalTermsDefault.class)
public abstract class MapFxAdditionalTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return fxAdditionalTerms 
	*/
	public FxAdditionalTerms evaluate(DataDocument fpmlDataDocument) {
		FxAdditionalTerms.FxAdditionalTermsBuilder fxAdditionalTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final FxAdditionalTerms fxAdditionalTerms;
		if (fxAdditionalTermsBuilder == null) {
			fxAdditionalTerms = null;
		} else {
			fxAdditionalTerms = fxAdditionalTermsBuilder.build();
			objectValidator.validate(FxAdditionalTerms.class, fxAdditionalTerms);
		}
		
		return fxAdditionalTerms;
	}

	protected abstract FxAdditionalTerms.FxAdditionalTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFxAdditionalTermsDefault extends MapFxAdditionalTerms {
		@Override
		protected FxAdditionalTerms.FxAdditionalTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FxAdditionalTerms.FxAdditionalTermsBuilder fxAdditionalTerms = FxAdditionalTerms.builder();
			return assignOutput(fxAdditionalTerms, fpmlDataDocument);
		}
		
		protected FxAdditionalTerms.FxAdditionalTermsBuilder assignOutput(FxAdditionalTerms.FxAdditionalTermsBuilder fxAdditionalTerms, DataDocument fpmlDataDocument) {
			fxAdditionalTerms = toBuilder(FxAdditionalTerms.builder()
				.build());
			
			return Optional.ofNullable(fxAdditionalTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
