package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.Basket;
import fpml.confirmation.SingleUnderlyer;
import fpml.confirmation.Underlyer;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class UnderlyerDeepPathUtil {
	public BigDecimal chooseOpenUnits(Underlyer underlyer) {
		final MapperS<SingleUnderlyer> singleUnderlyer = MapperS.of(underlyer).<SingleUnderlyer>map("getSingleUnderlyer", _underlyer -> _underlyer.getSingleUnderlyer());
		if (exists(singleUnderlyer).getOrDefault(false)) {
			return singleUnderlyer.<BigDecimal>map("getOpenUnits", _singleUnderlyer -> _singleUnderlyer.getOpenUnits()).get();
		}
		final MapperS<Basket> basket = MapperS.of(underlyer).<Basket>map("getBasket", _underlyer -> _underlyer.getBasket());
		if (exists(basket).getOrDefault(false)) {
			return basket.<BigDecimal>map("getOpenUnits", _basket -> _basket.getOpenUnits()).get();
		}
		return null;
	}
	
}
