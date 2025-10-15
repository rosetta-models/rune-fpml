package fpml.custom.functions;

import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.com.*;
import fpml.consolidated.correlation.swaps.CorrelationLeg;
import fpml.consolidated.dividend.swaps.DividendLeg;
import fpml.consolidated.dividend.swaps.FixedPaymentLeg;
import fpml.consolidated.eq.shared.InterestLeg;
import fpml.consolidated.eq.shared.ReturnLeg;
import fpml.consolidated.fx.FxSwapLeg;
import fpml.consolidated.ird.InterestRateStream;
import fpml.consolidated.repo.RepoFarLeg;
import fpml.consolidated.repo.RepoNearLeg;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.UnderlyerInterestLeg;
import fpml.consolidated.variance.swaps.VarianceLeg;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import fpml.custom.LegChoice;

public class ToLegChoiceImpl extends ToLegChoice {

    @Override
    protected LegChoice.LegChoiceBuilder doEvaluate(Leg leg) {
        LegChoice.LegChoiceBuilder builder = LegChoice.builder();

        if (leg instanceof RepoNearLeg) {
            builder.setRepoNearLeg((RepoNearLeg) leg);
        } else if (leg instanceof RepoFarLeg) {
            builder.setRepoFarLeg((RepoFarLeg) leg);
        } else if (leg instanceof ReturnLeg) {
            builder.setReturnLeg((ReturnLeg) leg);
        } else if (leg instanceof InterestLeg) {
            builder.setInterestLeg((InterestLeg) leg);
        } else if (leg instanceof FixedPaymentLeg) {
            builder.setFixedPaymentLeg((FixedPaymentLeg) leg);
        } else if (leg instanceof UnderlyerInterestLeg) {
            builder.setUnderlyerInterestLeg((UnderlyerInterestLeg) leg);
        } else if (leg instanceof DividendLeg) {
            builder.setDividendLeg((DividendLeg) leg);
        } else if (leg instanceof VolatilityLeg) {
            builder.setVolatilityLeg((VolatilityLeg) leg);
        } else if (leg instanceof CorrelationLeg) {
            builder.setCorrelationLeg((CorrelationLeg) leg);
        } else if (leg instanceof VarianceLeg) {
            builder.setVarianceLeg((VarianceLeg) leg);
        } else if (leg instanceof FeeLeg) {
            builder.setFeeLeg((FeeLeg) leg);
        } else if (leg instanceof FxSwapLeg) {
            builder.setFxSwapLeg((FxSwapLeg) leg);
        } else if (leg instanceof InterestRateStream) {
            builder.setInterestRateStream((InterestRateStream) leg);
        } else if (leg instanceof AveragePriceLeg) {
            builder.setAveragePriceLeg((AveragePriceLeg) leg);
        } else if (leg instanceof FixedLeg) {
            builder.setFixedLeg((FixedLeg) leg);
        } else if (leg instanceof WeatherLeg) {
            builder.setWeatherLeg((WeatherLeg) leg);
        } else if (leg instanceof FloatingLeg) {
            builder.setFloatingLeg((FloatingLeg) leg);
        } else if (leg instanceof NonPeriodicFixedPriceLeg) {
            builder.setNonPeriodicFixedPriceLeg((NonPeriodicFixedPriceLeg) leg);
        } else if (leg instanceof MetalPhysicalLeg) {
            builder.setMetalPhysicalLeg((MetalPhysicalLeg) leg);
        } else if (leg instanceof BullionPhysicalLeg) {
            builder.setBullionPhysicalLeg((BullionPhysicalLeg) leg);
        } else if (leg instanceof GasPhysicalLeg) {
            builder.setGasPhysicalLeg((GasPhysicalLeg) leg);
        } else if (leg instanceof OilPhysicalLeg) {
            builder.setOilPhysicalLeg((OilPhysicalLeg) leg);
        } else if (leg instanceof ElectricityPhysicalLeg) {
            builder.setElectricityPhysicalLeg((ElectricityPhysicalLeg) leg);
        } else if (leg instanceof EnvironmentalPhysicalLeg) {
            builder.setEnvironmentalPhysicalLeg((EnvironmentalPhysicalLeg) leg);
        } else if (leg instanceof CoalPhysicalLeg) {
            builder.setCoalPhysicalLeg((CoalPhysicalLeg) leg);
        } else if (leg instanceof CommodityVarianceLeg) {
            builder.setCommodityVarianceLeg((CommodityVarianceLeg) leg);
        } else if (leg instanceof CommodityInterestLeg) {
            builder.setCommodityInterestLeg((CommodityInterestLeg) leg);
        } else if (leg instanceof CommodityReturnLeg) {
            builder.setCommodityReturnLeg((CommodityReturnLeg) leg);
        }

        return builder;
    }
}