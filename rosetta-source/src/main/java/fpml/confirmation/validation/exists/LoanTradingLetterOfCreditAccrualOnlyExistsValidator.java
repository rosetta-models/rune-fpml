package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.LetterOfCreditReference;
import fpml.confirmation.LoanTradingLetterOfCreditAccrual;
import fpml.confirmation.NonNegativeMoney;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingLetterOfCreditAccrualOnlyExistsValidator implements ValidatorWithArg<LoanTradingLetterOfCreditAccrual, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingLetterOfCreditAccrual> ValidationResult<LoanTradingLetterOfCreditAccrual> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amount", ExistenceChecker.isSet((NonNegativeMoney) o.getAmount()))
				.put("accrualPeriod", ExistenceChecker.isSet((List<? extends AccrualPeriod>) o.getAccrualPeriod()))
				.put("letterOfCreditReference", ExistenceChecker.isSet((LetterOfCreditReference) o.getLetterOfCreditReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingLetterOfCreditAccrual", ValidationType.ONLY_EXISTS, "LoanTradingLetterOfCreditAccrual", path, "");
		}
		return failure("LoanTradingLetterOfCreditAccrual", ValidationType.ONLY_EXISTS, "LoanTradingLetterOfCreditAccrual", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
