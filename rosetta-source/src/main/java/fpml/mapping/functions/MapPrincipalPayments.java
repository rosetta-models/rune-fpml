package fpml.mapping.functions;

import cdm.product.common.settlement.PrincipalPayments;
import cdm.product.common.settlement.PrincipalPayments.PrincipalPaymentsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPrincipalPayments.MapPrincipalPaymentsDefault.class)
public abstract class MapPrincipalPayments implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPrincipalPaymentSchedule mapPrincipalPaymentSchedule;

	/**
	* @param fpmlDataDocument 
	* @return principalPayments 
	*/
	public PrincipalPayments evaluate(DataDocument fpmlDataDocument) {
		PrincipalPayments.PrincipalPaymentsBuilder principalPaymentsBuilder = doEvaluate(fpmlDataDocument);
		
		final PrincipalPayments principalPayments;
		if (principalPaymentsBuilder == null) {
			principalPayments = null;
		} else {
			principalPayments = principalPaymentsBuilder.build();
			objectValidator.validate(PrincipalPayments.class, principalPayments);
		}
		
		return principalPayments;
	}

	protected abstract PrincipalPayments.PrincipalPaymentsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPrincipalPaymentsDefault extends MapPrincipalPayments {
		@Override
		protected PrincipalPayments.PrincipalPaymentsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PrincipalPayments.PrincipalPaymentsBuilder principalPayments = PrincipalPayments.builder();
			return assignOutput(principalPayments, fpmlDataDocument);
		}
		
		protected PrincipalPayments.PrincipalPaymentsBuilder assignOutput(PrincipalPayments.PrincipalPaymentsBuilder principalPayments, DataDocument fpmlDataDocument) {
			principalPayments = toBuilder(PrincipalPayments.builder()
				.setInitialPayment(null)
				.setFinalPayment(null)
				.setIntermediatePayment(null)
				.setVaryingLegNotionalCurrency(Collections.<String>emptyList())
				.setPrincipalPaymentSchedule(mapPrincipalPaymentSchedule.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(principalPayments)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
