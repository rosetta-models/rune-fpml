package fpml.mapping.functions;

import cdm.product.asset.DividendReturnTerms;
import cdm.product.asset.DividendReturnTerms.DividendReturnTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendReturnTerms.MapDividendReturnTermsDefault.class)
public abstract class MapDividendReturnTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDividendCurrency mapDividendCurrency;
	@Inject protected MapDividendPayoutRatioList mapDividendPayoutRatioList;
	@Inject protected MapDividendPeriodList mapDividendPeriodList;

	/**
	* @param fpmlDataDocument 
	* @return dividendReturnTerms 
	*/
	public DividendReturnTerms evaluate(DataDocument fpmlDataDocument) {
		DividendReturnTerms.DividendReturnTermsBuilder dividendReturnTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final DividendReturnTerms dividendReturnTerms;
		if (dividendReturnTermsBuilder == null) {
			dividendReturnTerms = null;
		} else {
			dividendReturnTerms = dividendReturnTermsBuilder.build();
			objectValidator.validate(DividendReturnTerms.class, dividendReturnTerms);
		}
		
		return dividendReturnTerms;
	}

	protected abstract DividendReturnTerms.DividendReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDividendReturnTermsDefault extends MapDividendReturnTerms {
		@Override
		protected DividendReturnTerms.DividendReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DividendReturnTerms.DividendReturnTermsBuilder dividendReturnTerms = DividendReturnTerms.builder();
			return assignOutput(dividendReturnTerms, fpmlDataDocument);
		}
		
		protected DividendReturnTerms.DividendReturnTermsBuilder assignOutput(DividendReturnTerms.DividendReturnTermsBuilder dividendReturnTerms, DataDocument fpmlDataDocument) {
			dividendReturnTerms = toBuilder(DividendReturnTerms.builder()
				.setDividendPayoutRatio(new ArrayList(mapDividendPayoutRatioList.evaluate(fpmlDataDocument)))
				.setDividendReinvestment(null)
				.setDividendEntitlement(null)
				.setDividendAmountType(null)
				.setPerformance(null)
				.setFirstOrSecondPeriod(null)
				.setExtraordinaryDividendsParty(null)
				.setExcessDividendAmount(null)
				.setDividendCurrency(mapDividendCurrency.evaluate(fpmlDataDocument))
				.setNonCashDividendTreatment(null)
				.setDividendComposition(null)
				.setSpecialDividends(null)
				.setMaterialDividend(null)
				.setDividendPeriod(new ArrayList(mapDividendPeriodList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(dividendReturnTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
