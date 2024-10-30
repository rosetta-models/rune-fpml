package fpml.mapping.functions;

import cdm.legaldocumentation.master.Representations;
import cdm.legaldocumentation.master.Representations.RepresentationsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRepresentations.MapRepresentationsDefault.class)
public abstract class MapRepresentations implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return representations 
	*/
	public Representations evaluate(DataDocument fpmlDataDocument) {
		Representations.RepresentationsBuilder representationsBuilder = doEvaluate(fpmlDataDocument);
		
		final Representations representations;
		if (representationsBuilder == null) {
			representations = null;
		} else {
			representations = representationsBuilder.build();
			objectValidator.validate(Representations.class, representations);
		}
		
		return representations;
	}

	protected abstract Representations.RepresentationsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRepresentationsDefault extends MapRepresentations {
		@Override
		protected Representations.RepresentationsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Representations.RepresentationsBuilder representations = Representations.builder();
			return assignOutput(representations, fpmlDataDocument);
		}
		
		protected Representations.RepresentationsBuilder assignOutput(Representations.RepresentationsBuilder representations, DataDocument fpmlDataDocument) {
			representations = toBuilder(Representations.builder()
				.build());
			
			return Optional.ofNullable(representations)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
