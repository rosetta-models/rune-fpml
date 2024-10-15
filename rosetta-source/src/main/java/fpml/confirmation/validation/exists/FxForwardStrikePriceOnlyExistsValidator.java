package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxForwardStrikePrice;
import fpml.confirmation.QuoteBasisEnum;
import fpml.confirmation.Step;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxForwardStrikePriceOnlyExistsValidator implements ValidatorWithArg<FxForwardStrikePrice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxForwardStrikePrice> ValidationResult<FxForwardStrikePrice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("initialValue", ExistenceChecker.isSet((BigDecimal) o.getInitialValue()))
				.put("step", ExistenceChecker.isSet((List<? extends Step>) o.getStep()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("quoteBasis", ExistenceChecker.isSet((QuoteBasisEnum) o.getQuoteBasis()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxForwardStrikePrice", ValidationType.ONLY_EXISTS, "FxForwardStrikePrice", path, "");
		}
		return failure("FxForwardStrikePrice", ValidationType.ONLY_EXISTS, "FxForwardStrikePrice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
