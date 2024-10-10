package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.CoalAttributeDecimal;
import fpml.confirmation.CoalAttributeDecimalSequence0;
import fpml.confirmation.CoalAttributeDecimalSequence1;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class CoalAttributeDecimalDeepPathUtil {
	public BigDecimal chooseRejectionLimit(CoalAttributeDecimal coalAttributeDecimal) {
		final MapperS<CoalAttributeDecimalSequence0> coalAttributeDecimalSequence0 = MapperS.of(coalAttributeDecimal).<CoalAttributeDecimalSequence0>map("getCoalAttributeDecimalSequence0", _coalAttributeDecimal -> _coalAttributeDecimal.getCoalAttributeDecimalSequence0());
		if (exists(coalAttributeDecimalSequence0).getOrDefault(false)) {
			return coalAttributeDecimalSequence0.<BigDecimal>map("getRejectionLimit", _coalAttributeDecimalSequence0 -> _coalAttributeDecimalSequence0.getRejectionLimit()).get();
		}
		final MapperS<CoalAttributeDecimalSequence1> coalAttributeDecimalSequence1 = MapperS.of(coalAttributeDecimal).<CoalAttributeDecimalSequence1>map("getCoalAttributeDecimalSequence1", _coalAttributeDecimal -> _coalAttributeDecimal.getCoalAttributeDecimalSequence1());
		if (exists(coalAttributeDecimalSequence1).getOrDefault(false)) {
			return coalAttributeDecimalSequence1.<BigDecimal>map("getRejectionLimit", _coalAttributeDecimalSequence1 -> _coalAttributeDecimalSequence1.getRejectionLimit()).get();
		}
		return null;
	}
	
}
