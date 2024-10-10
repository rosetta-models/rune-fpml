package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.PGPDataType;
import fpml.confirmation.PGPDataTypeSequence0;
import fpml.confirmation.PGPDataTypeSequence1;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class PGPDataTypeDeepPathUtil {
	public String choosePgpKeyPacket(PGPDataType pGPDataType) {
		final MapperS<PGPDataTypeSequence0> pgpDataTypeSequence0 = MapperS.of(pGPDataType).<PGPDataTypeSequence0>map("getPgpDataTypeSequence0", _pGPDataType -> _pGPDataType.getPgpDataTypeSequence0());
		if (exists(pgpDataTypeSequence0).getOrDefault(false)) {
			return pgpDataTypeSequence0.<String>map("getPgpKeyPacket", pGPDataTypeSequence0 -> pGPDataTypeSequence0.getPgpKeyPacket()).get();
		}
		final MapperS<PGPDataTypeSequence1> pgpDataTypeSequence1 = MapperS.of(pGPDataType).<PGPDataTypeSequence1>map("getPgpDataTypeSequence1", _pGPDataType -> _pGPDataType.getPgpDataTypeSequence1());
		if (exists(pgpDataTypeSequence1).getOrDefault(false)) {
			return pgpDataTypeSequence1.<String>map("getPgpKeyPacket", pGPDataTypeSequence1 -> pGPDataTypeSequence1.getPgpKeyPacket()).get();
		}
		return null;
	}
	
}
