package fpml.enumeration.mapping.functions;

import cdm.product.template.RepoDurationEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapRepoDurationEnum.MapRepoDurationEnumDefault.class)
public abstract class MapRepoDurationEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public RepoDurationEnum evaluate(String value) {
		RepoDurationEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract RepoDurationEnum doEvaluate(String value);

	public static class MapRepoDurationEnumDefault extends MapRepoDurationEnum {
		@Override
		protected RepoDurationEnum doEvaluate(String value) {
			RepoDurationEnum result = null;
			return assignOutput(result, value);
		}
		
		protected RepoDurationEnum assignOutput(RepoDurationEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Overnight"), CardinalityOperator.All).get()) {
				result = RepoDurationEnum.OVERNIGHT;
			} else if (areEqual(switchArgument, MapperS.of("Term"), CardinalityOperator.All).get()) {
				result = RepoDurationEnum.TERM;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
