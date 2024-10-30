package fpml.mapping.functions;

import cdm.observable.asset.QuotedCurrencyPair;
import cdm.observable.asset.QuotedCurrencyPair.QuotedCurrencyPairBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapQuotedCurrencyPair.MapQuotedCurrencyPairDefault.class)
public abstract class MapQuotedCurrencyPair implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency1WithScheme mapCurrency1WithScheme;
	@Inject protected MapCurrency2WithScheme mapCurrency2WithScheme;

	/**
	* @param fpmlDataDocument 
	* @return quotedCurrencyPair 
	*/
	public QuotedCurrencyPair evaluate(DataDocument fpmlDataDocument) {
		QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPairBuilder = doEvaluate(fpmlDataDocument);
		
		final QuotedCurrencyPair quotedCurrencyPair;
		if (quotedCurrencyPairBuilder == null) {
			quotedCurrencyPair = null;
		} else {
			quotedCurrencyPair = quotedCurrencyPairBuilder.build();
			objectValidator.validate(QuotedCurrencyPair.class, quotedCurrencyPair);
		}
		
		return quotedCurrencyPair;
	}

	protected abstract QuotedCurrencyPair.QuotedCurrencyPairBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapQuotedCurrencyPairDefault extends MapQuotedCurrencyPair {
		@Override
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder doEvaluate(DataDocument fpmlDataDocument) {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair = QuotedCurrencyPair.builder();
			return assignOutput(quotedCurrencyPair, fpmlDataDocument);
		}
		
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder assignOutput(QuotedCurrencyPair.QuotedCurrencyPairBuilder quotedCurrencyPair, DataDocument fpmlDataDocument) {
			quotedCurrencyPair = toBuilder(QuotedCurrencyPair.builder()
				.setCurrency1Value(mapCurrency1WithScheme.evaluate(fpmlDataDocument))
				.setCurrency2Value(mapCurrency2WithScheme.evaluate(fpmlDataDocument))
				.setQuoteBasis(null)
				.build());
			
			return Optional.ofNullable(quotedCurrencyPair)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
