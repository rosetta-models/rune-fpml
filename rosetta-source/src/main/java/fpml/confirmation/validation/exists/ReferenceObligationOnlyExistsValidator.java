package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Bond;
import fpml.confirmation.ConvertibleBond;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.LegalEntityReference;
import fpml.confirmation.Loan;
import fpml.confirmation.Mortgage;
import fpml.confirmation.ReferenceObligation;
import fpml.confirmation.ReferenceObligationChoice;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReferenceObligationOnlyExistsValidator implements ValidatorWithArg<ReferenceObligation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReferenceObligation> ValidationResult<ReferenceObligation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("bond", ExistenceChecker.isSet((Bond) o.getBond()))
				.put("convertibleBond", ExistenceChecker.isSet((ConvertibleBond) o.getConvertibleBond()))
				.put("mortgage", ExistenceChecker.isSet((Mortgage) o.getMortgage()))
				.put("loan", ExistenceChecker.isSet((Loan) o.getLoan()))
				.put("primaryObligor", ExistenceChecker.isSet((LegalEntity) o.getPrimaryObligor()))
				.put("primaryObligorReference", ExistenceChecker.isSet((LegalEntityReference) o.getPrimaryObligorReference()))
				.put("referenceObligationChoice", ExistenceChecker.isSet((List<? extends ReferenceObligationChoice>) o.getReferenceObligationChoice()))
				.put("standardReferenceObligation", ExistenceChecker.isSet((Boolean) o.getStandardReferenceObligation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReferenceObligation", ValidationType.ONLY_EXISTS, "ReferenceObligation", path, "");
		}
		return failure("ReferenceObligation", ValidationType.ONLY_EXISTS, "ReferenceObligation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
