package fpml.mapping.functions;

import cdm.observable.asset.ValuationMethod;
import cdm.observable.asset.ValuationMethod.ValuationMethodBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapValuationMethod.MapValuationMethodDefault.class)
public abstract class MapValuationMethod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashCollateralValuationMethod mapCashCollateralValuationMethod;
	@Inject protected MapMoney mapMoney;
	@Inject protected MapValuationSource mapValuationSource;

	/**
	* @param fpmlDataDocument 
	* @return valuationMethod 
	*/
	public ValuationMethod evaluate(DataDocument fpmlDataDocument) {
		ValuationMethod.ValuationMethodBuilder valuationMethodBuilder = doEvaluate(fpmlDataDocument);
		
		final ValuationMethod valuationMethod;
		if (valuationMethodBuilder == null) {
			valuationMethod = null;
		} else {
			valuationMethod = valuationMethodBuilder.build();
			objectValidator.validate(ValuationMethod.class, valuationMethod);
		}
		
		return valuationMethod;
	}

	protected abstract ValuationMethod.ValuationMethodBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapValuationMethodDefault extends MapValuationMethod {
		@Override
		protected ValuationMethod.ValuationMethodBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ValuationMethod.ValuationMethodBuilder valuationMethod = ValuationMethod.builder();
			return assignOutput(valuationMethod, fpmlDataDocument);
		}
		
		protected ValuationMethod.ValuationMethodBuilder assignOutput(ValuationMethod.ValuationMethodBuilder valuationMethod, DataDocument fpmlDataDocument) {
			valuationMethod = toBuilder(ValuationMethod.builder()
				.setValuationSource(mapValuationSource.evaluate(fpmlDataDocument))
				.setQuotationMethod(null)
				.setValuationMethod(null)
				.setQuotationAmount(mapMoney.evaluate(fpmlDataDocument))
				.setMinimumQuotationAmount(mapMoney.evaluate(fpmlDataDocument))
				.setCashCollateralValuationMethod(mapCashCollateralValuationMethod.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(valuationMethod)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
