package fpml.mapping.functions;

import cdm.base.datetime.Frequency;
import cdm.base.datetime.Frequency.FrequencyBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFrequency.MapFrequencyDefault.class)
public abstract class MapFrequency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return frequency 
	*/
	public Frequency evaluate(DataDocument fpmlDataDocument) {
		Frequency.FrequencyBuilder frequencyBuilder = doEvaluate(fpmlDataDocument);
		
		final Frequency frequency;
		if (frequencyBuilder == null) {
			frequency = null;
		} else {
			frequency = frequencyBuilder.build();
			objectValidator.validate(Frequency.class, frequency);
		}
		
		return frequency;
	}

	protected abstract Frequency.FrequencyBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFrequencyDefault extends MapFrequency {
		@Override
		protected Frequency.FrequencyBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Frequency.FrequencyBuilder frequency = Frequency.builder();
			return assignOutput(frequency, fpmlDataDocument);
		}
		
		protected Frequency.FrequencyBuilder assignOutput(Frequency.FrequencyBuilder frequency, DataDocument fpmlDataDocument) {
			frequency = toBuilder(Frequency.builder()
				.setPeriodMultiplier(null)
				.setPeriod(null)
				.build());
			
			return Optional.ofNullable(frequency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
