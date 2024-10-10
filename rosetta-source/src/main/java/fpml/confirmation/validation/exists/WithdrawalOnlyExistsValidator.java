package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportingRegimeIdentifier;
import fpml.confirmation.RequestedWithdrawalAction;
import fpml.confirmation.Trade;
import fpml.confirmation.Withdrawal;
import fpml.confirmation.WithdrawalReason;
import fpml.confirmation.WithdrawalSequence;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class WithdrawalOnlyExistsValidator implements ValidatorWithArg<Withdrawal, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Withdrawal> ValidationResult<Withdrawal> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("withdrawalSequence", ExistenceChecker.isSet((WithdrawalSequence) o.getWithdrawalSequence()))
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
				.put("effectiveDate", ExistenceChecker.isSet((Date) o.getEffectiveDate()))
				.put("requestedAction", ExistenceChecker.isSet((RequestedWithdrawalAction) o.getRequestedAction()))
				.put("reason", ExistenceChecker.isSet((List<? extends WithdrawalReason>) o.getReason()))
				.put("reportingRegime", ExistenceChecker.isSet((List<? extends ReportingRegimeIdentifier>) o.getReportingRegime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Withdrawal", ValidationType.ONLY_EXISTS, "Withdrawal", path, "");
		}
		return failure("Withdrawal", ValidationType.ONLY_EXISTS, "Withdrawal", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
