package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetPool;
import fpml.confirmation.BondCalculationModel;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.FixedIncomeSecurityContentModel;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.LegalEntityReference;
import fpml.confirmation.Mortgage;
import fpml.confirmation.MortgageSector;
import fpml.confirmation.ProductReference;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MortgageOnlyExistsValidator implements ValidatorWithArg<Mortgage, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Mortgage> ValidationResult<Mortgage> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("currency", ExistenceChecker.isSet((IdentifiedCurrency) o.getCurrency()))
				.put("exchangeId", ExistenceChecker.isSet((ExchangeId) o.getExchangeId()))
				.put("clearanceSystem", ExistenceChecker.isSet((ClearanceSystem) o.getClearanceSystem()))
				.put("definition", ExistenceChecker.isSet((ProductReference) o.getDefinition()))
				.put("insurer", ExistenceChecker.isSet((LegalEntity) o.getInsurer()))
				.put("insurerReference", ExistenceChecker.isSet((LegalEntityReference) o.getInsurerReference()))
				.put("fixedIncomeSecurityContentModel", ExistenceChecker.isSet((FixedIncomeSecurityContentModel) o.getFixedIncomeSecurityContentModel()))
				.put("bondCalculationModel", ExistenceChecker.isSet((BondCalculationModel) o.getBondCalculationModel()))
				.put("originalPrincipalAmount", ExistenceChecker.isSet((BigDecimal) o.getOriginalPrincipalAmount()))
				.put("pool", ExistenceChecker.isSet((AssetPool) o.getPool()))
				.put("sector", ExistenceChecker.isSet((MortgageSector) o.getSector()))
				.put("tranche", ExistenceChecker.isSet((String) o.getTranche()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Mortgage", ValidationType.ONLY_EXISTS, "Mortgage", path, "");
		}
		return failure("Mortgage", ValidationType.ONLY_EXISTS, "Mortgage", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
