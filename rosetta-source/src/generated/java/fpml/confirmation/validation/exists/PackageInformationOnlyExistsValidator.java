package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AllocationReportingStatus;
import fpml.confirmation.ClearingStatusValue;
import fpml.confirmation.ExecutionDateTime;
import fpml.confirmation.ExecutionVenueType;
import fpml.confirmation.PackageInformation;
import fpml.confirmation.RelatedParty;
import fpml.confirmation.TradeCategory;
import fpml.confirmation.TradeProcessingTimestamps;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PackageInformationOnlyExistsValidator implements ValidatorWithArg<PackageInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PackageInformation> ValidationResult<PackageInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.put("category", ExistenceChecker.isSet((List<? extends TradeCategory>) o.getCategory()))
				.put("executionDateTime", ExistenceChecker.isSet((ExecutionDateTime) o.getExecutionDateTime()))
				.put("timestamps", ExistenceChecker.isSet((TradeProcessingTimestamps) o.getTimestamps()))
				.put("intentToAllocate", ExistenceChecker.isSet((Boolean) o.getIntentToAllocate()))
				.put("allocationStatus", ExistenceChecker.isSet((AllocationReportingStatus) o.getAllocationStatus()))
				.put("intentToClear", ExistenceChecker.isSet((Boolean) o.getIntentToClear()))
				.put("clearingStatus", ExistenceChecker.isSet((ClearingStatusValue) o.getClearingStatus()))
				.put("executionVenueType", ExistenceChecker.isSet((ExecutionVenueType) o.getExecutionVenueType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PackageInformation", ValidationType.ONLY_EXISTS, "PackageInformation", path, "");
		}
		return failure("PackageInformation", ValidationType.ONLY_EXISTS, "PackageInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
