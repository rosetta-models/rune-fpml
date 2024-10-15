package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates;
import fpml.confirmation.CurrencyAndDeterminationMethodModel;
import fpml.confirmation.DividendsModel;
import fpml.confirmation.Formula;
import fpml.confirmation.ReferenceAmount;
import fpml.confirmation.ReturnSwapAmount;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReturnSwapAmountOnlyExistsValidator implements ValidatorWithArg<ReturnSwapAmount, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReturnSwapAmount> ValidationResult<ReturnSwapAmount> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("currencyAndDeterminationMethodModel", ExistenceChecker.isSet((CurrencyAndDeterminationMethodModel) o.getCurrencyAndDeterminationMethodModel()))
				.put("referenceAmount", ExistenceChecker.isSet((ReferenceAmount) o.getReferenceAmount()))
				.put("formula", ExistenceChecker.isSet((Formula) o.getFormula()))
				.put("encodedDescription", ExistenceChecker.isSet((String) o.getEncodedDescription()))
				.put("calculationDates", ExistenceChecker.isSet((AdjustableRelativeOrPeriodicDates) o.getCalculationDates()))
				.put("cashSettlement", ExistenceChecker.isSet((Boolean) o.getCashSettlement()))
				.put("dividendsModel", ExistenceChecker.isSet((DividendsModel) o.getDividendsModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReturnSwapAmount", ValidationType.ONLY_EXISTS, "ReturnSwapAmount", path, "");
		}
		return failure("ReturnSwapAmount", ValidationType.ONLY_EXISTS, "ReturnSwapAmount", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
