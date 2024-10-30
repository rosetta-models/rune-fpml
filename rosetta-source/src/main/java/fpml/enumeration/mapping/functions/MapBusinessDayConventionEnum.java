package fpml.enumeration.mapping.functions;

import cdm.base.datetime.BusinessDayConventionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapBusinessDayConventionEnum.MapBusinessDayConventionEnumDefault.class)
public abstract class MapBusinessDayConventionEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public BusinessDayConventionEnum evaluate(String value) {
		BusinessDayConventionEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract BusinessDayConventionEnum doEvaluate(String value);

	public static class MapBusinessDayConventionEnumDefault extends MapBusinessDayConventionEnum {
		@Override
		protected BusinessDayConventionEnum doEvaluate(String value) {
			BusinessDayConventionEnum result = null;
			return assignOutput(result, value);
		}
		
		protected BusinessDayConventionEnum assignOutput(BusinessDayConventionEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("FOLLOWING"), CardinalityOperator.All).get()) {
				result = BusinessDayConventionEnum.FOLLOWING;
			} else if (areEqual(switchArgument, MapperS.of("FRN"), CardinalityOperator.All).get()) {
				result = BusinessDayConventionEnum.FRN;
			} else if (areEqual(switchArgument, MapperS.of("MODFOLLOWING"), CardinalityOperator.All).get()) {
				result = BusinessDayConventionEnum.MODFOLLOWING;
			} else if (areEqual(switchArgument, MapperS.of("PRECEDING"), CardinalityOperator.All).get()) {
				result = BusinessDayConventionEnum.PRECEDING;
			} else if (areEqual(switchArgument, MapperS.of("MODPRECEDING"), CardinalityOperator.All).get()) {
				result = BusinessDayConventionEnum.MODPRECEDING;
			} else if (areEqual(switchArgument, MapperS.of("NEAREST"), CardinalityOperator.All).get()) {
				result = BusinessDayConventionEnum.NEAREST;
			} else if (areEqual(switchArgument, MapperS.of("NONE"), CardinalityOperator.All).get()) {
				result = BusinessDayConventionEnum.NONE;
			} else if (areEqual(switchArgument, MapperS.of("NotApplicable"), CardinalityOperator.All).get()) {
				result = BusinessDayConventionEnum.NOT_APPLICABLE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
