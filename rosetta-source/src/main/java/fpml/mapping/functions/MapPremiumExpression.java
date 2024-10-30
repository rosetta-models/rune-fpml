package fpml.mapping.functions;

import cdm.observable.asset.PremiumExpression;
import cdm.observable.asset.PremiumExpression.PremiumExpressionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPremiumExpression.MapPremiumExpressionDefault.class)
public abstract class MapPremiumExpression implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoney mapMoney;

	/**
	* @param fpmlDataDocument 
	* @return premiumExpression 
	*/
	public PremiumExpression evaluate(DataDocument fpmlDataDocument) {
		PremiumExpression.PremiumExpressionBuilder premiumExpressionBuilder = doEvaluate(fpmlDataDocument);
		
		final PremiumExpression premiumExpression;
		if (premiumExpressionBuilder == null) {
			premiumExpression = null;
		} else {
			premiumExpression = premiumExpressionBuilder.build();
			objectValidator.validate(PremiumExpression.class, premiumExpression);
		}
		
		return premiumExpression;
	}

	protected abstract PremiumExpression.PremiumExpressionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPremiumExpressionDefault extends MapPremiumExpression {
		@Override
		protected PremiumExpression.PremiumExpressionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PremiumExpression.PremiumExpressionBuilder premiumExpression = PremiumExpression.builder();
			return assignOutput(premiumExpression, fpmlDataDocument);
		}
		
		protected PremiumExpression.PremiumExpressionBuilder assignOutput(PremiumExpression.PremiumExpressionBuilder premiumExpression, DataDocument fpmlDataDocument) {
			premiumExpression = toBuilder(PremiumExpression.builder()
				.setPremiumType(null)
				.setPricePerOption(mapMoney.evaluate(fpmlDataDocument))
				.setPercentageOfNotional(null)
				.build());
			
			return Optional.ofNullable(premiumExpression)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
