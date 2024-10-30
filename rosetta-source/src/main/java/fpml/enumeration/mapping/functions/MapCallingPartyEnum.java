package fpml.enumeration.mapping.functions;

import cdm.product.template.CallingPartyEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapCallingPartyEnum.MapCallingPartyEnumDefault.class)
public abstract class MapCallingPartyEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public CallingPartyEnum evaluate(String value) {
		CallingPartyEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract CallingPartyEnum doEvaluate(String value);

	public static class MapCallingPartyEnumDefault extends MapCallingPartyEnum {
		@Override
		protected CallingPartyEnum doEvaluate(String value) {
			CallingPartyEnum result = null;
			return assignOutput(result, value);
		}
		
		protected CallingPartyEnum assignOutput(CallingPartyEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("InitialBuyer"), CardinalityOperator.All).get()) {
				result = CallingPartyEnum.INITIAL_BUYER;
			} else if (areEqual(switchArgument, MapperS.of("InitialSeller"), CardinalityOperator.All).get()) {
				result = CallingPartyEnum.INITIAL_SELLER;
			} else if (areEqual(switchArgument, MapperS.of("Either"), CardinalityOperator.All).get()) {
				result = CallingPartyEnum.EITHER;
			} else if (areEqual(switchArgument, MapperS.of("AsDefinedInMasterAgreement"), CardinalityOperator.All).get()) {
				result = CallingPartyEnum.AS_DEFINED_IN_MASTER_AGREEMENT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
