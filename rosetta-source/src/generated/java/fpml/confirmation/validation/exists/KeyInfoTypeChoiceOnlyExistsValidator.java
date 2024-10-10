package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.KeyInfoTypeChoice;
import fpml.confirmation.KeyValueType;
import fpml.confirmation.PGPDataType;
import fpml.confirmation.RetrievalMethodType;
import fpml.confirmation.SPKIDataType;
import fpml.confirmation.X509DataType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class KeyInfoTypeChoiceOnlyExistsValidator implements ValidatorWithArg<KeyInfoTypeChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends KeyInfoTypeChoice> ValidationResult<KeyInfoTypeChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("keyName", ExistenceChecker.isSet((String) o.getKeyName()))
				.put("keyValue", ExistenceChecker.isSet((KeyValueType) o.getKeyValue()))
				.put("retrievalMethod", ExistenceChecker.isSet((RetrievalMethodType) o.getRetrievalMethod()))
				.put("x509Data", ExistenceChecker.isSet((X509DataType) o.getX509Data()))
				.put("pgpData", ExistenceChecker.isSet((PGPDataType) o.getPgpData()))
				.put("spkiData", ExistenceChecker.isSet((SPKIDataType) o.getSpkiData()))
				.put("mgmtData", ExistenceChecker.isSet((String) o.getMgmtData()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("KeyInfoTypeChoice", ValidationType.ONLY_EXISTS, "KeyInfoTypeChoice", path, "");
		}
		return failure("KeyInfoTypeChoice", ValidationType.ONLY_EXISTS, "KeyInfoTypeChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
