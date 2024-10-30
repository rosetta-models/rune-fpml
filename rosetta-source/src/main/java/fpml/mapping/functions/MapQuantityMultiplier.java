package fpml.mapping.functions;

import cdm.product.common.settlement.QuantityMultiplier;
import cdm.product.common.settlement.QuantityMultiplier.QuantityMultiplierBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapQuantityMultiplier.MapQuantityMultiplierDefault.class)
public abstract class MapQuantityMultiplier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxLinkedNotionalSchedule mapFxLinkedNotionalSchedule;

	/**
	* @param fpmlDataDocument 
	* @return quantityMultiplier 
	*/
	public QuantityMultiplier evaluate(DataDocument fpmlDataDocument) {
		QuantityMultiplier.QuantityMultiplierBuilder quantityMultiplierBuilder = doEvaluate(fpmlDataDocument);
		
		final QuantityMultiplier quantityMultiplier;
		if (quantityMultiplierBuilder == null) {
			quantityMultiplier = null;
		} else {
			quantityMultiplier = quantityMultiplierBuilder.build();
			objectValidator.validate(QuantityMultiplier.class, quantityMultiplier);
		}
		
		return quantityMultiplier;
	}

	protected abstract QuantityMultiplier.QuantityMultiplierBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapQuantityMultiplierDefault extends MapQuantityMultiplier {
		@Override
		protected QuantityMultiplier.QuantityMultiplierBuilder doEvaluate(DataDocument fpmlDataDocument) {
			QuantityMultiplier.QuantityMultiplierBuilder quantityMultiplier = QuantityMultiplier.builder();
			return assignOutput(quantityMultiplier, fpmlDataDocument);
		}
		
		protected QuantityMultiplier.QuantityMultiplierBuilder assignOutput(QuantityMultiplier.QuantityMultiplierBuilder quantityMultiplier, DataDocument fpmlDataDocument) {
			quantityMultiplier = toBuilder(QuantityMultiplier.builder()
				.setFxLinkedNotionalSchedule(mapFxLinkedNotionalSchedule.evaluate(fpmlDataDocument))
				.setMultiplierValue(null)
				.build());
			
			return Optional.ofNullable(quantityMultiplier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
