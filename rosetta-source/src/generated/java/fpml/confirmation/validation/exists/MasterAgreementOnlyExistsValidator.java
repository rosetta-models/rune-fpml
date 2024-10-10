package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MasterAgreement;
import fpml.confirmation.MasterAgreementId;
import fpml.confirmation.MasterAgreementType;
import fpml.confirmation.MasterAgreementVersion;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MasterAgreementOnlyExistsValidator implements ValidatorWithArg<MasterAgreement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MasterAgreement> ValidationResult<MasterAgreement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("masterAgreementId", ExistenceChecker.isSet((List<? extends MasterAgreementId>) o.getMasterAgreementId()))
				.put("masterAgreementType", ExistenceChecker.isSet((MasterAgreementType) o.getMasterAgreementType()))
				.put("masterAgreementVersion", ExistenceChecker.isSet((MasterAgreementVersion) o.getMasterAgreementVersion()))
				.put("masterAgreementDate", ExistenceChecker.isSet((Date) o.getMasterAgreementDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MasterAgreement", ValidationType.ONLY_EXISTS, "MasterAgreement", path, "");
		}
		return failure("MasterAgreement", ValidationType.ONLY_EXISTS, "MasterAgreement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
