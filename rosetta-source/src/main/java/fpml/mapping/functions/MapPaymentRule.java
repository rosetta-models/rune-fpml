package fpml.mapping.functions;

import cdm.product.common.settlement.PaymentRule;
import cdm.product.common.settlement.PaymentRule.PaymentRuleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPaymentRule.MapPaymentRuleDefault.class)
public abstract class MapPaymentRule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPercentageRule mapPercentageRule;

	/**
	* @param fpmlDataDocument 
	* @return paymentRule 
	*/
	public PaymentRule evaluate(DataDocument fpmlDataDocument) {
		PaymentRule.PaymentRuleBuilder paymentRuleBuilder = doEvaluate(fpmlDataDocument);
		
		final PaymentRule paymentRule;
		if (paymentRuleBuilder == null) {
			paymentRule = null;
		} else {
			paymentRule = paymentRuleBuilder.build();
			objectValidator.validate(PaymentRule.class, paymentRule);
		}
		
		return paymentRule;
	}

	protected abstract PaymentRule.PaymentRuleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPaymentRuleDefault extends MapPaymentRule {
		@Override
		protected PaymentRule.PaymentRuleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PaymentRule.PaymentRuleBuilder paymentRule = PaymentRule.builder();
			return assignOutput(paymentRule, fpmlDataDocument);
		}
		
		protected PaymentRule.PaymentRuleBuilder assignOutput(PaymentRule.PaymentRuleBuilder paymentRule, DataDocument fpmlDataDocument) {
			paymentRule = toBuilder(PaymentRule.builder()
				.setPercentageRule(mapPercentageRule.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(paymentRule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
