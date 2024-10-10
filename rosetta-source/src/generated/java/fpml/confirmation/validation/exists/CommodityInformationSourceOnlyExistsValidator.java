package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityInformationProvider;
import fpml.confirmation.CommodityInformationSource;
import fpml.confirmation.RateSourcePage;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityInformationSourceOnlyExistsValidator implements ValidatorWithArg<CommodityInformationSource, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityInformationSource> ValidationResult<CommodityInformationSource> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rateSource", ExistenceChecker.isSet((CommodityInformationProvider) o.getRateSource()))
				.put("rateSourcePage", ExistenceChecker.isSet((RateSourcePage) o.getRateSourcePage()))
				.put("rateSourcePageHeading", ExistenceChecker.isSet((String) o.getRateSourcePageHeading()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityInformationSource", ValidationType.ONLY_EXISTS, "CommodityInformationSource", path, "");
		}
		return failure("CommodityInformationSource", ValidationType.ONLY_EXISTS, "CommodityInformationSource", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
