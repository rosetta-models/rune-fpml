package fpml.mapping.functions;

import cdm.base.math.MoneyBound;
import cdm.base.math.MoneyBound.MoneyBoundBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMoneyBound.MapMoneyBoundDefault.class)
public abstract class MapMoneyBound implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoney mapMoney;

	/**
	* @param fpmlDataDocument 
	* @return moneyBound 
	*/
	public MoneyBound evaluate(DataDocument fpmlDataDocument) {
		MoneyBound.MoneyBoundBuilder moneyBoundBuilder = doEvaluate(fpmlDataDocument);
		
		final MoneyBound moneyBound;
		if (moneyBoundBuilder == null) {
			moneyBound = null;
		} else {
			moneyBound = moneyBoundBuilder.build();
			objectValidator.validate(MoneyBound.class, moneyBound);
		}
		
		return moneyBound;
	}

	protected abstract MoneyBound.MoneyBoundBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMoneyBoundDefault extends MapMoneyBound {
		@Override
		protected MoneyBound.MoneyBoundBuilder doEvaluate(DataDocument fpmlDataDocument) {
			MoneyBound.MoneyBoundBuilder moneyBound = MoneyBound.builder();
			return assignOutput(moneyBound, fpmlDataDocument);
		}
		
		protected MoneyBound.MoneyBoundBuilder assignOutput(MoneyBound.MoneyBoundBuilder moneyBound, DataDocument fpmlDataDocument) {
			moneyBound = toBuilder(MoneyBound.builder()
				.setMoney(mapMoney.evaluate(fpmlDataDocument))
				.setInclusive(null)
				.build());
			
			return Optional.ofNullable(moneyBound)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
