package fpml.enumeration.mapping.functions;

import cdm.legaldocumentation.common.ResourceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapResourceTypeEnum.MapResourceTypeEnumDefault.class)
public abstract class MapResourceTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public ResourceTypeEnum evaluate(String value) {
		ResourceTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract ResourceTypeEnum doEvaluate(String value);

	public static class MapResourceTypeEnumDefault extends MapResourceTypeEnum {
		@Override
		protected ResourceTypeEnum doEvaluate(String value) {
			ResourceTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected ResourceTypeEnum assignOutput(ResourceTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Confirmation"), CardinalityOperator.All).get()) {
				result = ResourceTypeEnum.CONFIRMATION;
			} else if (areEqual(switchArgument, MapperS.of("SupplementalMaterialEconomicTerms"), CardinalityOperator.All).get()) {
				result = ResourceTypeEnum.SUPPLEMENTAL_MATERIAL_ECONOMIC_TERMS;
			} else if (areEqual(switchArgument, MapperS.of("TermSheet"), CardinalityOperator.All).get()) {
				result = ResourceTypeEnum.TERM_SHEET;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
