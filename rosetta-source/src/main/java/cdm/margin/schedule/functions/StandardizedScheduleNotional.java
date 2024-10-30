package cdm.margin.schedule.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.event.common.Trade;
import cdm.observable.asset.Money;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.qualification.functions.Qualify_BaseProduct_CrossCurrency;
import cdm.product.qualification.functions.Qualify_BaseProduct_EquityForward;
import cdm.product.qualification.functions.Qualify_BaseProduct_EquitySwap;
import cdm.product.qualification.functions.Qualify_BaseProduct_IRSwap;
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.qualification.functions.Qualify_Commodity_Option;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Index;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_IndexTranche;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_SingleName;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwaption;
import cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_Basket;
import cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_Index;
import cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_SingleName;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_SingleName;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_SingleName;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_SingleName;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDF;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDS;
import cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnCorrelation;
import cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnVariance;
import cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnVolatility;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Spot_Forward;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Swap;
import cdm.product.qualification.functions.Qualify_InterestRate_CapFloor;
import cdm.product.qualification.functions.Qualify_InterestRate_Fra;
import cdm.product.qualification.functions.Qualify_InterestRate_Option_Swaption;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StandardizedScheduleNotional.StandardizedScheduleNotionalDefault.class)
public abstract class StandardizedScheduleNotional implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsCreditNthToDefault isCreditNthToDefault;
	@Inject protected IsFXDeliverableOption isFXDeliverableOption;
	@Inject protected IsFXNonDeliverableOption isFXNonDeliverableOption;
	@Inject protected IsIRSwapWithCallableBermudanRightToEnterExitSwaps isIRSwapWithCallableBermudanRightToEnterExitSwaps;
	@Inject protected IsIRSwaptionStraddle isIRSwaptionStraddle;
	@Inject protected ProductDeepPathUtil productDeepPathUtil;
	@Inject protected Qualify_BaseProduct_CrossCurrency qualify_BaseProduct_CrossCurrency;
	@Inject protected Qualify_BaseProduct_EquityForward qualify_BaseProduct_EquityForward;
	@Inject protected Qualify_BaseProduct_EquitySwap qualify_BaseProduct_EquitySwap;
	@Inject protected Qualify_BaseProduct_IRSwap qualify_BaseProduct_IRSwap;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;
	@Inject protected Qualify_Commodity_Option qualify_Commodity_Option;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;
	@Inject protected Qualify_CreditDefaultSwap_Index qualify_CreditDefaultSwap_Index;
	@Inject protected Qualify_CreditDefaultSwap_IndexTranche qualify_CreditDefaultSwap_IndexTranche;
	@Inject protected Qualify_CreditDefaultSwap_SingleName qualify_CreditDefaultSwap_SingleName;
	@Inject protected Qualify_CreditDefaultSwaption qualify_CreditDefaultSwaption;
	@Inject protected Qualify_EquityOption_PriceReturnBasicPerformance_Basket qualify_EquityOption_PriceReturnBasicPerformance_Basket;
	@Inject protected Qualify_EquityOption_PriceReturnBasicPerformance_Index qualify_EquityOption_PriceReturnBasicPerformance_Index;
	@Inject protected Qualify_EquityOption_PriceReturnBasicPerformance_SingleName qualify_EquityOption_PriceReturnBasicPerformance_SingleName;
	@Inject protected Qualify_EquitySwap_ParameterReturnDividend_Basket qualify_EquitySwap_ParameterReturnDividend_Basket;
	@Inject protected Qualify_EquitySwap_ParameterReturnDividend_Index qualify_EquitySwap_ParameterReturnDividend_Index;
	@Inject protected Qualify_EquitySwap_ParameterReturnDividend_SingleName qualify_EquitySwap_ParameterReturnDividend_SingleName;
	@Inject protected Qualify_EquitySwap_ParameterReturnVariance_Basket qualify_EquitySwap_ParameterReturnVariance_Basket;
	@Inject protected Qualify_EquitySwap_ParameterReturnVariance_Index qualify_EquitySwap_ParameterReturnVariance_Index;
	@Inject protected Qualify_EquitySwap_ParameterReturnVariance_SingleName qualify_EquitySwap_ParameterReturnVariance_SingleName;
	@Inject protected Qualify_EquitySwap_ParameterReturnVolatility_Basket qualify_EquitySwap_ParameterReturnVolatility_Basket;
	@Inject protected Qualify_EquitySwap_ParameterReturnVolatility_Index qualify_EquitySwap_ParameterReturnVolatility_Index;
	@Inject protected Qualify_EquitySwap_ParameterReturnVolatility_SingleName qualify_EquitySwap_ParameterReturnVolatility_SingleName;
	@Inject protected Qualify_ForeignExchange_NDF qualify_ForeignExchange_NDF;
	@Inject protected Qualify_ForeignExchange_NDS qualify_ForeignExchange_NDS;
	@Inject protected Qualify_ForeignExchange_ParameterReturnCorrelation qualify_ForeignExchange_ParameterReturnCorrelation;
	@Inject protected Qualify_ForeignExchange_ParameterReturnVariance qualify_ForeignExchange_ParameterReturnVariance;
	@Inject protected Qualify_ForeignExchange_ParameterReturnVolatility qualify_ForeignExchange_ParameterReturnVolatility;
	@Inject protected Qualify_ForeignExchange_Spot_Forward qualify_ForeignExchange_Spot_Forward;
	@Inject protected Qualify_ForeignExchange_Swap qualify_ForeignExchange_Swap;
	@Inject protected Qualify_InterestRate_CapFloor qualify_InterestRate_CapFloor;
	@Inject protected Qualify_InterestRate_Fra qualify_InterestRate_Fra;
	@Inject protected Qualify_InterestRate_Option_Swaption qualify_InterestRate_Option_Swaption;
	@Inject protected StandardizedScheduleCommodityForwardNotionalAmount standardizedScheduleCommodityForwardNotionalAmount;
	@Inject protected StandardizedScheduleCommoditySwapFixedFloatNotionalAmount standardizedScheduleCommoditySwapFixedFloatNotionalAmount;
	@Inject protected StandardizedScheduleEquityForwardNotionalAmount standardizedScheduleEquityForwardNotionalAmount;
	@Inject protected StandardizedScheduleFXNDONotional standardizedScheduleFXNDONotional;
	@Inject protected StandardizedScheduleFXVarianceNotionalAmount standardizedScheduleFXVarianceNotionalAmount;
	@Inject protected StandardizedScheduleMonetaryNotionalFromResolvablePQ standardizedScheduleMonetaryNotionalFromResolvablePQ;
	@Inject protected StandardizedScheduleOptionNotionalAmount standardizedScheduleOptionNotionalAmount;
	@Inject protected StandardizedScheduleVarianceSwapNotionalAmount standardizedScheduleVarianceSwapNotionalAmount;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param trade 
	* @return notional 
	*/
	public BigDecimal evaluate(Trade trade) {
		BigDecimal notional = doEvaluate(trade);
		
		return notional;
	}

	protected abstract BigDecimal doEvaluate(Trade trade);

	protected abstract MapperS<? extends NonTransferableProduct> product(Trade trade);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(Trade trade);

	public static class StandardizedScheduleNotionalDefault extends StandardizedScheduleNotional {
		@Override
		protected BigDecimal doEvaluate(Trade trade) {
			BigDecimal notional = null;
			return assignOutput(notional, trade);
		}
		
		protected BigDecimal assignOutput(BigDecimal notional, Trade trade) {
			if (ComparisonResult.of(MapperS.of(qualify_BaseProduct_IRSwap.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(isIRSwapWithCallableBermudanRightToEnterExitSwaps.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
				final MapperC<InterestRatePayout> thenArg0 = economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", payout -> payout.getInterestRatePayout())
					.filterItemNullSafe(item -> exists(item.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue())).get());
				final MapperS<InterestRatePayout> thenArg1 = thenArg0
					.first();
				final MapperS<ResolvablePriceQuantity> thenArg2 = thenArg1.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
				notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg2.get())).get();
			} else {
				final Boolean boolean0 = qualify_BaseProduct_CrossCurrency.evaluate(economicTerms(trade).get());
				if ((boolean0 == null ? false : boolean0)) {
					final MapperC<InterestRatePayout> thenArg3 = economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", payout -> payout.getInterestRatePayout())
						.filterItemNullSafe(item -> true);
					final MapperS<InterestRatePayout> thenArg4 = thenArg3
						.first();
					final MapperS<ResolvablePriceQuantity> thenArg5 = thenArg4.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
					notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg5.get())).get();
				} else if (ComparisonResult.of(MapperS.of(qualify_InterestRate_Option_Swaption.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(isIRSwaptionStraddle.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
					final MapperC<InterestRatePayout> thenArg6 = MapperS.of(underlierForProduct.evaluate(product(trade).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", payout -> payout.getInterestRatePayout())
						.filterItemNullSafe(item -> exists(item.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue())).get());
					final MapperS<InterestRatePayout> thenArg7 = thenArg6
						.first();
					final MapperS<ResolvablePriceQuantity> thenArg8 = thenArg7.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
					notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg8.get())).get();
				} else {
					final Boolean boolean1 = qualify_InterestRate_CapFloor.evaluate(economicTerms(trade).get());
					if ((boolean1 == null ? false : boolean1)) {
						final MapperS<ResolvablePriceQuantity> thenArg9 = MapperS.of(economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", payout -> payout.getInterestRatePayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
						notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg9.get())).get();
					} else {
						final Boolean boolean2 = qualify_InterestRate_Fra.evaluate(economicTerms(trade).get());
						if ((boolean2 == null ? false : boolean2)) {
							final MapperC<InterestRatePayout> thenArg10 = economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", payout -> payout.getInterestRatePayout())
								.filterItemNullSafe(item -> exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification())).get());
							final MapperS<InterestRatePayout> thenArg11 = MapperS.of(thenArg10.get());
							final MapperS<ResolvablePriceQuantity> thenArg12 = thenArg11.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity());
							notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg12.get())).get();
						} else if (ComparisonResult.of(MapperS.of(qualify_CreditDefaultSwap_SingleName.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(isCreditNthToDefault.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
							final MapperS<ResolvablePriceQuantity> thenArg13 = economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", creditDefaultPayout -> creditDefaultPayout.getPriceQuantity());
							notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg13.get())).get();
						} else {
							final Boolean boolean3 = qualify_CreditDefaultSwaption.evaluate(economicTerms(trade).get());
							if ((boolean3 == null ? false : boolean3)) {
								final MapperS<ResolvablePriceQuantity> thenArg14 = MapperS.of(underlierForProduct.evaluate(product(trade).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", creditDefaultPayout -> creditDefaultPayout.getPriceQuantity());
								notional = MapperS.of(standardizedScheduleMonetaryNotionalFromResolvablePQ.evaluate(thenArg14.get())).get();
							} else {
								final Boolean boolean4 = qualify_ForeignExchange_Swap.evaluate(economicTerms(trade).get());
								if ((boolean4 == null ? false : boolean4)) {
									notional = MapperS.of(economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>mapC("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get();
								} else {
									final Boolean boolean5 = qualify_ForeignExchange_NDS.evaluate(economicTerms(trade).get());
									if ((boolean5 == null ? false : boolean5)) {
										notional = new BigDecimal("0.0");
									} else {
										final Boolean boolean6 = qualify_ForeignExchange_Spot_Forward.evaluate(economicTerms(trade).get());
										if ((boolean6 == null ? false : boolean6)) {
											notional = MapperS.of(economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>mapC("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get();
										} else {
											final Boolean boolean7 = qualify_ForeignExchange_NDF.evaluate(economicTerms(trade).get());
											if ((boolean7 == null ? false : boolean7)) {
												notional = MapperS.of(MapperS.of(economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>mapC("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).<CashSettlementTerms>mapC("getCashSettlementTerms", settlementTerms -> settlementTerms.getCashSettlementTerms()).<Money>map("getCashSettlementAmount", cashSettlementTerms -> cashSettlementTerms.getCashSettlementAmount()).get()).<BigDecimal>map("getValue", money -> money.getValue()).get();
											} else {
												final Boolean boolean8 = isFXDeliverableOption.evaluate(economicTerms(trade).get());
												if ((boolean8 == null ? false : boolean8)) {
													notional = MapperS.of(economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get();
												} else {
													final Boolean boolean9 = isFXNonDeliverableOption.evaluate(economicTerms(trade).get());
													if ((boolean9 == null ? false : boolean9)) {
														notional = MapperS.of(standardizedScheduleFXNDONotional.evaluate(economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout()).get())).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get();
													} else {
														final Boolean boolean10 = qualify_ForeignExchange_ParameterReturnVariance.evaluate(economicTerms(trade).get());
														if ((boolean10 == null ? false : boolean10)) {
															notional = standardizedScheduleFXVarianceNotionalAmount.evaluate(economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>mapC("getPerformancePayout", payout -> payout.getPerformancePayout()).get());
														} else {
															final Boolean boolean11 = qualify_ForeignExchange_ParameterReturnVolatility.evaluate(economicTerms(trade).get());
															if ((boolean11 == null ? false : boolean11)) {
																notional = new BigDecimal("0.0");
															} else {
																final Boolean boolean12 = qualify_ForeignExchange_ParameterReturnCorrelation.evaluate(economicTerms(trade).get());
																if ((boolean12 == null ? false : boolean12)) {
																	notional = new BigDecimal("0.0");
																} else if (ComparisonResult.of(MapperS.of(qualify_EquityOption_PriceReturnBasicPerformance_Basket.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_PriceReturnBasicPerformance_Index.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquityOption_PriceReturnBasicPerformance_SingleName.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
																	notional = standardizedScheduleOptionNotionalAmount.evaluate(economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout()).get());
																} else {
																	final Boolean boolean13 = qualify_BaseProduct_EquityForward.evaluate(economicTerms(trade).get());
																	if ((boolean13 == null ? false : boolean13)) {
																		notional = standardizedScheduleEquityForwardNotionalAmount.evaluate(economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>mapC("getSettlementPayout", payout -> payout.getSettlementPayout()).get());
																	} else if (ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnDividend_Basket.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnDividend_Index.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnDividend_SingleName.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
																		notional = new BigDecimal("0.0");
																	} else if (ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnVariance_Basket.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnVariance_Index.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnVariance_SingleName.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
																		notional = standardizedScheduleVarianceSwapNotionalAmount.evaluate(economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>mapC("getPerformancePayout", payout -> payout.getPerformancePayout()).get());
																	} else if (ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnVolatility_Basket.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnVolatility_Index.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_EquitySwap_ParameterReturnVolatility_SingleName.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
																		notional = new BigDecimal("0.0");
																	} else {
																		final Boolean boolean14 = qualify_BaseProduct_EquitySwap.evaluate(economicTerms(trade).get());
																		if ((boolean14 == null ? false : boolean14)) {
																			notional = new BigDecimal("0.0");
																		} else {
																			final Boolean boolean15 = qualify_Commodity_Forward.evaluate(economicTerms(trade).get());
																			if ((boolean15 == null ? false : boolean15)) {
																				notional = standardizedScheduleCommodityForwardNotionalAmount.evaluate(economicTerms(trade).get());
																			} else {
																				final Boolean boolean16 = qualify_Commodity_Option.evaluate(economicTerms(trade).get());
																				if ((boolean16 == null ? false : boolean16)) {
																					notional = standardizedScheduleOptionNotionalAmount.evaluate(economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout()).get());
																				} else {
																					final Boolean boolean17 = qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms(trade).get());
																					if ((boolean17 == null ? false : boolean17)) {
																						notional = standardizedScheduleCommoditySwapFixedFloatNotionalAmount.evaluate(economicTerms(trade).get());
																					} else {
																						final Boolean boolean18 = qualify_Commodity_Swap_Basis.evaluate(economicTerms(trade).get());
																						if ((boolean18 == null ? false : boolean18)) {
																							notional = new BigDecimal("0.0");
																						} else {
																							final Boolean boolean19 = qualify_Commodity_Swaption.evaluate(economicTerms(trade).get());
																							if ((boolean19 == null ? false : boolean19)) {
																								notional = standardizedScheduleCommoditySwapFixedFloatNotionalAmount.evaluate(MapperS.of(underlierForProduct.evaluate(product(trade).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).get());
																							} else {
																								notional = null;
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			return notional;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(Trade trade) {
			return MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct());
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(Trade trade) {
			return product(trade).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
	}
}
