package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.UtilizationModel;
import fpml.confirmation.UtilizationModelSequence0;
import fpml.confirmation.UtilizationModelSequence1;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class UtilizationModelDeepPathUtil {
	public MoneyWithParticipantShare chooseFundedUtilizedAmount(UtilizationModel utilizationModel) {
		final MapperS<UtilizationModelSequence0> utilizationModelSequence0 = MapperS.of(utilizationModel).<UtilizationModelSequence0>map("getUtilizationModelSequence0", _utilizationModel -> _utilizationModel.getUtilizationModelSequence0());
		if (exists(utilizationModelSequence0).getOrDefault(false)) {
			return utilizationModelSequence0.<MoneyWithParticipantShare>map("getFundedUtilizedAmount", _utilizationModelSequence0 -> _utilizationModelSequence0.getFundedUtilizedAmount()).get();
		}
		final MapperS<UtilizationModelSequence1> utilizationModelSequence1 = MapperS.of(utilizationModel).<UtilizationModelSequence1>map("getUtilizationModelSequence1", _utilizationModel -> _utilizationModel.getUtilizationModelSequence1());
		if (exists(utilizationModelSequence1).getOrDefault(false)) {
			return utilizationModelSequence1.<MoneyWithParticipantShare>map("getFundedUtilizedAmount", _utilizationModelSequence1 -> _utilizationModelSequence1.getFundedUtilizedAmount()).get();
		}
		return null;
	}
	
	public MoneyWithParticipantShare chooseUnfundedUtilizedAmount(UtilizationModel utilizationModel) {
		final MapperS<UtilizationModelSequence0> utilizationModelSequence0 = MapperS.of(utilizationModel).<UtilizationModelSequence0>map("getUtilizationModelSequence0", _utilizationModel -> _utilizationModel.getUtilizationModelSequence0());
		if (exists(utilizationModelSequence0).getOrDefault(false)) {
			return utilizationModelSequence0.<MoneyWithParticipantShare>map("getUnfundedUtilizedAmount", _utilizationModelSequence0 -> _utilizationModelSequence0.getUnfundedUtilizedAmount()).get();
		}
		final MapperS<UtilizationModelSequence1> utilizationModelSequence1 = MapperS.of(utilizationModel).<UtilizationModelSequence1>map("getUtilizationModelSequence1", _utilizationModel -> _utilizationModel.getUtilizationModelSequence1());
		if (exists(utilizationModelSequence1).getOrDefault(false)) {
			return utilizationModelSequence1.<MoneyWithParticipantShare>map("getUnfundedUtilizedAmount", _utilizationModelSequence1 -> _utilizationModelSequence1.getUnfundedUtilizedAmount()).get();
		}
		return null;
	}
	
}
