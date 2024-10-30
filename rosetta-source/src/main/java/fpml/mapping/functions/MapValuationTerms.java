package fpml.mapping.functions;

import cdm.product.asset.ValuationTerms;
import cdm.product.asset.ValuationTerms.ValuationTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapValuationTerms.MapValuationTermsDefault.class)
public abstract class MapValuationTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableRelativeOrPeriodicDates mapAdjustableRelativeOrPeriodicDates;

	/**
	* @param fpmlDataDocument 
	* @return valuationTerms 
	*/
	public ValuationTerms evaluate(DataDocument fpmlDataDocument) {
		ValuationTerms.ValuationTermsBuilder valuationTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final ValuationTerms valuationTerms;
		if (valuationTermsBuilder == null) {
			valuationTerms = null;
		} else {
			valuationTerms = valuationTermsBuilder.build();
			objectValidator.validate(ValuationTerms.class, valuationTerms);
		}
		
		return valuationTerms;
	}

	protected abstract ValuationTerms.ValuationTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapValuationTermsDefault extends MapValuationTerms {
		@Override
		protected ValuationTerms.ValuationTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ValuationTerms.ValuationTermsBuilder valuationTerms = ValuationTerms.builder();
			return assignOutput(valuationTerms, fpmlDataDocument);
		}
		
		protected ValuationTerms.ValuationTermsBuilder assignOutput(ValuationTerms.ValuationTermsBuilder valuationTerms, DataDocument fpmlDataDocument) {
			valuationTerms = toBuilder(ValuationTerms.builder()
				.setFuturesPriceValuation(null)
				.setOptionsPriceValuation(null)
				.setNumberOfValuationDates(null)
				.setDividendValuationDates(mapAdjustableRelativeOrPeriodicDates.evaluate(fpmlDataDocument))
				.setFPVFinalPriceElectionFallback(null)
				.setMultipleExchangeIndexAnnexFallback(null)
				.setComponentSecurityIndexAnnexFallback(null)
				.build());
			
			return Optional.ofNullable(valuationTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
