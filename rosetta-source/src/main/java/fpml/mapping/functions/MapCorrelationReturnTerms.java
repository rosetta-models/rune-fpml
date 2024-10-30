package fpml.mapping.functions;

import cdm.product.asset.CorrelationReturnTerms;
import cdm.product.asset.CorrelationReturnTerms.CorrelationReturnTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCorrelationReturnTerms.MapCorrelationReturnTermsDefault.class)
public abstract class MapCorrelationReturnTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDividendApplicability mapDividendApplicability;
	@Inject protected MapEquityUnderlierProvisions mapEquityUnderlierProvisions;
	@Inject protected MapNumberRange mapNumberRange;
	@Inject protected MapPrice mapPrice;
	@Inject protected MapValuationTerms mapValuationTerms;

	/**
	* @param fpmlDataDocument 
	* @return correlationReturnTerms 
	*/
	public CorrelationReturnTerms evaluate(DataDocument fpmlDataDocument) {
		CorrelationReturnTerms.CorrelationReturnTermsBuilder correlationReturnTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final CorrelationReturnTerms correlationReturnTerms;
		if (correlationReturnTermsBuilder == null) {
			correlationReturnTerms = null;
		} else {
			correlationReturnTerms = correlationReturnTermsBuilder.build();
			objectValidator.validate(CorrelationReturnTerms.class, correlationReturnTerms);
		}
		
		return correlationReturnTerms;
	}

	protected abstract CorrelationReturnTerms.CorrelationReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCorrelationReturnTermsDefault extends MapCorrelationReturnTerms {
		@Override
		protected CorrelationReturnTerms.CorrelationReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CorrelationReturnTerms.CorrelationReturnTermsBuilder correlationReturnTerms = CorrelationReturnTerms.builder();
			return assignOutput(correlationReturnTerms, fpmlDataDocument);
		}
		
		protected CorrelationReturnTerms.CorrelationReturnTermsBuilder assignOutput(CorrelationReturnTerms.CorrelationReturnTermsBuilder correlationReturnTerms, DataDocument fpmlDataDocument) {
			correlationReturnTerms = toBuilder(CorrelationReturnTerms.builder()
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
				.setCorrelationStrikePrice(mapPrice.evaluate(fpmlDataDocument))
				.setBoundedCorrelation(mapNumberRange.evaluate(fpmlDataDocument))
				.setNumberOfDataSeries(null)
				.build());
			
			return Optional.ofNullable(correlationReturnTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
