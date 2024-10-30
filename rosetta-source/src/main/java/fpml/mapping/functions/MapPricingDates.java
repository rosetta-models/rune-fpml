package fpml.mapping.functions;

import cdm.product.common.settlement.PricingDates;
import cdm.product.common.settlement.PricingDates.PricingDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPricingDates.MapPricingDatesDefault.class)
public abstract class MapPricingDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDatesList mapAdjustableDatesList;
	@Inject protected MapParametricDates mapParametricDates;

	/**
	* @param fpmlDataDocument 
	* @return pricingDates 
	*/
	public PricingDates evaluate(DataDocument fpmlDataDocument) {
		PricingDates.PricingDatesBuilder pricingDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final PricingDates pricingDates;
		if (pricingDatesBuilder == null) {
			pricingDates = null;
		} else {
			pricingDates = pricingDatesBuilder.build();
			objectValidator.validate(PricingDates.class, pricingDates);
		}
		
		return pricingDates;
	}

	protected abstract PricingDates.PricingDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPricingDatesDefault extends MapPricingDates {
		@Override
		protected PricingDates.PricingDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PricingDates.PricingDatesBuilder pricingDates = PricingDates.builder();
			return assignOutput(pricingDates, fpmlDataDocument);
		}
		
		protected PricingDates.PricingDatesBuilder assignOutput(PricingDates.PricingDatesBuilder pricingDates, DataDocument fpmlDataDocument) {
			pricingDates = toBuilder(PricingDates.builder()
				.setSpecifiedDates(new ArrayList(mapAdjustableDatesList.evaluate(fpmlDataDocument)))
				.setParametricDates(mapParametricDates.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(pricingDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
