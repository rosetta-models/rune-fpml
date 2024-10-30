package fpml.enumeration.mapping.functions;

import cdm.observable.asset.CsaTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapCsaTypeEnum.MapCsaTypeEnumDefault.class)
public abstract class MapCsaTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public CsaTypeEnum evaluate(String value) {
		CsaTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract CsaTypeEnum doEvaluate(String value);

	public static class MapCsaTypeEnumDefault extends MapCsaTypeEnum {
		@Override
		protected CsaTypeEnum doEvaluate(String value) {
			CsaTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected CsaTypeEnum assignOutput(CsaTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("NoCSA"), CardinalityOperator.All).get()) {
				result = CsaTypeEnum.NO_CSA;
			} else if (areEqual(switchArgument, MapperS.of("ExistingCSA"), CardinalityOperator.All).get()) {
				result = CsaTypeEnum.EXISTING_CSA;
			} else if (areEqual(switchArgument, MapperS.of("ReferenceVMCSA"), CardinalityOperator.All).get()) {
				result = CsaTypeEnum.REFERENCE_VMCSA;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
