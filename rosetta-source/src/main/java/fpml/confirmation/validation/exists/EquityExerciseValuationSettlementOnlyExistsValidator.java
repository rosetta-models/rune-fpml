package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.Currency;
import fpml.confirmation.EquityAmericanExercise;
import fpml.confirmation.EquityBermudaExercise;
import fpml.confirmation.EquityEuropeanExercise;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityExerciseValuationSettlementSequence;
import fpml.confirmation.EquityValuation;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PrePayment;
import fpml.confirmation.SettlementPriceDefaultElection;
import fpml.confirmation.SettlementPriceSource;
import fpml.confirmation.SettlementTypeEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquityExerciseValuationSettlementOnlyExistsValidator implements ValidatorWithArg<EquityExerciseValuationSettlement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquityExerciseValuationSettlement> ValidationResult<EquityExerciseValuationSettlement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("equityEuropeanExercise", ExistenceChecker.isSet((EquityEuropeanExercise) o.getEquityEuropeanExercise()))
				.put("equityAmericanExercise", ExistenceChecker.isSet((EquityAmericanExercise) o.getEquityAmericanExercise()))
				.put("equityBermudaExercise", ExistenceChecker.isSet((EquityBermudaExercise) o.getEquityBermudaExercise()))
				.put("equityExerciseValuationSettlementSequence", ExistenceChecker.isSet((EquityExerciseValuationSettlementSequence) o.getEquityExerciseValuationSettlementSequence()))
				.put("prePayment", ExistenceChecker.isSet((PrePayment) o.getPrePayment()))
				.put("equityValuation", ExistenceChecker.isSet((EquityValuation) o.getEquityValuation()))
				.put("settlementDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getSettlementDate()))
				.put("settlementCurrency", ExistenceChecker.isSet((Currency) o.getSettlementCurrency()))
				.put("settlementPriceSource", ExistenceChecker.isSet((SettlementPriceSource) o.getSettlementPriceSource()))
				.put("settlementType", ExistenceChecker.isSet((SettlementTypeEnum) o.getSettlementType()))
				.put("settlementMethodElectionDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getSettlementMethodElectionDate()))
				.put("settlementMethodElectingPartyReference", ExistenceChecker.isSet((PartyReference) o.getSettlementMethodElectingPartyReference()))
				.put("settlementPriceDefaultElection", ExistenceChecker.isSet((SettlementPriceDefaultElection) o.getSettlementPriceDefaultElection()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityExerciseValuationSettlement", ValidationType.ONLY_EXISTS, "EquityExerciseValuationSettlement", path, "");
		}
		return failure("EquityExerciseValuationSettlement", ValidationType.ONLY_EXISTS, "EquityExerciseValuationSettlement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
