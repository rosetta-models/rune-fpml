package fpml.mapping.functions;

import cdm.base.math.MoneyRange;
import cdm.base.math.MoneyRange.MoneyRangeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMoneyRange.MapMoneyRangeDefault.class)
public abstract class MapMoneyRange implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoneyBound mapMoneyBound;

	/**
	* @param fpmlDataDocument 
	* @return moneyRange 
	*/
	public MoneyRange evaluate(DataDocument fpmlDataDocument) {
		MoneyRange.MoneyRangeBuilder moneyRangeBuilder = doEvaluate(fpmlDataDocument);
		
		final MoneyRange moneyRange;
		if (moneyRangeBuilder == null) {
			moneyRange = null;
		} else {
			moneyRange = moneyRangeBuilder.build();
			objectValidator.validate(MoneyRange.class, moneyRange);
		}
		
		return moneyRange;
	}

	protected abstract MoneyRange.MoneyRangeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMoneyRangeDefault extends MapMoneyRange {
		@Override
		protected MoneyRange.MoneyRangeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			MoneyRange.MoneyRangeBuilder moneyRange = MoneyRange.builder();
			return assignOutput(moneyRange, fpmlDataDocument);
		}
		
		protected MoneyRange.MoneyRangeBuilder assignOutput(MoneyRange.MoneyRangeBuilder moneyRange, DataDocument fpmlDataDocument) {
			moneyRange = toBuilder(MoneyRange.builder()
				.setLowerBound(mapMoneyBound.evaluate(fpmlDataDocument))
				.setUpperBound(mapMoneyBound.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(moneyRange)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
