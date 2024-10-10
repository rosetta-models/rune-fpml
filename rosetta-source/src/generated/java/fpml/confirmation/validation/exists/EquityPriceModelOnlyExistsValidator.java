package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ActualPrice;
import fpml.confirmation.EquityPriceModel;
import fpml.confirmation.FxConversion;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquityPriceModelOnlyExistsValidator implements ValidatorWithArg<EquityPriceModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquityPriceModel> ValidationResult<EquityPriceModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("grossPrice", ExistenceChecker.isSet((ActualPrice) o.getGrossPrice()))
				.put("netPrice", ExistenceChecker.isSet((ActualPrice) o.getNetPrice()))
				.put("accruedInterestPrice", ExistenceChecker.isSet((BigDecimal) o.getAccruedInterestPrice()))
				.put("fxConversion", ExistenceChecker.isSet((FxConversion) o.getFxConversion()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityPriceModel", ValidationType.ONLY_EXISTS, "EquityPriceModel", path, "");
		}
		return failure("EquityPriceModel", ValidationType.ONLY_EXISTS, "EquityPriceModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
