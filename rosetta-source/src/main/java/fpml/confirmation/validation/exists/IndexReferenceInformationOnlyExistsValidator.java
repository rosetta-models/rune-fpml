package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IndexAnnexSource;
import fpml.confirmation.IndexReferenceInformation;
import fpml.confirmation.IndexReferenceInformationSequence0;
import fpml.confirmation.IndexReferenceInformationSequence1;
import fpml.confirmation.IndexReferenceInformationSequence2;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.SettledEntityMatrix;
import fpml.confirmation.Tranche;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class IndexReferenceInformationOnlyExistsValidator implements ValidatorWithArg<IndexReferenceInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends IndexReferenceInformation> ValidationResult<IndexReferenceInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("indexReferenceInformationSequence0", ExistenceChecker.isSet((IndexReferenceInformationSequence0) o.getIndexReferenceInformationSequence0()))
				.put("indexReferenceInformationSequence1", ExistenceChecker.isSet((IndexReferenceInformationSequence1) o.getIndexReferenceInformationSequence1()))
				.put("indexSeries", ExistenceChecker.isSet((Integer) o.getIndexSeries()))
				.put("indexAnnexVersion", ExistenceChecker.isSet((Integer) o.getIndexAnnexVersion()))
				.put("indexAnnexDate", ExistenceChecker.isSet((Date) o.getIndexAnnexDate()))
				.put("indexAnnexSource", ExistenceChecker.isSet((IndexAnnexSource) o.getIndexAnnexSource()))
				.put("excludedReferenceEntity", ExistenceChecker.isSet((List<? extends LegalEntity>) o.getExcludedReferenceEntity()))
				.put("tranche", ExistenceChecker.isSet((Tranche) o.getTranche()))
				.put("settledEntityMatrix", ExistenceChecker.isSet((SettledEntityMatrix) o.getSettledEntityMatrix()))
				.put("indexReferenceInformationSequence2", ExistenceChecker.isSet((IndexReferenceInformationSequence2) o.getIndexReferenceInformationSequence2()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("IndexReferenceInformation", ValidationType.ONLY_EXISTS, "IndexReferenceInformation", path, "");
		}
		return failure("IndexReferenceInformation", ValidationType.ONLY_EXISTS, "IndexReferenceInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
