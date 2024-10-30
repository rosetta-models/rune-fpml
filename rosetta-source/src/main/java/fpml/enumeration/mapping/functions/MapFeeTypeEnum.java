package fpml.enumeration.mapping.functions;

import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapFeeTypeEnum.MapFeeTypeEnumDefault.class)
public abstract class MapFeeTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public FeeTypeEnum evaluate(String value) {
		FeeTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract FeeTypeEnum doEvaluate(String value);

	public static class MapFeeTypeEnumDefault extends MapFeeTypeEnum {
		@Override
		protected FeeTypeEnum doEvaluate(String value) {
			FeeTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected FeeTypeEnum assignOutput(FeeTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AmendmentFee"), CardinalityOperator.All).get()) {
				result = FeeTypeEnum.RENEGOTIATION;
			} else if (areEqual(switchArgument, MapperS.of("AssignmentFee"), CardinalityOperator.All).get()) {
				result = FeeTypeEnum.ASSIGNMENT;
			} else if (areEqual(switchArgument, MapperS.of("IncreaseFee"), CardinalityOperator.All).get()) {
				result = FeeTypeEnum.INCREASE;
			} else if (areEqual(switchArgument, MapperS.of("PartialTerminationFee"), CardinalityOperator.All).get()) {
				result = FeeTypeEnum.PARTIAL_TERMINATION;
			} else if (areEqual(switchArgument, MapperS.of("TerminationFee"), CardinalityOperator.All).get()) {
				result = FeeTypeEnum.TERMINATION;
			} else if (areEqual(switchArgument, MapperS.of("UPFRONT_FEE"), CardinalityOperator.All).get()) {
				result = FeeTypeEnum.UPFRONT;
			} else if (areEqual(switchArgument, MapperS.of("Upfront fee"), CardinalityOperator.All).get()) {
				result = FeeTypeEnum.UPFRONT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
