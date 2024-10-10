package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConstituentWeight;
import fpml.confirmation.ProtectionTermsReference;
import fpml.confirmation.ReferencePair;
import fpml.confirmation.ReferencePoolItem;
import fpml.confirmation.SettlementTermsReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReferencePoolItemOnlyExistsValidator implements ValidatorWithArg<ReferencePoolItem, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReferencePoolItem> ValidationResult<ReferencePoolItem> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("constituentWeight", ExistenceChecker.isSet((ConstituentWeight) o.getConstituentWeight()))
				.put("referencePair", ExistenceChecker.isSet((ReferencePair) o.getReferencePair()))
				.put("protectionTermsReference", ExistenceChecker.isSet((ProtectionTermsReference) o.getProtectionTermsReference()))
				.put("settlementTermsReference", ExistenceChecker.isSet((SettlementTermsReference) o.getSettlementTermsReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReferencePoolItem", ValidationType.ONLY_EXISTS, "ReferencePoolItem", path, "");
		}
		return failure("ReferencePoolItem", ValidationType.ONLY_EXISTS, "ReferencePoolItem", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
