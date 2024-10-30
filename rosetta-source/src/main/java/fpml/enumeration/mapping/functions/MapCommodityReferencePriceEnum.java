package fpml.enumeration.mapping.functions;

import cdm.observable.asset.CommodityReferencePriceEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapCommodityReferencePriceEnum.MapCommodityReferencePriceEnumDefault.class)
public abstract class MapCommodityReferencePriceEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public CommodityReferencePriceEnum evaluate(String value) {
		CommodityReferencePriceEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract CommodityReferencePriceEnum doEvaluate(String value);

	public static class MapCommodityReferencePriceEnumDefault extends MapCommodityReferencePriceEnum {
		@Override
		protected CommodityReferencePriceEnum doEvaluate(String value) {
			CommodityReferencePriceEnum result = null;
			return assignOutput(result, value);
		}
		
		protected CommodityReferencePriceEnum assignOutput(CommodityReferencePriceEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("ALUMINIUM ALLOY-LME 15 MONTH"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.ALUMINIUM_ALLOY_LME_15_MONTH;
			} else if (areEqual(switchArgument, MapperS.of("COAL-CENTRAL APPALACHIAN-NYMEX"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.COAL_CENTRAL_APPALACHIAN_NYMEX;
			} else if (areEqual(switchArgument, MapperS.of("COCOA-ICE"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.COCOA_ICE;
			} else if (areEqual(switchArgument, MapperS.of("COFFEE ARABICA-ICE"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.COFFEE_ARABICA_ICE;
			} else if (areEqual(switchArgument, MapperS.of("COFFEE ROBUSTA-ICE"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.COFFEE_ROBUSTA_ICE;
			} else if (areEqual(switchArgument, MapperS.of("COPPER-COMEX"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.COPPER_COMEX;
			} else if (areEqual(switchArgument, MapperS.of("CORN-CBOT"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.CORN_CBOT;
			} else if (areEqual(switchArgument, MapperS.of("COTTON NO. 2-ICE"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.COTTON_NO__2_ICE;
			} else if (areEqual(switchArgument, MapperS.of("ETHANOL-CBOT"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.ETHANOL_CBOT;
			} else if (areEqual(switchArgument, MapperS.of("FEEDER CATTLE-CME"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.FEEDER_CATTLE_CME;
			} else if (areEqual(switchArgument, MapperS.of("FROZEN CONCENTRATED ORANGE JUICE NO. 1-ICE"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.FROZEN_CONCENTRATED_ORANGE_JUICE_NO__1_ICE;
			} else if (areEqual(switchArgument, MapperS.of("GASOLINE-RBOB-NEW YORK-ICE"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.GASOLINE_RBOB_NEW_YORK_ICE;
			} else if (areEqual(switchArgument, MapperS.of("GASOLINE-RBOB-NEW YORK-NYMEX"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.GASOLINE_RBOB_NEW_YORK_NYMEX;
			} else if (areEqual(switchArgument, MapperS.of("GOLD-COMEX"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.GOLD_COMEX;
			} else if (areEqual(switchArgument, MapperS.of("HEATING OIL-NEW YORK-NYMEX"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.HEATING_OIL_NEW_YORK_NYMEX;
			} else if (areEqual(switchArgument, MapperS.of("LEAN HOGS-CME"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.LEAN_HOGS_CME;
			} else if (areEqual(switchArgument, MapperS.of("LIVE CATTLE-CME"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.LIVE_CATTLE_CME;
			} else if (areEqual(switchArgument, MapperS.of("LUMBER-CME"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.LUMBER_CME;
			} else if (areEqual(switchArgument, MapperS.of("MILK-CLASS III-CME"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.MILK_CLASS_III_CME;
			} else if (areEqual(switchArgument, MapperS.of("MILK-NONFAT-DRY-CME"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.MILK_NONFAT_DRY_CME;
			} else if (areEqual(switchArgument, MapperS.of("NATURAL GAS-NYMEX"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.NATURAL_GAS_NYMEX;
			} else if (areEqual(switchArgument, MapperS.of("NATURAL GAS-PEPL (TEXOK MAINLINE)-INSIDE FERC"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.NATURAL_GAS_PEPL__TEXOK_MAINLINE__INSIDE_FERC;
			} else if (areEqual(switchArgument, MapperS.of("NATURAL GAS-W. TEXAS (WAHA)-INSIDE FERC"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.NATURAL_GAS_W__TEXAS__WAHA__INSIDE_FERC;
			} else if (areEqual(switchArgument, MapperS.of("OATS-CBOT"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.OATS_CBOT;
			} else if (areEqual(switchArgument, MapperS.of("OIL-WTI-NYMEX"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.OIL_WTI_NYMEX;
			} else if (areEqual(switchArgument, MapperS.of("PALLADIUM-NYMEX"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.PALLADIUM_NYMEX;
			} else if (areEqual(switchArgument, MapperS.of("PLATINUM-NYMEX"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.PLATINUM_NYMEX;
			} else if (areEqual(switchArgument, MapperS.of("RICE-CBOT"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.RICE_CBOT;
			} else if (areEqual(switchArgument, MapperS.of("SILVER-COMEX"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.SILVER_COMEX;
			} else if (areEqual(switchArgument, MapperS.of("SOYBEANS-CBOT"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.SOYBEANS_CBOT;
			} else if (areEqual(switchArgument, MapperS.of("SOYBEAN MEAL-CBOT"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.SOYBEAN_MEAL_CBOT;
			} else if (areEqual(switchArgument, MapperS.of("SOYBEAN OIL-CBOT"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.SOYBEAN_OIL_CBOT;
			} else if (areEqual(switchArgument, MapperS.of("SUGAR # 11 (WORLD)-ICE"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.SUGAR___11__WORLD__ICE;
			} else if (areEqual(switchArgument, MapperS.of("SUGAR # 16 (US)-ICE"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.SUGAR___16__US__ICE;
			} else if (areEqual(switchArgument, MapperS.of("WHEAT-CBOT"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.WHEAT_CBOT;
			} else if (areEqual(switchArgument, MapperS.of("WHEAT HRW-KCBOT"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.WHEAT_HRW_KCBOT;
			} else if (areEqual(switchArgument, MapperS.of("WHEAT RED SPRING-MGE"), CardinalityOperator.All).get()) {
				result = CommodityReferencePriceEnum.WHEAT_RED_SPRING_MGE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
