package fpml.mapping.functions;

import cdm.event.common.ScheduledTransfer;
import cdm.event.common.ScheduledTransfer.ScheduledTransferBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapScheduledTransfer.MapScheduledTransferDefault.class)
public abstract class MapScheduledTransfer implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return scheduledTransfer 
	*/
	public ScheduledTransfer evaluate(DataDocument fpmlDataDocument) {
		ScheduledTransfer.ScheduledTransferBuilder scheduledTransferBuilder = doEvaluate(fpmlDataDocument);
		
		final ScheduledTransfer scheduledTransfer;
		if (scheduledTransferBuilder == null) {
			scheduledTransfer = null;
		} else {
			scheduledTransfer = scheduledTransferBuilder.build();
			objectValidator.validate(ScheduledTransfer.class, scheduledTransfer);
		}
		
		return scheduledTransfer;
	}

	protected abstract ScheduledTransfer.ScheduledTransferBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapScheduledTransferDefault extends MapScheduledTransfer {
		@Override
		protected ScheduledTransfer.ScheduledTransferBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ScheduledTransfer.ScheduledTransferBuilder scheduledTransfer = ScheduledTransfer.builder();
			return assignOutput(scheduledTransfer, fpmlDataDocument);
		}
		
		protected ScheduledTransfer.ScheduledTransferBuilder assignOutput(ScheduledTransfer.ScheduledTransferBuilder scheduledTransfer, DataDocument fpmlDataDocument) {
			scheduledTransfer = toBuilder(ScheduledTransfer.builder()
				.setTransferType(null)
				.setCorporateActionTransferType(null)
				.build());
			
			return Optional.ofNullable(scheduledTransfer)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
