package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.MandatoryEarlyTermination;
import fpml.confirmation.MandatoryEarlyTerminationModel;
import fpml.confirmation.MandatoryEarlyTerminationModelSequence;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class MandatoryEarlyTerminationModelDeepPathUtil {
	public MandatoryEarlyTermination chooseMandatoryEarlyTermination(MandatoryEarlyTerminationModel mandatoryEarlyTerminationModel) {
		final MapperS<MandatoryEarlyTermination> mandatoryEarlyTermination = MapperS.of(mandatoryEarlyTerminationModel).<MandatoryEarlyTermination>map("getMandatoryEarlyTermination", _mandatoryEarlyTerminationModel -> _mandatoryEarlyTerminationModel.getMandatoryEarlyTermination());
		if (exists(mandatoryEarlyTermination).getOrDefault(false)) {
			return mandatoryEarlyTermination.get();
		}
		final MapperS<MandatoryEarlyTerminationModelSequence> mandatoryEarlyTerminationModelSequence = MapperS.of(mandatoryEarlyTerminationModel).<MandatoryEarlyTerminationModelSequence>map("getMandatoryEarlyTerminationModelSequence", _mandatoryEarlyTerminationModel -> _mandatoryEarlyTerminationModel.getMandatoryEarlyTerminationModelSequence());
		if (exists(mandatoryEarlyTerminationModelSequence).getOrDefault(false)) {
			return mandatoryEarlyTerminationModelSequence.<MandatoryEarlyTermination>map("getMandatoryEarlyTermination", _mandatoryEarlyTerminationModelSequence -> _mandatoryEarlyTerminationModelSequence.getMandatoryEarlyTermination()).get();
		}
		return null;
	}
	
}
