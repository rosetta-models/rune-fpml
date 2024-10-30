package fpml.mapping.functions;

import cdm.base.math.NumberBound;
import cdm.base.math.NumberBound.NumberBoundBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapNumberBound.MapNumberBoundDefault.class)
public abstract class MapNumberBound implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return numberBound 
	*/
	public NumberBound evaluate(DataDocument fpmlDataDocument) {
		NumberBound.NumberBoundBuilder numberBoundBuilder = doEvaluate(fpmlDataDocument);
		
		final NumberBound numberBound;
		if (numberBoundBuilder == null) {
			numberBound = null;
		} else {
			numberBound = numberBoundBuilder.build();
			objectValidator.validate(NumberBound.class, numberBound);
		}
		
		return numberBound;
	}

	protected abstract NumberBound.NumberBoundBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapNumberBoundDefault extends MapNumberBound {
		@Override
		protected NumberBound.NumberBoundBuilder doEvaluate(DataDocument fpmlDataDocument) {
			NumberBound.NumberBoundBuilder numberBound = NumberBound.builder();
			return assignOutput(numberBound, fpmlDataDocument);
		}
		
		protected NumberBound.NumberBoundBuilder assignOutput(NumberBound.NumberBoundBuilder numberBound, DataDocument fpmlDataDocument) {
			numberBound = toBuilder(NumberBound.builder()
				.setNumber(null)
				.setInclusive(null)
				.build());
			
			return Optional.ofNullable(numberBound)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
