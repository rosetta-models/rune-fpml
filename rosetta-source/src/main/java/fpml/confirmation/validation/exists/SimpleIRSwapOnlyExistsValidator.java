package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.Period;
import fpml.confirmation.ProductReference;
import fpml.confirmation.SimpleIRSwap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SimpleIRSwapOnlyExistsValidator implements ValidatorWithArg<SimpleIRSwap, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SimpleIRSwap> ValidationResult<SimpleIRSwap> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("currency", ExistenceChecker.isSet((IdentifiedCurrency) o.getCurrency()))
				.put("exchangeId", ExistenceChecker.isSet((ExchangeId) o.getExchangeId()))
				.put("clearanceSystem", ExistenceChecker.isSet((ClearanceSystem) o.getClearanceSystem()))
				.put("definition", ExistenceChecker.isSet((ProductReference) o.getDefinition()))
				.put("term", ExistenceChecker.isSet((Period) o.getTerm()))
				.put("paymentFrequency", ExistenceChecker.isSet((Period) o.getPaymentFrequency()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SimpleIRSwap", ValidationType.ONLY_EXISTS, "SimpleIRSwap", path, "");
		}
		return failure("SimpleIRSwap", ValidationType.ONLY_EXISTS, "SimpleIRSwap", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
