package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.SettlementAmountOrCurrencyModel;
import fpml.confirmation.SettlementTypeEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionSettlementModelOnlyExistsValidator implements ValidatorWithArg<OptionSettlementModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionSettlementModel> ValidationResult<OptionSettlementModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("settlementType", ExistenceChecker.isSet((SettlementTypeEnum) o.getSettlementType()))
				.put("settlementDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getSettlementDate()))
				.put("settlementAmountOrCurrencyModel", ExistenceChecker.isSet((SettlementAmountOrCurrencyModel) o.getSettlementAmountOrCurrencyModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionSettlementModel", ValidationType.ONLY_EXISTS, "OptionSettlementModel", path, "");
		}
		return failure("OptionSettlementModel", ValidationType.ONLY_EXISTS, "OptionSettlementModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
