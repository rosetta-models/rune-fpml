package fpml.mapping.functions;

import cdm.observable.asset.CashPrice;
import cdm.observable.asset.CashPrice.CashPriceBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCashPrice.MapCashPriceDefault.class)
public abstract class MapCashPrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPremiumExpression mapPremiumExpression;

	/**
	* @param fpmlDataDocument 
	* @return cashPrice 
	*/
	public CashPrice evaluate(DataDocument fpmlDataDocument) {
		CashPrice.CashPriceBuilder cashPriceBuilder = doEvaluate(fpmlDataDocument);
		
		final CashPrice cashPrice;
		if (cashPriceBuilder == null) {
			cashPrice = null;
		} else {
			cashPrice = cashPriceBuilder.build();
			objectValidator.validate(CashPrice.class, cashPrice);
		}
		
		return cashPrice;
	}

	protected abstract CashPrice.CashPriceBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCashPriceDefault extends MapCashPrice {
		@Override
		protected CashPrice.CashPriceBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CashPrice.CashPriceBuilder cashPrice = CashPrice.builder();
			return assignOutput(cashPrice, fpmlDataDocument);
		}
		
		protected CashPrice.CashPriceBuilder assignOutput(CashPrice.CashPriceBuilder cashPrice, DataDocument fpmlDataDocument) {
			cashPrice = toBuilder(CashPrice.builder()
				.setCashPriceType(null)
				.setPremiumExpression(mapPremiumExpression.evaluate(fpmlDataDocument))
				.setFeeType(null)
				.build());
			
			return Optional.ofNullable(cashPrice)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
