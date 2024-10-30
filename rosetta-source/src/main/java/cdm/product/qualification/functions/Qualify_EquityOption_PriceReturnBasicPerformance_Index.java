package cdm.product.qualification.functions;

import cdm.observable.asset.EquityIndex;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionFeature;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_EquityOption_PriceReturnBasicPerformance_Index.Qualify_EquityOption_PriceReturnBasicPerformance_IndexDefault.class)
public abstract class Qualify_EquityOption_PriceReturnBasicPerformance_Index implements RosettaFunction,IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;

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

	public static class Qualify_EquityOption_PriceReturnBasicPerformance_IndexDefault extends Qualify_EquityOption_PriceReturnBasicPerformance_Index {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			is_product = areEqual(MapperS.of(qualify_AssetClass_Equity.evaluate(economicTerms)), MapperS.of(true), CardinalityOperator.All).and(onlyExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()), Arrays.asList("interestRatePayout", "creditDefaultPayout", "optionPayout", "commodityPayout", "settlementPayout", "fixedPricePayout", "cashflow", "performancePayout", "assetPayout"), Arrays.asList("optionPayout"))).and(exists(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout()).get()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("getValue", _f->_f.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<EquityIndex>map("getEquityIndex", index -> index.getEquityIndex()))).and(notExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout()).<OptionFeature>map("getFeature", optionPayout -> optionPayout.getFeature())).or(onlyExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout()).<OptionFeature>map("getFeature", optionPayout -> optionPayout.getFeature()), Arrays.asList("fxFeature", "strategyFeature", "averagingFeature", "barrier", "knock", "passThrough"), Arrays.asList("averagingFeature")))).get();
			
			return is_product;
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
