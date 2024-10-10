package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditLimit;
import fpml.confirmation.Currency;
import fpml.confirmation.LimitApplicable;
import fpml.confirmation.LimitId;
import fpml.confirmation.Period;
import fpml.confirmation.ProductModel;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditLimitOnlyExistsValidator implements ValidatorWithArg<CreditLimit, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditLimit> ValidationResult<CreditLimit> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("limitId", ExistenceChecker.isSet((LimitId) o.getLimitId()))
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("tenor", ExistenceChecker.isSet((Period) o.getTenor()))
				.put("limitApplicable", ExistenceChecker.isSet((List<? extends LimitApplicable>) o.getLimitApplicable()))
				.put("expirationDate", ExistenceChecker.isSet((ZonedDateTime) o.getExpirationDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditLimit", ValidationType.ONLY_EXISTS, "CreditLimit", path, "");
		}
		return failure("CreditLimit", ValidationType.ONLY_EXISTS, "CreditLimit", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
