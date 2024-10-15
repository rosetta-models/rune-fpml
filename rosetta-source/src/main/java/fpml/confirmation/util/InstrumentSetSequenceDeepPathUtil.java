package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.Asset;
import fpml.confirmation.InstrumentSetSequence;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class InstrumentSetSequenceDeepPathUtil {
	public String chooseId(InstrumentSetSequence instrumentSetSequence) {
		final MapperS<Asset> underlyingAsset = MapperS.of(instrumentSetSequence).<Asset>map("getUnderlyingAsset", _instrumentSetSequence -> _instrumentSetSequence.getUnderlyingAsset());
		if (exists(underlyingAsset).getOrDefault(false)) {
			return underlyingAsset.<String>map("getId", asset -> asset.getId()).get();
		}
		final MapperS<Asset> curveInstrument = MapperS.of(instrumentSetSequence).<Asset>map("getCurveInstrument", _instrumentSetSequence -> _instrumentSetSequence.getCurveInstrument());
		if (exists(curveInstrument).getOrDefault(false)) {
			return curveInstrument.<String>map("getId", asset -> asset.getId()).get();
		}
		return null;
	}
	
}
