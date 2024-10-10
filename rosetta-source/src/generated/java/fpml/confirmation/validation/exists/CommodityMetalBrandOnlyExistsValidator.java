package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityMetalBrand;
import fpml.confirmation.CommodityMetalBrandManager;
import fpml.confirmation.CommodityMetalBrandName;
import fpml.confirmation.CommodityMetalProducer;
import fpml.confirmation.CountryCode;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityMetalBrandOnlyExistsValidator implements ValidatorWithArg<CommodityMetalBrand, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityMetalBrand> ValidationResult<CommodityMetalBrand> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("name", ExistenceChecker.isSet((CommodityMetalBrandName) o.getName()))
				.put("brandManager", ExistenceChecker.isSet((CommodityMetalBrandManager) o.getBrandManager()))
				.put("country", ExistenceChecker.isSet((CountryCode) o.getCountry()))
				.put("producer", ExistenceChecker.isSet((CommodityMetalProducer) o.getProducer()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityMetalBrand", ValidationType.ONLY_EXISTS, "CommodityMetalBrand", path, "");
		}
		return failure("CommodityMetalBrand", ValidationType.ONLY_EXISTS, "CommodityMetalBrand", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
