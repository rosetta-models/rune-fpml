package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.InterestCalculation;
import fpml.confirmation.InterestLeg;
import fpml.confirmation.InterestLegCalculationPeriodDates;
import fpml.confirmation.LegAmount;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.ReturnSwapNotional;
import fpml.confirmation.StubCalculationPeriod;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InterestLegOnlyExistsValidator implements ValidatorWithArg<InterestLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InterestLeg> ValidationResult<InterestLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("legIdentifier", ExistenceChecker.isSet((List<? extends LegIdentifier>) o.getLegIdentifier()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getTerminationDate()))
				.put("interestLegCalculationPeriodDates", ExistenceChecker.isSet((InterestLegCalculationPeriodDates) o.getInterestLegCalculationPeriodDates()))
				.put("notional", ExistenceChecker.isSet((ReturnSwapNotional) o.getNotional()))
				.put("interestAmount", ExistenceChecker.isSet((LegAmount) o.getInterestAmount()))
				.put("interestCalculation", ExistenceChecker.isSet((InterestCalculation) o.getInterestCalculation()))
				.put("stubCalculationPeriod", ExistenceChecker.isSet((StubCalculationPeriod) o.getStubCalculationPeriod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InterestLeg", ValidationType.ONLY_EXISTS, "InterestLeg", path, "");
		}
		return failure("InterestLeg", ValidationType.ONLY_EXISTS, "InterestLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
