package fpml.mapping.functions;

import cdm.base.staticdata.asset.credit.NotDomesticCurrency;
import cdm.base.staticdata.asset.credit.NotDomesticCurrency.NotDomesticCurrencyBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapNotDomesticCurrency.MapNotDomesticCurrencyDefault.class)
public abstract class MapNotDomesticCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrencyWithScheme mapCurrencyWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return notDomesticCurrency 
	*/
	public NotDomesticCurrency evaluate(DataDocument fpmlDataDocument) {
		NotDomesticCurrency.NotDomesticCurrencyBuilder notDomesticCurrencyBuilder = doEvaluate(fpmlDataDocument);
		
		final NotDomesticCurrency notDomesticCurrency;
		if (notDomesticCurrencyBuilder == null) {
			notDomesticCurrency = null;
		} else {
			notDomesticCurrency = notDomesticCurrencyBuilder.build();
			objectValidator.validate(NotDomesticCurrency.class, notDomesticCurrency);
		}
		
		return notDomesticCurrency;
	}

	protected abstract NotDomesticCurrency.NotDomesticCurrencyBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapNotDomesticCurrencyDefault extends MapNotDomesticCurrency {
		@Override
		protected NotDomesticCurrency.NotDomesticCurrencyBuilder doEvaluate(DataDocument fpmlDataDocument) {
			NotDomesticCurrency.NotDomesticCurrencyBuilder notDomesticCurrency = NotDomesticCurrency.builder();
			return assignOutput(notDomesticCurrency, fpmlDataDocument);
		}
		
		protected NotDomesticCurrency.NotDomesticCurrencyBuilder assignOutput(NotDomesticCurrency.NotDomesticCurrencyBuilder notDomesticCurrency, DataDocument fpmlDataDocument) {
			notDomesticCurrency = toBuilder(NotDomesticCurrency.builder()
				.setApplicable(null)
				.setCurrencyValue(mapCurrencyWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(notDomesticCurrency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
