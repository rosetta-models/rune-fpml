package fpml.mapping.functions;

import cdm.product.common.settlement.PrincipalPayment;
import cdm.product.common.settlement.PrincipalPayment.PrincipalPaymentBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPrincipalPayment.MapPrincipalPaymentDefault.class)
public abstract class MapPrincipalPayment implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapMoney mapMoney;
	@Inject protected MapPayerReceiver mapPayerReceiver;

	/**
	* @param fpmlDataDocument 
	* @return principalPayment 
	*/
	public PrincipalPayment evaluate(DataDocument fpmlDataDocument) {
		PrincipalPayment.PrincipalPaymentBuilder principalPaymentBuilder = doEvaluate(fpmlDataDocument);
		
		final PrincipalPayment principalPayment;
		if (principalPaymentBuilder == null) {
			principalPayment = null;
		} else {
			principalPayment = principalPaymentBuilder.build();
			objectValidator.validate(PrincipalPayment.class, principalPayment);
		}
		
		return principalPayment;
	}

	protected abstract PrincipalPayment.PrincipalPaymentBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPrincipalPaymentDefault extends MapPrincipalPayment {
		@Override
		protected PrincipalPayment.PrincipalPaymentBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PrincipalPayment.PrincipalPaymentBuilder principalPayment = PrincipalPayment.builder();
			return assignOutput(principalPayment, fpmlDataDocument);
		}
		
		protected PrincipalPayment.PrincipalPaymentBuilder assignOutput(PrincipalPayment.PrincipalPaymentBuilder principalPayment, DataDocument fpmlDataDocument) {
			principalPayment = toBuilder(PrincipalPayment.builder()
				.setPrincipalPaymentDate(mapAdjustableDate.evaluate(fpmlDataDocument))
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPrincipalAmount(mapMoney.evaluate(fpmlDataDocument))
				.setDiscountFactor(null)
				.setPresentValuePrincipalAmount(mapMoney.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(principalPayment)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
