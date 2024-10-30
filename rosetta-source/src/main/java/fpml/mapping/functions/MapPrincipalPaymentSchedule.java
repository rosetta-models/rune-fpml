package fpml.mapping.functions;

import cdm.product.common.settlement.PrincipalPaymentSchedule;
import cdm.product.common.settlement.PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPrincipalPaymentSchedule.MapPrincipalPaymentScheduleDefault.class)
public abstract class MapPrincipalPaymentSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableRelativeOrPeriodicDates mapAdjustableRelativeOrPeriodicDates;
	@Inject protected MapPrincipalPayment mapPrincipalPayment;

	/**
	* @param fpmlDataDocument 
	* @return principalPaymentSchedule 
	*/
	public PrincipalPaymentSchedule evaluate(DataDocument fpmlDataDocument) {
		PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder principalPaymentScheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final PrincipalPaymentSchedule principalPaymentSchedule;
		if (principalPaymentScheduleBuilder == null) {
			principalPaymentSchedule = null;
		} else {
			principalPaymentSchedule = principalPaymentScheduleBuilder.build();
			objectValidator.validate(PrincipalPaymentSchedule.class, principalPaymentSchedule);
		}
		
		return principalPaymentSchedule;
	}

	protected abstract PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPrincipalPaymentScheduleDefault extends MapPrincipalPaymentSchedule {
		@Override
		protected PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder principalPaymentSchedule = PrincipalPaymentSchedule.builder();
			return assignOutput(principalPaymentSchedule, fpmlDataDocument);
		}
		
		protected PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder assignOutput(PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder principalPaymentSchedule, DataDocument fpmlDataDocument) {
			principalPaymentSchedule = toBuilder(PrincipalPaymentSchedule.builder()
				.setInitialPrincipalPayment(mapPrincipalPayment.evaluate(fpmlDataDocument))
				.setIntermediatePrincipalPayment(mapAdjustableRelativeOrPeriodicDates.evaluate(fpmlDataDocument))
				.setFinalPrincipalPayment(mapPrincipalPayment.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(principalPaymentSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
