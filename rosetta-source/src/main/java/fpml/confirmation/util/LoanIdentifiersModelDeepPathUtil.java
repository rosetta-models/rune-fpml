package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.LoanIdentifiersModel;
import fpml.confirmation.OverrideIdentifier;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.TaskIdentifier;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class LoanIdentifiersModelDeepPathUtil {
	public PartyAndAccountReferencesModel choosePartyAndAccountReferencesModel(LoanIdentifiersModel loanIdentifiersModel) {
		final MapperS<BusinessEventIdentifier> eventIdentifier = MapperS.of(loanIdentifiersModel).<BusinessEventIdentifier>map("getEventIdentifier", _loanIdentifiersModel -> _loanIdentifiersModel.getEventIdentifier());
		if (exists(eventIdentifier).getOrDefault(false)) {
			return eventIdentifier.<PartyAndAccountReferencesModel>map("getPartyAndAccountReferencesModel", businessEventIdentifier -> businessEventIdentifier.getPartyAndAccountReferencesModel()).get();
		}
		final MapperS<OverrideIdentifier> overrideIdentifier = MapperS.of(loanIdentifiersModel).<OverrideIdentifier>map("getOverrideIdentifier", _loanIdentifiersModel -> _loanIdentifiersModel.getOverrideIdentifier());
		if (exists(overrideIdentifier).getOrDefault(false)) {
			return overrideIdentifier.<PartyAndAccountReferencesModel>map("getPartyAndAccountReferencesModel", _overrideIdentifier -> _overrideIdentifier.getPartyAndAccountReferencesModel()).get();
		}
		final MapperS<TaskIdentifier> taskIdentifier = MapperS.of(loanIdentifiersModel).<TaskIdentifier>map("getTaskIdentifier", _loanIdentifiersModel -> _loanIdentifiersModel.getTaskIdentifier());
		if (exists(taskIdentifier).getOrDefault(false)) {
			return taskIdentifier.<PartyAndAccountReferencesModel>map("getPartyAndAccountReferencesModel", _taskIdentifier -> _taskIdentifier.getPartyAndAccountReferencesModel()).get();
		}
		return null;
	}
	
	public String chooseId(LoanIdentifiersModel loanIdentifiersModel) {
		final MapperS<BusinessEventIdentifier> eventIdentifier = MapperS.of(loanIdentifiersModel).<BusinessEventIdentifier>map("getEventIdentifier", _loanIdentifiersModel -> _loanIdentifiersModel.getEventIdentifier());
		if (exists(eventIdentifier).getOrDefault(false)) {
			return eventIdentifier.<String>map("getId", businessEventIdentifier -> businessEventIdentifier.getId()).get();
		}
		final MapperS<OverrideIdentifier> overrideIdentifier = MapperS.of(loanIdentifiersModel).<OverrideIdentifier>map("getOverrideIdentifier", _loanIdentifiersModel -> _loanIdentifiersModel.getOverrideIdentifier());
		if (exists(overrideIdentifier).getOrDefault(false)) {
			return overrideIdentifier.<String>map("getId", _overrideIdentifier -> _overrideIdentifier.getId()).get();
		}
		final MapperS<TaskIdentifier> taskIdentifier = MapperS.of(loanIdentifiersModel).<TaskIdentifier>map("getTaskIdentifier", _loanIdentifiersModel -> _loanIdentifiersModel.getTaskIdentifier());
		if (exists(taskIdentifier).getOrDefault(false)) {
			return taskIdentifier.<String>map("getId", _taskIdentifier -> _taskIdentifier.getId()).get();
		}
		return null;
	}
	
}
