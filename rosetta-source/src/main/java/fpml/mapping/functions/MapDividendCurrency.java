package fpml.mapping.functions;

import cdm.product.asset.DividendCurrency;
import cdm.product.asset.DividendCurrency.DividendCurrencyBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendCurrency.MapDividendCurrencyDefault.class)
public abstract class MapDividendCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrencyWithScheme mapCurrencyWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return dividendCurrency 
	*/
	public DividendCurrency evaluate(DataDocument fpmlDataDocument) {
		DividendCurrency.DividendCurrencyBuilder dividendCurrencyBuilder = doEvaluate(fpmlDataDocument);
		
		final DividendCurrency dividendCurrency;
		if (dividendCurrencyBuilder == null) {
			dividendCurrency = null;
		} else {
			dividendCurrency = dividendCurrencyBuilder.build();
			objectValidator.validate(DividendCurrency.class, dividendCurrency);
		}
		
		return dividendCurrency;
	}

	protected abstract DividendCurrency.DividendCurrencyBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDividendCurrencyDefault extends MapDividendCurrency {
		@Override
		protected DividendCurrency.DividendCurrencyBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DividendCurrency.DividendCurrencyBuilder dividendCurrency = DividendCurrency.builder();
			return assignOutput(dividendCurrency, fpmlDataDocument);
		}
		
		protected DividendCurrency.DividendCurrencyBuilder assignOutput(DividendCurrency.DividendCurrencyBuilder dividendCurrency, DataDocument fpmlDataDocument) {
			dividendCurrency = toBuilder(DividendCurrency.builder()
				.setCurrencyValue(mapCurrencyWithScheme.evaluate(fpmlDataDocument))
				.setDeterminationMethod(null)
				.setCurrencyReferenceValue(null)
				.build());
			
			return Optional.ofNullable(dividendCurrency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
