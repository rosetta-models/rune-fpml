package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerAmounts;
import fpml.confirmation.NonNegativeMoney;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BuyerSellerAmountsOnlyExistsValidator implements ValidatorWithArg<BuyerSellerAmounts, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BuyerSellerAmounts> ValidationResult<BuyerSellerAmounts> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("buyersAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getBuyersAmount()))
				.put("sellersAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getSellersAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BuyerSellerAmounts", ValidationType.ONLY_EXISTS, "BuyerSellerAmounts", path, "");
		}
		return failure("BuyerSellerAmounts", ValidationType.ONLY_EXISTS, "BuyerSellerAmounts", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
