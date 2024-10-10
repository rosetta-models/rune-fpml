package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.Period;
import fpml.confirmation.TimeDimension;
import fpml.confirmation.TimeDimensionSequence;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class TimeDimensionDeepPathUtil {
	public Period chooseTenor(TimeDimension timeDimension) {
		final MapperS<Period> tenor = MapperS.of(timeDimension).<Period>map("getTenor", _timeDimension -> _timeDimension.getTenor());
		if (exists(tenor).getOrDefault(false)) {
			return tenor.get();
		}
		final MapperS<TimeDimensionSequence> timeDimensionSequence = MapperS.of(timeDimension).<TimeDimensionSequence>map("getTimeDimensionSequence", _timeDimension -> _timeDimension.getTimeDimensionSequence());
		if (exists(timeDimensionSequence).getOrDefault(false)) {
			return timeDimensionSequence.<Period>map("getTenor", _timeDimensionSequence -> _timeDimensionSequence.getTenor()).get();
		}
		return null;
	}
	
}
