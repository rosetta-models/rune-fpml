package fpml.mapping.functions;

import cdm.product.asset.VarianceReturnTerms;
import cdm.product.asset.VarianceReturnTerms.VarianceReturnTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVarianceReturnTerms.MapVarianceReturnTermsDefault.class)
public abstract class MapVarianceReturnTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDividendApplicability mapDividendApplicability;
	@Inject protected MapEquityUnderlierProvisions mapEquityUnderlierProvisions;
	@Inject protected MapNonNegativeQuantitySchedule mapNonNegativeQuantitySchedule;
	@Inject protected MapObservable mapObservable;
	@Inject protected MapPrice mapPrice;
	@Inject protected MapValuationTerms mapValuationTerms;
	@Inject protected MapVarianceCapFloor mapVarianceCapFloor;
	@Inject protected MapVolatilityCapFloor mapVolatilityCapFloor;

	/**
	* @param fpmlDataDocument 
	* @return varianceReturnTerms 
	*/
	public VarianceReturnTerms evaluate(DataDocument fpmlDataDocument) {
		VarianceReturnTerms.VarianceReturnTermsBuilder varianceReturnTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final VarianceReturnTerms varianceReturnTerms;
		if (varianceReturnTermsBuilder == null) {
			varianceReturnTerms = null;
		} else {
			varianceReturnTerms = varianceReturnTermsBuilder.build();
			objectValidator.validate(VarianceReturnTerms.class, varianceReturnTerms);
		}
		
		return varianceReturnTerms;
	}

	protected abstract VarianceReturnTerms.VarianceReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapVarianceReturnTermsDefault extends MapVarianceReturnTerms {
		@Override
		protected VarianceReturnTerms.VarianceReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			VarianceReturnTerms.VarianceReturnTermsBuilder varianceReturnTerms = VarianceReturnTerms.builder();
			return assignOutput(varianceReturnTerms, fpmlDataDocument);
		}
		
		protected VarianceReturnTerms.VarianceReturnTermsBuilder assignOutput(VarianceReturnTerms.VarianceReturnTermsBuilder varianceReturnTerms, DataDocument fpmlDataDocument) {
			varianceReturnTerms = toBuilder(VarianceReturnTerms.builder()
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
				.setVarianceStrikePrice(mapPrice.evaluate(fpmlDataDocument))
				.setVolatilityStrikePrice(mapPrice.evaluate(fpmlDataDocument))
				.setVarianceCapFloor(mapVarianceCapFloor.evaluate(fpmlDataDocument))
				.setVolatilityCapFloor(mapVolatilityCapFloor.evaluate(fpmlDataDocument))
				.setVegaNotionalAmount(mapNonNegativeQuantitySchedule.evaluate(fpmlDataDocument))
				.setExchangeTradedContractNearestValue(mapObservable.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(varianceReturnTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
