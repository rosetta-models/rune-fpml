package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IssuerTradeId;
import fpml.confirmation.OrderIdentifier;
import fpml.confirmation.PackageSummary;
import fpml.confirmation.PackageType;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PackageSummaryOnlyExistsValidator implements ValidatorWithArg<PackageSummary, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PackageSummary> ValidationResult<PackageSummary> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("packageIdentifier", ExistenceChecker.isSet((IssuerTradeId) o.getPackageIdentifier()))
				.put("orderIdentifier", ExistenceChecker.isSet((OrderIdentifier) o.getOrderIdentifier()))
				.put("packageType", ExistenceChecker.isSet((List<? extends PackageType>) o.getPackageType()))
				.put("size", ExistenceChecker.isSet((BigDecimal) o.getSize()))
				.put("sequenceNumber", ExistenceChecker.isSet((BigDecimal) o.getSequenceNumber()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PackageSummary", ValidationType.ONLY_EXISTS, "PackageSummary", path, "");
		}
		return failure("PackageSummary", ValidationType.ONLY_EXISTS, "PackageSummary", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
