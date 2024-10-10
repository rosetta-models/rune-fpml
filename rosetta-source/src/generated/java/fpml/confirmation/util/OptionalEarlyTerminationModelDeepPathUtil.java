package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.OptionalEarlyTermination;
import fpml.confirmation.OptionalEarlyTerminationModel;
import fpml.confirmation.OptionalEarlyTerminationModelSequence;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class OptionalEarlyTerminationModelDeepPathUtil {
	public OptionalEarlyTermination chooseOptionalEarlyTermination(OptionalEarlyTerminationModel optionalEarlyTerminationModel) {
		final MapperS<OptionalEarlyTermination> optionalEarlyTermination = MapperS.of(optionalEarlyTerminationModel).<OptionalEarlyTermination>map("getOptionalEarlyTermination", _optionalEarlyTerminationModel -> _optionalEarlyTerminationModel.getOptionalEarlyTermination());
		if (exists(optionalEarlyTermination).getOrDefault(false)) {
			return optionalEarlyTermination.get();
		}
		final MapperS<OptionalEarlyTerminationModelSequence> optionalEarlyTerminationModelSequence = MapperS.of(optionalEarlyTerminationModel).<OptionalEarlyTerminationModelSequence>map("getOptionalEarlyTerminationModelSequence", _optionalEarlyTerminationModel -> _optionalEarlyTerminationModel.getOptionalEarlyTerminationModelSequence());
		if (exists(optionalEarlyTerminationModelSequence).getOrDefault(false)) {
			return optionalEarlyTerminationModelSequence.<OptionalEarlyTermination>map("getOptionalEarlyTermination", _optionalEarlyTerminationModelSequence -> _optionalEarlyTerminationModelSequence.getOptionalEarlyTermination()).get();
		}
		return null;
	}
	
}
