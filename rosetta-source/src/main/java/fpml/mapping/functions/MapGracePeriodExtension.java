package fpml.mapping.functions;

import cdm.observable.event.GracePeriodExtension;
import cdm.observable.event.GracePeriodExtension.GracePeriodExtensionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapGracePeriodExtension.MapGracePeriodExtensionDefault.class)
public abstract class MapGracePeriodExtension implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapOffset mapOffset;

	/**
	* @param fpmlDataDocument 
	* @return gracePeriodExtension 
	*/
	public GracePeriodExtension evaluate(DataDocument fpmlDataDocument) {
		GracePeriodExtension.GracePeriodExtensionBuilder gracePeriodExtensionBuilder = doEvaluate(fpmlDataDocument);
		
		final GracePeriodExtension gracePeriodExtension;
		if (gracePeriodExtensionBuilder == null) {
			gracePeriodExtension = null;
		} else {
			gracePeriodExtension = gracePeriodExtensionBuilder.build();
			objectValidator.validate(GracePeriodExtension.class, gracePeriodExtension);
		}
		
		return gracePeriodExtension;
	}

	protected abstract GracePeriodExtension.GracePeriodExtensionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapGracePeriodExtensionDefault extends MapGracePeriodExtension {
		@Override
		protected GracePeriodExtension.GracePeriodExtensionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			GracePeriodExtension.GracePeriodExtensionBuilder gracePeriodExtension = GracePeriodExtension.builder();
			return assignOutput(gracePeriodExtension, fpmlDataDocument);
		}
		
		protected GracePeriodExtension.GracePeriodExtensionBuilder assignOutput(GracePeriodExtension.GracePeriodExtensionBuilder gracePeriodExtension, DataDocument fpmlDataDocument) {
			gracePeriodExtension = toBuilder(GracePeriodExtension.builder()
				.setApplicable(null)
				.setGracePeriod(mapOffset.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(gracePeriodExtension)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
