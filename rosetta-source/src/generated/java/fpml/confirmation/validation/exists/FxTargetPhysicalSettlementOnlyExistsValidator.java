package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxExchangedCurrencyModel;
import fpml.confirmation.FxSettlementAdjustmentMethodEnum;
import fpml.confirmation.FxTargetPhysicalSettlement;
import fpml.confirmation.StrikeOrStrikeReferenceModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetPhysicalSettlementOnlyExistsValidator implements ValidatorWithArg<FxTargetPhysicalSettlement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTargetPhysicalSettlement> ValidationResult<FxTargetPhysicalSettlement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fxExchangedCurrencyModel", ExistenceChecker.isSet((FxExchangedCurrencyModel) o.getFxExchangedCurrencyModel()))
				.put("settlementAdjustmentStyle", ExistenceChecker.isSet((FxSettlementAdjustmentMethodEnum) o.getSettlementAdjustmentStyle()))
				.put("strikeOrStrikeReferenceModel", ExistenceChecker.isSet((StrikeOrStrikeReferenceModel) o.getStrikeOrStrikeReferenceModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTargetPhysicalSettlement", ValidationType.ONLY_EXISTS, "FxTargetPhysicalSettlement", path, "");
		}
		return failure("FxTargetPhysicalSettlement", ValidationType.ONLY_EXISTS, "FxTargetPhysicalSettlement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
