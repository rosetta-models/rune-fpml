package fpml.mapping.functions;

import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.BasketConstituent.BasketConstituentBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapBasketConstituentList.MapBasketConstituentListDefault.class)
public abstract class MapBasketConstituentList implements RosettaFunction {
	
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
	* @return basketConstituentList 
	*/
	public List<? extends BasketConstituent> evaluate(DataDocument fpmlDataDocument) {
		List<BasketConstituent.BasketConstituentBuilder> basketConstituentListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends BasketConstituent> basketConstituentList;
		if (basketConstituentListBuilder == null) {
			basketConstituentList = null;
		} else {
			basketConstituentList = basketConstituentListBuilder.stream().map(BasketConstituent::build).collect(Collectors.toList());
			objectValidator.validate(BasketConstituent.class, basketConstituentList);
		}
		
		return basketConstituentList;
	}

	protected abstract List<BasketConstituent.BasketConstituentBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBasketConstituentListDefault extends MapBasketConstituentList {
		@Override
		protected List<BasketConstituent.BasketConstituentBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<BasketConstituent.BasketConstituentBuilder> basketConstituentList = new ArrayList<>();
			return assignOutput(basketConstituentList, fpmlDataDocument);
		}
		
		protected List<BasketConstituent.BasketConstituentBuilder> assignOutput(List<BasketConstituent.BasketConstituentBuilder> basketConstituentList, DataDocument fpmlDataDocument) {
			basketConstituentList.addAll(toBuilder(MapperC.<BasketConstituent>of(MapperS.of(BasketConstituent.builder()
				.setAsset(mapAsset.evaluate(fpmlDataDocument))
				.setBasket(mapBasket.evaluate(fpmlDataDocument))
				.setIndex(mapIndex.evaluate(fpmlDataDocument))
				.setQuantityValue(new ArrayList(mapNonNegativeQuantityScheduleList.evaluate(fpmlDataDocument)))
				.setInitialValuationPriceValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.setInterimValuationPriceValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.setFinalValuationPriceValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.build())).getMulti()));
			
			return Optional.ofNullable(basketConstituentList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
