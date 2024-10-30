package fpml.mapping.functions;

import cdm.base.staticdata.asset.credit.SpecifiedCurrency;
import cdm.base.staticdata.asset.credit.SpecifiedCurrency.SpecifiedCurrencyBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSpecifiedCurrency.MapSpecifiedCurrencyDefault.class)
public abstract class MapSpecifiedCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrencyWithScheme mapCurrencyWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return specifiedCurrency 
	*/
	public SpecifiedCurrency evaluate(DataDocument fpmlDataDocument) {
		SpecifiedCurrency.SpecifiedCurrencyBuilder specifiedCurrencyBuilder = doEvaluate(fpmlDataDocument);
		
		final SpecifiedCurrency specifiedCurrency;
		if (specifiedCurrencyBuilder == null) {
			specifiedCurrency = null;
		} else {
			specifiedCurrency = specifiedCurrencyBuilder.build();
			objectValidator.validate(SpecifiedCurrency.class, specifiedCurrency);
		}
		
		return specifiedCurrency;
	}

	protected abstract SpecifiedCurrency.SpecifiedCurrencyBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSpecifiedCurrencyDefault extends MapSpecifiedCurrency {
		@Override
		protected SpecifiedCurrency.SpecifiedCurrencyBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SpecifiedCurrency.SpecifiedCurrencyBuilder specifiedCurrency = SpecifiedCurrency.builder();
			return assignOutput(specifiedCurrency, fpmlDataDocument);
		}
		
		protected SpecifiedCurrency.SpecifiedCurrencyBuilder assignOutput(SpecifiedCurrency.SpecifiedCurrencyBuilder specifiedCurrency, DataDocument fpmlDataDocument) {
			specifiedCurrency = toBuilder(SpecifiedCurrency.builder()
				.setApplicable(null)
				.setCurrencyValue(mapCurrencyWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(specifiedCurrency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
