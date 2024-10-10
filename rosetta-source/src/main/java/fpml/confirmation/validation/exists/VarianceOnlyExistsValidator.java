package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BoundedVariance;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.ExchangeTradedContract;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Variance;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class VarianceOnlyExistsValidator implements ValidatorWithArg<Variance, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Variance> ValidationResult<Variance> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationFromObservationChoice", ExistenceChecker.isSet((CalculationFromObservationChoice) o.getCalculationFromObservationChoice()))
				.put("closingLevel", ExistenceChecker.isSet((Boolean) o.getClosingLevel()))
				.put("expiringLevel", ExistenceChecker.isSet((Boolean) o.getExpiringLevel()))
				.put("expectedN", ExistenceChecker.isSet((Integer) o.getExpectedN()))
				.put("varianceAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getVarianceAmount()))
				.put("volatilityStrikePrice", ExistenceChecker.isSet((BigDecimal) o.getVolatilityStrikePrice()))
				.put("varianceStrikePrice", ExistenceChecker.isSet((BigDecimal) o.getVarianceStrikePrice()))
				.put("varianceCap", ExistenceChecker.isSet((Boolean) o.getVarianceCap()))
				.put("unadjustedVarianceCap", ExistenceChecker.isSet((BigDecimal) o.getUnadjustedVarianceCap()))
				.put("boundedVariance", ExistenceChecker.isSet((BoundedVariance) o.getBoundedVariance()))
				.put("exchangeTradedContractNearest", ExistenceChecker.isSet((ExchangeTradedContract) o.getExchangeTradedContractNearest()))
				.put("vegaNotionalAmount", ExistenceChecker.isSet((BigDecimal) o.getVegaNotionalAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Variance", ValidationType.ONLY_EXISTS, "Variance", path, "");
		}
		return failure("Variance", ValidationType.ONLY_EXISTS, "Variance", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
