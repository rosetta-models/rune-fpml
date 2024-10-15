package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CancelableProvision;
import fpml.confirmation.EarlyTerminationProvision;
import fpml.confirmation.ExtendibleProvision;
import fpml.confirmation.InterestRateStream;
import fpml.confirmation.Payment;
import fpml.confirmation.ProductModel;
import fpml.confirmation.Swap;
import fpml.confirmation.SwapAdditionalTerms;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SwapOnlyExistsValidator implements ValidatorWithArg<Swap, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Swap> ValidationResult<Swap> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("swapStream", ExistenceChecker.isSet((List<? extends InterestRateStream>) o.getSwapStream()))
				.put("earlyTerminationProvision", ExistenceChecker.isSet((EarlyTerminationProvision) o.getEarlyTerminationProvision()))
				.put("cancelableProvision", ExistenceChecker.isSet((CancelableProvision) o.getCancelableProvision()))
				.put("extendibleProvision", ExistenceChecker.isSet((ExtendibleProvision) o.getExtendibleProvision()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends Payment>) o.getAdditionalPayment()))
				.put("additionalTerms", ExistenceChecker.isSet((SwapAdditionalTerms) o.getAdditionalTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Swap", ValidationType.ONLY_EXISTS, "Swap", path, "");
		}
		return failure("Swap", ValidationType.ONLY_EXISTS, "Swap", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
