package fpml.enumeration.mapping.functions;

import cdm.product.asset.IndexAnnexSourceEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapIndexAnnexSourceEnum.MapIndexAnnexSourceEnumDefault.class)
public abstract class MapIndexAnnexSourceEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public IndexAnnexSourceEnum evaluate(String value) {
		IndexAnnexSourceEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract IndexAnnexSourceEnum doEvaluate(String value);

	public static class MapIndexAnnexSourceEnumDefault extends MapIndexAnnexSourceEnum {
		@Override
		protected IndexAnnexSourceEnum doEvaluate(String value) {
			IndexAnnexSourceEnum result = null;
			return assignOutput(result, value);
		}
		
		protected IndexAnnexSourceEnum assignOutput(IndexAnnexSourceEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("MasterConfirmation"), CardinalityOperator.All).get()) {
				result = IndexAnnexSourceEnum.MASTER_CONFIRMATION;
			} else if (areEqual(switchArgument, MapperS.of("Publisher"), CardinalityOperator.All).get()) {
				result = IndexAnnexSourceEnum.PUBLISHER;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
