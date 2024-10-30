package fpml.enumeration.mapping.functions;

import cdm.observable.event.ShareExtraordinaryEventEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapShareExtraordinaryEventEnum.MapShareExtraordinaryEventEnumDefault.class)
public abstract class MapShareExtraordinaryEventEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public ShareExtraordinaryEventEnum evaluate(String value) {
		ShareExtraordinaryEventEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract ShareExtraordinaryEventEnum doEvaluate(String value);

	public static class MapShareExtraordinaryEventEnumDefault extends MapShareExtraordinaryEventEnum {
		@Override
		protected ShareExtraordinaryEventEnum doEvaluate(String value) {
			ShareExtraordinaryEventEnum result = null;
			return assignOutput(result, value);
		}
		
		protected ShareExtraordinaryEventEnum assignOutput(ShareExtraordinaryEventEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AlternativeObligation"), CardinalityOperator.All).get()) {
				result = ShareExtraordinaryEventEnum.ALTERNATIVE_OBLIGATION;
			} else if (areEqual(switchArgument, MapperS.of("CancellationAndPayment"), CardinalityOperator.All).get()) {
				result = ShareExtraordinaryEventEnum.CANCELLATION_AND_PAYMENT;
			} else if (areEqual(switchArgument, MapperS.of("OptionsExchange"), CardinalityOperator.All).get()) {
				result = ShareExtraordinaryEventEnum.OPTIONS_EXCHANGE;
			} else if (areEqual(switchArgument, MapperS.of("CalculationAgent"), CardinalityOperator.All).get()) {
				result = ShareExtraordinaryEventEnum.CALCULATION_AGENT;
			} else if (areEqual(switchArgument, MapperS.of("ModifiedCalculationAgent"), CardinalityOperator.All).get()) {
				result = ShareExtraordinaryEventEnum.MODIFIED_CALCULATION_AGENT;
			} else if (areEqual(switchArgument, MapperS.of("PartialCancellationAndPayment"), CardinalityOperator.All).get()) {
				result = ShareExtraordinaryEventEnum.PARTIAL_CANCELLATION_AND_PAYMENT;
			} else if (areEqual(switchArgument, MapperS.of("Component"), CardinalityOperator.All).get()) {
				result = ShareExtraordinaryEventEnum.COMPONENT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
