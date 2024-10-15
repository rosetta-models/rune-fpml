package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Currency;
import fpml.confirmation.DeliverableObligations;
import fpml.confirmation.PhysicalSettlementPeriod;
import fpml.confirmation.PhysicalSettlementTerms;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PhysicalSettlementTermsOnlyExistsValidator implements ValidatorWithArg<PhysicalSettlementTerms, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PhysicalSettlementTerms> ValidationResult<PhysicalSettlementTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("settlementCurrency", ExistenceChecker.isSet((Currency) o.getSettlementCurrency()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("physicalSettlementPeriod", ExistenceChecker.isSet((PhysicalSettlementPeriod) o.getPhysicalSettlementPeriod()))
				.put("deliverableObligations", ExistenceChecker.isSet((DeliverableObligations) o.getDeliverableObligations()))
				.put("escrow", ExistenceChecker.isSet((Boolean) o.getEscrow()))
				.put("sixtyBusinessDaySettlementCap", ExistenceChecker.isSet((Boolean) o.getSixtyBusinessDaySettlementCap()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PhysicalSettlementTerms", ValidationType.ONLY_EXISTS, "PhysicalSettlementTerms", path, "");
		}
		return failure("PhysicalSettlementTerms", ValidationType.ONLY_EXISTS, "PhysicalSettlementTerms", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
