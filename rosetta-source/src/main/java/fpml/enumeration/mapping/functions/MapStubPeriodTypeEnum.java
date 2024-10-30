package fpml.enumeration.mapping.functions;

import cdm.product.common.schedule.StubPeriodTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapStubPeriodTypeEnum.MapStubPeriodTypeEnumDefault.class)
public abstract class MapStubPeriodTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public StubPeriodTypeEnum evaluate(String value) {
		StubPeriodTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract StubPeriodTypeEnum doEvaluate(String value);

	public static class MapStubPeriodTypeEnumDefault extends MapStubPeriodTypeEnum {
		@Override
		protected StubPeriodTypeEnum doEvaluate(String value) {
			StubPeriodTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected StubPeriodTypeEnum assignOutput(StubPeriodTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("ShortInitial"), CardinalityOperator.All).get()) {
				result = StubPeriodTypeEnum.SHORT_INITIAL;
			} else if (areEqual(switchArgument, MapperS.of("ShortFinal"), CardinalityOperator.All).get()) {
				result = StubPeriodTypeEnum.SHORT_FINAL;
			} else if (areEqual(switchArgument, MapperS.of("LongInitial"), CardinalityOperator.All).get()) {
				result = StubPeriodTypeEnum.LONG_INITIAL;
			} else if (areEqual(switchArgument, MapperS.of("LongFinal"), CardinalityOperator.All).get()) {
				result = StubPeriodTypeEnum.LONG_FINAL;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
