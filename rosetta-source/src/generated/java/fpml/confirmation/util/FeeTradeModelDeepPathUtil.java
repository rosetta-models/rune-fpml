package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.FeeTradeModel;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Trade;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class FeeTradeModelDeepPathUtil {
	public String chooseId(FeeTradeModel feeTradeModel) {
		final MapperS<PartyTradeIdentifier> feeTradeIdentifier = MapperS.of(feeTradeModel).<PartyTradeIdentifier>map("getFeeTradeIdentifier", _feeTradeModel -> _feeTradeModel.getFeeTradeIdentifier());
		if (exists(feeTradeIdentifier).getOrDefault(false)) {
			return feeTradeIdentifier.<String>map("getId", partyTradeIdentifier -> partyTradeIdentifier.getId()).get();
		}
		final MapperS<Trade> feeTrade = MapperS.of(feeTradeModel).<Trade>map("getFeeTrade", _feeTradeModel -> _feeTradeModel.getFeeTrade());
		if (exists(feeTrade).getOrDefault(false)) {
			return feeTrade.<String>map("getId", trade -> trade.getId()).get();
		}
		return null;
	}
	
}
