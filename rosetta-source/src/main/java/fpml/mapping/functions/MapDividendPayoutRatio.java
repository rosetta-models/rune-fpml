package fpml.mapping.functions;

import cdm.product.asset.DividendPayoutRatio;
import cdm.product.asset.DividendPayoutRatio.DividendPayoutRatioBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendPayoutRatio.MapDividendPayoutRatioDefault.class)
public abstract class MapDividendPayoutRatio implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBasketConstituent mapBasketConstituent;

	/**
	* @param fpmlDataDocument 
	* @return dividendPayoutRatio 
	*/
	public DividendPayoutRatio evaluate(DataDocument fpmlDataDocument) {
		DividendPayoutRatio.DividendPayoutRatioBuilder dividendPayoutRatioBuilder = doEvaluate(fpmlDataDocument);
		
		final DividendPayoutRatio dividendPayoutRatio;
		if (dividendPayoutRatioBuilder == null) {
			dividendPayoutRatio = null;
		} else {
			dividendPayoutRatio = dividendPayoutRatioBuilder.build();
			objectValidator.validate(DividendPayoutRatio.class, dividendPayoutRatio);
		}
		
		return dividendPayoutRatio;
	}

	protected abstract DividendPayoutRatio.DividendPayoutRatioBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDividendPayoutRatioDefault extends MapDividendPayoutRatio {
		@Override
		protected DividendPayoutRatio.DividendPayoutRatioBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DividendPayoutRatio.DividendPayoutRatioBuilder dividendPayoutRatio = DividendPayoutRatio.builder();
			return assignOutput(dividendPayoutRatio, fpmlDataDocument);
		}
		
		protected DividendPayoutRatio.DividendPayoutRatioBuilder assignOutput(DividendPayoutRatio.DividendPayoutRatioBuilder dividendPayoutRatio, DataDocument fpmlDataDocument) {
			dividendPayoutRatio = toBuilder(DividendPayoutRatio.builder()
				.setTotalRatio(null)
				.setCashRatio(null)
				.setNonCashRatio(null)
				.setBasketConstituentValue(mapBasketConstituent.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(dividendPayoutRatio)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
