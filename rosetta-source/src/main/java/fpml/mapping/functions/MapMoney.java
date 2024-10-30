package fpml.mapping.functions;

import cdm.observable.asset.Money;
import cdm.observable.asset.Money.MoneyBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMoney.MapMoneyDefault.class)
public abstract class MapMoney implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDatedValueList mapDatedValueList;
	@Inject protected MapFrequency mapFrequency;
	@Inject protected MapMeasure mapMeasure;
	@Inject protected MapUnitType mapUnitType;

	/**
	* @param fpmlDataDocument 
	* @return money 
	*/
	public Money evaluate(DataDocument fpmlDataDocument) {
		Money.MoneyBuilder moneyBuilder = doEvaluate(fpmlDataDocument);
		
		final Money money;
		if (moneyBuilder == null) {
			money = null;
		} else {
			money = moneyBuilder.build();
			objectValidator.validate(Money.class, money);
		}
		
		return money;
	}

	protected abstract Money.MoneyBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMoneyDefault extends MapMoney {
		@Override
		protected Money.MoneyBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Money.MoneyBuilder money = Money.builder();
			return assignOutput(money, fpmlDataDocument);
		}
		
		protected Money.MoneyBuilder assignOutput(Money.MoneyBuilder money, DataDocument fpmlDataDocument) {
			money = toBuilder(Money.builder()
				.setValue(null)
				.setUnit(mapUnitType.evaluate(fpmlDataDocument))
				.setDatedValue(new ArrayList(mapDatedValueList.evaluate(fpmlDataDocument)))
				.setMultiplier(mapMeasure.evaluate(fpmlDataDocument))
				.setFrequency(mapFrequency.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(money)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
