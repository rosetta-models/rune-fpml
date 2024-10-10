package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.PhysicalSettlement;
import fpml.confirmation.Product;
import fpml.confirmation.Trade;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class PhysicalSettlementDeepPathUtil {
	public String chooseId(PhysicalSettlement physicalSettlement) {
		final MapperS<PartyTradeIdentifier> resultingTradeIdentifier = MapperS.of(physicalSettlement).<PartyTradeIdentifier>map("getResultingTradeIdentifier", _physicalSettlement -> _physicalSettlement.getResultingTradeIdentifier());
		if (exists(resultingTradeIdentifier).getOrDefault(false)) {
			return resultingTradeIdentifier.<String>map("getId", partyTradeIdentifier -> partyTradeIdentifier.getId()).get();
		}
		final MapperS<Trade> resultingTrade = MapperS.of(physicalSettlement).<Trade>map("getResultingTrade", _physicalSettlement -> _physicalSettlement.getResultingTrade());
		if (exists(resultingTrade).getOrDefault(false)) {
			return resultingTrade.<String>map("getId", trade -> trade.getId()).get();
		}
		final MapperS<Product> product = MapperS.of(physicalSettlement).<Product>map("getProduct", _physicalSettlement -> _physicalSettlement.getProduct());
		if (exists(product).getOrDefault(false)) {
			return product.<String>map("getId", _product -> _product.getId()).get();
		}
		return null;
	}
	
}
