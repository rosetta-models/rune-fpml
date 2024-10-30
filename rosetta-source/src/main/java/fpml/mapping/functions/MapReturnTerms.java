package fpml.mapping.functions;

import cdm.product.template.ReturnTerms;
import cdm.product.template.ReturnTerms.ReturnTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReturnTerms.MapReturnTermsDefault.class)
public abstract class MapReturnTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCorrelationReturnTerms mapCorrelationReturnTerms;
	@Inject protected MapDividendReturnTerms mapDividendReturnTerms;
	@Inject protected MapPriceReturnTerms mapPriceReturnTerms;
	@Inject protected MapVarianceReturnTerms mapVarianceReturnTerms;
	@Inject protected MapVolatilityReturnTerms mapVolatilityReturnTerms;

	/**
	* @param fpmlDataDocument 
	* @return returnTerms 
	*/
	public ReturnTerms evaluate(DataDocument fpmlDataDocument) {
		ReturnTerms.ReturnTermsBuilder returnTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final ReturnTerms returnTerms;
		if (returnTermsBuilder == null) {
			returnTerms = null;
		} else {
			returnTerms = returnTermsBuilder.build();
			objectValidator.validate(ReturnTerms.class, returnTerms);
		}
		
		return returnTerms;
	}

	protected abstract ReturnTerms.ReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapReturnTermsDefault extends MapReturnTerms {
		@Override
		protected ReturnTerms.ReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ReturnTerms.ReturnTermsBuilder returnTerms = ReturnTerms.builder();
			return assignOutput(returnTerms, fpmlDataDocument);
		}
		
		protected ReturnTerms.ReturnTermsBuilder assignOutput(ReturnTerms.ReturnTermsBuilder returnTerms, DataDocument fpmlDataDocument) {
			returnTerms = toBuilder(ReturnTerms.builder()
				.setPriceReturnTerms(mapPriceReturnTerms.evaluate(fpmlDataDocument))
				.setDividendReturnTerms(mapDividendReturnTerms.evaluate(fpmlDataDocument))
				.setVarianceReturnTerms(mapVarianceReturnTerms.evaluate(fpmlDataDocument))
				.setVolatilityReturnTerms(mapVolatilityReturnTerms.evaluate(fpmlDataDocument))
				.setCorrelationReturnTerms(mapCorrelationReturnTerms.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(returnTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
