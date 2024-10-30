package cdm.margin.schedule.functions;

import cdm.base.math.Quantity;
import cdm.base.math.UnitType;
import cdm.event.common.Exposure;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.Valuation;
import cdm.event.common.ValuationTypeEnum;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.position.PortfolioState;
import cdm.event.position.Position;
import cdm.event.position.metafields.ReferenceWithMetaPortfolioState;
import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import cdm.margin.schedule.StandardizedScheduleInitialMargin;
import cdm.margin.schedule.StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder;
import cdm.margin.schedule.StandardizedScheduleProductClassEnum;
import cdm.margin.schedule.StandardizedScheduleTradeInfo;
import cdm.observable.asset.Money;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(GetNetInitialMarginFromExposure.GetNetInitialMarginFromExposureDefault.class)
public abstract class GetNetInitialMarginFromExposure implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected BuildStandardizedSchedule buildStandardizedSchedule;
	@Inject protected GetGrossInitialMarginFromStandardizedSchedule getGrossInitialMarginFromStandardizedSchedule;

	/**
	* @param exposure 
	* @return initialMargin 
	*/
	public StandardizedScheduleInitialMargin evaluate(Exposure exposure) {
		StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder initialMarginBuilder = doEvaluate(exposure);
		
		final StandardizedScheduleInitialMargin initialMargin;
		if (initialMarginBuilder == null) {
			initialMargin = null;
		} else {
			initialMargin = initialMarginBuilder.build();
			objectValidator.validate(StandardizedScheduleInitialMargin.class, initialMargin);
		}
		
		return initialMargin;
	}

	protected abstract StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder doEvaluate(Exposure exposure);

	protected abstract MapperS<? extends PortfolioState> tradePortfolio(Exposure exposure);

	protected abstract MapperC<? extends Position> positions(Exposure exposure);

	protected abstract MapperC<? extends StandardizedScheduleTradeInfo> tradeInitialMargin(Exposure exposure);

	protected abstract MapperS<BigDecimal> totalGIM(Exposure exposure);

	protected abstract MapperS<BigDecimal> netCurrentReplacementCost(Exposure exposure);

	protected abstract MapperS<BigDecimal> grossCurrentReplacementCost(Exposure exposure);

	protected abstract MapperS<BigDecimal> netToGrossRatio(Exposure exposure);

	public static class GetNetInitialMarginFromExposureDefault extends GetNetInitialMarginFromExposure {
		@Override
		protected StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder doEvaluate(Exposure exposure) {
			StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder initialMargin = StandardizedScheduleInitialMargin.builder();
			return assignOutput(initialMargin, exposure);
		}
		
		protected StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder assignOutput(StandardizedScheduleInitialMargin.StandardizedScheduleInitialMarginBuilder initialMargin, Exposure exposure) {
			initialMargin
				.addTradeInfo(tradeInitialMargin(exposure).getMulti());
			
			initialMargin
				.getOrCreateNetInitialMargin()
				.setValue(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(new BigDecimal("0.4")), totalGIM(exposure)), MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(new BigDecimal("0.6")), totalGIM(exposure)), netToGrossRatio(exposure))).get());
			
			initialMargin
				.getOrCreateNetInitialMargin()
				.getOrCreateUnit()
				.setCurrencyValue(distinct(tradeInitialMargin(exposure).<Quantity>map("getMarkToMarketValue", standardizedScheduleTradeInfo -> standardizedScheduleTradeInfo.getMarkToMarketValue()).<UnitType>map("getUnit", quantity -> quantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("getValue", _f->_f.getValue())).get());
			
			return Optional.ofNullable(initialMargin)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends PortfolioState> tradePortfolio(Exposure exposure) {
			return MapperS.of(exposure).<ReferenceWithMetaPortfolioState>map("getTradePortfolio", _exposure -> _exposure.getTradePortfolio()).<PortfolioState>map("getValue", _f->_f.getValue());
		}
		
		@Override
		protected MapperC<? extends Position> positions(Exposure exposure) {
			return tradePortfolio(exposure).<Position>mapC("getPositions", portfolioState -> portfolioState.getPositions());
		}
		
		@Override
		protected MapperC<? extends StandardizedScheduleTradeInfo> tradeInitialMargin(Exposure exposure) {
			return positions(exposure)
				.mapItem(item -> {
					final MapperC<Valuation> thenArg0 = item.<ReferenceWithMetaTradeState>map("getTradeReference", position -> position.getTradeReference()).<TradeState>map("getValue", _f->_f.getValue()).<Valuation>mapC("getValuationHistory", tradeState -> tradeState.getValuationHistory())
						.filterItemNullSafe(_item -> areEqual(_item.<ValuationTypeEnum>map("getMethod", valuation -> valuation.getMethod()), MapperS.of(ValuationTypeEnum.MARK_TO_MARKET), CardinalityOperator.All).get());
					final MapperS<Valuation> thenArg1 = MapperS.of(thenArg0.get());
					return MapperS.of(StandardizedScheduleTradeInfo.builder()
						.setAssetClass(MapperS.of(buildStandardizedSchedule.evaluate(item.<ReferenceWithMetaTradeState>map("getTradeReference", position -> position.getTradeReference()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).get())).<StandardizedScheduleAssetClassEnum>map("getAssetClass", standardizedSchedule -> standardizedSchedule.getAssetClass()).get())
						.setProductClass(MapperS.of(buildStandardizedSchedule.evaluate(item.<ReferenceWithMetaTradeState>map("getTradeReference", position -> position.getTradeReference()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).get())).<StandardizedScheduleProductClassEnum>map("getProductClass", standardizedSchedule -> standardizedSchedule.getProductClass()).get())
						.setGrossInitialMargin(getGrossInitialMarginFromStandardizedSchedule.evaluate(buildStandardizedSchedule.evaluate(item.<ReferenceWithMetaTradeState>map("getTradeReference", position -> position.getTradeReference()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).get())))
						.setMarkToMarketValue(thenArg1.<Money>map("getAmount", valuation -> valuation.getAmount()).get())
						.build());
				});
		}
		
		@Override
		protected MapperS<BigDecimal> totalGIM(Exposure exposure) {
			return tradeInitialMargin(exposure).<Quantity>map("getGrossInitialMargin", standardizedScheduleTradeInfo -> standardizedScheduleTradeInfo.getGrossInitialMargin()).<BigDecimal>map("getValue", quantity -> quantity.getValue())
				.sumBigDecimal();
		}
		
		@Override
		protected MapperS<BigDecimal> netCurrentReplacementCost(Exposure exposure) {
			return tradeInitialMargin(exposure).<Quantity>map("getMarkToMarketValue", standardizedScheduleTradeInfo -> standardizedScheduleTradeInfo.getMarkToMarketValue()).<BigDecimal>map("getValue", quantity -> quantity.getValue())
				.sumBigDecimal();
		}
		
		@Override
		protected MapperS<BigDecimal> grossCurrentReplacementCost(Exposure exposure) {
			final MapperC<Quantity> thenArg = tradeInitialMargin(exposure).<Quantity>map("getMarkToMarketValue", standardizedScheduleTradeInfo -> standardizedScheduleTradeInfo.getMarkToMarketValue())
				.filterItemNullSafe(item -> greaterThan(item.<BigDecimal>map("getValue", quantity -> quantity.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).get());
			return thenArg.<BigDecimal>map("getValue", quantity -> quantity.getValue())
				.sumBigDecimal();
		}
		
		@Override
		protected MapperS<BigDecimal> netToGrossRatio(Exposure exposure) {
			return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(netCurrentReplacementCost(exposure), grossCurrentReplacementCost(exposure));
		}
	}
}
