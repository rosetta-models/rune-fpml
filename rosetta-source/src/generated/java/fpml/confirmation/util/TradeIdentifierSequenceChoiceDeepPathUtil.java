package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.TradeId;
import fpml.confirmation.TradeIdentifierSequenceChoice;
import fpml.confirmation.VersionedTradeId;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class TradeIdentifierSequenceChoiceDeepPathUtil {
	public TradeId chooseTradeId(TradeIdentifierSequenceChoice tradeIdentifierSequenceChoice) {
		final MapperS<TradeId> tradeId = MapperS.of(tradeIdentifierSequenceChoice).<TradeId>map("getTradeId", _tradeIdentifierSequenceChoice -> _tradeIdentifierSequenceChoice.getTradeId());
		if (exists(tradeId).getOrDefault(false)) {
			return tradeId.get();
		}
		final MapperS<VersionedTradeId> versionedTradeId = MapperS.of(tradeIdentifierSequenceChoice).<VersionedTradeId>map("getVersionedTradeId", _tradeIdentifierSequenceChoice -> _tradeIdentifierSequenceChoice.getVersionedTradeId());
		if (exists(versionedTradeId).getOrDefault(false)) {
			return versionedTradeId.<TradeId>map("getTradeId", _versionedTradeId -> _versionedTradeId.getTradeId()).get();
		}
		return null;
	}
	
}
