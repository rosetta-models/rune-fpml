package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates;
import fpml.confirmation.DividendsModel;
import fpml.confirmation.Volatility;
import fpml.confirmation.VolatilityAmount;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class VolatilityAmountOnlyExistsValidator implements ValidatorWithArg<VolatilityAmount, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends VolatilityAmount> ValidationResult<VolatilityAmount> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationDates", ExistenceChecker.isSet((AdjustableRelativeOrPeriodicDates) o.getCalculationDates()))
				.put("observationStartDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getObservationStartDate()))
				.put("dividendsModel", ExistenceChecker.isSet((DividendsModel) o.getDividendsModel()))
				.put("volatility", ExistenceChecker.isSet((Volatility) o.getVolatility()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("VolatilityAmount", ValidationType.ONLY_EXISTS, "VolatilityAmount", path, "");
		}
		return failure("VolatilityAmount", ValidationType.ONLY_EXISTS, "VolatilityAmount", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
