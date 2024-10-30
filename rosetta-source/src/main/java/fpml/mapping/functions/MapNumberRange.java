package fpml.mapping.functions;

import cdm.base.math.NumberRange;
import cdm.base.math.NumberRange.NumberRangeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapNumberRange.MapNumberRangeDefault.class)
public abstract class MapNumberRange implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNumberBound mapNumberBound;

	/**
	* @param fpmlDataDocument 
	* @return numberRange 
	*/
	public NumberRange evaluate(DataDocument fpmlDataDocument) {
		NumberRange.NumberRangeBuilder numberRangeBuilder = doEvaluate(fpmlDataDocument);
		
		final NumberRange numberRange;
		if (numberRangeBuilder == null) {
			numberRange = null;
		} else {
			numberRange = numberRangeBuilder.build();
			objectValidator.validate(NumberRange.class, numberRange);
		}
		
		return numberRange;
	}

	protected abstract NumberRange.NumberRangeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapNumberRangeDefault extends MapNumberRange {
		@Override
		protected NumberRange.NumberRangeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			NumberRange.NumberRangeBuilder numberRange = NumberRange.builder();
			return assignOutput(numberRange, fpmlDataDocument);
		}
		
		protected NumberRange.NumberRangeBuilder assignOutput(NumberRange.NumberRangeBuilder numberRange, DataDocument fpmlDataDocument) {
			numberRange = toBuilder(NumberRange.builder()
				.setLowerBound(mapNumberBound.evaluate(fpmlDataDocument))
				.setUpperBound(mapNumberBound.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(numberRange)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
