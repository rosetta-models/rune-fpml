package fpml.mapping.functions;

import cdm.product.asset.PriceReturnTerms;
import cdm.product.asset.PriceReturnTerms.PriceReturnTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPriceReturnTerms.MapPriceReturnTermsDefault.class)
public abstract class MapPriceReturnTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return priceReturnTerms 
	*/
	public PriceReturnTerms evaluate(DataDocument fpmlDataDocument) {
		PriceReturnTerms.PriceReturnTermsBuilder priceReturnTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final PriceReturnTerms priceReturnTerms;
		if (priceReturnTermsBuilder == null) {
			priceReturnTerms = null;
		} else {
			priceReturnTerms = priceReturnTermsBuilder.build();
			objectValidator.validate(PriceReturnTerms.class, priceReturnTerms);
		}
		
		return priceReturnTerms;
	}

	protected abstract PriceReturnTerms.PriceReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPriceReturnTermsDefault extends MapPriceReturnTerms {
		@Override
		protected PriceReturnTerms.PriceReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PriceReturnTerms.PriceReturnTermsBuilder priceReturnTerms = PriceReturnTerms.builder();
			return assignOutput(priceReturnTerms, fpmlDataDocument);
		}
		
		protected PriceReturnTerms.PriceReturnTermsBuilder assignOutput(PriceReturnTerms.PriceReturnTermsBuilder priceReturnTerms, DataDocument fpmlDataDocument) {
			priceReturnTerms = toBuilder(PriceReturnTerms.builder()
				.setReturnType(null)
				.setConversionFactor(null)
				.setPerformance(null)
				.build());
			
			return Optional.ofNullable(priceReturnTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
