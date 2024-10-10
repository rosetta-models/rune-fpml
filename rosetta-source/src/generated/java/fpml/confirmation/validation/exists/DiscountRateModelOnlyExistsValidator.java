package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.DiscountRateModel;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DiscountRateModelOnlyExistsValidator implements ValidatorWithArg<DiscountRateModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DiscountRateModel> ValidationResult<DiscountRateModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("discountRate", ExistenceChecker.isSet((BigDecimal) o.getDiscountRate()))
				.put("discountRateDayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDiscountRateDayCountFraction()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DiscountRateModel", ValidationType.ONLY_EXISTS, "DiscountRateModel", path, "");
		}
		return failure("DiscountRateModel", ValidationType.ONLY_EXISTS, "DiscountRateModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
