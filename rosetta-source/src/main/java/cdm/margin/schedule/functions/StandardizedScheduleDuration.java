package cdm.margin.schedule.functions;

import cdm.base.datetime.AdjustableDates;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.functions.ConvertToAdjustableOrAdjustedOrRelativeDate;
import cdm.event.common.Trade;
import cdm.product.qualification.functions.Qualify_BaseProduct_CrossCurrency;
import cdm.product.qualification.functions.Qualify_BaseProduct_IRSwap;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Index;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_IndexTranche;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_SingleName;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwaption;
import cdm.product.qualification.functions.Qualify_InterestRate_CapFloor;
import cdm.product.qualification.functions.Qualify_InterestRate_Fra;
import cdm.product.qualification.functions.Qualify_InterestRate_Option_DebtOption;
import cdm.product.qualification.functions.Qualify_InterestRate_Option_Swaption;
import cdm.product.template.EconomicTerms;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StandardizedScheduleDuration.StandardizedScheduleDurationDefault.class)
public abstract class StandardizedScheduleDuration implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableDatesResolution adjustableDatesResolution;
	@Inject protected AdjustableOrAdjustedOrRelativeDateResolution adjustableOrAdjustedOrRelativeDateResolution;
	@Inject protected AuxiliarEffectiveDate auxiliarEffectiveDate;
	@Inject protected AuxiliarTerminationDate auxiliarTerminationDate;
	@Inject protected ConvertToAdjustableOrAdjustedOrRelativeDate convertToAdjustableOrAdjustedOrRelativeDate;
	@Inject protected DateDifferenceYears dateDifferenceYears;
	@Inject protected IsCreditNthToDefault isCreditNthToDefault;
	@Inject protected IsIRSwapWithCallableBermudanRightToEnterExitSwaps isIRSwapWithCallableBermudanRightToEnterExitSwaps;
	@Inject protected IsIRSwaptionStraddle isIRSwaptionStraddle;
	@Inject protected ProductDeepPathUtil productDeepPathUtil;
	@Inject protected Qualify_BaseProduct_CrossCurrency qualify_BaseProduct_CrossCurrency;
	@Inject protected Qualify_BaseProduct_IRSwap qualify_BaseProduct_IRSwap;
	@Inject protected Qualify_CreditDefaultSwap_Index qualify_CreditDefaultSwap_Index;
	@Inject protected Qualify_CreditDefaultSwap_IndexTranche qualify_CreditDefaultSwap_IndexTranche;
	@Inject protected Qualify_CreditDefaultSwap_SingleName qualify_CreditDefaultSwap_SingleName;
	@Inject protected Qualify_CreditDefaultSwaption qualify_CreditDefaultSwaption;
	@Inject protected Qualify_InterestRate_CapFloor qualify_InterestRate_CapFloor;
	@Inject protected Qualify_InterestRate_Fra qualify_InterestRate_Fra;
	@Inject protected Qualify_InterestRate_Option_DebtOption qualify_InterestRate_Option_DebtOption;
	@Inject protected Qualify_InterestRate_Option_Swaption qualify_InterestRate_Option_Swaption;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param trade 
	* @return durationInYears 
	*/
	public BigDecimal evaluate(Trade trade) {
		BigDecimal durationInYears = doEvaluate(trade);
		
		return durationInYears;
	}

	protected abstract BigDecimal doEvaluate(Trade trade);

	protected abstract MapperS<? extends NonTransferableProduct> product(Trade trade);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(Trade trade);

	protected abstract MapperS<? extends Underlier> underlier(Trade trade);

	protected abstract MapperS<Date> transactionEffectiveDate(Trade trade);

	protected abstract MapperS<Date> transactionTerminationDate(Trade trade);

	protected abstract MapperS<BigDecimal> transactionTenorInYears(Trade trade);

	protected abstract MapperS<Date> underlyingTransactionEffectiveDate(Trade trade);

	protected abstract MapperS<Date> underlyingTransactionTerminationDate(Trade trade);

	protected abstract MapperS<BigDecimal> underlyingTransactionTenorInYears(Trade trade);

	protected abstract MapperS<Date> optionExpiry(Trade trade);

	protected abstract MapperS<BigDecimal> timeToOptionExpiryInYears(Trade trade);

	protected abstract MapperS<BigDecimal> genericDurationInYears(Trade trade);

	protected abstract MapperS<BigDecimal> auxiliarDurationInYears(Trade trade);

	public static class StandardizedScheduleDurationDefault extends StandardizedScheduleDuration {
		@Override
		protected BigDecimal doEvaluate(Trade trade) {
			BigDecimal durationInYears = null;
			return assignOutput(durationInYears, trade);
		}
		
		protected BigDecimal assignOutput(BigDecimal durationInYears, Trade trade) {
			if (exists(genericDurationInYears(trade)).getOrDefault(false)) {
				durationInYears = genericDurationInYears(trade).get();
			} else {
				durationInYears = auxiliarDurationInYears(trade).get();
			}
			
			return durationInYears;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(Trade trade) {
			return MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct());
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(Trade trade) {
			return MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
		
		@Override
		protected MapperS<? extends Underlier> underlier(Trade trade) {
			return MapperS.of(underlierForProduct.evaluate(product(trade).get()));
		}
		
		@Override
		protected MapperS<Date> transactionEffectiveDate(Trade trade) {
			return MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(economicTerms(trade).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).get())));
		}
		
		@Override
		protected MapperS<Date> transactionTerminationDate(Trade trade) {
			return MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(economicTerms(trade).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()).get())));
		}
		
		@Override
		protected MapperS<BigDecimal> transactionTenorInYears(Trade trade) {
			if (exists(transactionEffectiveDate(trade)).and(exists(transactionTerminationDate(trade))).getOrDefault(false)) {
				return MapperS.of(dateDifferenceYears.evaluate(transactionEffectiveDate(trade).get(), transactionTerminationDate(trade).get()));
			}
			return MapperS.<BigDecimal>ofNull();
		}
		
		@Override
		protected MapperS<Date> underlyingTransactionEffectiveDate(Trade trade) {
			return MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(underlier(trade).<Product>map("getProduct", _underlier -> _underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).get())));
		}
		
		@Override
		protected MapperS<Date> underlyingTransactionTerminationDate(Trade trade) {
			return MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(underlier(trade).<Product>map("getProduct", _underlier -> _underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", _product -> productDeepPathUtil.chooseEconomicTerms(_product)).<AdjustableOrRelativeDate>map("getTerminationDate", _economicTerms -> _economicTerms.getTerminationDate()).get())));
		}
		
		@Override
		protected MapperS<BigDecimal> underlyingTransactionTenorInYears(Trade trade) {
			if (exists(underlyingTransactionEffectiveDate(trade)).and(exists(underlyingTransactionTerminationDate(trade))).getOrDefault(false)) {
				return MapperS.of(dateDifferenceYears.evaluate(underlyingTransactionEffectiveDate(trade).get(), underlyingTransactionTerminationDate(trade).get()));
			}
			return MapperS.<BigDecimal>ofNull();
		}
		
		@Override
		protected MapperS<Date> optionExpiry(Trade trade) {
			final MapperS<ExerciseTerms> thenArg = MapperS.of(economicTerms(trade).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms());
			return thenArg
				.mapSingleToItem(item -> {
					if (areEqual(item.<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.AMERICAN), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(item.<AdjustableOrRelativeDate>mapC("getExpirationDate", exerciseTerms -> exerciseTerms.getExpirationDate()).get())));
					}
					if (areEqual(item.<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.EUROPEAN), CardinalityOperator.All).getOrDefault(false)) {
						return item.<AdjustableOrRelativeDate>mapC("getExpirationDate", exerciseTerms -> exerciseTerms.getExpirationDate())
							.max(_item -> MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(_item.get()))))
							.mapSingleToItem(_item -> MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(convertToAdjustableOrAdjustedOrRelativeDate.evaluate(_item.get()))));
					}
					if (areEqual(item.<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.BERMUDA), CardinalityOperator.All).getOrDefault(false)) {
						if (exists(item.<AdjustableOrRelativeDates>map("getExerciseDates", exerciseTerms -> exerciseTerms.getExerciseDates()).<AdjustableDates>map("getAdjustableDates", adjustableOrRelativeDates -> adjustableOrRelativeDates.getAdjustableDates())).getOrDefault(false)) {
							return MapperC.<Date>of(adjustableDatesResolution.evaluate(item.<AdjustableOrRelativeDates>map("getExerciseDates", exerciseTerms -> exerciseTerms.getExerciseDates()).<AdjustableDates>map("getAdjustableDates", adjustableOrRelativeDates -> adjustableOrRelativeDates.getAdjustableDates()).get()))
								.max(_item -> _item)
								.mapSingleToItem(_item -> _item);
						}
						return MapperS.<Date>ofNull();
					}
					return MapperS.<Date>ofNull();
				});
		}
		
		@Override
		protected MapperS<BigDecimal> timeToOptionExpiryInYears(Trade trade) {
			if (exists(transactionEffectiveDate(trade)).and(exists(optionExpiry(trade))).getOrDefault(false)) {
				return MapperS.of(dateDifferenceYears.evaluate(transactionEffectiveDate(trade).get(), optionExpiry(trade).get()));
			}
			return MapperS.<BigDecimal>ofNull();
		}
		
		@Override
		protected MapperS<BigDecimal> genericDurationInYears(Trade trade) {
			if (ComparisonResult.of(MapperS.of(qualify_BaseProduct_IRSwap.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(isIRSwapWithCallableBermudanRightToEnterExitSwaps.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_BaseProduct_CrossCurrency.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_InterestRate_Fra.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_CreditDefaultSwap_SingleName.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(isCreditNthToDefault.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
				return transactionTenorInYears(trade);
			}
			if (ComparisonResult.of(MapperS.of(qualify_InterestRate_Option_Swaption.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(qualify_CreditDefaultSwaption.evaluate(economicTerms(trade).get())))).or(ComparisonResult.of(MapperS.of(isIRSwaptionStraddle.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
				if (exists(timeToOptionExpiryInYears(trade)).and(exists(underlyingTransactionTenorInYears(trade))).getOrDefault(false)) {
					return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(timeToOptionExpiryInYears(trade), underlyingTransactionTenorInYears(trade));
				}
				if (exists(timeToOptionExpiryInYears(trade)).getOrDefault(false)) {
					return timeToOptionExpiryInYears(trade);
				}
				if (exists(underlyingTransactionTenorInYears(trade)).getOrDefault(false)) {
					return underlyingTransactionTenorInYears(trade);
				}
				return MapperS.<BigDecimal>ofNull();
			}
			if (ComparisonResult.of(MapperS.of(qualify_InterestRate_CapFloor.evaluate(economicTerms(trade).get()))).or(ComparisonResult.of(MapperS.of(qualify_InterestRate_Option_DebtOption.evaluate(economicTerms(trade).get())))).getOrDefault(false)) {
				return timeToOptionExpiryInYears(trade);
			}
			return MapperS.<BigDecimal>ofNull();
		}
		
		@Override
		protected MapperS<BigDecimal> auxiliarDurationInYears(Trade trade) {
			return MapperS.of(dateDifferenceYears.evaluate(auxiliarEffectiveDate.evaluate(trade), auxiliarTerminationDate.evaluate(trade)));
		}
	}
}
