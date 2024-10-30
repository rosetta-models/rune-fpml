package fpml.mapping.functions;

import cdm.base.math.Rounding;
import cdm.base.math.Rounding.RoundingBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRounding.MapRoundingDefault.class)
public abstract class MapRounding implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return rounding 
	*/
	public Rounding evaluate(DataDocument fpmlDataDocument) {
		Rounding.RoundingBuilder roundingBuilder = doEvaluate(fpmlDataDocument);
		
		final Rounding rounding;
		if (roundingBuilder == null) {
			rounding = null;
		} else {
			rounding = roundingBuilder.build();
			objectValidator.validate(Rounding.class, rounding);
		}
		
		return rounding;
	}

	protected abstract Rounding.RoundingBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRoundingDefault extends MapRounding {
		@Override
		protected Rounding.RoundingBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Rounding.RoundingBuilder rounding = Rounding.builder();
			return assignOutput(rounding, fpmlDataDocument);
		}
		
		protected Rounding.RoundingBuilder assignOutput(Rounding.RoundingBuilder rounding, DataDocument fpmlDataDocument) {
			rounding = toBuilder(Rounding.builder()
				.setRoundingDirection(null)
				.setPrecision(null)
				.build());
			
			return Optional.ofNullable(rounding)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
