package fpml.enumeration.mapping.functions;

import cdm.observable.common.TimeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapTimeTypeEnum.MapTimeTypeEnumDefault.class)
public abstract class MapTimeTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public TimeTypeEnum evaluate(String value) {
		TimeTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract TimeTypeEnum doEvaluate(String value);

	public static class MapTimeTypeEnumDefault extends MapTimeTypeEnum {
		@Override
		protected TimeTypeEnum doEvaluate(String value) {
			TimeTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected TimeTypeEnum assignOutput(TimeTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Close"), CardinalityOperator.All).get()) {
				result = TimeTypeEnum.CLOSE;
			} else if (areEqual(switchArgument, MapperS.of("Open"), CardinalityOperator.All).get()) {
				result = TimeTypeEnum.OPEN;
			} else if (areEqual(switchArgument, MapperS.of("OSP"), CardinalityOperator.All).get()) {
				result = TimeTypeEnum.OSP;
			} else if (areEqual(switchArgument, MapperS.of("SpecificTime"), CardinalityOperator.All).get()) {
				result = TimeTypeEnum.SPECIFIC_TIME;
			} else if (areEqual(switchArgument, MapperS.of("XETRA"), CardinalityOperator.All).get()) {
				result = TimeTypeEnum.XETRA;
			} else if (areEqual(switchArgument, MapperS.of("DerivativesClose"), CardinalityOperator.All).get()) {
				result = TimeTypeEnum.DERIVATIVES_CLOSE;
			} else if (areEqual(switchArgument, MapperS.of("AsSpecifiedInMasterConfirmation"), CardinalityOperator.All).get()) {
				result = TimeTypeEnum.AS_SPECIFIED_IN_MASTER_CONFIRMATION;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
