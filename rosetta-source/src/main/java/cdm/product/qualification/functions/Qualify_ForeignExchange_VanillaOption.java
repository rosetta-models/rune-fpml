package cdm.product.qualification.functions;

import cdm.product.template.EconomicTerms;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.OptionFeature;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_ForeignExchange_VanillaOption.Qualify_ForeignExchange_VanillaOptionDefault.class)
public abstract class Qualify_ForeignExchange_VanillaOption implements RosettaFunction,IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_AssetClass_ForeignExchange qualify_AssetClass_ForeignExchange;

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

	public static class Qualify_ForeignExchange_VanillaOptionDefault extends Qualify_ForeignExchange_VanillaOption {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			is_product = areEqual(MapperS.of(qualify_AssetClass_ForeignExchange.evaluate(economicTerms)), MapperS.of(true), CardinalityOperator.All).and(onlyExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()), Arrays.asList("interestRatePayout", "creditDefaultPayout", "optionPayout", "commodityPayout", "settlementPayout", "fixedPricePayout", "cashflow", "performancePayout", "assetPayout"), Arrays.asList("optionPayout"))).and(notEqual(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.BERMUDA), CardinalityOperator.Any)).and(notExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout()).<OptionFeature>map("getFeature", optionPayout -> optionPayout.getFeature())).or(onlyExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout()).<OptionFeature>map("getFeature", optionPayout -> optionPayout.getFeature()), Arrays.asList("fxFeature", "strategyFeature", "averagingFeature", "barrier", "knock", "passThrough"), Arrays.asList("averagingFeature")))).get();
			
			return is_product;
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
