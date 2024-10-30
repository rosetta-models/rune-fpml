package fpml.mapping.functions;

import cdm.product.common.settlement.PercentageRule;
import cdm.product.common.settlement.PercentageRule.PercentageRuleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPercentageRule.MapPercentageRuleDefault.class)
public abstract class MapPercentageRule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoney mapMoney;

	/**
	* @param fpmlDataDocument 
	* @return percentageRule 
	*/
	public PercentageRule evaluate(DataDocument fpmlDataDocument) {
		PercentageRule.PercentageRuleBuilder percentageRuleBuilder = doEvaluate(fpmlDataDocument);
		
		final PercentageRule percentageRule;
		if (percentageRuleBuilder == null) {
			percentageRule = null;
		} else {
			percentageRule = percentageRuleBuilder.build();
			objectValidator.validate(PercentageRule.class, percentageRule);
		}
		
		return percentageRule;
	}

	protected abstract PercentageRule.PercentageRuleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPercentageRuleDefault extends MapPercentageRule {
		@Override
		protected PercentageRule.PercentageRuleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PercentageRule.PercentageRuleBuilder percentageRule = PercentageRule.builder();
			return assignOutput(percentageRule, fpmlDataDocument);
		}
		
		protected PercentageRule.PercentageRuleBuilder assignOutput(PercentageRule.PercentageRuleBuilder percentageRule, DataDocument fpmlDataDocument) {
			percentageRule = toBuilder(PercentageRule.builder()
				.setPaymentPercent(null)
				.setNotionalAmountReferenceValue(mapMoney.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(percentageRule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
