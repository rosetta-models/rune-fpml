package fpml.mapping.functions;

import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.BasketConstituent.BasketConstituentBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBasketConstituent.MapBasketConstituentDefault.class)
public abstract class MapBasketConstituent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAsset mapAsset;
	@Inject protected MapBasket mapBasket;
	@Inject protected MapIndex mapIndex;
	@Inject protected MapNonNegativeQuantityScheduleList mapNonNegativeQuantityScheduleList;
	@Inject protected MapPriceScheduleList mapPriceScheduleList;

	/**
	* @param fpmlDataDocument 
	* @return basketConstituent 
	*/
	public BasketConstituent evaluate(DataDocument fpmlDataDocument) {
		BasketConstituent.BasketConstituentBuilder basketConstituentBuilder = doEvaluate(fpmlDataDocument);
		
		final BasketConstituent basketConstituent;
		if (basketConstituentBuilder == null) {
			basketConstituent = null;
		} else {
			basketConstituent = basketConstituentBuilder.build();
			objectValidator.validate(BasketConstituent.class, basketConstituent);
		}
		
		return basketConstituent;
	}

	protected abstract BasketConstituent.BasketConstituentBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBasketConstituentDefault extends MapBasketConstituent {
		@Override
		protected BasketConstituent.BasketConstituentBuilder doEvaluate(DataDocument fpmlDataDocument) {
			BasketConstituent.BasketConstituentBuilder basketConstituent = BasketConstituent.builder();
			return assignOutput(basketConstituent, fpmlDataDocument);
		}
		
		protected BasketConstituent.BasketConstituentBuilder assignOutput(BasketConstituent.BasketConstituentBuilder basketConstituent, DataDocument fpmlDataDocument) {
			basketConstituent = toBuilder(BasketConstituent.builder()
				.setAsset(mapAsset.evaluate(fpmlDataDocument))
				.setBasket(mapBasket.evaluate(fpmlDataDocument))
				.setIndex(mapIndex.evaluate(fpmlDataDocument))
				.setQuantityValue(new ArrayList(mapNonNegativeQuantityScheduleList.evaluate(fpmlDataDocument)))
				.setInitialValuationPriceValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.setInterimValuationPriceValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.setFinalValuationPriceValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(basketConstituent)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
