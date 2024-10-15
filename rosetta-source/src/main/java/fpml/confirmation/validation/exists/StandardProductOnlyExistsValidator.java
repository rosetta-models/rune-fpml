package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasicQuotation;
import fpml.confirmation.CashflowNotional;
import fpml.confirmation.ProductModel;
import fpml.confirmation.StandardProduct;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class StandardProductOnlyExistsValidator implements ValidatorWithArg<StandardProduct, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends StandardProduct> ValidationResult<StandardProduct> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("notional", ExistenceChecker.isSet((CashflowNotional) o.getNotional()))
				.put("quote", ExistenceChecker.isSet((List<? extends BasicQuotation>) o.getQuote()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("StandardProduct", ValidationType.ONLY_EXISTS, "StandardProduct", path, "");
		}
		return failure("StandardProduct", ValidationType.ONLY_EXISTS, "StandardProduct", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
