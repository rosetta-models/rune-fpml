package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.CommodityBasketByNotional;
import fpml.confirmation.CommodityBasketByPercentage;
import fpml.confirmation.CommodityBasketModel;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class CommodityBasketModelDeepPathUtil {
	public String chooseId(CommodityBasketModel commodityBasketModel) {
		final MapperS<CommodityBasketByNotional> notionalQuantityBasket = MapperS.of(commodityBasketModel).<CommodityBasketByNotional>map("getNotionalQuantityBasket", _commodityBasketModel -> _commodityBasketModel.getNotionalQuantityBasket());
		if (exists(notionalQuantityBasket).getOrDefault(false)) {
			return notionalQuantityBasket.<String>map("getId", commodityBasketByNotional -> commodityBasketByNotional.getId()).get();
		}
		final MapperS<CommodityBasketByPercentage> notionalAmountBasket = MapperS.of(commodityBasketModel).<CommodityBasketByPercentage>map("getNotionalAmountBasket", _commodityBasketModel -> _commodityBasketModel.getNotionalAmountBasket());
		if (exists(notionalAmountBasket).getOrDefault(false)) {
			return notionalAmountBasket.<String>map("getId", commodityBasketByPercentage -> commodityBasketByPercentage.getId()).get();
		}
		return null;
	}
	
}
