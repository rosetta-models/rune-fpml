package fpml.mapping.functions;

import cdm.base.math.Quantity;
import cdm.base.math.Quantity.QuantityBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapQuantity.MapQuantityDefault.class)
public abstract class MapQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDatedValueList mapDatedValueList;
	@Inject protected MapFrequency mapFrequency;
	@Inject protected MapMeasure mapMeasure;
	@Inject protected MapUnitType mapUnitType;

	/**
	* @param fpmlDataDocument 
	* @return quantity 
	*/
	public Quantity evaluate(DataDocument fpmlDataDocument) {
		Quantity.QuantityBuilder quantityBuilder = doEvaluate(fpmlDataDocument);
		
		final Quantity quantity;
		if (quantityBuilder == null) {
			quantity = null;
		} else {
			quantity = quantityBuilder.build();
			objectValidator.validate(Quantity.class, quantity);
		}
		
		return quantity;
	}

	protected abstract Quantity.QuantityBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapQuantityDefault extends MapQuantity {
		@Override
		protected Quantity.QuantityBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Quantity.QuantityBuilder quantity = Quantity.builder();
			return assignOutput(quantity, fpmlDataDocument);
		}
		
		protected Quantity.QuantityBuilder assignOutput(Quantity.QuantityBuilder quantity, DataDocument fpmlDataDocument) {
			quantity = toBuilder(Quantity.builder()
				.setValue(null)
				.setUnit(mapUnitType.evaluate(fpmlDataDocument))
				.setDatedValue(new ArrayList(mapDatedValueList.evaluate(fpmlDataDocument)))
				.setMultiplier(mapMeasure.evaluate(fpmlDataDocument))
				.setFrequency(mapFrequency.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(quantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
