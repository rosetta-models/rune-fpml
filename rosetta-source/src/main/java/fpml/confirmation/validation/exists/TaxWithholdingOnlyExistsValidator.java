package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.TaxWithholding;
import fpml.confirmation.WithholdingTaxReason;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TaxWithholdingOnlyExistsValidator implements ValidatorWithArg<TaxWithholding, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TaxWithholding> ValidationResult<TaxWithholding> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amount", ExistenceChecker.isSet((NonNegativeMoney) o.getAmount()))
				.put("taxRate", ExistenceChecker.isSet((BigDecimal) o.getTaxRate()))
				.put("reason", ExistenceChecker.isSet((WithholdingTaxReason) o.getReason()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TaxWithholding", ValidationType.ONLY_EXISTS, "TaxWithholding", path, "");
		}
		return failure("TaxWithholding", ValidationType.ONLY_EXISTS, "TaxWithholding", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
