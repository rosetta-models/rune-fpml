package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityMetalBrand;
import fpml.confirmation.CommodityMetalGrade;
import fpml.confirmation.CommodityMetalShape;
import fpml.confirmation.Material;
import fpml.confirmation.Metal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MetalOnlyExistsValidator implements ValidatorWithArg<Metal, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Metal> ValidationResult<Metal> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("material", ExistenceChecker.isSet((Material) o.getMaterial()))
				.put("shape", ExistenceChecker.isSet((List<? extends CommodityMetalShape>) o.getShape()))
				.put("brand", ExistenceChecker.isSet((List<? extends CommodityMetalBrand>) o.getBrand()))
				.put("grade", ExistenceChecker.isSet((List<? extends CommodityMetalGrade>) o.getGrade()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Metal", ValidationType.ONLY_EXISTS, "Metal", path, "");
		}
		return failure("Metal", ValidationType.ONLY_EXISTS, "Metal", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
