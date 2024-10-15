package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.FxAccrualRegionBoundModel;
import fpml.confirmation.FxAccrualRegionBoundModelSequence;
import fpml.confirmation.FxAccrualRegionUpperBound;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class FxAccrualRegionBoundModelDeepPathUtil {
	public FxAccrualRegionUpperBound chooseUpperBound(FxAccrualRegionBoundModel fxAccrualRegionBoundModel) {
		final MapperS<FxAccrualRegionUpperBound> upperBound = MapperS.of(fxAccrualRegionBoundModel).<FxAccrualRegionUpperBound>map("getUpperBound", _fxAccrualRegionBoundModel -> _fxAccrualRegionBoundModel.getUpperBound());
		if (exists(upperBound).getOrDefault(false)) {
			return upperBound.get();
		}
		final MapperS<FxAccrualRegionBoundModelSequence> fxAccrualRegionBoundModelSequence = MapperS.of(fxAccrualRegionBoundModel).<FxAccrualRegionBoundModelSequence>map("getFxAccrualRegionBoundModelSequence", _fxAccrualRegionBoundModel -> _fxAccrualRegionBoundModel.getFxAccrualRegionBoundModelSequence());
		if (exists(fxAccrualRegionBoundModelSequence).getOrDefault(false)) {
			return fxAccrualRegionBoundModelSequence.<FxAccrualRegionUpperBound>map("getUpperBound", _fxAccrualRegionBoundModelSequence -> _fxAccrualRegionBoundModelSequence.getUpperBound()).get();
		}
		return null;
	}
	
}
