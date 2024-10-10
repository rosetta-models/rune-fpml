package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Currency;
import fpml.confirmation.DealRolesModel;
import fpml.confirmation.DealSummary;
import fpml.confirmation.DealSummarySequence;
import fpml.confirmation.InstrumentId;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DealSummaryOnlyExistsValidator implements ValidatorWithArg<DealSummary, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DealSummary> ValidationResult<DealSummary> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("dealRolesModel", ExistenceChecker.isSet((DealRolesModel) o.getDealRolesModel()))
				.put("creditAgreementDate", ExistenceChecker.isSet((Date) o.getCreditAgreementDate()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("dealSummarySequence", ExistenceChecker.isSet((DealSummarySequence) o.getDealSummarySequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DealSummary", ValidationType.ONLY_EXISTS, "DealSummary", path, "");
		}
		return failure("DealSummary", ValidationType.ONLY_EXISTS, "DealSummary", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
