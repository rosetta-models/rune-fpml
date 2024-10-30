package fpml.mapping.functions;

import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPrice.MapPriceDefault.class)
public abstract class MapPrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashPrice mapCashPrice;
	@Inject protected MapDatedValueList mapDatedValueList;
	@Inject protected MapPriceComposite mapPriceComposite;
	@Inject protected MapUnitType mapUnitType;

	/**
	* @param fpmlDataDocument 
	* @return price 
	*/
	public Price evaluate(DataDocument fpmlDataDocument) {
		Price.PriceBuilder priceBuilder = doEvaluate(fpmlDataDocument);
		
		final Price price;
		if (priceBuilder == null) {
			price = null;
		} else {
			price = priceBuilder.build();
			objectValidator.validate(Price.class, price);
		}
		
		return price;
	}

	protected abstract Price.PriceBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPriceDefault extends MapPrice {
		@Override
		protected Price.PriceBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Price.PriceBuilder price = Price.builder();
			return assignOutput(price, fpmlDataDocument);
		}
		
		protected Price.PriceBuilder assignOutput(Price.PriceBuilder price, DataDocument fpmlDataDocument) {
			price = toBuilder(Price.builder()
				.setValue(null)
				.setUnit(mapUnitType.evaluate(fpmlDataDocument))
				.setDatedValue(new ArrayList(mapDatedValueList.evaluate(fpmlDataDocument)))
				.setPerUnitOf(mapUnitType.evaluate(fpmlDataDocument))
				.setPriceType(null)
				.setPriceExpression(null)
				.setComposite(mapPriceComposite.evaluate(fpmlDataDocument))
				.setArithmeticOperator(null)
				.setCashPrice(mapCashPrice.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(price)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
