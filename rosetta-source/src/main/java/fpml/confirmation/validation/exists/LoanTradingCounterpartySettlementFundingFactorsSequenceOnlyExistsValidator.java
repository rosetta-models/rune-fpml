package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingCostOfCarry;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactorsSequence;
import fpml.confirmation.LoanTradingDelayedCompensation;
import fpml.confirmation.LoanTradingEconomicBenefit;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingCounterpartySettlementFundingFactorsSequenceOnlyExistsValidator implements ValidatorWithArg<LoanTradingCounterpartySettlementFundingFactorsSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingCounterpartySettlementFundingFactorsSequence> ValidationResult<LoanTradingCounterpartySettlementFundingFactorsSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("delayedCompensation", ExistenceChecker.isSet((LoanTradingDelayedCompensation) o.getDelayedCompensation()))
				.put("costOfCarry", ExistenceChecker.isSet((LoanTradingCostOfCarry) o.getCostOfCarry()))
				.put("economicBenefit", ExistenceChecker.isSet((List<? extends LoanTradingEconomicBenefit>) o.getEconomicBenefit()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingCounterpartySettlementFundingFactorsSequence", ValidationType.ONLY_EXISTS, "LoanTradingCounterpartySettlementFundingFactorsSequence", path, "");
		}
		return failure("LoanTradingCounterpartySettlementFundingFactorsSequence", ValidationType.ONLY_EXISTS, "LoanTradingCounterpartySettlementFundingFactorsSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
