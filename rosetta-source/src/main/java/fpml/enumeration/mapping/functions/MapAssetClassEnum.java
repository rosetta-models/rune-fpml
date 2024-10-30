package fpml.enumeration.mapping.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapAssetClassEnum.MapAssetClassEnumDefault.class)
public abstract class MapAssetClassEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public AssetClassEnum evaluate(String value) {
		AssetClassEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract AssetClassEnum doEvaluate(String value);

	public static class MapAssetClassEnumDefault extends MapAssetClassEnum {
		@Override
		protected AssetClassEnum doEvaluate(String value) {
			AssetClassEnum result = null;
			return assignOutput(result, value);
		}
		
		protected AssetClassEnum assignOutput(AssetClassEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Commodity"), CardinalityOperator.All).get()) {
				result = AssetClassEnum.COMMODITY;
			} else if (areEqual(switchArgument, MapperS.of("Credit"), CardinalityOperator.All).get()) {
				result = AssetClassEnum.CREDIT;
			} else if (areEqual(switchArgument, MapperS.of("Equity"), CardinalityOperator.All).get()) {
				result = AssetClassEnum.EQUITY;
			} else if (areEqual(switchArgument, MapperS.of("ForeignExchange"), CardinalityOperator.All).get()) {
				result = AssetClassEnum.FOREIGN_EXCHANGE;
			} else if (areEqual(switchArgument, MapperS.of("InterestRate"), CardinalityOperator.All).get()) {
				result = AssetClassEnum.INTEREST_RATE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
