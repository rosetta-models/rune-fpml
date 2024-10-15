package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.ExchangeIdentifierModel;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.Warrant;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class WarrantOnlyExistsValidator implements ValidatorWithArg<Warrant, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Warrant> ValidationResult<Warrant> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("currency", ExistenceChecker.isSet((IdentifiedCurrency) o.getCurrency()))
				.put("exchangeId", ExistenceChecker.isSet((ExchangeId) o.getExchangeId()))
				.put("clearanceSystem", ExistenceChecker.isSet((ClearanceSystem) o.getClearanceSystem()))
				.put("definition", ExistenceChecker.isSet((ProductReference) o.getDefinition()))
				.put("exchangeIdentifierModel", ExistenceChecker.isSet((ExchangeIdentifierModel) o.getExchangeIdentifierModel()))
				.put("multiplier", ExistenceChecker.isSet((BigDecimal) o.getMultiplier()))
				.put("contractReference", ExistenceChecker.isSet((String) o.getContractReference()))
				.put("expirationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getExpirationDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Warrant", ValidationType.ONLY_EXISTS, "Warrant", path, "");
		}
		return failure("Warrant", ValidationType.ONLY_EXISTS, "Warrant", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
