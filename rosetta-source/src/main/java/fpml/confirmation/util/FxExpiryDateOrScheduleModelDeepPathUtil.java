package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxExpiryDate;
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import fpml.confirmation.FxExpirySchedule;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class FxExpiryDateOrScheduleModelDeepPathUtil {
	public BusinessCenterTime chooseExpiryTime(FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel) {
		final MapperS<FxExpiryDate> expiryDate = MapperS.of(fxExpiryDateOrScheduleModel).<FxExpiryDate>map("getExpiryDate", _fxExpiryDateOrScheduleModel -> _fxExpiryDateOrScheduleModel.getExpiryDate());
		if (exists(expiryDate).getOrDefault(false)) {
			return expiryDate.<BusinessCenterTime>map("getExpiryTime", fxExpiryDate -> fxExpiryDate.getExpiryTime()).get();
		}
		final MapperS<FxExpirySchedule> expirySchedule = MapperS.of(fxExpiryDateOrScheduleModel).<FxExpirySchedule>map("getExpirySchedule", _fxExpiryDateOrScheduleModel -> _fxExpiryDateOrScheduleModel.getExpirySchedule());
		if (exists(expirySchedule).getOrDefault(false)) {
			return expirySchedule.<BusinessCenterTime>map("getExpiryTime", fxExpirySchedule -> fxExpirySchedule.getExpiryTime()).get();
		}
		return null;
	}
	
}
