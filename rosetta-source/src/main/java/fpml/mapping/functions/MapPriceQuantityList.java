package fpml.mapping.functions;

import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceQuantity.PriceQuantityBuilder;
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


@ImplementedBy(MapPriceQuantityList.MapPriceQuantityListDefault.class)
public abstract class MapPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapNonNegativeQuantityScheduleList mapNonNegativeQuantityScheduleList;
	@Inject protected MapObservable mapObservable;
	@Inject protected MapPriceScheduleList mapPriceScheduleList;

	/**
	* @param fpmlDataDocument 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(DataDocument fpmlDataDocument) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPriceQuantityListDefault extends MapPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlDataDocument);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, DataDocument fpmlDataDocument) {
			priceQuantityList.addAll(toBuilder(MapperC.<PriceQuantity>of(MapperS.of(PriceQuantity.builder()
				.setPriceValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.setQuantityValue(new ArrayList(mapNonNegativeQuantityScheduleList.evaluate(fpmlDataDocument)))
				.setObservableValue(mapObservable.evaluate(fpmlDataDocument))
				.setEffectiveDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
