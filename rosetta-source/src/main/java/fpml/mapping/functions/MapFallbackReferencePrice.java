package fpml.mapping.functions;

import cdm.observable.asset.FallbackReferencePrice;
import cdm.observable.asset.FallbackReferencePrice.FallbackReferencePriceBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFallbackReferencePrice.MapFallbackReferencePriceDefault.class)
public abstract class MapFallbackReferencePrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationAgent mapCalculationAgent;
	@Inject protected MapFallBackSettlementRateOptionWithSchemeList mapFallBackSettlementRateOptionWithSchemeList;
	@Inject protected MapValuationPostponement mapValuationPostponement;

	/**
	* @param fpmlDataDocument 
	* @return fallbackReferencePrice 
	*/
	public FallbackReferencePrice evaluate(DataDocument fpmlDataDocument) {
		FallbackReferencePrice.FallbackReferencePriceBuilder fallbackReferencePriceBuilder = doEvaluate(fpmlDataDocument);
		
		final FallbackReferencePrice fallbackReferencePrice;
		if (fallbackReferencePriceBuilder == null) {
			fallbackReferencePrice = null;
		} else {
			fallbackReferencePrice = fallbackReferencePriceBuilder.build();
			objectValidator.validate(FallbackReferencePrice.class, fallbackReferencePrice);
		}
		
		return fallbackReferencePrice;
	}

	protected abstract FallbackReferencePrice.FallbackReferencePriceBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFallbackReferencePriceDefault extends MapFallbackReferencePrice {
		@Override
		protected FallbackReferencePrice.FallbackReferencePriceBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FallbackReferencePrice.FallbackReferencePriceBuilder fallbackReferencePrice = FallbackReferencePrice.builder();
			return assignOutput(fallbackReferencePrice, fpmlDataDocument);
		}
		
		protected FallbackReferencePrice.FallbackReferencePriceBuilder assignOutput(FallbackReferencePrice.FallbackReferencePriceBuilder fallbackReferencePrice, DataDocument fpmlDataDocument) {
			fallbackReferencePrice = toBuilder(FallbackReferencePrice.builder()
				.setValuationPostponement(mapValuationPostponement.evaluate(fpmlDataDocument))
				.setFallBackSettlementRateOptionValue(mapFallBackSettlementRateOptionWithSchemeList.evaluate(fpmlDataDocument))
				.setFallbackSurveyValuationPostponement(null)
				.setCalculationAgentDetermination(mapCalculationAgent.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(fallbackReferencePrice)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
