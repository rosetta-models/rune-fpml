package fpml.confirmation.custom.functions;

import fpml.confirmation.*;
import fpml.confirmation.custom.ProductChoice;

public class ToProductChoiceImpl extends ToProductChoice {
    @Override
    protected ProductChoice.ProductChoiceBuilder doEvaluate(Product product) {
        ProductChoice.ProductChoiceBuilder builder = ProductChoice.builder();
        if (product instanceof BondOption) {
            return builder.setBondOption(((BondOption) product));
        } else if (product instanceof BrokerEquityOption) {
            return builder.setBrokerEquityOption(((BrokerEquityOption) product));
//        } else if (product instanceof BulletPayment) {
//            return builder.setBulletPayment(((BulletPayment) product));
        } else if (product instanceof CapFloor) {
            return builder.setCapFloor(((CapFloor) product));
        } else if (product instanceof CommodityBasketOption) {
            return builder.setCommodityBasketOption(((CommodityBasketOption) product));
//        } else if (product instanceof CommodityDigitalOption) {
//            return builder.setCommodityDigitalOption(((CommodityDigitalOption) product));
        } else if (product instanceof CommodityForward) {
            return builder.setCommodityForward(((CommodityForward) product));
        } else if (product instanceof CommodityOption) {
            return builder.setCommodityOption(((CommodityOption) product));
//        } else if (product instanceof CommodityPerformanceSwap) {
//            return builder.setCommodityPerformanceSwap(((CommodityPerformanceSwap) product));
        } else if (product instanceof CommoditySwap) {
            return builder.setCommoditySwap(((CommoditySwap) product));
        } else if (product instanceof CommoditySwaption) {
            return builder.setCommoditySwaption(((CommoditySwaption) product));
        } else if (product instanceof CorrelationSwap) {
            return builder.setCorrelationSwap(((CorrelationSwap) product));
        } else if (product instanceof CreditDefaultSwap) {
            return builder.setCreditDefaultSwap(((CreditDefaultSwap) product));
        } else if (product instanceof CreditDefaultSwapOption) {
            return builder.setCreditDefaultSwapOption(((CreditDefaultSwapOption) product));
        } else if (product instanceof DividendSwapOptionTransactionSupplement) {
            return builder.setDividendSwapOptionTransactionSupplement(((DividendSwapOptionTransactionSupplement) product));
        } else if (product instanceof DividendSwapTransactionSupplement) {
            return builder.setDividendSwapTransactionSupplement(((DividendSwapTransactionSupplement) product));
        } else if (product instanceof EquityForward) {
            return builder.setEquityForward(((EquityForward) product));
        } else if (product instanceof EquityOption) {
            return builder.setEquityOption(((EquityOption) product));
        } else if (product instanceof EquityOptionTransactionSupplement) {
            return builder.setEquityOptionTransactionSupplement(((EquityOptionTransactionSupplement) product));
        } else if (product instanceof EquitySwapTransactionSupplement) {
            return builder.setEquitySwapTransactionSupplement(((EquitySwapTransactionSupplement) product));
        } else if (product instanceof Fra) {
            return builder.setFra(((Fra) product));
//        } else if (product instanceof FxAccrualDigitalOption) {
//            return builder.setFxAccrualDigitalOption(((FxAccrualDigitalOption) product));
//        } else if (product instanceof FxAccrualForward) {
//            return builder.setFxAccrualForward(((FxAccrualForward) product));
//        } else if (product instanceof FxAccrualOption) {
//            return builder.setFxAccrualOption(((FxAccrualOption) product));
        } else if (product instanceof FxDigitalOption) {
            return builder.setFxDigitalOption(((FxDigitalOption) product));
//        } else if (product instanceof FxFlexibleForward) {
//            return builder.setFxFlexibleForward(((FxFlexibleForward) product));
//        } else if (product instanceof FxForwardVolatilityAgreement) {
//            return builder.setFxForwardVolatilityAgreement(((FxForwardVolatilityAgreement) product));
        } else if (product instanceof FxOption) {
            return builder.setFxOption(((FxOption) product));
//        } else if (product instanceof FxRangeAccrual) {
//            return builder.setFxRangeAccrual(((FxRangeAccrual) product));
        } else if (product instanceof FxSingleLeg) {
            return builder.setFxSingleLeg(((FxSingleLeg) product));
        } else if (product instanceof FxSwap) {
            return builder.setFxSwap(((FxSwap) product));
//        } else if (product instanceof FxTargetKnockoutForward) {
//            return builder.setFxTargetKnockoutForward(((FxTargetKnockoutForward) product));
        } else if (product instanceof FxVarianceSwap) {
            return builder.setFxVarianceSwap(((FxVarianceSwap) product));
        } else if (product instanceof FxVolatilitySwap) {
            return builder.setFxVolatilitySwap(((FxVolatilitySwap) product));
        } else if (product instanceof GenericProduct) {
            return builder.setGenericProduct(((GenericProduct) product));
//        } else if (product instanceof InstrumentTradeDetails) {
//            return builder.setInstrumentTradeDetails(((InstrumentTradeDetails) product));
//        } else if (product instanceof Repo) {
//            return builder.setRepo(((Repo) product));
        } else if (product instanceof ReturnSwap) {
            return builder.setReturnSwap(((ReturnSwap) product));
        } else if (product instanceof SecurityLending) {
            return builder.setSecurityLending(((SecurityLending) product));
//        } else if (product instanceof StandardProduct) {
//            return builder.setStandardProduct(((StandardProduct) product));
//        } else if (product instanceof Strategy) {
//            return builder.setStrategy(((Strategy) product));
        } else if (product instanceof Swap) {
            return builder.setSwap(((Swap) product));
        } else if (product instanceof Swaption) {
            return builder.setSwaption(((Swaption) product));
//        } else if (product instanceof TermDeposit) {
//            return builder.setTermDeposit(((TermDeposit) product));
        } else if (product instanceof VarianceOptionTransactionSupplement) {
            return builder.setVarianceOptionTransactionSupplement(((VarianceOptionTransactionSupplement) product));
        } else if (product instanceof VarianceSwap) {
            return builder.setVarianceSwap(((VarianceSwap) product));
        } else if (product instanceof VarianceSwapTransactionSupplement) {
            return builder.setVarianceSwapTransactionSupplement(((VarianceSwapTransactionSupplement) product));
        } else if (product instanceof VolatilitySwap) {
            return builder.setVolatilitySwap(((VolatilitySwap) product));
        } else if (product instanceof VolatilitySwapTransactionSupplement) {
            return builder.setVolatilitySwapTransactionSupplement(((VolatilitySwapTransactionSupplement) product));
        }
        return builder;
    }
}
