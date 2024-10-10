package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ContractualDefinitions;
import fpml.confirmation.ContractualTermsSupplement;
import fpml.confirmation.CreditDerivativesNotices;
import fpml.confirmation.Empty;
import fpml.confirmation.FirstPeriodStartDate;
import fpml.confirmation.NovationTermsModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NovationTermsModelOnlyExistsValidator implements ValidatorWithArg<NovationTermsModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NovationTermsModel> ValidationResult<NovationTermsModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fullFirstCalculationPeriod", ExistenceChecker.isSet((Boolean) o.getFullFirstCalculationPeriod()))
				.put("firstPeriodStartDate", ExistenceChecker.isSet((List<? extends FirstPeriodStartDate>) o.getFirstPeriodStartDate()))
				.put("nonReliance", ExistenceChecker.isSet((Empty) o.getNonReliance()))
				.put("creditDerivativesNotices", ExistenceChecker.isSet((CreditDerivativesNotices) o.getCreditDerivativesNotices()))
				.put("contractualDefinitions", ExistenceChecker.isSet((List<? extends ContractualDefinitions>) o.getContractualDefinitions()))
				.put("contractualTermsSupplement", ExistenceChecker.isSet((List<? extends ContractualTermsSupplement>) o.getContractualTermsSupplement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NovationTermsModel", ValidationType.ONLY_EXISTS, "NovationTermsModel", path, "");
		}
		return failure("NovationTermsModel", ValidationType.ONLY_EXISTS, "NovationTermsModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
