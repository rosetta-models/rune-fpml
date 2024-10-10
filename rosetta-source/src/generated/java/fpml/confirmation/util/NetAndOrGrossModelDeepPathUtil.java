package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.NetAndOrGrossModel;
import fpml.confirmation.NetAndOrGrossModelSequence;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class NetAndOrGrossModelDeepPathUtil {
	public BigDecimal chooseNet(NetAndOrGrossModel netAndOrGrossModel) {
		final MapperS<BigDecimal> net = MapperS.of(netAndOrGrossModel).<BigDecimal>map("getNet", _netAndOrGrossModel -> _netAndOrGrossModel.getNet());
		if (exists(net).getOrDefault(false)) {
			return net.get();
		}
		final MapperS<NetAndOrGrossModelSequence> netAndOrGrossModelSequence = MapperS.of(netAndOrGrossModel).<NetAndOrGrossModelSequence>map("getNetAndOrGrossModelSequence", _netAndOrGrossModel -> _netAndOrGrossModel.getNetAndOrGrossModelSequence());
		if (exists(netAndOrGrossModelSequence).getOrDefault(false)) {
			return netAndOrGrossModelSequence.<BigDecimal>map("getNet", _netAndOrGrossModelSequence -> _netAndOrGrossModelSequence.getNet()).get();
		}
		return null;
	}
	
}
