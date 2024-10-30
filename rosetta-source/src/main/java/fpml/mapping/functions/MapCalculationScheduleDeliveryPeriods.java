package fpml.mapping.functions;

import cdm.product.asset.CalculationScheduleDeliveryPeriods;
import cdm.product.asset.CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCalculationScheduleDeliveryPeriods.MapCalculationScheduleDeliveryPeriodsDefault.class)
public abstract class MapCalculationScheduleDeliveryPeriods implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetDeliveryProfileList mapAssetDeliveryProfileList;
	@Inject protected MapPrice mapPrice;
	@Inject protected MapQuantity mapQuantity;

	/**
	* @param fpmlDataDocument 
	* @return calculationScheduleDeliveryPeriods 
	*/
	public CalculationScheduleDeliveryPeriods evaluate(DataDocument fpmlDataDocument) {
		CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder calculationScheduleDeliveryPeriodsBuilder = doEvaluate(fpmlDataDocument);
		
		final CalculationScheduleDeliveryPeriods calculationScheduleDeliveryPeriods;
		if (calculationScheduleDeliveryPeriodsBuilder == null) {
			calculationScheduleDeliveryPeriods = null;
		} else {
			calculationScheduleDeliveryPeriods = calculationScheduleDeliveryPeriodsBuilder.build();
			objectValidator.validate(CalculationScheduleDeliveryPeriods.class, calculationScheduleDeliveryPeriods);
		}
		
		return calculationScheduleDeliveryPeriods;
	}

	protected abstract CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCalculationScheduleDeliveryPeriodsDefault extends MapCalculationScheduleDeliveryPeriods {
		@Override
		protected CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder calculationScheduleDeliveryPeriods = CalculationScheduleDeliveryPeriods.builder();
			return assignOutput(calculationScheduleDeliveryPeriods, fpmlDataDocument);
		}
		
		protected CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder assignOutput(CalculationScheduleDeliveryPeriods.CalculationScheduleDeliveryPeriodsBuilder calculationScheduleDeliveryPeriods, DataDocument fpmlDataDocument) {
			calculationScheduleDeliveryPeriods = toBuilder(CalculationScheduleDeliveryPeriods.builder()
				.setProfile(new ArrayList(mapAssetDeliveryProfileList.evaluate(fpmlDataDocument)))
				.setStartDate(null)
				.setEndDate(null)
				.setDeliveryCapacity(mapQuantity.evaluate(fpmlDataDocument))
				.setPriceTimeIntervalQuantity(mapPrice.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(calculationScheduleDeliveryPeriods)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
