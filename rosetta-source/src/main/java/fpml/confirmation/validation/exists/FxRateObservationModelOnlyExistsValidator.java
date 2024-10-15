package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAverageRateObservation;
import fpml.confirmation.FxRateObservationModel;
import fpml.confirmation.StrikeQuoteBasisEnum;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxRateObservationModelOnlyExistsValidator implements ValidatorWithArg<FxRateObservationModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxRateObservationModel> ValidationResult<FxRateObservationModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rateObservation", ExistenceChecker.isSet((List<? extends FxAverageRateObservation>) o.getRateObservation()))
				.put("rateObservationQuoteBasis", ExistenceChecker.isSet((StrikeQuoteBasisEnum) o.getRateObservationQuoteBasis()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxRateObservationModel", ValidationType.ONLY_EXISTS, "FxRateObservationModel", path, "");
		}
		return failure("FxRateObservationModel", ValidationType.ONLY_EXISTS, "FxRateObservationModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
