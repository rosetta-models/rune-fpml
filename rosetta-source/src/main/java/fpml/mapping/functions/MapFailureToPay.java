package fpml.mapping.functions;

import cdm.observable.event.FailureToPay;
import cdm.observable.event.FailureToPay.FailureToPayBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFailureToPay.MapFailureToPayDefault.class)
public abstract class MapFailureToPay implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapGracePeriodExtension mapGracePeriodExtension;
	@Inject protected MapMoney mapMoney;

	/**
	* @param fpmlDataDocument 
	* @return failureToPay 
	*/
	public FailureToPay evaluate(DataDocument fpmlDataDocument) {
		FailureToPay.FailureToPayBuilder failureToPayBuilder = doEvaluate(fpmlDataDocument);
		
		final FailureToPay failureToPay;
		if (failureToPayBuilder == null) {
			failureToPay = null;
		} else {
			failureToPay = failureToPayBuilder.build();
			objectValidator.validate(FailureToPay.class, failureToPay);
		}
		
		return failureToPay;
	}

	protected abstract FailureToPay.FailureToPayBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFailureToPayDefault extends MapFailureToPay {
		@Override
		protected FailureToPay.FailureToPayBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FailureToPay.FailureToPayBuilder failureToPay = FailureToPay.builder();
			return assignOutput(failureToPay, fpmlDataDocument);
		}
		
		protected FailureToPay.FailureToPayBuilder assignOutput(FailureToPay.FailureToPayBuilder failureToPay, DataDocument fpmlDataDocument) {
			failureToPay = toBuilder(FailureToPay.builder()
				.setApplicable(null)
				.setGracePeriodExtension(mapGracePeriodExtension.evaluate(fpmlDataDocument))
				.setPaymentRequirement(mapMoney.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(failureToPay)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
