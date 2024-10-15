package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportId;
import fpml.confirmation.ReportSectionIdentification;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportSectionIdentificationOnlyExistsValidator implements ValidatorWithArg<ReportSectionIdentification, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportSectionIdentification> ValidationResult<ReportSectionIdentification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("reportId", ExistenceChecker.isSet((ReportId) o.getReportId()))
				.put("sectionNumber", ExistenceChecker.isSet((Integer) o.getSectionNumber()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportSectionIdentification", ValidationType.ONLY_EXISTS, "ReportSectionIdentification", path, "");
		}
		return failure("ReportSectionIdentification", ValidationType.ONLY_EXISTS, "ReportSectionIdentification", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
