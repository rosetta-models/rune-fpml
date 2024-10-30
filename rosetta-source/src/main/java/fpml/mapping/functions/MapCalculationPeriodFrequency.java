package fpml.mapping.functions;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCalculationPeriodFrequency.MapCalculationPeriodFrequencyDefault.class)
public abstract class MapCalculationPeriodFrequency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return calculationPeriodFrequency 
	*/
	public CalculationPeriodFrequency evaluate(DataDocument fpmlDataDocument) {
		CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequencyBuilder = doEvaluate(fpmlDataDocument);
		
		final CalculationPeriodFrequency calculationPeriodFrequency;
		if (calculationPeriodFrequencyBuilder == null) {
			calculationPeriodFrequency = null;
		} else {
			calculationPeriodFrequency = calculationPeriodFrequencyBuilder.build();
			objectValidator.validate(CalculationPeriodFrequency.class, calculationPeriodFrequency);
		}
		
		return calculationPeriodFrequency;
	}

	protected abstract CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCalculationPeriodFrequencyDefault extends MapCalculationPeriodFrequency {
		@Override
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency = CalculationPeriodFrequency.builder();
			return assignOutput(calculationPeriodFrequency, fpmlDataDocument);
		}
		
		protected CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder assignOutput(CalculationPeriodFrequency.CalculationPeriodFrequencyBuilder calculationPeriodFrequency, DataDocument fpmlDataDocument) {
			calculationPeriodFrequency = toBuilder(CalculationPeriodFrequency.builder()
				.setPeriodMultiplier(null)
				.setPeriod(null)
				.setRollConvention(null)
				.setBalanceOfFirstPeriod(null)
				.build());
			
			return Optional.ofNullable(calculationPeriodFrequency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
