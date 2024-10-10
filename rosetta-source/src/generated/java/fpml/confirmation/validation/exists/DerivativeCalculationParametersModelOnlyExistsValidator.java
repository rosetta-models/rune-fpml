package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AnalyticDerivativeParametersModel;
import fpml.confirmation.DerivativeCalculationParametersModel;
import fpml.confirmation.FiniteDifferenceDerivativeParametersModel;
import fpml.confirmation.SubstitutionDerivativeParametersModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DerivativeCalculationParametersModelOnlyExistsValidator implements ValidatorWithArg<DerivativeCalculationParametersModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DerivativeCalculationParametersModel> ValidationResult<DerivativeCalculationParametersModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("finiteDifferenceDerivativeParametersModel", ExistenceChecker.isSet((FiniteDifferenceDerivativeParametersModel) o.getFiniteDifferenceDerivativeParametersModel()))
				.put("analyticDerivativeParametersModel", ExistenceChecker.isSet((AnalyticDerivativeParametersModel) o.getAnalyticDerivativeParametersModel()))
				.put("substitutionDerivativeParametersModel", ExistenceChecker.isSet((SubstitutionDerivativeParametersModel) o.getSubstitutionDerivativeParametersModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DerivativeCalculationParametersModel", ValidationType.ONLY_EXISTS, "DerivativeCalculationParametersModel", path, "");
		}
		return failure("DerivativeCalculationParametersModel", ValidationType.ONLY_EXISTS, "DerivativeCalculationParametersModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
