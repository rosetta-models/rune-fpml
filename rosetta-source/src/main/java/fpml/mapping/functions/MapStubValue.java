package fpml.mapping.functions;

import cdm.product.asset.StubValue;
import cdm.product.asset.StubValue.StubValueBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapStubValue.MapStubValueDefault.class)
public abstract class MapStubValue implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoney mapMoney;
	@Inject protected MapStubFloatingRateList mapStubFloatingRateList;

	/**
	* @param fpmlDataDocument 
	* @return stubValue 
	*/
	public StubValue evaluate(DataDocument fpmlDataDocument) {
		StubValue.StubValueBuilder stubValueBuilder = doEvaluate(fpmlDataDocument);
		
		final StubValue stubValue;
		if (stubValueBuilder == null) {
			stubValue = null;
		} else {
			stubValue = stubValueBuilder.build();
			objectValidator.validate(StubValue.class, stubValue);
		}
		
		return stubValue;
	}

	protected abstract StubValue.StubValueBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapStubValueDefault extends MapStubValue {
		@Override
		protected StubValue.StubValueBuilder doEvaluate(DataDocument fpmlDataDocument) {
			StubValue.StubValueBuilder stubValue = StubValue.builder();
			return assignOutput(stubValue, fpmlDataDocument);
		}
		
		protected StubValue.StubValueBuilder assignOutput(StubValue.StubValueBuilder stubValue, DataDocument fpmlDataDocument) {
			stubValue = toBuilder(StubValue.builder()
				.setFloatingRate(new ArrayList(mapStubFloatingRateList.evaluate(fpmlDataDocument)))
				.setStubRate(null)
				.setStubAmount(mapMoney.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(stubValue)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
