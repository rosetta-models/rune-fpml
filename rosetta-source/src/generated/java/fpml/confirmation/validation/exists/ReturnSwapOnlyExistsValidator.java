package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DirectionalLeg;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.PrincipalExchangeFeatures;
import fpml.confirmation.ProductModel;
import fpml.confirmation.ReturnSwap;
import fpml.confirmation.ReturnSwapAdditionalPayment;
import fpml.confirmation.ReturnSwapEarlyTermination;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReturnSwapOnlyExistsValidator implements ValidatorWithArg<ReturnSwap, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReturnSwap> ValidationResult<ReturnSwap> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("returnSwapLeg", ExistenceChecker.isSet((List<? extends DirectionalLeg>) o.getReturnSwapLeg()))
				.put("principalExchangeFeatures", ExistenceChecker.isSet((PrincipalExchangeFeatures) o.getPrincipalExchangeFeatures()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends ReturnSwapAdditionalPayment>) o.getAdditionalPayment()))
				.put("earlyTermination", ExistenceChecker.isSet((List<? extends ReturnSwapEarlyTermination>) o.getEarlyTermination()))
				.put("extraordinaryEvents", ExistenceChecker.isSet((ExtraordinaryEvents) o.getExtraordinaryEvents()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReturnSwap", ValidationType.ONLY_EXISTS, "ReturnSwap", path, "");
		}
		return failure("ReturnSwap", ValidationType.ONLY_EXISTS, "ReturnSwap", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
