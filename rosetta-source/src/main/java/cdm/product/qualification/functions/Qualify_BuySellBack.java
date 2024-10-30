package cdm.product.qualification.functions;

import cdm.event.common.CollateralPortfolio;
import cdm.event.common.CollateralPosition;
import cdm.event.common.metafields.ReferenceWithMetaCollateralPortfolio;
import cdm.product.asset.InterestRatePayout;
import cdm.product.collateral.Collateral;
import cdm.product.template.AssetPayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.RepoTypeEnum;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_BuySellBack.Qualify_BuySellBackDefault.class)
public abstract class Qualify_BuySellBack implements RosettaFunction,IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ProductDeepPathUtil productDeepPathUtil;

	/**
	* @param economicTerms 
	* @return is_product 
	*/
	@Override
	public Boolean evaluate(EconomicTerms economicTerms) {
		Boolean is_product = doEvaluate(economicTerms);
		
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);

	public static class Qualify_BuySellBackDefault extends Qualify_BuySellBack {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			is_product = onlyExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()), Arrays.asList("interestRatePayout", "creditDefaultPayout", "optionPayout", "commodityPayout", "settlementPayout", "fixedPricePayout", "cashflow", "performancePayout", "assetPayout"), Arrays.asList("interestRatePayout")).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", payout -> payout.getInterestRatePayout()).resultCount()), MapperS.of(1), CardinalityOperator.All)).and(exists(MapperS.of(economicTerms).<Collateral>map("getCollateral", _economicTerms -> _economicTerms.getCollateral()).<ReferenceWithMetaCollateralPortfolio>mapC("getCollateralPortfolio", collateral -> collateral.getCollateralPortfolio()).<CollateralPortfolio>map("getValue", _f->_f.getValue()).<CollateralPosition>mapC("getCollateralPosition", collateralPortfolio -> collateralPortfolio.getCollateralPosition()).<Product>map("getProduct", collateralPosition -> collateralPosition.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<AssetPayout>mapC("getAssetPayout", payout -> payout.getAssetPayout()))).and(areEqual(MapperS.of(economicTerms).<Collateral>map("getCollateral", _economicTerms -> _economicTerms.getCollateral()).<ReferenceWithMetaCollateralPortfolio>mapC("getCollateralPortfolio", collateral -> collateral.getCollateralPortfolio()).<CollateralPortfolio>map("getValue", _f->_f.getValue()).<CollateralPosition>mapC("getCollateralPosition", collateralPortfolio -> collateralPortfolio.getCollateralPosition()).<Product>map("getProduct", collateralPosition -> collateralPosition.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<AssetPayout>mapC("getAssetPayout", payout -> payout.getAssetPayout()).<RepoTypeEnum>map("getRepoType", assetPayout -> assetPayout.getRepoType()), MapperS.of(RepoTypeEnum.BUY_SELL_BACK), CardinalityOperator.Any)).get();
			
			return is_product;
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
