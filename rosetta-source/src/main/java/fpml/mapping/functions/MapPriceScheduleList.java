package fpml.mapping.functions;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceSchedule.PriceScheduleBuilder;
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


@ImplementedBy(MapPriceScheduleList.MapPriceScheduleListDefault.class)
public abstract class MapPriceScheduleList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashPrice mapCashPrice;
	@Inject protected MapDatedValueList mapDatedValueList;
	@Inject protected MapPriceComposite mapPriceComposite;
	@Inject protected MapUnitType mapUnitType;

	/**
	* @param fpmlDataDocument 
	* @return priceScheduleList 
	*/
	public List<? extends PriceSchedule> evaluate(DataDocument fpmlDataDocument) {
		List<PriceSchedule.PriceScheduleBuilder> priceScheduleListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends PriceSchedule> priceScheduleList;
		if (priceScheduleListBuilder == null) {
			priceScheduleList = null;
		} else {
			priceScheduleList = priceScheduleListBuilder.stream().map(PriceSchedule::build).collect(Collectors.toList());
			objectValidator.validate(PriceSchedule.class, priceScheduleList);
		}
		
		return priceScheduleList;
	}

	protected abstract List<PriceSchedule.PriceScheduleBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPriceScheduleListDefault extends MapPriceScheduleList {
		@Override
		protected List<PriceSchedule.PriceScheduleBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<PriceSchedule.PriceScheduleBuilder> priceScheduleList = new ArrayList<>();
			return assignOutput(priceScheduleList, fpmlDataDocument);
		}
		
		protected List<PriceSchedule.PriceScheduleBuilder> assignOutput(List<PriceSchedule.PriceScheduleBuilder> priceScheduleList, DataDocument fpmlDataDocument) {
			priceScheduleList.addAll(toBuilder(MapperC.<PriceSchedule>of(MapperS.of(PriceSchedule.builder()
				.setValue(null)
				.setUnit(mapUnitType.evaluate(fpmlDataDocument))
				.setDatedValue(new ArrayList(mapDatedValueList.evaluate(fpmlDataDocument)))
				.setPerUnitOf(mapUnitType.evaluate(fpmlDataDocument))
				.setPriceType(null)
				.setPriceExpression(null)
				.setComposite(mapPriceComposite.evaluate(fpmlDataDocument))
				.setArithmeticOperator(null)
				.setCashPrice(mapCashPrice.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(priceScheduleList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
