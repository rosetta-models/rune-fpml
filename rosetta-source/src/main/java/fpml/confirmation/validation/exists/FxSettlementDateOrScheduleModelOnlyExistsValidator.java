package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAdjustedDateAndDateAdjustments;
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import fpml.confirmation.FxSettlementSchedule;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxSettlementDateOrScheduleModelOnlyExistsValidator implements ValidatorWithArg<FxSettlementDateOrScheduleModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxSettlementDateOrScheduleModel> ValidationResult<FxSettlementDateOrScheduleModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("settlementDate", ExistenceChecker.isSet((FxAdjustedDateAndDateAdjustments) o.getSettlementDate()))
				.put("settlementSchedule", ExistenceChecker.isSet((FxSettlementSchedule) o.getSettlementSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxSettlementDateOrScheduleModel", ValidationType.ONLY_EXISTS, "FxSettlementDateOrScheduleModel", path, "");
		}
		return failure("FxSettlementDateOrScheduleModel", ValidationType.ONLY_EXISTS, "FxSettlementDateOrScheduleModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
