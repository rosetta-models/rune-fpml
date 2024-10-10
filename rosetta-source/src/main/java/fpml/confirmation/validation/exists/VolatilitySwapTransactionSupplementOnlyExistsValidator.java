package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityUnderlyerProvisionsModel;
import fpml.confirmation.ProductModel;
import fpml.confirmation.VolatilityLeg;
import fpml.confirmation.VolatilitySwapTransactionSupplement;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class VolatilitySwapTransactionSupplementOnlyExistsValidator implements ValidatorWithArg<VolatilitySwapTransactionSupplement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends VolatilitySwapTransactionSupplement> ValidationResult<VolatilitySwapTransactionSupplement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("volatilityLeg", ExistenceChecker.isSet((List<? extends VolatilityLeg>) o.getVolatilityLeg()))
				.put("equityUnderlyerProvisionsModel", ExistenceChecker.isSet((EquityUnderlyerProvisionsModel) o.getEquityUnderlyerProvisionsModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("VolatilitySwapTransactionSupplement", ValidationType.ONLY_EXISTS, "VolatilitySwapTransactionSupplement", path, "");
		}
		return failure("VolatilitySwapTransactionSupplement", ValidationType.ONLY_EXISTS, "VolatilitySwapTransactionSupplement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
