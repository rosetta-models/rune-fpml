package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AverageDailyTradingVolumeLimit;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AverageDailyTradingVolumeLimitOnlyExistsValidator implements ValidatorWithArg<AverageDailyTradingVolumeLimit, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AverageDailyTradingVolumeLimit> ValidationResult<AverageDailyTradingVolumeLimit> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("limitationPercentage", ExistenceChecker.isSet((BigDecimal) o.getLimitationPercentage()))
				.put("limitationPeriod", ExistenceChecker.isSet((Integer) o.getLimitationPeriod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AverageDailyTradingVolumeLimit", ValidationType.ONLY_EXISTS, "AverageDailyTradingVolumeLimit", path, "");
		}
		return failure("AverageDailyTradingVolumeLimit", ValidationType.ONLY_EXISTS, "AverageDailyTradingVolumeLimit", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
