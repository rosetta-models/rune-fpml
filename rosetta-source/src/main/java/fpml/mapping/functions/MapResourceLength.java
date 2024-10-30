package fpml.mapping.functions;

import cdm.legaldocumentation.common.ResourceLength;
import cdm.legaldocumentation.common.ResourceLength.ResourceLengthBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapResourceLength.MapResourceLengthDefault.class)
public abstract class MapResourceLength implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return resourceLength 
	*/
	public ResourceLength evaluate(DataDocument fpmlDataDocument) {
		ResourceLength.ResourceLengthBuilder resourceLengthBuilder = doEvaluate(fpmlDataDocument);
		
		final ResourceLength resourceLength;
		if (resourceLengthBuilder == null) {
			resourceLength = null;
		} else {
			resourceLength = resourceLengthBuilder.build();
			objectValidator.validate(ResourceLength.class, resourceLength);
		}
		
		return resourceLength;
	}

	protected abstract ResourceLength.ResourceLengthBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapResourceLengthDefault extends MapResourceLength {
		@Override
		protected ResourceLength.ResourceLengthBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ResourceLength.ResourceLengthBuilder resourceLength = ResourceLength.builder();
			return assignOutput(resourceLength, fpmlDataDocument);
		}
		
		protected ResourceLength.ResourceLengthBuilder assignOutput(ResourceLength.ResourceLengthBuilder resourceLength, DataDocument fpmlDataDocument) {
			resourceLength = toBuilder(ResourceLength.builder()
				.setLengthUnit(null)
				.setLengthValue(null)
				.build());
			
			return Optional.ofNullable(resourceLength)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
