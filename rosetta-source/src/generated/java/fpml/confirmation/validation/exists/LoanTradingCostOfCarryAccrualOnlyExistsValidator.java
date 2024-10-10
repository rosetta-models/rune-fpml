package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.LoanTradingCostOfCarryAccrual;
import fpml.confirmation.UtilizationPeriod;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingCostOfCarryAccrualOnlyExistsValidator implements ValidatorWithArg<LoanTradingCostOfCarryAccrual, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingCostOfCarryAccrual> ValidationResult<LoanTradingCostOfCarryAccrual> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("utilizationPeriod", ExistenceChecker.isSet((List<? extends UtilizationPeriod>) o.getUtilizationPeriod()))
				.put("commencementAccrual", ExistenceChecker.isSet((AccrualPeriod) o.getCommencementAccrual()))
				.put("settlementPeriodAccrual", ExistenceChecker.isSet((List<? extends AccrualPeriod>) o.getSettlementPeriodAccrual()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingCostOfCarryAccrual", ValidationType.ONLY_EXISTS, "LoanTradingCostOfCarryAccrual", path, "");
		}
		return failure("LoanTradingCostOfCarryAccrual", ValidationType.ONLY_EXISTS, "LoanTradingCostOfCarryAccrual", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
