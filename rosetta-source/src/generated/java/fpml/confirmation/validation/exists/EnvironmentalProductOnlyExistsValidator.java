package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EnvironmentalProduct;
import fpml.confirmation.EnvironmentalProductApplicableLaw;
import fpml.confirmation.EnvironmentalProductComplaincePeriod;
import fpml.confirmation.EnvironmentalProductTypeEnum;
import fpml.confirmation.EnvironmentalTrackingSystem;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EnvironmentalProductOnlyExistsValidator implements ValidatorWithArg<EnvironmentalProduct, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EnvironmentalProduct> ValidationResult<EnvironmentalProduct> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productType", ExistenceChecker.isSet((EnvironmentalProductTypeEnum) o.getProductType()))
				.put("compliancePeriod", ExistenceChecker.isSet((EnvironmentalProductComplaincePeriod) o.getCompliancePeriod()))
				.put("vintage", ExistenceChecker.isSet((List<Integer>) o.getVintage()))
				.put("applicableLaw", ExistenceChecker.isSet((EnvironmentalProductApplicableLaw) o.getApplicableLaw()))
				.put("trackingSystem", ExistenceChecker.isSet((EnvironmentalTrackingSystem) o.getTrackingSystem()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EnvironmentalProduct", ValidationType.ONLY_EXISTS, "EnvironmentalProduct", path, "");
		}
		return failure("EnvironmentalProduct", ValidationType.ONLY_EXISTS, "EnvironmentalProduct", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
