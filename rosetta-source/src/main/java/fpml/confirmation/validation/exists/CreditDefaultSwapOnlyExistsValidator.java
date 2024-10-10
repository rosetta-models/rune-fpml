package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditDefaultSwap;
import fpml.confirmation.CreditDefaultSwapChoice;
import fpml.confirmation.FeeLeg;
import fpml.confirmation.GeneralTerms;
import fpml.confirmation.ProductModel;
import fpml.confirmation.ProtectionTerms;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditDefaultSwapOnlyExistsValidator implements ValidatorWithArg<CreditDefaultSwap, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditDefaultSwap> ValidationResult<CreditDefaultSwap> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("generalTerms", ExistenceChecker.isSet((GeneralTerms) o.getGeneralTerms()))
				.put("feeLeg", ExistenceChecker.isSet((FeeLeg) o.getFeeLeg()))
				.put("protectionTerms", ExistenceChecker.isSet((List<? extends ProtectionTerms>) o.getProtectionTerms()))
				.put("creditDefaultSwapChoice", ExistenceChecker.isSet((List<? extends CreditDefaultSwapChoice>) o.getCreditDefaultSwapChoice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditDefaultSwap", ValidationType.ONLY_EXISTS, "CreditDefaultSwap", path, "");
		}
		return failure("CreditDefaultSwap", ValidationType.ONLY_EXISTS, "CreditDefaultSwap", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
