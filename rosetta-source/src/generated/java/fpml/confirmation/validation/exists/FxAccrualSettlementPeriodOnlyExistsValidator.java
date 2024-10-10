package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualSettlementPeriod;
import fpml.confirmation.FxAccrualSettlementPeriodPayoff;
import fpml.confirmation.FxSettlementPeriodBarrier;
import fpml.confirmation.SettlementPeriodFixingDates;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualSettlementPeriodOnlyExistsValidator implements ValidatorWithArg<FxAccrualSettlementPeriod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualSettlementPeriod> ValidationResult<FxAccrualSettlementPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expiryDate", ExistenceChecker.isSet((Date) o.getExpiryDate()))
				.put("settlementDate", ExistenceChecker.isSet((Date) o.getSettlementDate()))
				.put("notionalAmount", ExistenceChecker.isSet((BigDecimal) o.getNotionalAmount()))
				.put("payoff", ExistenceChecker.isSet((List<? extends FxAccrualSettlementPeriodPayoff>) o.getPayoff()))
				.put("accrualFactor", ExistenceChecker.isSet((BigDecimal) o.getAccrualFactor()))
				.put("barrier", ExistenceChecker.isSet((FxSettlementPeriodBarrier) o.getBarrier()))
				.put("accrualFixingDates", ExistenceChecker.isSet((SettlementPeriodFixingDates) o.getAccrualFixingDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualSettlementPeriod", ValidationType.ONLY_EXISTS, "FxAccrualSettlementPeriod", path, "");
		}
		return failure("FxAccrualSettlementPeriod", ValidationType.ONLY_EXISTS, "FxAccrualSettlementPeriod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
