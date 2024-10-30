package fpml.mapping.functions;

import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.NonNegativeQuantity.NonNegativeQuantityBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapNonNegativeQuantity.MapNonNegativeQuantityDefault.class)
public abstract class MapNonNegativeQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDatedValueList mapDatedValueList;
	@Inject protected MapFrequency mapFrequency;
	@Inject protected MapMeasure mapMeasure;
	@Inject protected MapUnitType mapUnitType;

	/**
	* @param fpmlDataDocument 
	* @return nonNegativeQuantity 
	*/
	public NonNegativeQuantity evaluate(DataDocument fpmlDataDocument) {
		NonNegativeQuantity.NonNegativeQuantityBuilder nonNegativeQuantityBuilder = doEvaluate(fpmlDataDocument);
		
		final NonNegativeQuantity nonNegativeQuantity;
		if (nonNegativeQuantityBuilder == null) {
			nonNegativeQuantity = null;
		} else {
			nonNegativeQuantity = nonNegativeQuantityBuilder.build();
			objectValidator.validate(NonNegativeQuantity.class, nonNegativeQuantity);
		}
		
		return nonNegativeQuantity;
	}

	protected abstract NonNegativeQuantity.NonNegativeQuantityBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapNonNegativeQuantityDefault extends MapNonNegativeQuantity {
		@Override
		protected NonNegativeQuantity.NonNegativeQuantityBuilder doEvaluate(DataDocument fpmlDataDocument) {
			NonNegativeQuantity.NonNegativeQuantityBuilder nonNegativeQuantity = NonNegativeQuantity.builder();
			return assignOutput(nonNegativeQuantity, fpmlDataDocument);
		}
		
		protected NonNegativeQuantity.NonNegativeQuantityBuilder assignOutput(NonNegativeQuantity.NonNegativeQuantityBuilder nonNegativeQuantity, DataDocument fpmlDataDocument) {
			nonNegativeQuantity = toBuilder(NonNegativeQuantity.builder()
				.setValue(null)
				.setUnit(mapUnitType.evaluate(fpmlDataDocument))
				.setDatedValue(new ArrayList(mapDatedValueList.evaluate(fpmlDataDocument)))
				.setMultiplier(mapMeasure.evaluate(fpmlDataDocument))
				.setFrequency(mapFrequency.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(nonNegativeQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
