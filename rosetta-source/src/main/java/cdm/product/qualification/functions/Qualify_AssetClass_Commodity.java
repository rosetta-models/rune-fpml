package cdm.product.qualification.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaCommodity;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.CommodityPayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TransferableProduct;
import cdm.product.template.Underlier;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_AssetClass_Commodity.Qualify_AssetClass_CommodityDefault.class)
public abstract class Qualify_AssetClass_Commodity implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ProductDeepPathUtil productDeepPathUtil;
	@Inject protected cdm.product.qualification.functions.Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;

	/**
	* @param economicTerms 
	* @return is_product 
	*/
	public Boolean evaluate(EconomicTerms economicTerms) {
		Boolean is_product = doEvaluate(economicTerms);
		
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);

	protected abstract MapperS<? extends Underlier> optionUnderlier(EconomicTerms economicTerms);

	protected abstract MapperS<? extends Underlier> settlementUnderlier(EconomicTerms economicTerms);

	public static class Qualify_AssetClass_CommodityDefault extends Qualify_AssetClass_Commodity {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			final ComparisonResult ifThenElseResult0;
			if (exists(optionUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct())).getOrDefault(false)) {
				ifThenElseResult0 = areEqual(MapperS.of(qualify_AssetClass_Commodity.evaluate(optionUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).get())), MapperS.of(true), CardinalityOperator.All);
			} else {
				ifThenElseResult0 = ComparisonResult.of(MapperS.of(false));
			}
			final ComparisonResult ifThenElseResult1;
			if (exists(settlementUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product))).getOrDefault(false)) {
				ifThenElseResult1 = areEqual(MapperS.of(qualify_AssetClass_Commodity.evaluate(settlementUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).get())), MapperS.of(true), CardinalityOperator.All);
			} else {
				ifThenElseResult1 = ComparisonResult.of(MapperS.of(false));
			}
			is_product = onlyExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()), Arrays.asList("interestRatePayout", "creditDefaultPayout", "optionPayout", "commodityPayout", "settlementPayout", "fixedPricePayout", "cashflow", "performancePayout", "assetPayout"), Arrays.asList("commodityPayout", "fixedPricePayout")).or(onlyExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()), Arrays.asList("interestRatePayout", "creditDefaultPayout", "optionPayout", "commodityPayout", "settlementPayout", "fixedPricePayout", "cashflow", "performancePayout", "assetPayout"), Arrays.asList("commodityPayout")).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>mapC("getCommodityPayout", payout -> payout.getCommodityPayout()).resultCount()), MapperS.of(2), CardinalityOperator.All))).or(onlyExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()), Arrays.asList("interestRatePayout", "creditDefaultPayout", "optionPayout", "commodityPayout", "settlementPayout", "fixedPricePayout", "cashflow", "performancePayout", "assetPayout"), Arrays.asList("optionPayout")).and(exists(optionUnderlier(economicTerms).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("getValue", _f->_f.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<FieldWithMetaCommodity>map("getCommodity", asset -> asset.getCommodity()).<Commodity>map("getValue", _f->_f.getValue())).or(exists(optionUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<TransferableProduct>map("getTransferableProduct", product -> product.getTransferableProduct()).<FieldWithMetaCommodity>map("getCommodity", transferableProduct -> transferableProduct.getCommodity()).<Commodity>map("getValue", _f->_f.getValue()))).or(ifThenElseResult0))).or(onlyExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()), Arrays.asList("interestRatePayout", "creditDefaultPayout", "optionPayout", "commodityPayout", "settlementPayout", "fixedPricePayout", "cashflow", "performancePayout", "assetPayout"), Arrays.asList("settlementPayout", "fixedPricePayout")).or(onlyExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()), Arrays.asList("interestRatePayout", "creditDefaultPayout", "optionPayout", "commodityPayout", "settlementPayout", "fixedPricePayout", "cashflow", "performancePayout", "assetPayout"), Arrays.asList("settlementPayout", "commodityPayout"))).and(exists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>mapC("getSettlementPayout", payout -> payout.getSettlementPayout()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("getValue", _f->_f.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<FieldWithMetaCommodity>map("getCommodity", asset -> asset.getCommodity()).<Commodity>map("getValue", _f->_f.getValue())).or(exists(settlementUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<TransferableProduct>map("getTransferableProduct", product -> product.getTransferableProduct()).<FieldWithMetaCommodity>map("getCommodity", transferableProduct -> transferableProduct.getCommodity()).<Commodity>map("getValue", _f->_f.getValue()))).or(ifThenElseResult1))).get();
			
			return is_product;
		}
		
		@Override
		protected MapperS<? extends Underlier> optionUnderlier(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout()).get()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier());
		}
		
		@Override
		protected MapperS<? extends Underlier> settlementUnderlier(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>mapC("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier());
		}
	}
}
