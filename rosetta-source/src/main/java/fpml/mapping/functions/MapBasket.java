package fpml.mapping.functions;

import cdm.observable.asset.Basket;
import cdm.observable.asset.Basket.BasketBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBasket.MapBasketDefault.class)
public abstract class MapBasket implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapBasketConstituentList mapBasketConstituentList;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLegalEntityList mapLegalEntityList;
	@Inject protected MapTaxonomyList mapTaxonomyList;

	/**
	* @param fpmlDataDocument 
	* @return basket 
	*/
	public Basket evaluate(DataDocument fpmlDataDocument) {
		Basket.BasketBuilder basketBuilder = doEvaluate(fpmlDataDocument);
		
		final Basket basket;
		if (basketBuilder == null) {
			basket = null;
		} else {
			basket = basketBuilder.build();
			objectValidator.validate(Basket.class, basket);
		}
		
		return basket;
	}

	protected abstract Basket.BasketBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBasketDefault extends MapBasket {
		@Override
		protected Basket.BasketBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Basket.BasketBuilder basket = Basket.builder();
			return assignOutput(basket, fpmlDataDocument);
		}
		
		protected Basket.BasketBuilder assignOutput(Basket.BasketBuilder basket, DataDocument fpmlDataDocument) {
			basket = toBuilder(Basket.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setTaxonomy(new ArrayList(mapTaxonomyList.evaluate(fpmlDataDocument)))
				.setIsExchangeListed(null)
				.setExchange(mapLegalEntity.evaluate(fpmlDataDocument))
				.setRelatedExchange(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.setBasketConstituentValue(new ArrayList(mapBasketConstituentList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(basket)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
