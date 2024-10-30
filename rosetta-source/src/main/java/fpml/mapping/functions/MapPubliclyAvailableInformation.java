package fpml.mapping.functions;

import cdm.observable.event.PubliclyAvailableInformation;
import cdm.observable.event.PubliclyAvailableInformation.PubliclyAvailableInformationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPubliclyAvailableInformation.MapPubliclyAvailableInformationDefault.class)
public abstract class MapPubliclyAvailableInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return publiclyAvailableInformation 
	*/
	public PubliclyAvailableInformation evaluate(DataDocument fpmlDataDocument) {
		PubliclyAvailableInformation.PubliclyAvailableInformationBuilder publiclyAvailableInformationBuilder = doEvaluate(fpmlDataDocument);
		
		final PubliclyAvailableInformation publiclyAvailableInformation;
		if (publiclyAvailableInformationBuilder == null) {
			publiclyAvailableInformation = null;
		} else {
			publiclyAvailableInformation = publiclyAvailableInformationBuilder.build();
			objectValidator.validate(PubliclyAvailableInformation.class, publiclyAvailableInformation);
		}
		
		return publiclyAvailableInformation;
	}

	protected abstract PubliclyAvailableInformation.PubliclyAvailableInformationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPubliclyAvailableInformationDefault extends MapPubliclyAvailableInformation {
		@Override
		protected PubliclyAvailableInformation.PubliclyAvailableInformationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PubliclyAvailableInformation.PubliclyAvailableInformationBuilder publiclyAvailableInformation = PubliclyAvailableInformation.builder();
			return assignOutput(publiclyAvailableInformation, fpmlDataDocument);
		}
		
		protected PubliclyAvailableInformation.PubliclyAvailableInformationBuilder assignOutput(PubliclyAvailableInformation.PubliclyAvailableInformationBuilder publiclyAvailableInformation, DataDocument fpmlDataDocument) {
			publiclyAvailableInformation = toBuilder(PubliclyAvailableInformation.builder()
				.setStandardPublicSources(null)
				.setPublicSource(Collections.<String>emptyList())
				.setSpecifiedNumber(null)
				.build());
			
			return Optional.ofNullable(publiclyAvailableInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
