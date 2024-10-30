package fpml.mapping.functions;

import cdm.product.template.CancelableProvisionAdjustedDates;
import cdm.product.template.CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCancelableProvisionAdjustedDates.MapCancelableProvisionAdjustedDatesDefault.class)
public abstract class MapCancelableProvisionAdjustedDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCancellationEventList mapCancellationEventList;

	/**
	* @param fpmlDataDocument 
	* @return cancelableProvisionAdjustedDates 
	*/
	public CancelableProvisionAdjustedDates evaluate(DataDocument fpmlDataDocument) {
		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder cancelableProvisionAdjustedDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final CancelableProvisionAdjustedDates cancelableProvisionAdjustedDates;
		if (cancelableProvisionAdjustedDatesBuilder == null) {
			cancelableProvisionAdjustedDates = null;
		} else {
			cancelableProvisionAdjustedDates = cancelableProvisionAdjustedDatesBuilder.build();
			objectValidator.validate(CancelableProvisionAdjustedDates.class, cancelableProvisionAdjustedDates);
		}
		
		return cancelableProvisionAdjustedDates;
	}

	protected abstract CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCancelableProvisionAdjustedDatesDefault extends MapCancelableProvisionAdjustedDates {
		@Override
		protected CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder cancelableProvisionAdjustedDates = CancelableProvisionAdjustedDates.builder();
			return assignOutput(cancelableProvisionAdjustedDates, fpmlDataDocument);
		}
		
		protected CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder assignOutput(CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder cancelableProvisionAdjustedDates, DataDocument fpmlDataDocument) {
			cancelableProvisionAdjustedDates = toBuilder(CancelableProvisionAdjustedDates.builder()
				.setCancellationEvent(new ArrayList(mapCancellationEventList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(cancelableProvisionAdjustedDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
