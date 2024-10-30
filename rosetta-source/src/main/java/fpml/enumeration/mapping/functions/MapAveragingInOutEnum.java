package fpml.enumeration.mapping.functions;

import cdm.product.template.AveragingInOutEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapAveragingInOutEnum.MapAveragingInOutEnumDefault.class)
public abstract class MapAveragingInOutEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public AveragingInOutEnum evaluate(String value) {
		AveragingInOutEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract AveragingInOutEnum doEvaluate(String value);

	public static class MapAveragingInOutEnumDefault extends MapAveragingInOutEnum {
		@Override
		protected AveragingInOutEnum doEvaluate(String value) {
			AveragingInOutEnum result = null;
			return assignOutput(result, value);
		}
		
		protected AveragingInOutEnum assignOutput(AveragingInOutEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("In"), CardinalityOperator.All).get()) {
				result = AveragingInOutEnum.IN;
			} else if (areEqual(switchArgument, MapperS.of("Out"), CardinalityOperator.All).get()) {
				result = AveragingInOutEnum.OUT;
			} else if (areEqual(switchArgument, MapperS.of("Both"), CardinalityOperator.All).get()) {
				result = AveragingInOutEnum.BOTH;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
