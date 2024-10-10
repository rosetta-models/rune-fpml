package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.FxFixingObservation;
import fpml.confirmation.FxWeightedFixingSchedule;
import fpml.confirmation.FxWeightedFixingScheduleSequence0;
import fpml.confirmation.FxWeightedFixingScheduleSequence1;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class FxWeightedFixingScheduleDeepPathUtil {
	public List<FxFixingObservation> chooseFixing(FxWeightedFixingSchedule fxWeightedFixingSchedule) {
		final MapperS<FxWeightedFixingScheduleSequence0> fxWeightedFixingScheduleSequence0 = MapperS.of(fxWeightedFixingSchedule).<FxWeightedFixingScheduleSequence0>map("getFxWeightedFixingScheduleSequence0", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getFxWeightedFixingScheduleSequence0());
		if (exists(fxWeightedFixingScheduleSequence0).getOrDefault(false)) {
			return fxWeightedFixingScheduleSequence0.<FxFixingObservation>mapC("getFixing", _fxWeightedFixingScheduleSequence0 -> _fxWeightedFixingScheduleSequence0.getFixing()).getMulti();
		}
		final MapperS<FxWeightedFixingScheduleSequence1> fxWeightedFixingScheduleSequence1 = MapperS.of(fxWeightedFixingSchedule).<FxWeightedFixingScheduleSequence1>map("getFxWeightedFixingScheduleSequence1", _fxWeightedFixingSchedule -> _fxWeightedFixingSchedule.getFxWeightedFixingScheduleSequence1());
		if (exists(fxWeightedFixingScheduleSequence1).getOrDefault(false)) {
			return fxWeightedFixingScheduleSequence1.<FxFixingObservation>mapC("getFixing", _fxWeightedFixingScheduleSequence1 -> _fxWeightedFixingScheduleSequence1.getFixing()).getMulti();
		}
		return Collections.<FxFixingObservation>emptyList();
	}
	
}
