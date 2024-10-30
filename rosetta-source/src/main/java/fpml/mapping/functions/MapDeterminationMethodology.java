package fpml.mapping.functions;

import cdm.observable.event.DeterminationMethodology;
import cdm.observable.event.DeterminationMethodology.DeterminationMethodologyBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDeterminationMethodology.MapDeterminationMethodologyDefault.class)
public abstract class MapDeterminationMethodology implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return determinationMethodology 
	*/
	public DeterminationMethodology evaluate(DataDocument fpmlDataDocument) {
		DeterminationMethodology.DeterminationMethodologyBuilder determinationMethodologyBuilder = doEvaluate(fpmlDataDocument);
		
		final DeterminationMethodology determinationMethodology;
		if (determinationMethodologyBuilder == null) {
			determinationMethodology = null;
		} else {
			determinationMethodology = determinationMethodologyBuilder.build();
			objectValidator.validate(DeterminationMethodology.class, determinationMethodology);
		}
		
		return determinationMethodology;
	}

	protected abstract DeterminationMethodology.DeterminationMethodologyBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDeterminationMethodologyDefault extends MapDeterminationMethodology {
		@Override
		protected DeterminationMethodology.DeterminationMethodologyBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DeterminationMethodology.DeterminationMethodologyBuilder determinationMethodology = DeterminationMethodology.builder();
			return assignOutput(determinationMethodology, fpmlDataDocument);
		}
		
		protected DeterminationMethodology.DeterminationMethodologyBuilder assignOutput(DeterminationMethodology.DeterminationMethodologyBuilder determinationMethodology, DataDocument fpmlDataDocument) {
			determinationMethodology = toBuilder(DeterminationMethodology.builder()
				.setDeterminationMethod(null)
				.setAveragingMethod(null)
				.build());
			
			return Optional.ofNullable(determinationMethodology)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
