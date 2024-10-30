package fpml.enumeration.mapping.functions;

import cdm.product.template.ExpirationTimeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapExpirationTimeTypeEnum.MapExpirationTimeTypeEnumDefault.class)
public abstract class MapExpirationTimeTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public ExpirationTimeTypeEnum evaluate(String value) {
		ExpirationTimeTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract ExpirationTimeTypeEnum doEvaluate(String value);

	public static class MapExpirationTimeTypeEnumDefault extends MapExpirationTimeTypeEnum {
		@Override
		protected ExpirationTimeTypeEnum doEvaluate(String value) {
			ExpirationTimeTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected ExpirationTimeTypeEnum assignOutput(ExpirationTimeTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Close"), CardinalityOperator.All).get()) {
				result = ExpirationTimeTypeEnum.CLOSE;
			} else if (areEqual(switchArgument, MapperS.of("Open"), CardinalityOperator.All).get()) {
				result = ExpirationTimeTypeEnum.OPEN;
			} else if (areEqual(switchArgument, MapperS.of("OSP"), CardinalityOperator.All).get()) {
				result = ExpirationTimeTypeEnum.OSP;
			} else if (areEqual(switchArgument, MapperS.of("SpecificTime"), CardinalityOperator.All).get()) {
				result = ExpirationTimeTypeEnum.SPECIFIC_TIME;
			} else if (areEqual(switchArgument, MapperS.of("XETRA"), CardinalityOperator.All).get()) {
				result = ExpirationTimeTypeEnum.XETRA;
			} else if (areEqual(switchArgument, MapperS.of("DerivativesClose"), CardinalityOperator.All).get()) {
				result = ExpirationTimeTypeEnum.DERIVATIVES_CLOSE;
			} else if (areEqual(switchArgument, MapperS.of("AsSpecifiedInMasterConfirmation"), CardinalityOperator.All).get()) {
				result = ExpirationTimeTypeEnum.AS_SPECIFIED_IN_MASTER_CONFIRMATION;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
