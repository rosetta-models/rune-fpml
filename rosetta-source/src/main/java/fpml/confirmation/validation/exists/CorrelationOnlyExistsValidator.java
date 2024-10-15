package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BoundedCorrelation;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.Correlation;
import fpml.confirmation.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CorrelationOnlyExistsValidator implements ValidatorWithArg<Correlation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Correlation> ValidationResult<Correlation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationFromObservationChoice", ExistenceChecker.isSet((CalculationFromObservationChoice) o.getCalculationFromObservationChoice()))
				.put("closingLevel", ExistenceChecker.isSet((Boolean) o.getClosingLevel()))
				.put("expiringLevel", ExistenceChecker.isSet((Boolean) o.getExpiringLevel()))
				.put("expectedN", ExistenceChecker.isSet((Integer) o.getExpectedN()))
				.put("notionalAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getNotionalAmount()))
				.put("correlationStrikePrice", ExistenceChecker.isSet((BigDecimal) o.getCorrelationStrikePrice()))
				.put("boundedCorrelation", ExistenceChecker.isSet((BoundedCorrelation) o.getBoundedCorrelation()))
				.put("numberOfDataSeries", ExistenceChecker.isSet((Integer) o.getNumberOfDataSeries()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Correlation", ValidationType.ONLY_EXISTS, "Correlation", path, "");
		}
		return failure("Correlation", ValidationType.ONLY_EXISTS, "Correlation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
