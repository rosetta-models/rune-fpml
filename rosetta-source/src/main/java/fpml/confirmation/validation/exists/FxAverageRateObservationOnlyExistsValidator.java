package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAverageRateObservation;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAverageRateObservationOnlyExistsValidator implements ValidatorWithArg<FxAverageRateObservation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAverageRateObservation> ValidationResult<FxAverageRateObservation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("date", ExistenceChecker.isSet((Date) o.getDate()))
				.put("averageRateWeightingFactor", ExistenceChecker.isSet((BigDecimal) o.getAverageRateWeightingFactor()))
				.put("rate", ExistenceChecker.isSet((BigDecimal) o.getRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAverageRateObservation", ValidationType.ONLY_EXISTS, "FxAverageRateObservation", path, "");
		}
		return failure("FxAverageRateObservation", ValidationType.ONLY_EXISTS, "FxAverageRateObservation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
