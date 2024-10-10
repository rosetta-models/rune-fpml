package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.CoalAttributePercentage;
import fpml.confirmation.CoalAttributePercentageSequence0;
import fpml.confirmation.CoalAttributePercentageSequence1;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class CoalAttributePercentageDeepPathUtil {
	public BigDecimal chooseRejectionLimit(CoalAttributePercentage coalAttributePercentage) {
		final MapperS<CoalAttributePercentageSequence0> coalAttributePercentageSequence0 = MapperS.of(coalAttributePercentage).<CoalAttributePercentageSequence0>map("getCoalAttributePercentageSequence0", _coalAttributePercentage -> _coalAttributePercentage.getCoalAttributePercentageSequence0());
		if (exists(coalAttributePercentageSequence0).getOrDefault(false)) {
			return coalAttributePercentageSequence0.<BigDecimal>map("getRejectionLimit", _coalAttributePercentageSequence0 -> _coalAttributePercentageSequence0.getRejectionLimit()).get();
		}
		final MapperS<CoalAttributePercentageSequence1> coalAttributePercentageSequence1 = MapperS.of(coalAttributePercentage).<CoalAttributePercentageSequence1>map("getCoalAttributePercentageSequence1", _coalAttributePercentage -> _coalAttributePercentage.getCoalAttributePercentageSequence1());
		if (exists(coalAttributePercentageSequence1).getOrDefault(false)) {
			return coalAttributePercentageSequence1.<BigDecimal>map("getRejectionLimit", _coalAttributePercentageSequence1 -> _coalAttributePercentageSequence1.getRejectionLimit()).get();
		}
		return null;
	}
	
}
