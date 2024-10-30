package fpml.mapping.functions;

import cdm.event.common.ExecutionDetails;
import cdm.event.common.ExecutionDetails.ExecutionDetailsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExecutionDetails.MapExecutionDetailsDefault.class)
public abstract class MapExecutionDetails implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapIdentifiedList mapIdentifiedList;
	@Inject protected MapLegalEntity mapLegalEntity;

	/**
	* @param fpmlDataDocument 
	* @return executionDetails 
	*/
	public ExecutionDetails evaluate(DataDocument fpmlDataDocument) {
		ExecutionDetails.ExecutionDetailsBuilder executionDetailsBuilder = doEvaluate(fpmlDataDocument);
		
		final ExecutionDetails executionDetails;
		if (executionDetailsBuilder == null) {
			executionDetails = null;
		} else {
			executionDetails = executionDetailsBuilder.build();
			objectValidator.validate(ExecutionDetails.class, executionDetails);
		}
		
		return executionDetails;
	}

	protected abstract ExecutionDetails.ExecutionDetailsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapExecutionDetailsDefault extends MapExecutionDetails {
		@Override
		protected ExecutionDetails.ExecutionDetailsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ExecutionDetails.ExecutionDetailsBuilder executionDetails = ExecutionDetails.builder();
			return assignOutput(executionDetails, fpmlDataDocument);
		}
		
		protected ExecutionDetails.ExecutionDetailsBuilder assignOutput(ExecutionDetails.ExecutionDetailsBuilder executionDetails, DataDocument fpmlDataDocument) {
			executionDetails = toBuilder(ExecutionDetails.builder()
				.setExecutionType(null)
				.setExecutionVenue(mapLegalEntity.evaluate(fpmlDataDocument))
				.setPackageReference(mapIdentifiedList.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(executionDetails)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
