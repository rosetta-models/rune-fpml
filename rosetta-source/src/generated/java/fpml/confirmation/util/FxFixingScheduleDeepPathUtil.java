package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.FxFixingSchedule;
import fpml.confirmation.FxFixingScheduleSequence0;
import fpml.confirmation.FxFixingScheduleSequence1;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class FxFixingScheduleDeepPathUtil {
	public List<Date> chooseFixingDate(FxFixingSchedule fxFixingSchedule) {
		final MapperS<FxFixingScheduleSequence0> fxFixingScheduleSequence0 = MapperS.of(fxFixingSchedule).<FxFixingScheduleSequence0>map("getFxFixingScheduleSequence0", _fxFixingSchedule -> _fxFixingSchedule.getFxFixingScheduleSequence0());
		if (exists(fxFixingScheduleSequence0).getOrDefault(false)) {
			return fxFixingScheduleSequence0.<Date>mapC("getFixingDate", _fxFixingScheduleSequence0 -> _fxFixingScheduleSequence0.getFixingDate()).getMulti();
		}
		final MapperS<FxFixingScheduleSequence1> fxFixingScheduleSequence1 = MapperS.of(fxFixingSchedule).<FxFixingScheduleSequence1>map("getFxFixingScheduleSequence1", _fxFixingSchedule -> _fxFixingSchedule.getFxFixingScheduleSequence1());
		if (exists(fxFixingScheduleSequence1).getOrDefault(false)) {
			return fxFixingScheduleSequence1.<Date>mapC("getFixingDate", _fxFixingScheduleSequence1 -> _fxFixingScheduleSequence1.getFixingDate()).getMulti();
		}
		return Collections.<Date>emptyList();
	}
	
}
