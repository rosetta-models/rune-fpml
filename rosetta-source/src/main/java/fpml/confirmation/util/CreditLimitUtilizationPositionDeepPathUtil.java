package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.CreditLimitUtilizationPosition;
import fpml.confirmation.CreditLimitUtilizationPositionSequence;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class CreditLimitUtilizationPositionDeepPathUtil {
	public BigDecimal chooseGlobal(CreditLimitUtilizationPosition creditLimitUtilizationPosition) {
		final MapperS<CreditLimitUtilizationPositionSequence> creditLimitUtilizationPositionSequence = MapperS.of(creditLimitUtilizationPosition).<CreditLimitUtilizationPositionSequence>map("getCreditLimitUtilizationPositionSequence", _creditLimitUtilizationPosition -> _creditLimitUtilizationPosition.getCreditLimitUtilizationPositionSequence());
		if (exists(creditLimitUtilizationPositionSequence).getOrDefault(false)) {
			return creditLimitUtilizationPositionSequence.<BigDecimal>map("getGlobal", _creditLimitUtilizationPositionSequence -> _creditLimitUtilizationPositionSequence.getGlobal()).get();
		}
		final MapperS<BigDecimal> global = MapperS.of(creditLimitUtilizationPosition).<BigDecimal>map("getGlobal", _creditLimitUtilizationPosition -> _creditLimitUtilizationPosition.getGlobal());
		if (exists(global).getOrDefault(false)) {
			return global.get();
		}
		return null;
	}
	
}
