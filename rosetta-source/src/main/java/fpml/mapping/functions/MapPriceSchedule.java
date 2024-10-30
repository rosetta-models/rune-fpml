package fpml.mapping.functions;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceSchedule.PriceScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPriceSchedule.MapPriceScheduleDefault.class)
public abstract class MapPriceSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashPrice mapCashPrice;
	@Inject protected MapDatedValueList mapDatedValueList;
	@Inject protected MapPriceComposite mapPriceComposite;
	@Inject protected MapUnitType mapUnitType;

	/**
	* @param fpmlDataDocument 
	* @return priceSchedule 
	*/
	public PriceSchedule evaluate(DataDocument fpmlDataDocument) {
		PriceSchedule.PriceScheduleBuilder priceScheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final PriceSchedule priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.build();
			objectValidator.validate(PriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPriceScheduleDefault extends MapPriceSchedule {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PriceSchedule.PriceScheduleBuilder priceSchedule = PriceSchedule.builder();
			return assignOutput(priceSchedule, fpmlDataDocument);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder priceSchedule, DataDocument fpmlDataDocument) {
			priceSchedule = toBuilder(PriceSchedule.builder()
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
			
			return Optional.ofNullable(priceSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
