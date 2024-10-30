package fpml.enumeration.mapping.functions;

import cdm.product.asset.NegativeInterestRateTreatmentEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapNegativeInterestRateTreatmentEnum.MapNegativeInterestRateTreatmentEnumDefault.class)
public abstract class MapNegativeInterestRateTreatmentEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public NegativeInterestRateTreatmentEnum evaluate(String value) {
		NegativeInterestRateTreatmentEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract NegativeInterestRateTreatmentEnum doEvaluate(String value);

	public static class MapNegativeInterestRateTreatmentEnumDefault extends MapNegativeInterestRateTreatmentEnum {
		@Override
		protected NegativeInterestRateTreatmentEnum doEvaluate(String value) {
			NegativeInterestRateTreatmentEnum result = null;
			return assignOutput(result, value);
		}
		
		protected NegativeInterestRateTreatmentEnum assignOutput(NegativeInterestRateTreatmentEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("NegativeInterestRateMethod"), CardinalityOperator.All).get()) {
				result = NegativeInterestRateTreatmentEnum.NEGATIVE_INTEREST_RATE_METHOD;
			} else if (areEqual(switchArgument, MapperS.of("ZeroInterestRateMethod"), CardinalityOperator.All).get()) {
				result = NegativeInterestRateTreatmentEnum.ZERO_INTEREST_RATE_METHOD;
			} else if (areEqual(switchArgument, MapperS.of("ZeroInterestRateMethodExcludingSpread"), CardinalityOperator.All).get()) {
				result = NegativeInterestRateTreatmentEnum.ZERO_INTEREST_RATE_EXCLUDING_SPREAD_METHOD;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
