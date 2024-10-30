package fpml.enumeration.mapping.functions;

import cdm.product.asset.FPVFinalPriceElectionFallbackEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapFPVFinalPriceElectionFallbackEnum.MapFPVFinalPriceElectionFallbackEnumDefault.class)
public abstract class MapFPVFinalPriceElectionFallbackEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public FPVFinalPriceElectionFallbackEnum evaluate(String value) {
		FPVFinalPriceElectionFallbackEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract FPVFinalPriceElectionFallbackEnum doEvaluate(String value);

	public static class MapFPVFinalPriceElectionFallbackEnumDefault extends MapFPVFinalPriceElectionFallbackEnum {
		@Override
		protected FPVFinalPriceElectionFallbackEnum doEvaluate(String value) {
			FPVFinalPriceElectionFallbackEnum result = null;
			return assignOutput(result, value);
		}
		
		protected FPVFinalPriceElectionFallbackEnum assignOutput(FPVFinalPriceElectionFallbackEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("FPVClose"), CardinalityOperator.All).get()) {
				result = FPVFinalPriceElectionFallbackEnum.FPV_CLOSE;
			} else if (areEqual(switchArgument, MapperS.of("FPVHedgeExecution"), CardinalityOperator.All).get()) {
				result = FPVFinalPriceElectionFallbackEnum.FPV_HEDGE_EXECUTION;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
