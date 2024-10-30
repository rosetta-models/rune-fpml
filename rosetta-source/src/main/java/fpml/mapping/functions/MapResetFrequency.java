package fpml.mapping.functions;

import cdm.product.common.schedule.ResetFrequency;
import cdm.product.common.schedule.ResetFrequency.ResetFrequencyBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapResetFrequency.MapResetFrequencyDefault.class)
public abstract class MapResetFrequency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return resetFrequency 
	*/
	public ResetFrequency evaluate(DataDocument fpmlDataDocument) {
		ResetFrequency.ResetFrequencyBuilder resetFrequencyBuilder = doEvaluate(fpmlDataDocument);
		
		final ResetFrequency resetFrequency;
		if (resetFrequencyBuilder == null) {
			resetFrequency = null;
		} else {
			resetFrequency = resetFrequencyBuilder.build();
			objectValidator.validate(ResetFrequency.class, resetFrequency);
		}
		
		return resetFrequency;
	}

	protected abstract ResetFrequency.ResetFrequencyBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapResetFrequencyDefault extends MapResetFrequency {
		@Override
		protected ResetFrequency.ResetFrequencyBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ResetFrequency.ResetFrequencyBuilder resetFrequency = ResetFrequency.builder();
			return assignOutput(resetFrequency, fpmlDataDocument);
		}
		
		protected ResetFrequency.ResetFrequencyBuilder assignOutput(ResetFrequency.ResetFrequencyBuilder resetFrequency, DataDocument fpmlDataDocument) {
			resetFrequency = toBuilder(ResetFrequency.builder()
				.setPeriodMultiplier(null)
				.setPeriod(null)
				.setWeeklyRollConvention(null)
				.build());
			
			return Optional.ofNullable(resetFrequency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
