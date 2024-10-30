package cdm.product.qualification.functions;

import cdm.base.staticdata.asset.common.FundProductTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.SecurityTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_SecurityTypeEquity.Qualify_SecurityTypeEquityDefault.class)
public abstract class Qualify_SecurityTypeEquity implements RosettaFunction {

	/**
	* @param security 
	* @return is_equity 
	*/
	public Boolean evaluate(Security security) {
		Boolean is_equity = doEvaluate(security);
		
		return is_equity;
	}

	protected abstract Boolean doEvaluate(Security security);

	public static class Qualify_SecurityTypeEquityDefault extends Qualify_SecurityTypeEquity {
		@Override
		protected Boolean doEvaluate(Security security) {
			Boolean is_equity = null;
			return assignOutput(is_equity, security);
		}
		
		protected Boolean assignOutput(Boolean is_equity, Security security) {
			is_equity = areEqual(MapperS.of(security).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.EQUITY), CardinalityOperator.All).or(areEqual(MapperS.of(security).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.FUND), CardinalityOperator.All).and(areEqual(MapperS.of(security).<FundProductTypeEnum>map("getFundType", _security -> _security.getFundType()), MapperS.of(FundProductTypeEnum.EXCHANGE_TRADED_FUND), CardinalityOperator.All))).or(areEqual(MapperS.of(security).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.FUND), CardinalityOperator.All).and(areEqual(MapperS.of(security).<FundProductTypeEnum>map("getFundType", _security -> _security.getFundType()), MapperS.of(FundProductTypeEnum.MUTUAL_FUND), CardinalityOperator.All))).or(areEqual(MapperS.of(security).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.WARRANT), CardinalityOperator.All)).get();
			
			return is_equity;
		}
	}
}
