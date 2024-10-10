package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.FxTargetRegionBoundModel;
import fpml.confirmation.FxTargetRegionBoundModelSequence;
import fpml.confirmation.FxTargetRegionUpperBound;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class FxTargetRegionBoundModelDeepPathUtil {
	public FxTargetRegionUpperBound chooseUpperBound(FxTargetRegionBoundModel fxTargetRegionBoundModel) {
		final MapperS<FxTargetRegionUpperBound> upperBound = MapperS.of(fxTargetRegionBoundModel).<FxTargetRegionUpperBound>map("getUpperBound", _fxTargetRegionBoundModel -> _fxTargetRegionBoundModel.getUpperBound());
		if (exists(upperBound).getOrDefault(false)) {
			return upperBound.get();
		}
		final MapperS<FxTargetRegionBoundModelSequence> fxTargetRegionBoundModelSequence = MapperS.of(fxTargetRegionBoundModel).<FxTargetRegionBoundModelSequence>map("getFxTargetRegionBoundModelSequence", _fxTargetRegionBoundModel -> _fxTargetRegionBoundModel.getFxTargetRegionBoundModelSequence());
		if (exists(fxTargetRegionBoundModelSequence).getOrDefault(false)) {
			return fxTargetRegionBoundModelSequence.<FxTargetRegionUpperBound>map("getUpperBound", _fxTargetRegionBoundModelSequence -> _fxTargetRegionBoundModelSequence.getUpperBound()).get();
		}
		return null;
	}
	
}
