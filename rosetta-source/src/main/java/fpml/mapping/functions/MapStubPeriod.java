package fpml.mapping.functions;

import cdm.product.common.schedule.StubPeriod;
import cdm.product.common.schedule.StubPeriod.StubPeriodBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapStubPeriod.MapStubPeriodDefault.class)
public abstract class MapStubPeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationPeriodDates mapCalculationPeriodDates;
	@Inject protected MapStubValue mapStubValue;

	/**
	* @param fpmlDataDocument 
	* @return stubPeriod 
	*/
	public StubPeriod evaluate(DataDocument fpmlDataDocument) {
		StubPeriod.StubPeriodBuilder stubPeriodBuilder = doEvaluate(fpmlDataDocument);
		
		final StubPeriod stubPeriod;
		if (stubPeriodBuilder == null) {
			stubPeriod = null;
		} else {
			stubPeriod = stubPeriodBuilder.build();
			objectValidator.validate(StubPeriod.class, stubPeriod);
		}
		
		return stubPeriod;
	}

	protected abstract StubPeriod.StubPeriodBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapStubPeriodDefault extends MapStubPeriod {
		@Override
		protected StubPeriod.StubPeriodBuilder doEvaluate(DataDocument fpmlDataDocument) {
			StubPeriod.StubPeriodBuilder stubPeriod = StubPeriod.builder();
			return assignOutput(stubPeriod, fpmlDataDocument);
		}
		
		protected StubPeriod.StubPeriodBuilder assignOutput(StubPeriod.StubPeriodBuilder stubPeriod, DataDocument fpmlDataDocument) {
			stubPeriod = toBuilder(StubPeriod.builder()
				.setCalculationPeriodDatesReferenceValue(mapCalculationPeriodDates.evaluate(fpmlDataDocument))
				.setInitialStub(mapStubValue.evaluate(fpmlDataDocument))
				.setFinalStub(mapStubValue.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(stubPeriod)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
