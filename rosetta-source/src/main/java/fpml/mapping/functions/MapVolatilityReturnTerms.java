package fpml.mapping.functions;

import cdm.product.asset.VolatilityReturnTerms;
import cdm.product.asset.VolatilityReturnTerms.VolatilityReturnTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVolatilityReturnTerms.MapVolatilityReturnTermsDefault.class)
public abstract class MapVolatilityReturnTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDividendApplicability mapDividendApplicability;
	@Inject protected MapEquityUnderlierProvisions mapEquityUnderlierProvisions;
	@Inject protected MapListedDerivative mapListedDerivative;
	@Inject protected MapPrice mapPrice;
	@Inject protected MapValuationTerms mapValuationTerms;
	@Inject protected MapVolatilityCapFloor mapVolatilityCapFloor;

	/**
	* @param fpmlDataDocument 
	* @return volatilityReturnTerms 
	*/
	public VolatilityReturnTerms evaluate(DataDocument fpmlDataDocument) {
		VolatilityReturnTerms.VolatilityReturnTermsBuilder volatilityReturnTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final VolatilityReturnTerms volatilityReturnTerms;
		if (volatilityReturnTermsBuilder == null) {
			volatilityReturnTerms = null;
		} else {
			volatilityReturnTerms = volatilityReturnTermsBuilder.build();
			objectValidator.validate(VolatilityReturnTerms.class, volatilityReturnTerms);
		}
		
		return volatilityReturnTerms;
	}

	protected abstract VolatilityReturnTerms.VolatilityReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapVolatilityReturnTermsDefault extends MapVolatilityReturnTerms {
		@Override
		protected VolatilityReturnTerms.VolatilityReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			VolatilityReturnTerms.VolatilityReturnTermsBuilder volatilityReturnTerms = VolatilityReturnTerms.builder();
			return assignOutput(volatilityReturnTerms, fpmlDataDocument);
		}
		
		protected VolatilityReturnTerms.VolatilityReturnTermsBuilder assignOutput(VolatilityReturnTerms.VolatilityReturnTermsBuilder volatilityReturnTerms, DataDocument fpmlDataDocument) {
			volatilityReturnTerms = toBuilder(VolatilityReturnTerms.builder()
				.setValuationTerms(mapValuationTerms.evaluate(fpmlDataDocument))
				.setAnnualizationFactor(null)
				.setDividendApplicability(mapDividendApplicability.evaluate(fpmlDataDocument))
				.setEquityUnderlierProvisions(mapEquityUnderlierProvisions.evaluate(fpmlDataDocument))
				.setSharePriceDividendAdjustment(null)
				.setExpectedN(null)
				.setInitialLevel(null)
				.setInitialLevelSource(null)
				.setMeanAdjustment(null)
				.setPerformance(null)
				.setVolatilityStrikePrice(mapPrice.evaluate(fpmlDataDocument))
				.setVolatilityCapFloor(mapVolatilityCapFloor.evaluate(fpmlDataDocument))
				.setExchangeTradedContractNearest(mapListedDerivative.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(volatilityReturnTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
