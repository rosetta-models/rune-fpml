package cdm.margin.schedule.functions;

import cdm.base.math.Measure;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.common.settlement.FixedPrice;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.EconomicTerms;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StandardizedScheduleCommodityForwardNotionalAmount.StandardizedScheduleCommodityForwardNotionalAmountDefault.class)
public abstract class StandardizedScheduleCommodityForwardNotionalAmount implements RosettaFunction {

	/**
	* @param economicTerms 
	* @return amount 
	*/
	public BigDecimal evaluate(EconomicTerms economicTerms) {
		BigDecimal amount = doEvaluate(economicTerms);
		
		return amount;
	}

	protected abstract BigDecimal doEvaluate(EconomicTerms economicTerms);

	protected abstract MapperS<BigDecimal> forwardPrice(EconomicTerms economicTerms);

	protected abstract MapperS<BigDecimal> notionalQuantity(EconomicTerms economicTerms);

	public static class StandardizedScheduleCommodityForwardNotionalAmountDefault extends StandardizedScheduleCommodityForwardNotionalAmount {
		@Override
		protected BigDecimal doEvaluate(EconomicTerms economicTerms) {
			BigDecimal amount = null;
			return assignOutput(amount, economicTerms);
		}
		
		protected BigDecimal assignOutput(BigDecimal amount, EconomicTerms economicTerms) {
			amount = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(forwardPrice(economicTerms), notionalQuantity(economicTerms)).get();
			
			return amount;
		}
		
		@Override
		protected MapperS<BigDecimal> forwardPrice(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<FixedPricePayout>mapC("getFixedPricePayout", payout -> payout.getFixedPricePayout()).get()).<FixedPrice>map("getFixedPrice", fixedPricePayout -> fixedPricePayout.getFixedPrice()).<ReferenceWithMetaPriceSchedule>map("getPrice", fixedPrice -> fixedPrice.getPrice()).<PriceSchedule>map("getValue", _f->_f.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue());
		}
		
		@Override
		protected MapperS<BigDecimal> notionalQuantity(EconomicTerms economicTerms) {
			final MapperS<NonNegativeQuantitySchedule> thenArg = MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>mapC("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue());
			final MapperS<BigDecimal> ifThenElseResult;
			if (exists(thenArg.<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier())).getOrDefault(false)) {
				ifThenElseResult = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(thenArg.<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), thenArg.<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<BigDecimal>map("getValue", measure -> measure.getValue()));
			} else {
				ifThenElseResult = thenArg.<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue());
			}
			return ifThenElseResult;
		}
	}
}
